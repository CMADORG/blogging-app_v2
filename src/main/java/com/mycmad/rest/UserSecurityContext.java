package com.mycmad.rest;

import java.security.Principal;

import javax.ws.rs.core.SecurityContext;

import com.mycmad.api.User;

public class UserSecurityContext implements SecurityContext {

	private User secuser;
	

	
	public UserSecurityContext(User secuser) {
		super();
		this.secuser = secuser;
	}




	@Override
	public Principal getUserPrincipal() {
		// TODO Auto-generated method stub
		return this.secuser;
	}

	@Override
	public boolean isSecure() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isUserInRole(String arg0) {
		// TODO Auto-generated method stub
		return false;
	}
	
	@Override
	public String getAuthenticationScheme() {
		// TODO Auto-generated method stub
		return SecurityContext.BASIC_AUTH;
	}


}
