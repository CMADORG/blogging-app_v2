package com.mycmad.rest;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.Consumes;
import javax.ws.rs.CookieParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.NewCookie;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.Provider;

import com.mycmad.api.User;
import com.mycmad.blogexceptions.InvalidUserException;
import com.mycmad.service.UserManagementService;


@Path("")
public class UserRestServices{
	
	UserManagementService ums = new UserManagementService();
	
	@POST
	@Path("/user")
	@Consumes(MediaType.APPLICATION_JSON)
	public  Response addUsers(User user)
	{
		//Request
		ums.addUser(user);		
		return Response.ok(200).build();
	}
	
	@POST
	@Path("/login")
	@Consumes(MediaType.APPLICATION_JSON)
	public  Response loginUser(User user)
	{
		//Request
		String token = ums.loginUser(user);
		StringBuffer sb = new StringBuffer();
		sb.append(user.getUserName() + ".");
		sb.append(token);
		return Response.ok(200).cookie(new NewCookie("token", sb.toString())).build();
	}
	
	@POST
	@Path("/sub")
	@Produces(MediaType.APPLICATION_JSON)
	public  Response getUser()
	{
		System.out.println("Test service");
		 User u = new User();
		 u.setUserName("Sankar");
		 u.setPassword("sdfsa");
		 u.setToken("hi");
		return Response.ok(200).entity(u).build();
	} 
	
	@POST
	@Path("/sub1")
	@Produces(MediaType.TEXT_HTML)
	public  String getUser1()
	{
		System.out.println("Test service");
		 User u = new User();
		 u.setUserName("Sankar");
		 u.setPassword("sdfsa");
		 u.setToken("hi");
		 return "<html> " + "<title>" + "Hello Jersey" + "</title>"
	     + "<body><h1>" + "Hello Jersey" + "</body></h1>" + "</html> ";
	}
	
	
	 

	@POST
	@Path("/logout")
	public  Response logOutUser(@CookieParam("token") String userval /*User u*/)
	{
		System.out.println("UserRestServices.logOutUser() -- " +userval);
		
		if(userval.contains(".") == false)
		{
			throw new InvalidUserException("Invalid username or password");
		}
		String[] split = userval.split("[.]");
		if(split.length != 2)
		{
			throw new InvalidUserException("Invalid username or password");
		}
		//System.out.println(split[0]);
		//System.out.println(split[1]);
		
		User u = new User();
		u.setUserName(split[0]);
		u.setToken(split[1]);
		ums.logoutUser(u);
	
	   return Response.ok(200).cookie(new NewCookie("token", null)).build();
		
	} 

}
