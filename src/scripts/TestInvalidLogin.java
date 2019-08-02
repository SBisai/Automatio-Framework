package scripts;

import org.testng.annotations.Test;
import org.testng.annotations.Test;

import generic.BaseTest;
import generic.Lib;
import pompages.LoginPage;

public class TestInvalidLogin extends BaseTest {
	@Test
	public void testInvalidLogin() throws Exception {
		LoginPage login = new LoginPage(driver);
		// for username
		for(int i=1; i<= Lib.getTotalRowCount("InvalidLogin"); i++) {
			String un = Lib.getCellValue("InvalidLogin", i, 0);
			login.setUsername(un);
			System.out.println("username-->"+un);
			Thread.sleep(1000);
			String pwd = Lib.getCellValue("InvalidLogin", i, 1);
			login.setPassword(pwd);
			System.out.println("password-->"+pwd);
			Thread.sleep(1000);
			login.clickLogin();
			Thread.sleep(10000);
		}	 
		
		
		
	}
	

}
