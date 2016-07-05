package com.thekioskapp.util;

import java.io.FileInputStream;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * This class will provide a GUI to change the Tetris configurations.
 * 
 * @author Joshua Neighbarger
 * @version 03 June 2016
 */
public class ConfigManager extends Application {
    
	@Override
	public void start(Stage primaryStage) {
		try {
			final Parent root = new FXMLLoader().load(new FileInputStream("./res/ConfigManager.fxml"));
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
		System.exit(0);
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
