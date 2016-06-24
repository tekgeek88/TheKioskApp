package com.thekioskapp.model;

import java.util.ArrayList;

/**
 * A Clients class that can be used to add, remove, and maintain clients.
 * @author TekGeek88
 */
public class Clients {

	// An ArrayList of type Client.
	private ArrayList<Client> clients;

	// Default constructor initializes an empty client list.
	public Clients(){
		clients = new ArrayList<Client>();
	}

	//--------------- Basic Getters and Setters -------------------

	/**
	 * Getter for the Clients class. Returns complete list of<br>
	 * ALL clients currently added to this Clients object.<br>
	 * This is the default getter for this class and is generally not used.
	 * @return ArrayList of type Client
	 */
	public ArrayList<Client> getClients() {
		return clients;
	}

	/**
	 * Takes an Arraylist of client and adds it the Clients object.<br>
	 * This is the default setter for this class and is generally not used.
	 * @param clients
	 */
	public void setClients(ArrayList<Client> clients) {
		this.clients = clients;
	}

	
	//------- Methods used to interact with the Client ArrayList

	
	/**
	 * Takes a client as a parameter and adds it to the list of clients.<br>
	 * Returns a boolean to indicate whether the client was successfully added to the list.
	 * @param client
	 * @return boolean
	 */
	public boolean addClient(Client client) {
		return clients.add(client); 
	}

	/**
	 * Takes a client as a parameter and removes it from the list of clients.<br>
	 * Returns a boolean to indicate whether the client was successfully removed from the list.
	 * @param client
	 * @return boolean
	 */
	public boolean removeClient(Client client) {
		return clients.remove(client);
	}

	/**
	 * Iterates through the clients list and returns a new Clients object<br>
	 * Returns all clients who's phoneNumber matches the phoneNumber parameter.
	 * Returns a list of clients regardless of number of clients found. If any...<br>
	 * @param phoneNumber
	 * @return Clients
	 */
	public Clients getClients(String phoneNumber) {
		Clients clientsFound = new Clients();
		for (Client c: getClients()) {
			if (c.getPhoneNumber().equals(phoneNumber)) {
				clientsFound.addClient(c);
			}
		}
		return clientsFound;
	}
	
	/**
	 * Looks up a client in the clients list by phone number<br>
	 * Returns the <em>FIRST</em> occurrence of a client with the matching phone number.<br>
	 * This method only returns <em>ONE</em> client even if more than one exists.<br>
	 * If the no clients are returned size will be zero.
	 * @param phoneNumber
	 * @return Client
	 */
	public Client getClient(String phoneNumber) {
		Client clientFound = null;
		for (Client c: getClients()) {
			if (c.getPhoneNumber().equals(phoneNumber)) {
				clientFound = c;
				return clientFound;
			}
		}
		return clientFound;
	}
	
	/**
	 * Looks up a client by first and last name.<br>
	 * Returns only the client object matching both first <em>AND</em> last name.<br>
	 * If the no clients are found q NULL client will be returned..
	 * @param nameFirst
	 * @param nameLast
	 * @return
	 */
	public Client getClient(String nameFirst, String nameLast) {
		Client clientFound = null;
		for(Client c: getClients()) {
			if (c.getNameFirst().equalsIgnoreCase(nameFirst) && c.getNameLast().equalsIgnoreCase(nameLast)) {
				clientFound = c;
				return clientFound;
			}
		}
		return clientFound;
	}

	/**
	 * Returns the an integer representing the number of clients in the list.<br>
	 * If no clients are in the list returned size will be zero.
	 * @return int
	 */
	public int size() {
		return clients.size();
	}
	
	
	
	
}
