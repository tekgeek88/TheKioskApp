package com.thekioskapp.controller;
import java.sql.*;
import java.sql.Connection;
import java.sql.Date;
import java.sql.SQLException;
import java.util.Calendar;

import com.thekioskapp.model.MySqlConnection;

public class SQLInsertQuery {

	private static Connection db;

	/**
	 * Adds a new client to the SQL database. Takes a String for all three parameters.<br>
	 * Returns true or false to indicate a successful addition to the database.
	 * @param nameFirst
	 * @param nameLast
	 * @param numberCell
	 * @return boolean
	 */
	public static boolean insertNewClient(String nameFirst, String nameLast, String phoneNumber) {
		makeConnection();
		Date dateCreated = getTimeStamp();
		String query;
		PreparedStatement preparedStmt;
		
		// The MySql insert statement
		query = "INSERT INTO clients (nameFirst, nameLast, phoneNumber, dateCreated)"
				+ "VALUES (?, ?, ?, ?)";

		try {
			preparedStmt = db.prepareStatement(query);
			preparedStmt.setString(1, nameFirst);
			preparedStmt.setString(2, nameLast);
			preparedStmt.setString(3, phoneNumber);
			preparedStmt.setDate(4, dateCreated);
			// execute the statement
			preparedStmt.execute();
			// Close the connection
			preparedStmt.close();
			db.close();
			db = null;
			return true;
		}
		catch (SQLException ex){
		    System.out.println("SQLException: " + ex.getMessage());
		    System.out.println("SQLState: " + ex.getSQLState());
		    System.out.println("VendorError: " + ex.getErrorCode());
			return false;
		}
	}	

	/**
	 * Establishs a connection to the SQL database.
	 * @return
	 */
	private static boolean makeConnection() {
		db = new MySqlConnection().getConnection();
		if (db != null) {
			return true;
		}
		else return false;
	}

	// This Date object is a java.sql.Date object
	public static Date getTimeStamp() {
		Calendar calendar = Calendar.getInstance();
		return new Date(calendar.getTime().getTime());
	}

}
