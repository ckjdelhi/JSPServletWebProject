package com.registration.model;

public class User {
	private int id;
	private String name;
	private String emailId;
	private String country;
	public User() {}
	public User(int id, String name, String emailId, String country) {
		this.id = id;
		this.name = name;
		this.emailId = emailId;
		this.country = country;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", emailId=" + emailId + ", country=" + country + "]";
	}
	
}
