package com.thekioskapp.model;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MySqlConnection {

	private Connection connection = null;
	
	private String baseUrl = "jdbc:mysql://";
	private String host = "localhost";
	private String port = "3306";
	private String database = "TheKioskApp";
	private String userName = "root";
	private String password = "12345678";
	private String url = baseUrl + host + ":" + port + "/" + database;

	/**
	 *  Default constructor to make a basic SQL connection object.
	 * @return 
	 */
	public MySqlConnection() {
	}
	
	/**
	 * Establishes a connection to an SQL database and returns the connection back to the caller.<br>
	 * Returns null if connection could not be established 
	 * @return Connection
	 */
	private Connection makeConnection() {
		try {
			connection = DriverManager.getConnection(url, userName, password);
		}
		catch (SQLException ex){
			System.out.println(ex.getMessage());
			System.out.println("SQLException: " + ex.getMessage());
		    System.out.println("SQLState: " + ex.getSQLState());
		    System.out.println("VendorError: " + ex.getErrorCode());
		}
		if (connection != null) {
			System.out.println("Connected to database!");
		}
		return connection;
	}

	public Connection getConnection() {
			if (connection == null) {
				makeConnection();
			}
			else {
				System.out.println("Database is already connected!");
			}
		return connection;
	}

	public String getHost() {
		return host;
	}


	public void setHost(String host) {
		this.host = host;
	}


	public String getPort() {
		return port;
	}


	public void setPort(String port) {
		this.port = port;
	}


	public String getDatabase() {
		return database;
	}


	public void setDatabase(String database) {
		this.database = database;
	}


	public String getUserName() {
		return userName;
	}


	public void setUserName(String userName) {
		this.userName = userName;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}

}

