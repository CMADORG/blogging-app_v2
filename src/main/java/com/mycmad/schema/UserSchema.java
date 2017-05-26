package com.mycmad.schema;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.MapKey;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.mycmad.api.User;

@Entity
@Table(name="Users")
public class UserSchema {

	
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	@Column(name="userId")
	private int userId;
	private String passwordHash;
	private String userName;
	private String token;
	@OneToMany(cascade=CascadeType.ALL, mappedBy="user")
	private List<Blog> myblogs;
	 


	public String getUserName() {
		return userName;
	}



	public void setUserName(String userName) {
		this.userName = userName;
	}



	public int getUserId() {
		return userId;
	}



	public void setUserId(int userId) {
		this.userId = userId;
	}



	public String getPasswordHash() {
		return passwordHash;
	}



	public void setPasswordHash(String passwordHash) {
		this.passwordHash = passwordHash;
	}

	public UserSchema() {
		// TODO Auto-generated constructor stub
	}



	public String getToken() {
		return token;
	}



	public void setToken(String token) {
		this.token = token;
	}



	public static UserSchema createSchema(User u) {
		// TODO Auto-generated method stub
		UserSchema us = new UserSchema();
		us.setUserId(u.getUserid());
		us.setUserName(u.getUserName());
		return us;
	}

	
	
}
