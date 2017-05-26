package myusertest;

import com.mycmad.service.UserManagementService;
import static org.junit.Assert.fail;
import org.junit.Test;
import com.mycmad.api.User;


public class LoginUserTest {
	
	@Test
	public void loginUser_positiveCase()
	{
		UserManagementService ums = new UserManagementService();
		User u =  new User();
		u.setUserName("san");
		u.setPassword("san");
		try{
		ums.loginUser(u);
		}
		catch(Exception e)
		{
			e.printStackTrace();
			fail();
		}
	}
	
	@Test
	public void loginUser_negativeCase()
	{
		UserManagementService ums = new UserManagementService();
		User u =  new User();
		u.setUserName("san");
		u.setPassword("sank");
		try{
		ums.loginUser(u);
		fail();
		}
		catch(Exception e)
		{
			e.printStackTrace();
			//fail();
		}
	}
	
	
}
