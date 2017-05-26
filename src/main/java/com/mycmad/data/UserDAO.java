package com.mycmad.data;

import com.mycmad.api.User;
import com.mycmad.blogexceptions.DuplicateUserException;
import com.mycmad.blogexceptions.InvalidParameterException;
import com.mycmad.blogexceptions.InvalidUserException;
import com.mycmad.schema.UserSchema;

public interface UserDAO {
	
	public boolean addUser(UserSchema u) throws DuplicateUserException;
	public String loginUser(User u) throws InvalidUserException;
	public UserSchema findUser(String name);
	public UserSchema validateUserLogin(User u) throws InvalidUserException;
	public void logoutUser(User u) throws InvalidUserException;
}
