package com.mycmad.rest;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

import com.mycmad.blogexceptions.DuplicateUserException;
import com.mycmad.blogexceptions.InvalidParameterException;
@Provider
public class BlogExceptionMapper implements ExceptionMapper<Throwable> {

	@Override
	public Response toResponse(Throwable t) {
		t.printStackTrace();
		if(t instanceof DuplicateUserException)
		{
			return Response.status(400).build();
		}
		else if(t instanceof InvalidParameterException)
		{
			return Response.status(401).build();
		}
		else
		{
			return Response.status(402).build();
		}
	}

}
