package com.thekioskapp.view;
	
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import com.thekioskapp.util.ConfigManager;
import com.thekioskapp.util.CustomerManager;
import com.thekioskapp.view.components.CustomerEntry;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.VBox;

/**
 * Launches the application.
 * @author Joshua Neighbarger
 */
public class Main extends Application implements Initializable {
	
	@FXML private VBox anchor;
	
	@FXML private TableView<CustomerEntry> completedTable;
	@FXML private TableColumn<CustomerEntry, String> completedFirstName;
	@FXML private TableColumn<CustomerEntry, String> completedLastName;
	@FXML private TableColumn<CustomerEntry, String> completedTimeOut;
	@FXML private TableColumn<CustomerEntry, String> completedTotalTime;
	
	@FXML private TableView<CustomerEntry> waitingTable;
	@FXML private TableColumn<CustomerEntry, String> waitingFirstName;
	@FXML private TableColumn<CustomerEntry, String> waitingLastName;
	@FXML private TableColumn<CustomerEntry, String> waitingTimeIn;
	@FXML private TableColumn<CustomerEntry, String> waitingElapsedTime;
	
	@FXML private TableView<CustomerEntry> currentTable;
	@FXML private TableColumn<CustomerEntry, String> currentFirstName;
	@FXML private TableColumn<CustomerEntry, String> currentLastName;
	@FXML private TableColumn<CustomerEntry, String> currentEmployee;
	@FXML private TableColumn<CustomerEntry, String> currentElapsedTime;
	
	private CustomerEntry selectedCustomer;
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		completedFirstName.setCellValueFactory(new PropertyValueFactory<>("firstName"));
		completedLastName.setCellValueFactory(new PropertyValueFactory<>("lastName"));
		completedTimeOut.setCellValueFactory(new PropertyValueFactory<>("timeOut"));
		completedTotalTime.setCellValueFactory(new PropertyValueFactory<>("totalTime"));
		completedTable.setItems(CustomerManager.getCompletedCustomers());
		completedTable.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {
		    if (newSelection != null) {
		    	waitingTable.getSelectionModel().clearSelection();
		    	currentTable.getSelectionModel().clearSelection();
		    	selectedCustomer = newSelection;
		    }
		});
		
		waitingFirstName.setCellValueFactory(new PropertyValueFactory<>("firstName"));
		waitingLastName.setCellValueFactory(new PropertyValueFactory<>("lastName"));
		waitingTimeIn.setCellValueFactory(new PropertyValueFactory<>("timeIn"));
		waitingElapsedTime.setCellValueFactory(new PropertyValueFactory<>("elapsedTime"));
		waitingTable.setItems(CustomerManager.getWaitingCustomers());
		waitingTable.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {
		    if (newSelection != null) {
		    	completedTable.getSelectionModel().clearSelection();
		    	currentTable.getSelectionModel().clearSelection();
		    	selectedCustomer = newSelection;
		    }
		});
		
		currentFirstName.setCellValueFactory(new PropertyValueFactory<>("firstName"));
		currentLastName.setCellValueFactory(new PropertyValueFactory<>("lastName"));
		currentEmployee.setCellValueFactory(new PropertyValueFactory<>("timeIn"));
		currentElapsedTime.setCellValueFactory(new PropertyValueFactory<>("employee"));
		currentTable.setItems(CustomerManager.getCurrentCustomers());
		currentTable.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {
		    if (newSelection != null) {
		    	waitingTable.getSelectionModel().clearSelection();
		    	completedTable.getSelectionModel().clearSelection();
		    	selectedCustomer = newSelection;
		    }
		});
		
	}
	
	@Override
	public void stop() {
		System.out.println("Closing application...");
		System.exit(0);
	}
	
	@Override
	public void start(Stage primaryStage) {
		try {
			final Parent root = new FXMLLoader().load(new FileInputStream("./res/DesktopApp.fxml"));
			primaryStage.setTitle("TheKioskApp");
			primaryStage.setScene(new Scene(root));
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	@FXML
	private void addCustomerMenu() {
		try {
			final Parent root = new FXMLLoader().load(new FileInputStream("./res/CustomerEditDialog.fxml"));
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
		CustomerManager.removeCustomer(selectedCustomer);
	}
	
	@FXML
	private void exitAction() {
		anchor.getScene().getWindow().hide();
	}
	
	@FXML
	private void editCustomerMenu() {
		try {
			final FXMLLoader loader = new FXMLLoader();
			final Parent root = loader.load(new FileInputStream("./res/CustomerEditDialog.fxml"));
			((CustomerEditDialog) loader.getController()).setCustomer(selectedCustomer);
			
			final Stage stage = new Stage();
			stage.setTitle("Edit Customer");
			stage.setScene(new Scene(root));
			stage.showAndWait();
			
			completedTable.getColumns().get(0).setVisible(false);
			completedTable.getColumns().get(0).setVisible(true);
			waitingTable.getColumns().get(0).setVisible(false);
			waitingTable.getColumns().get(0).setVisible(true);
			currentTable.getColumns().get(0).setVisible(false);
			currentTable.getColumns().get(0).setVisible(true);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@FXML
	private void preferencesMenu(final ActionEvent event) {
		new ConfigManager().start(new Stage());
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
	
	@FXML
	private void handleKeyPressed(final KeyEvent event) {
		if (event.getCode() == KeyCode.DELETE && selectedCustomer != null) {
//			if (completedTable.getItems().contains(selectedCustomer)) {
//				
//			} else if (waitingTable.getItems().contains(selectedCustomer)) {
//				
//			} else if (currentTable.getItems().contains(selectedCustomer)) {
//				
//			}
			try {
				CustomerManager.removeCustomer(selectedCustomer);
			} catch (final IllegalStateException e) {
				// Customer does not exist.
			}
		}
	}
	
	/**
	 * The main method. 
	 * 
	 * @param args the command line args.
	 */
	public static void main(String[] args) {
		launch(args);
	}
	
}
