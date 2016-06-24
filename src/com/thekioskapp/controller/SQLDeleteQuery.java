package com.thekioskapp.controller;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import com.thekioskapp.model.Client;
import com.thekioskapp.model.MySqlConnection;

public class SQLDeleteQuery {

	private static Connection db;

	/**
	 * Opens a connection to the SQL database and makes an update query in an attempt to delete a client.<br>
	 * Returns a boolean to determine if the client was deleted.
	 * @param Client
	 * @return boolean
	 */
	public static boolean deleteClient(Client client) {
		boolean wasDeleted = false;				// The Clients object we want to return back to the caller.
		String query = null;			// The SQL query we want to execute 
		// Prepare the query to be sent to the database
		if (client != null) {
			query = "DELETE FROM clients WHERE id = '" + client.getId() + "'";
			wasDeleted = executeUpdateQuery(query); 
		}
		return wasDeleted;
	}

	/**
	 * Opens a connection to the SQL database and makes an update query in an attempt to delete a client.<br>
	 * Takes a first and last name as a parameter and is not case sensitive.
	 * Returns a boolean to determine if the client was deleted.
	 * @param nameFirst
	 * @param nameLast
	 * @return boolean
	 */
	public static boolean deleteClient(String nameFirst, String nameLast) {
		boolean wasDeleted = false;				// The Clients object we want to return back to the caller.
		String query = null;			// The SQL query we want to execute 
		// Prepare the query to be sent to the database
		query = "DELETE FROM clients WHERE nameFirst = '" + nameFirst + "'" + "AND nameLast = '" + nameLast + "'";
		wasDeleted = executeUpdateQuery(query); 
		return wasDeleted;
	}



	// ----------------- Helper Methods --------------------------

	/**
	 * Helper method that allows this class to establish a connection to teh database
	 * @return
	 */
	private static boolean makeConnection() {
		db = new MySqlConnection().getConnection();
		if (db != null) {
			return true;
		}
		else return false;
	}

	/**
	 * Takes a query as an SQL Data Manipulation Language (DML) statement, such as INSERT, UPDATE or DELETE as a parameter.<br>
	 * Returns true or false if a change was successful.
	 * @param query
	 * @return boolean
	 */
	private static boolean executeUpdateQuery(String query) {
		boolean success = false;
		makeConnection();
		Statement statement = null;		// The SQL statement object to execute

		try {
			// Initialize the statement object
			statement = db.createStatement();
			// execute the statement with the query and store the result in a result set
			int rowsAffected = statement.executeUpdate(query);
			if (rowsAffected > 0) {
				System.out.println("Rows affected: " + rowsAffected);
				success = true;
			}
			return success;
		}
		catch (SQLException ex){
			System.out.println("SQLException: " + ex.getMessage());
			System.out.println("SQLState: " + ex.getSQLState());
			System.out.println("VendorError: " + ex.getErrorCode());
			return success;
		}
		 //The finally statement releases all the resources used in producing the result
					finally {
						if (statement != null) {
							try {
								statement.close();
							}
							catch (SQLException sqlEx) {} // ignore
							statement = null;
						}
					}
	}


}
