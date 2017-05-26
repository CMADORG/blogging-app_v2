package myblogtest;

import static org.junit.Assert.*;
import myusertest.*;
import javax.ws.rs.core.SecurityContext;

import org.junit.Test;

import com.mycmad.api.User;
import com.mycmad.rest.UserSecurityContext;
import com.mycmad.schema.Blog;
import com.mycmad.service.BlogManagementService;

public class AddBlogTest {
	
	@Test
	public void addblog_valid()
	{
		BlogManagementService bms =  new BlogManagementService();
		/*******************************/
		User u = new User();
		u.setUserName(new String("Sankar"));
		u.setPassword(new String("password"));
		
		SecurityContext sc = new UserSecurityContext(u);
		/************************************/
		AddUserTest aut = new AddUserTest();
		//aut.testAddUser_validinput();
		
		Blog b = new Blog();
		b.setBlogText("Hello this is my new blog sfadf");
		b.setBlogtitle("Hello Blog");
		System.out.println("AddBlogTest.addblog_valid()");
		try{
		bms.addBlog(b, sc);
		}
		catch(Exception e)
		{
			fail();
		}
		
		
		
	}

}
