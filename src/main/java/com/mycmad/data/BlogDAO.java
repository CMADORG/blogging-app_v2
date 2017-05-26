package com.mycmad.data;

import com.mycmad.schema.Blog;

public interface BlogDAO {
	
	public String[] readMyTitles();
	public void addBlog(Blog blog);
	public Blog readBlog(int blogId);
	
	

}
