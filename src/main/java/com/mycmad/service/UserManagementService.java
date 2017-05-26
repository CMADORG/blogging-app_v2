package com.mycmad.service;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import com.mycmad.api.User;
import com.mycmad.api.UserManagementApi;
import com.mycmad.blogexceptions.DuplicateUserException;
import com.mycmad.blogexceptions.InvalidParameterException;
import com.mycmad.blogexceptions.InvalidUserException;
import com.mycmad.data.JPAUserDAO;
import com.mycmad.data.UserDAO;
import com.mycmad.schema.UserSchema;
import com.mycmad.utility.MD5Utility;


public class UserManagementService implements UserManagementApi {
	
	UserDAO udao = new JPAUserDAO();
	

	public void testDAO()
	{
	((JPAUserDAO)udao).printfemf();
	}
	public UserManagementService() {
		// TODO Auto-generated constructor stub
	}

	public void addUser(User u) throws InvalidParameterException, DuplicateUserException {
		
		if(u.getUserName() == null || u.getPassword() == null)
		{
			throw new InvalidParameterException("User name or password is null");
		}
		else
		{
			UserSchema us = new UserSchema();
			us.setUserName(u.getUserName());
			us.setPasswordHash(MD5Utility.generatePasswordHash(u.getPassword()));
			udao.addUser(us);
			
		}
		
	}

	public String loginUser(User u) throws InvalidUserException {
		
		if(u.getUserName() == null || u.getPassword() == null)
		{
			throw new InvalidParameterException("User name or password is null");
		}
		else
		{
			return udao.loginUser(u);
		}	
		//return null;
	}
	
	
	public void logoutUser(User u) throws InvalidUserException {
		
		if(u.getUserName() == null || u.getToken() == null)
		{
			throw new InvalidParameterException("User name or password is null");
		}
		else
		{
			 udao.logoutUser(u);
		}	
		//return null;
	}
	
	public User validateUserLogin(User u) throws InvalidUserException
	{
		
		if(u.getUserName() == null || u.getToken() == null)
		{
			throw new InvalidParameterException("User name or password is null");
		}
		else
		{
			
		
			UserSchema us =  udao.validateUserLogin(u);
			User user = new User(us.getUserId(), us.getUserName());
			return user;
		}
		//return false;
		
	}

	public void deleteUser(User u) throws InvalidUserException {
		// TODO Auto-generated method stub
		
	}

	public User readUser(int userId) throws InvalidUserException {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	public User readUser(String u)
	{
		User u1 = new User();
		UserSchema myuser = udao.findUser(u);
		u1.setUserid(myuser.getUserId());
		u1.setUserName(myuser.getUserName());
		return u1;
	}

	public void updateUser(User u) throws InvalidUserException {
		// TODO Auto-generated method stub
		
	}
	
//	public int generatePasswordHash(String password)
//	{
//		return password.charAt(0);
//	}

	
}
