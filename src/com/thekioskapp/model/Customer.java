package com.thekioskapp.model;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 * Stores all data for each Customer.
 * @author Joshua Neighbarger
 */
public class Customer {

	private String firstName;
	private String lastName;
	private ObservableList<String> notes;
	
	public Customer() {
		notes = FXCollections.observableArrayList();
	}
	
	public String getFirstName() {
		return firstName;
	}
	
	public String getLastName() {
		return lastName;
	}
	
	public ObservableList<String> getNotes() {
		final ObservableList<String> clone = FXCollections.observableArrayList();
		clone.setAll(notes);
		return (ObservableList<String>) clone;
	}
	
	public void setFirstName(final String name) {
		firstName = name;
	}

	public void setLastName(final String name) {
		lastName = name;
	}
	
	public void setNotes(final ObservableList<String> noteList) {
		final ObservableList<String> clone = FXCollections.observableArrayList();
		clone.setAll(noteList);
		notes = clone;
	}
	
}
