package com.thekioskapp.main;

import com.thekioskapp.controller.SQLRequestQuery;
import com.thekioskapp.model.Clients;

public class Test {

	public static void main(String[] args) {
		
		//System.out.println(SQLInsertQuery.insertNewClient("Joe", "Bloe", "2222222222"));
		
		Clients myClients = new Clients();
		System.out.println("Size before " + myClients.size());
		myClients = SQLRequestQuery.getClients("2535909132");
		System.out.println("Size after " + myClients.size());
		
		System.out.println(myClients.getClient("carl", "argabright"));
		
		System.out.println("Program completed successfuly!");
	}
	
}
