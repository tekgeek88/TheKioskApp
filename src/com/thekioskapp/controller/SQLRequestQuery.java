package com.thekioskapp.controller;

import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Calendar;

import com.thekioskapp.model.Client;
import com.thekioskapp.model.Clients;
import com.thekioskapp.model.MySqlConnection;


public class SQLRequestQuery {

	private static Connection db;

	/**
	 * Opens a connection to the SQL database and makes a request for all clients.<br>
	 * Returns a Clients object with an ArrayList that contains all clients.
	 * @return Clients
	 */
	public static Clients getClients() {
		Clients clients = null;			// The Clients object we want to return back to the caller.
		String query = null;			// The SQL query we want to execute 

		// Prepare the query to be sent to the database
		query = "SELECT * FROM clients";

		// Connect to the database and attempt to execute the statement and query.
		ResultSet results = fetchResults(query);

		// Handle the results with the getClients Reesult handler
		clients = getClientsHandler(results);
		return clients;
	}	
	
	/**
	 * Opens a connection to the SQL database and makes a request for clients.<br>
	 * Returns a Clients object with an ArrayList that contains all clients whose number matched the parameter.
	 * @param phoneNumber
	 * @return Clients
	 */
	public static Clients getClients(String phoneNumber) {
		Clients clients = null;			// The Clients object we want to return back to the caller.
		String query = null;			// The SQL query we want to execute 

		// Prepare the query to be sent to the database
		query = "SELECT id, nameFirst, nameLast, phoneNumber, dateCreated, lastVisitDate, avgWaitTime, avgCutTime FROM clients WHERE phoneNumber = '" + phoneNumber + "'";

		// Connect to the database and attempt to execute the statement and query.
		ResultSet results = fetchResults(query);

		// Handle the results with the getClients Reesult handler
		clients = getClientsHandler(results);
		return clients;
	}	

	// -----------------  Request Handlers ----------------------

	/**
	 * Takes a ResultSet as a parameter and converts it into a Clients list. 
	 * @param result
	 * @return a Clients object
	 */
	private static Clients getClientsHandler(ResultSet result) {
		Clients clientResults = new Clients();
		try {
			while(result.next()) {
				Client client = new Client();
				client.setId(result.getInt("id"));
				client.setNameFirst(result.getString("nameFirst"));
				client.setNameLast(result.getString("nameLast"));
				client.setPhoneNumber(result.getString("phoneNumber"));
				client.setDateCreated(result.getDate("dateCreated"));
				if (clientResults.addClient(client)){
					System.out.println(client.getNameFirst() + " " + client.getNameLast() + " added to the clients list...");
				}
			}
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		return clientResults;
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
	 * Takes an SQL as a parameter, makes a connection to the database, and returns the results.
	 * @param query
	 * @return
	 */
	private static ResultSet fetchResults(String query) {
		makeConnection();
		Statement statement = null;		// The SQL statement object to execute
		ResultSet resultSet = null;		// The results from the SQL statement
		try {
			// Initialize the statement object
			statement = db.createStatement();
			// execute the statement with the query and store the result in a result set
			resultSet = statement.executeQuery(query);
			return resultSet;
		}
		catch (SQLException ex){
			System.out.println("SQLException: " + ex.getMessage());
			System.out.println("SQLState: " + ex.getSQLState());
			System.out.println("VendorError: " + ex.getErrorCode());
			return resultSet;
		}
		// The finally statement releases all the resources used in producing the result
//		finally {
//			if (resultSet != null) {
//				try {
//					resultSet.close();
//				} catch (SQLException sqlEx) {} // ignore
//				resultSet = null;
//			}
//			if (statement != null) {
//				try {
//					statement.close();
//				}
//				catch (SQLException sqlEx) {} // ignore
//				statement = null;
//			}
//		}
	}

	// This Date object is a java.sql.Date object
	private static Date getTimeStamp() {
		Calendar calendar = Calendar.getInstance();
		return new Date(calendar.getTime().getTime());
	}

}
