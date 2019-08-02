package scripts;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import generic.BaseTest;
import generic.Lib;
import pompages.HomePage;
import pompages.LoginPage;

public class ValidateProductVersion_ActiTime extends BaseTest {
	@Test
	public void testLogin() throws Exception {
		LoginPage login = new LoginPage(driver);
		//enter username
		String un = Lib.getCellValue("ValidLogin", 1, 0);
		login.setUsername(un);
		System.out.println("username-->"+un);
		Thread.sleep(2000);
		//enter password
		String pwd = Lib.getCellValue("ValidLogin", 1, 1);
		login.setPassword(pwd);
		System.out.println("password-->"+pwd);
		Thread.sleep(2000);
		// click login
		login.clickLogin();
		Thread.sleep(10000);
		//driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		//explicit wait
		/*WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.titleIs("actiTIME - Enter Time-Track"));
		Assert.assertEquals(driver.getTitle(), "actiTIME - Enter Time-Track");*/
		
		//homepage
		HomePage home = new HomePage(driver);
		
		// click on help button
		home.clickHelp();
		Thread.sleep(3000);
		
		// click on about your actitime
		home.clickAbout();
		
		String expProductVersion = Lib.getCellValue("Help", 1, 0);
		String xpOfProductVersion="//td[contains(text(), 'Product Version:')]/following-sibling::td/span[text()='actiTIME 2019.2 Pro']";
		
		WebElement productVersion = driver.findElement(By.xpath(xpOfProductVersion));
		
	   String actProductVersion = productVersion.getText();
	   Assert.assertEquals(expProductVersion, actProductVersion);
	   Reporter.log("Product Version is correct", true);
	   
	   // close popup window
	   home.closePopup();
	   Thread.sleep(3000);
	   
	   //click on logout
	   home.clickLogout();
	   Reporter.log("Logged Out", true);
	             
	}

}
