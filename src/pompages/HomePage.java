package pompages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	
	
    // Declaretion
	@FindBy(xpath="(//div[@class='popup_menu_icon'])[3]")
	WebElement helpBtn;
	
	@FindBy(xpath="//a[contains(text(),'About your')]")
	WebElement aboutBtn;
	
	@FindBy(id="aboutPopupCloseButtonId")
	WebElement closeBtn;
	
	@FindBy(xpath="//a[text()='Logout']")
	WebElement logoutBtn;
	
	
	//Initialization
	public HomePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	//utilization
	public void clickHelp() {
		helpBtn.click();
	}
	public void clickAbout() {
		aboutBtn.click();
	}
	
	public void closePopup() {
		closeBtn.click();
	}
	
	public void clickLogout() {
		logoutBtn.click();
	}
}
