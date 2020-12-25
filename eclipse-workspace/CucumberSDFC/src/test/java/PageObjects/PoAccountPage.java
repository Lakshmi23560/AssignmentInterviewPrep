package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Utilities.TestBase;

public class PoAccountPage extends TestBase {

	public PoAccountPage(WebDriver driver) {
		// this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//input[@name='new']")
	public WebElement accountNew_Button;
	@FindBy(xpath = "//input[@id='acc2']")
	public WebElement accountName;
	@FindBy(xpath = "//div[contains(@class,'pbBottomButtons')]//input[1]")
	public WebElement accountSave_Button;
//	@FindBy(xpath = "//h2[contains(text(),'Marry')]")
//	public WebElement checkaccountname;
}
