package com.mycmad.rest;

import java.io.IOException;
import java.util.Map;


import javax.ws.rs.client.ClientRequestContext;
import javax.ws.rs.client.ClientRequestFilter;
import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.container.PreMatching;
import javax.ws.rs.core.Cookie;
import javax.ws.rs.core.SecurityContext;
import javax.ws.rs.ext.Provider;

import com.mycmad.api.User;
import com.mycmad.blogexceptions.InvalidUserException;
import com.mycmad.service.UserManagementService;

@Provider
@PreMatching
public class BlogAuthenticator implements ContainerRequestFilter {

	@Override
	public void filter(ContainerRequestContext containerRequest) throws IOException {
		
		System.out.println("*******************coming here");
		containerRequest.setSecurityContext(null);
		
		if(containerRequest.getUriInfo().getPath().compareTo("user") != 0 && 
				containerRequest.getUriInfo().getPath().compareTo("login") != 0)
		{
			Map<String, Cookie> s = containerRequest.getCookies();
			Cookie ck = (Cookie) s.get(new String("token"));
			System.out.println("PSS --- " +ck.getValue());
			String token = ck.getValue();
			if(token.contains(".") == false)
			{
				throw new InvalidUserException("Invalid username or password");
			}
			String[] split = token.split("[.]");
			if(split.length != 2)
			{
				throw new InvalidUserException("Invalid username or password");
			}
			//System.out.println(split[0]);
			//System.out.println(split[1]);
			UserManagementService ums = new UserManagementService();
			User u = new User();
			u.setUserName(split[0]);
			u.setToken(split[1]);
			
			ums.validateUserLogin(u);
			UserSecurityContext userSecurityCtxt = new UserSecurityContext(u);
			containerRequest.setSecurityContext(userSecurityCtxt);
			
		}
		

	}

}
