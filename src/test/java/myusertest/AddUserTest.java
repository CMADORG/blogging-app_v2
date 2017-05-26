package myusertest;

import static org.junit.Assert.fail;

import org.junit.Test;

import com.mycmad.api.User;
import com.mycmad.blogexceptions.DuplicateUserException;
import com.mycmad.blogexceptions.InvalidParameterException;
import com.mycmad.service.BlogManagementService;
import com.mycmad.service.UserManagementService;
public class AddUserTest {

	public AddUserTest() {
		// TODO Auto-generated constructor stub
	}

	@Test
	public void testAddUser_validinput()
	{
		UserManagementService ums = new UserManagementService();
		BlogManagementService bms = new BlogManagementService();
		bms.testDAO();
		ums.testDAO();
	
		User u = new User();
		String name = new String("Sankar");
		String password = new String("password");
		u.setUserName(name);
		u.setPassword(password);
		try{
		ums.addUser(u);
			}
		catch(InvalidParameterException e)
		{
			e.printStackTrace();
			fail();
		}
		catch(DuplicateUserException e)
		{
			e.printStackTrace();
			fail();
		}
		
	}
	
	@Test
	public void testAddUser_invalidinput()
	{
		UserManagementService ums = new UserManagementService();
		User u = new User();
		u.setUserName(null);
		u.setPassword(null);
		try{
		ums.addUser(u);
		fail();
			}
		catch(InvalidParameterException e)
		{
			e.printStackTrace();
			//fail();
		}
		
	}
	
	@Test
	public void testAddUser_duplicateuser()
	{
		UserManagementService ums = new UserManagementService();
		User u = new User();
		String name = new String("Sankar");
		String password = new String("password");
		u.setUserName(name);
		u.setPassword(password);
		try{
		ums.addUser(u);
		fail();
			}
		catch(InvalidParameterException e)
		{
			e.printStackTrace();
			fail();
		}
		catch(DuplicateUserException e)
		{
			e.printStackTrace();
		}
		
	}
	
	@Test
	public void testFindUser()
	{
	   UserManagementService ums = new UserManagementService();
		User u = new User();
		String name = new String("Sankar");
		String password = new String("password");
		u.setUserName(name);
		u.setPassword(password);
		try{
		System.out.println("UserTest.testFindUser() " +ums.readUser("Sankar"));
		//fail();
			}
		catch(InvalidParameterException e)
		{
			
			e.printStackTrace();
			//fail();
		
		}
		
	}
	
	
}
