package com.thekioskapp.model;

import com.thekioskapp.controller.SQLDeleteQuery;
import com.thekioskapp.controller.SQLInsertQuery;
import com.thekioskapp.controller.SQLRequestQuery;

public class Test {

	public static void main(String[] args) {
		
		
		deleteClientFromDatabaseByName();
		
		getClientsFromDatabaseByPhoneNumner();
		
		addClientToDatabase();
		
		getClientsFromDatabase();
		
		
		System.out.println("Program completed successfuly!");
	}
	
	// --------------  Sample method usage for database -------------------
	
	/**
	 * Sample usage of deleteing a client form the SQL database<br>
	 * This method should not need to be used but great for testing...
	 * This is using the Client object as a parameter
	 */
	public static void deleteClientFromDatabase() {
		Clients clients = new Clients();
		clients = SQLRequestQuery.getClients();
		Client client = new Client();
		client = clients.getClient("Sarom", "Teng");
		System.out.println(SQLDeleteQuery.deleteClient(client));
	}
	
	/**
	 * Example of how to directly delete a client from the datavase<br>
	 */
	public static void deleteClientFromDatabaseByName(){
		System.out.println(SQLDeleteQuery.deleteClient("Joe", "Bloe"));
	}
	
	public static void getClientsFromDatabaseByPhoneNumner() {
		Clients clients = new Clients();
		System.out.println("Clients size before " + clients.size());
		clients = SQLRequestQuery.getClients("222222222");
		System.out.println("Clients size after " + clients.size());
	}
	
	public static void addClientToDatabase() {
		System.out.println(SQLInsertQuery.insertNewClient("Joe", "Bloe", "2222222222"));
	}
	
	public static void getClientsFromDatabase(){
		SQLRequestQuery.getClients("2222222222");
	}
	
}
