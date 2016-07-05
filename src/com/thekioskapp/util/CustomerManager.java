package com.thekioskapp.util;

import com.thekioskapp.view.components.CustomerEntry;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 * This class loads and maintains the Customer as a Singleton. This method is necessary,
 * so the List of Customer Objects does not need to be loaded from SQL every time the List
 * is accessed, which is actually very frequently.
 * 
 * @author Joshua Neighbarger
 */
public final class CustomerManager {
	/** The only instance of this CustomerManager. */
	private static CustomerManager INSTANCE = new CustomerManager();
	/** A list of all completed customers. */
	private final ObservableList<CustomerEntry> completedCustomers;
	/** A list of all waiting customers, */
	private final ObservableList<CustomerEntry> waitingCustomers;
	/** A list of all current customers. */
	private final ObservableList<CustomerEntry> currentCustomers;
	
	/**
	 * Private constructor to avoid external instantiation.
	 */
	private CustomerManager() {
		completedCustomers = FXCollections.observableArrayList();
		waitingCustomers = FXCollections.observableArrayList();
		currentCustomers = FXCollections.observableArrayList();
	}
	
	/**
	 * 
	 * @param customer
	 */
	public static void addCustomer(final CustomerEntry customer) {
		INSTANCE.waitingCustomers.add(customer);
	}
	
	/**
	 * 
	 * @param customer
	 */
	public static void removeCustomer(final CustomerEntry customer) throws IllegalStateException {
		if (INSTANCE.completedCustomers.contains(customer)) {
			INSTANCE.completedCustomers.remove(customer);
		} else if (INSTANCE.waitingCustomers.contains(customer)) {
			INSTANCE.waitingCustomers.remove(customer);
		} else if (INSTANCE.currentCustomers.contains(customer)) {
			INSTANCE.currentCustomers.remove(customer);
		} else {
			throw new IllegalStateException("Customer not found in any list.");
		}
	}
	
	/**
	 * 
	 * @param customer
	 */
	public static void helpCustomer(final CustomerEntry customer) {
		if (INSTANCE.waitingCustomers.contains(customer)) {
			INSTANCE.waitingCustomers.remove(customer);
			INSTANCE.currentCustomers.add(customer);
		} else {
			
		}
	}
	
	// Intentionally NOT cloning ArrayLists.
	
	public static ObservableList<CustomerEntry> getCompletedCustomers() {
		return INSTANCE.completedCustomers;
	}
	
	public static ObservableList<CustomerEntry> getWaitingCustomers() {
		return INSTANCE.waitingCustomers;
	}
	
	public static ObservableList<CustomerEntry> getCurrentCustomers() {
		return INSTANCE.currentCustomers;
	}
	
}
