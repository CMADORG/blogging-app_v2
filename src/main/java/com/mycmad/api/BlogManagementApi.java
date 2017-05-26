package com.mycmad.api;

import javax.ws.rs.core.SecurityContext;

import com.mycmad.schema.Blog;

public interface BlogManagementApi {

	public String[] readMyTitles();
	
	public Blog readBlog(int blogId);
	void addBlog(Blog blog, SecurityContext usercontext);
	
	
}
