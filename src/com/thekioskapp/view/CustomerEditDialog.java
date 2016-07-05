package com.thekioskapp.view;

import java.util.ArrayList;
import java.util.Objects;

import com.thekioskapp.util.CustomerManager;
import com.thekioskapp.view.components.CustomerEntry;

import javafx.collections.FXCollections;
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
	
	private CustomerEntry customer;
	private ArrayList<String> noteList;
	
	public void initialize() {
		noteView.setCellFactory(TextFieldListCell.forListView());
		noteList = new ArrayList<>();
	}
	
	public void setCustomer(final CustomerEntry customer) {
		Objects.requireNonNull(customer);
		this.customer = customer;
		final String firstName = customer.getFirstName(); 
		final String lastName = customer.getLastName();
		noteList = customer.getNotes();
		noteView.setItems(FXCollections.observableArrayList(noteList));
		
		if (firstName != null) {
			firstNameField.setText(firstName);
		}
		if (lastName != null) {
			lastNameField.setText(lastName);
		}
		if (noteList != null && !noteList.isEmpty()) {
			noteView.setItems(FXCollections.observableArrayList(noteList));
		}
	}
	
	public void refreshNoteView() {
		noteView.setItems(null);
		noteView.setItems(FXCollections.observableArrayList(noteList));
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
		if (customer == null) {
			CustomerManager.addCustomer(new CustomerEntry(firstNameField.getText(), 
					lastNameField.getText(), noteList));
		} else {
			customer.setFirstName(firstNameField.getText());
			customer.setLastName(lastNameField.getText());
			customer.setNotes(noteList);
		}
		closeStage();
	}

}
