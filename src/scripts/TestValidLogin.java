package scripts;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import generic.BaseTest;
import generic.Lib;
import pompages.LoginPage;

public class TestValidLogin extends BaseTest{
	@Test
	public void testValidLogin() throws Exception {
		
		// enter username - admin
		LoginPage login = new LoginPage(driver);
		String un = Lib.getCellValue("ValidLogin", 1, 0);
		login.setUsername(un);
		System.out.println("username-->"+un);
		Thread.sleep(2000);
		// set password
		String pwd = Lib.getCellValue("ValidLogin", 1, 1);
		login.setPassword(pwd);
		System.out.println("password-->"+pwd);
		Thread.sleep(2000);
		// click login
		login.clickLogin();
		Thread.sleep(5000);
		String homePageTitle = driver.getTitle();
		System.out.println(homePageTitle);
		/*Assert.fail();
		String ahomePageTitle = driver.getTitle();
		if (ahomePageTitle.equals("wrong page")) {
			System.out.println("login successful");
			
		} else {
			System.out.println("login failed..");

		}*/
	}

}
