package com.thekioskapp.view;
	
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;

/**
 * Launches the application.
 * @author Joshua Neighbarger
 */
public class Main extends Application {
	
	@Override
	public void start(Stage primaryStage) {
		try {
			final Parent root = FXMLLoader.load(getClass().getResource("assets/DesktopApp.fxml"));
			primaryStage.setTitle("TheKioskApp");
			primaryStage.setScene(new Scene(root));
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public void stop() {
		System.out.println("Closing application...");
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
