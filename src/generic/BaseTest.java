package generic;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest implements IAutoConstant {
	public WebDriver driver;
	static {
		// set the path of all browser drivers executable
		System.setProperty(GECKO_KEY, GECKO_PATH);
		System.setProperty(CHROME_KEY, CHROME_PATH);
		System.setProperty(IE_KEY, IE_PATH);
	}
	
	@BeforeMethod
	public void openApplication() {
		// Launch browser
		driver = new FirefoxDriver();
		//enter URL
		driver.get(Lib.getPropertyValue("URL"));
		//driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	
	@AfterMethod
	public void closeApplication(ITestResult res) {
		//capture screenshot
		if(ITestResult.FAILURE==res.getStatus()) {
			Lib.captureScreeshot(driver, res.getName());
		}
		
		// close browser
		driver.close();
	}

}
