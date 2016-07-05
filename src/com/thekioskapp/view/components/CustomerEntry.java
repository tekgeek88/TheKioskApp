package com.thekioskapp.view.components;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.beans.property.SimpleStringProperty;
import javafx.util.Duration;

/**
 * Stores all data for each Customer.
 * @author Joshua Neighbarger
 */
public class CustomerEntry {

	private SimpleStringProperty firstName;
	private SimpleStringProperty lastName;
	private SimpleStringProperty employee;
	private SimpleStringProperty timeIn;
	private SimpleStringProperty timeOut;
	private SimpleStringProperty elapsedTime;
	private SimpleStringProperty totalTime;
	
	private ArrayList<String> notes;
	private Timeline timeline;
	
	public CustomerEntry(final String firstName, final String lastName, final ArrayList<String> notes) {
		this.firstName = new SimpleStringProperty(firstName);
		this.lastName = new SimpleStringProperty(lastName);
		this.notes = new ArrayList<>(notes);
		timeIn = new SimpleStringProperty(milsToString(System.currentTimeMillis()));
		elapsedTime = new SimpleStringProperty("00:00");
		timeline = new Timeline(new KeyFrame(Duration.millis(1000),
		        event -> elapsedTime.set(getTimeString(timeline.getCurrentTime()))));
		timeline.setCycleCount(Animation.INDEFINITE);
		timeline.play();
				
	}
	
	private String getTimeString(final Duration time) {
		final Date date = new Date((long) time.toMillis());
		final DateFormat formatter = new SimpleDateFormat("mm:ss");
		return formatter.format(date);
	}
	
	private String milsToString(final long mils) {
		final Date date = new Date(mils);
		final DateFormat formatter = new SimpleDateFormat("HH:mm");
		return formatter.format(date);
	}
	
	public String getFirstName() {
		return firstName.get();
	}
	
	public void setFirstName(final String name) {
		firstName.set(name);
	}
	
	public String getLastName() {
		return lastName.get();
	}
	
	public void setLastName(final String name) {
		lastName.set(name);
	}
	
	/**
	 * @return the employee
	 */
	public String getEmployee() {
		return employee.get();
	}

	/**
	 * @param employee the employee to set
	 */
	public void setEmployee(final String employee) {
		this.employee.set(employee);
	}

	/**
	 * @return the timeIn
	 */
	public String getTimeIn() {
		return timeIn.get();
	}

	/**
	 * @param timeIn the timeIn to set
	 */
	public void setTimeIn(final Long time) {
		this.timeIn.set(milsToString(time));
	}

	/**
	 * @return the timeOut
	 */
	public String getTimeOut() {
		return timeOut.get();
	}

	/**
	 * @param timeOut the timeOut to set
	 */
	public void setTimeOut(final Long time) {
		this.timeOut.set(milsToString(time));
	}

	/**
	 * @return the elapsedTime
	 */
	public String getElapsedTime() {
		return elapsedTime.get();
	}

	/**
	 * @param elapsedTime the elapsedTime to set
	 */
	public void setElapsedTime(final Long time) {
		this.elapsedTime.set(milsToString(time));
	}

	/**
	 * @return the totalTime
	 */
	public String getTotalTime() {
		return totalTime.get();
	}

	/**
	 * @param totalTime the totalTime to set
	 */
	public void setTotalTime(final Long time) {
		this.totalTime.set(milsToString(time));
	}

	@SuppressWarnings("unchecked")
	public ArrayList<String> getNotes() {
		return (ArrayList<String>) notes.clone();
	}
	
	public void setNotes(final ArrayList<String> noteList) {
		notes.addAll(noteList);
	}
	
	
}
