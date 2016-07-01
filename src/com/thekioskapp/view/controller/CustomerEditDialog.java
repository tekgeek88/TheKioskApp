package com.thekioskapp.view.controller;

import java.util.Objects;

import com.thekioskapp.model.Customer;

import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.TextFieldListCell;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.VBox;

/**
 * Controls the add and edit customer dialogs.
 * @author Joshua Neighbarger
 */
public class CustomerEditDialog {

	@FXML private VBox anchor;
	@FXML private TextField firstNameField;
	@FXML private TextField lastNameField;
	@FXML private TextField noteField;
	@FXML private ListView<String> noteView;
	
	private Customer customer;
	private String firstName;
	private String lastName;
	private ObservableList<String> noteList;
	
	public void initialize() {
		setCustomer(new Customer());
		noteView.setCellFactory(TextFieldListCell.forListView());	
	}
	
	public void setCustomer(final Customer customer) {
		Objects.requireNonNull(customer);
		this.customer = customer;
		firstName = customer.getFirstName(); 
		lastName = customer.getLastName();
		noteList = customer.getNotes();
		
		if (firstName != null) {
			firstNameField.setText(firstName);
		}
		if (lastName != null) {
			lastNameField.setText(lastName);
		}
		if (noteList != null && !noteList.isEmpty()) {
			noteView.setItems(noteList);
		}
	}
	
	public void refreshNoteView() {
		noteView.setItems(null);
		noteView.setItems(noteList);
	}
	
	public void closeStage() {
		anchor.getScene().getWindow().hide();
	}
	
	@FXML
	private void addNote() {
		final String note = noteField.getText();
		if (!note.isEmpty() && !noteList.contains(note)) {
			noteList.add(note);
			refreshNoteView();
		}
	}
	
	@FXML
	private void handleKeyPressed(final KeyEvent event) {
		if (event.getCode() == KeyCode.DELETE) {
			noteList.remove(noteView.getSelectionModel().getSelectedIndex());
			refreshNoteView();
		}
	}
	
	@FXML
	private void handleCancelAction() {
		closeStage();
	}
	
	@FXML
	private void handleOkayAction() {
		customer.setFirstName(firstName);
		customer.setLastName(lastName);
		customer.setNotes(noteList);
		System.out.println("Add customer to database: not implemented");
		closeStage();
	}

}
