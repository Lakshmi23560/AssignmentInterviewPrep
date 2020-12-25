package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Utilities.TestBase;

public class PoLogin extends TestBase {

	public PoLogin(WebDriver driver) { // initializing the page objects
		// this.driver = driver;
		PageFactory.initElements(driver, this); // Using this keyword all the below variables intialized with
												// the driver
	}

	@FindBy(xpath = "//input[@id='username']")
	public WebElement username;

	@FindBy(xpath = "//input[@id='password']")
	public WebElement password;

	@FindBy(xpath = "//input[@id='Login']")
	public WebElement button_login;

	public void loginToApp(String uname, String pwd) {

		username.sendKeys(uname);
		password.sendKeys(pwd);
		button_login.click();
	}

	public String ufgetTitle() {
		return driver.getTitle();

	}
}
