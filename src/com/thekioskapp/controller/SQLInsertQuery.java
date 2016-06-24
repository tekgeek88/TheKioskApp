package com.thekioskapp.controller;
import java.sql.*;
import java.sql.Connection;
import java.sql.Date;
import java.sql.SQLException;
import java.util.Calendar;

import com.thekioskapp.model.MySqlConnection;

public class SQLInsertQuery {

	private static Connection db;

	public static boolean insertNewClient(String nameFirst, String nameLast, String numberCell) {
		makeConnection();
		Date dateCreated = getTimeStamp();
		String query;
		PreparedStatement preparedStmt;
		
		// The MySql insert statement
		query = "INSERT INTO clients (nameFirst, nameLast, numberCell, dateCreated)"
				+ "VALUES (?, ?, ?, ?)";
		//('Carlos', 'Albright',2535909132, CURDATE())";
		// create the mysql insert preparedstatement

		try {
			preparedStmt = db.prepareStatement(query);
			preparedStmt.setString(1, nameFirst);
			preparedStmt.setString(2, nameLast);
			preparedStmt.setString(3, numberCell);
			preparedStmt.setDate(4, dateCreated);
			// execute the statement
			preparedStmt.execute();
			// Close the connection
			db.close();
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
	 * Establishs a connection to the SQL database an se
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
