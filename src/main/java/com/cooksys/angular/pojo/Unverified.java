package com.cooksys.angular.pojo;

public class Unverified {

	private String username;
	private String password;

	Unverified() {
	}

	public Unverified(String username, String password) {
		this.username = username;
		this.password = password;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
