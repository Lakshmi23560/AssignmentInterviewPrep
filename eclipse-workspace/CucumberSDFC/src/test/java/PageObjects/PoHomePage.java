package PageObjects;

import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Utilities.TestBase;

public class PoHomePage extends TestBase {

	public PoHomePage(WebDriver driver) {
		// this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//span[@id='userNavLabel']")
	public WebElement userMenuName;

	@FindBy(xpath = "//a[contains(text(),'Logout')]")
	public WebElement logout;

	@FindBy(xpath = "//a[@class='debugLogLink menuButtonMenuLink']")
	public WebElement developerConsole;

	@FindBy(xpath = "//a[@id='Users_font']")
	public WebElement manageUsers;

	@FindBy(xpath = "//a[@id='Roles_font']")
	public WebElement Roles;

	@FindBy(xpath = "//select[@id='samples']")
	public WebElement Rolesdropdown;

	@FindBy(xpath = "//li[@id='Account_Tab']//a[contains(text(),'Accounts')]")
	public WebElement accountTab;

	@FindBy(xpath = "//li[@id='Lead_Tab']//a[contains(text(),'Leads')]")
	public WebElement leadsTab;

	@FindBy(xpath = "//li[@id='Contact_Tab']//a[contains(text(),'Contacts')]")
	public WebElement contactsTab;

	public void LogOutApp() {
		userMenuName.click();
		logout.click();
	}

	public int ufgetWindowHandles(WebDriver driver) {
		String mainwindow = driver.getWindowHandle();
		Set<String> getAllWindows = driver.getWindowHandles();
		int windowsize = getAllWindows.size();
		System.out.println(windowsize);
		String[] getwindow = getAllWindows.toArray(new String[getAllWindows.size()]);
		driver.switchTo().window(getwindow[1]).getCurrentUrl();
		driver.close();
		driver.switchTo().window(mainwindow);
		return windowsize;
	}

}
