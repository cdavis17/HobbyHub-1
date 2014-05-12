package edu.ycp.cs320.hobbyhub.server;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.bcel.generic.FREM;
import org.apache.tools.ant.taskdefs.SQLExec.Transaction;

import com.google.gwt.i18n.client.Messages.Select;

import edu.ycp.cs320.hobbyhub.server.persist.IDatabase;
import edu.ycp.cs320.hobbyhub.shared.Hobby;
import edu.ycp.cs320.hobbyhub.shared.Message;
import edu.ycp.cs320.hobbyhub.shared.User;

public class DerbyDatabase implements IDatabase {
	
	
	private interface Transaction<ResultType> {
		public ResultType execute(Connection conn) throws SQLException;
	}
	
	private static final int MAX_ATTEMPTS = 10;
	
	
	@Override
	public User getUser(int userID) {
		
		org.apache.bcel.generic.Select USERID;
			FREM USERS;
		
		return null;
		
	}

	@Override
	public User login(String username, String password) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void addAccount(User user) {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean checkExistence(String username) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean verifyAccount(String usr, String password) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean createAccount(String username, String password, int userID,
			String firstname, String lastname, String email) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int getUserID(String username) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public User getUser(String username) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean addMessage(int userID, Message mes) {
		return false;
		// TODO Auto-generated method stub

	}

	@Override
	public ArrayList<Message> getMessages(User user) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<Hobby> getHobbies(User user) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	public<ResultType> ResultType executeTransaction(Transaction<ResultType> txn) {
		try {
			return doExecuteTransaction(txn);
		} catch (SQLException e) {
			throw new PersistenceException("Transaction failed", e);
		}
	}
	
	public<ResultType> ResultType doExecuteTransaction(Transaction<ResultType> txn) throws SQLException {
		Connection conn = connect();
		
		try {
			int numAttempts = 0;
			boolean success = false;
			ResultType result = null;
			
			while (!success && numAttempts < MAX_ATTEMPTS) {
				try {
					result = txn.execute(conn);
					conn.commit();
					success = true;
				} catch (SQLException e) {
					if (e.getSQLState() != null && e.getSQLState().equals("41000")) {
						// Deadlock: retry (unless max retry count has been reached)
						numAttempts++;
					} else {
						// Some other kind of SQLException
						throw e;
					}
				}
			}
			
			if (!success) {
				throw new SQLException("Transaction failed (too many retries)");
			}
			
			// Success!
			return result;
		} finally {
			DBUtil.closeQuietly(conn);
		}
	}

	private Connection connect() throws SQLException {
		Connection conn = DriverManager.getConnection("jdbc:derby:users.db;create=true");
		
		// Set autocommit to false to allow multiple the execution of
		// multiple queries/statements as part of the same transaction.
		conn.setAutoCommit(false);
		
		return conn;
	}
	public void createTables() {
		executeTransaction(new Transaction<Boolean>() {
			@Override
			public Boolean execute(Connection conn) throws SQLException {
				PreparedStatement stmt1 = null;
				
				try {
					stmt1 = conn.prepareStatement(
							"create table users (" +
							"    id integer primary key," +
							"    user_id integer," +
							"    first name(20)," +
							"    last name(20)" +
							")");
					stmt1.executeUpdate();
					
					
					return true;
				} finally {
					DBUtil.closeQuietly(stmt1);
				}
			}
		});
	}
	
	
	public void loadInitialData() {
		executeTransaction(new Transaction<Boolean>() {
			@Override
			public Boolean execute(Connection conn) throws SQLException {
				List<User> userList;
				
				try {
					userList = InitialData.getUsers();
					
				} catch (IOException e) {
					throw new SQLException("Couldn't read initial data", e);
				}

				PreparedStatement insertUser = null;

				try {
					insertUser = conn.prepareStatement("insert into users values (?, ?, ?, ?)");
					for (User user : userList) {
						insertUser.setInt(1, user.getuserID());
						insertUser.setString(2, user.getFirstName());
						insertUser.setString(3, user.getLastName());
						insertUser.setString(4, user.getUserName());
						insertUser.setString(5, user.getLocationState());
						insertUser.setString(6, user.getLocationCity());
						insertUser.addBatch();
					}
					insertUser.executeBatch();
					
					return true;
				} finally {
					DBUtil.closeQuietly(insertUser);
				}
			}
		});
	}

	// The main method creates the database tables and loads the initial data.
		public static void main(String[] args) throws IOException {
			System.out.println("Creating tables...");
			DerbyDatabase db = new DerbyDatabase();
			db.createTables();
			
			System.out.println("Loading initial data...");
			db.loadInitialData();
			
			System.out.println("Success!");
		}
}
