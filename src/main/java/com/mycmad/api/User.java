package com.mycmad.api;

import java.security.Principal;

public class User implements Principal {

	private String password;
	private String userName;
	private String Token;
	private int userid;
	public User() {
		// TODO Auto-generated constructor stub
	}
	public User(int userId2, String userName2) {
		this.userid = userId2;
		this.userName = userName2;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String passwordHash) {
		this.password = passwordHash;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public int getUserid() {
		return userid;
	}
	public void setUserid(int userid) {
		this.userid = userid;
	}
	public String getToken() {
		return Token;
	}
	public void setToken(String token) {
		Token = token;
	}
	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return this.getUserName();
	}

}
