package com.mycmad.rest;

import javax.ws.rs.ApplicationPath;

import org.glassfish.jersey.server.ResourceConfig;

@ApplicationPath("/")
public class BlogApplication extends ResourceConfig {
	public BlogApplication() {
		packages("com.mycmad.rest");
	}
}
