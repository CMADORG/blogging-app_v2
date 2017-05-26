package myusertest;

import static org.junit.Assert.fail;

import org.junit.Test;

import com.mycmad.api.User;
import com.mycmad.service.UserManagementService;

public class Logout {
	//@Test
	public void loginUser_positiveCase()
	{
		UserManagementService ums = new UserManagementService();
		User u =  new User();
		u.setUserName("san");
		u.setPassword("san");
		try{
		ums.logoutUser(u);
		}
		catch(Exception e)
		{
			e.printStackTrace();
			fail();
		}
	}
}
