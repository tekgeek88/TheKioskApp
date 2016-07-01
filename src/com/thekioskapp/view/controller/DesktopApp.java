package com.thekioskapp.view.controller;

import java.io.IOException;

import com.thekioskapp.view.Main;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 * Controls the main desktop application.
 * @author Joshua Neighbarger
 */
public class DesktopApp {

	@FXML private VBox anchor;
	
	@FXML
	private void addCustomerMenu() {
		try {
			final FXMLLoader loader = new FXMLLoader(Main.class.getResource("assets/CustomerEditDialog.fxml"));
			final Parent root = loader.load();
			final Scene scene = new Scene(root);
			
			final Stage stage = new Stage();
			stage.setTitle("New Customer");
			stage.setScene(scene);
			stage.showAndWait();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@FXML
	private void removeCustomerMenu(final ActionEvent event) {
		System.out.println("Hello");
	}
	
	@FXML
	private void exitAction() {
		anchor.getScene().getWindow().hide();
	}
	
	@FXML
	private void editCustomerMenu() {
		try {
			final FXMLLoader loader = new FXMLLoader(Main.class.getResource("assets/CustomerEditDialog.fxml"));
			final Parent root = loader.load();
			System.out.println("Replace with Customer selector and let selector call edit dialog");
			
			final Stage stage = new Stage();
			stage.setTitle("Edit Customer");
			stage.setScene(new Scene(root));
			stage.showAndWait();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@FXML
	private void preferencesMenu(final ActionEvent event) {
		System.out.println("Hello");
	}
	
	@FXML
	private void busyTimesMenu(final ActionEvent event) {
		System.out.println("Hello");
	}
	
	@FXML
	private void waitTimesHistogramMenu(final ActionEvent event) {
		System.out.println("Hello");
	}
	
	@FXML
	private void helpMenu() {
		Alert about = new Alert(AlertType.INFORMATION);
		about.setTitle("Help");
		about.setHeaderText(null);
		about.setContentText("Please visit our website at:\n www.theuwhackers.com");
		about.showAndWait();
	}
	
	@FXML
	private void aboutMenu() {
		Alert about = new Alert(AlertType.INFORMATION);
		about.setTitle("About");
		about.setHeaderText(null);
		about.setContentText("theUWHackers © 2016\nVersion 0.0.1\nWebsite: www.theuwhackers.com\nPhone: 555.555.5555");
		about.showAndWait();
	}
	
}
