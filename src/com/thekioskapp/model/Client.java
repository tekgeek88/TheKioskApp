package com.thekioskapp.model;

import java.util.Date;

public class Client {

	private int id;
	private String nameFirst;
	private String nameLast;
	private String phoneNumber;
	private Date dateCreated;
	private Date lastVisitDate;
	private Date avgWaitTime;
	private Date avgCutTime;

	// Default constructor
	public Client() {
	}

	// Constructor with minimal required fields
	public Client(int id, String nameFirst, String nameLast, String phoneNumber, Date dateCreated) {
		super();
		this.id = id;
		this.nameFirst = nameFirst;
		this.nameLast = nameLast;
		this.phoneNumber = phoneNumber;
		this.dateCreated = dateCreated;
	}

	// Constructor with all fields
	public Client(int id, String nameFirst, String nameLast, String phoneNumber, Date dateCreated, Date lastVisitDate,
			Date avgWaitTime, Date avgCutTime) {
		super();
		this.id = id;
		this.nameFirst = nameFirst;
		this.nameLast = nameLast;
		this.phoneNumber = phoneNumber;
		this.dateCreated = dateCreated;
		this.lastVisitDate = lastVisitDate;
		this.avgWaitTime = avgWaitTime;
		this.avgCutTime = avgCutTime;
	}

	// Constructor with all fields except avgCutTime
	public Client(int id, String nameFirst, String nameLast, String phoneNumber, Date dateCreated, Date lastVisitDate,
			Date avgWaitTime) {
		super();
		this.id = id;
		this.nameFirst = nameFirst;
		this.nameLast = nameLast;
		this.phoneNumber = phoneNumber;
		this.dateCreated = dateCreated;
		this.lastVisitDate = lastVisitDate;
		this.avgWaitTime = avgWaitTime;
	}

	// Constructor with all fields except avgCutTime and avgWaitTime
	public Client(int id, String nameFirst, String nameLast, String phoneNumber, Date dateCreated, Date lastVisitDate) {
		super();
		this.id = id;
		this.nameFirst = nameFirst;
		this.nameLast = nameLast;
		this.phoneNumber = phoneNumber;
		this.dateCreated = dateCreated;
		this.lastVisitDate = lastVisitDate;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNameFirst() {
		return nameFirst;
	}

	public void setNameFirst(String nameFirst) {
		this.nameFirst = nameFirst;
	}

	public String getNameLast() {
		return nameLast;
	}

	public void setNameLast(String nameLast) {
		this.nameLast = nameLast;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public Date getDateCreated() {
		return dateCreated;
	}

	public void setDateCreated(Date dateCreated) {
		this.dateCreated = dateCreated;
	}

	public Date getLastVisitDate() {
		return lastVisitDate;
	}

	public void setLastVisitDate(Date lastVisitDate) {
		this.lastVisitDate = lastVisitDate;
	}

	public Date getAvgWaitTime() {
		return avgWaitTime;
	}

	public void setAvgWaitTime(Date avgWaitTime) {
		this.avgWaitTime = avgWaitTime;
	}

	public Date getAvgCutTime() {
		return avgCutTime;
	}

	public void setAvgCutTime(Date avgCutTime) {
		this.avgCutTime = avgCutTime;
	}
	
	@Override
	public String toString() throws NullPointerException {
		return "id: " + id + " " + nameFirst + " " + nameLast + " " + phoneNumber;
	}




}
