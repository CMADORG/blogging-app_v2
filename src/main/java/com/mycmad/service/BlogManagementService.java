package com.mycmad.service;

import javax.ws.rs.core.Context;
import javax.ws.rs.core.SecurityContext;

import com.mycmad.api.BlogManagementApi;
import com.mycmad.api.User;
import com.mycmad.data.BlogDAO;
import com.mycmad.data.JPABlogDAO;
import com.mycmad.data.JPAUserDAO;
import com.mycmad.schema.Blog;
import com.mycmad.schema.UserSchema;

public class BlogManagementService implements BlogManagementApi {

	JPABlogDAO bdao = new JPABlogDAO();
	
	JPAUserDAO udao = new JPAUserDAO();
	
	public void testDAO()
	{
	bdao.printfemf();	
	}
	@Override
	public String[] readMyTitles() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void addBlog(Blog blog, @Context SecurityContext sc) {
		User user = (User) sc.getUserPrincipal();
		System.out.println("BlogManagementService.addBlog()" +user);
		System.out.println("BlogManagementService.addBlog() " +user.getUserName());
		UserSchema myuser =  udao.findUser(user.getName());//UserSchema.createSchema(user);
		System.out.println("BlogManagementService.addBlog() " +myuser.getUserId() +myuser.getUserName());
		blog.setUser(myuser);
		bdao.addBlog(blog);
	}

	@Override
	public Blog readBlog(int blogId) {
		// TODO Auto-generated method stub
		return null;
	}

}
