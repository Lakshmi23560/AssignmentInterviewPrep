package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Utilities.TestBase;

public class PoContacts extends TestBase {

	public PoContacts(WebDriver driver) {
		// this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//input[@name='new']")
	public WebElement new_Button;
	@FindBy(xpath = "//input[@id='name_lastcon2']")
	public WebElement lastName;
	@FindBy(xpath = "//input[@id='con4']")
	public WebElement accountName;
	@FindBy(xpath = "//div[contains(@class,'pbHeader')]//input[1]")
	public WebElement save_Button;
	@FindBy(xpath = "//td[@id='topButtonRow']//input[contains(@name,'save_new')]")
	public WebElement saveAndNew_Button;
	@FindBy(xpath = "//select[@id='hotlist_mode']")
	public WebElement recentlyCreated_dropDown;
}
