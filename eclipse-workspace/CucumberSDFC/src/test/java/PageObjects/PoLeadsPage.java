package PageObjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import Utilities.TestBase;

public class PoLeadsPage extends TestBase {

	public PoLeadsPage(WebDriver driver) {
		// this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//select[@id='fcf']")
	public WebElement leads_dropDown;
	@FindBy(xpath = "//span[@class='fBody']//input[@name='go']")
	public WebElement go_Button;
	@FindBy(xpath = "//input[@name='new']")
	public WebElement new_leadButton;
	@FindBy(xpath = "//input[@id='name_lastlea2']")
	public WebElement lastName;
	@FindBy(xpath = "//input[@id='lea3']")
	public WebElement companyName;
	@FindBy(xpath = "//div[contains(@class,'pbHeader')]//input[1]")
	public WebElement save_Button;

	public void LeadssDropdown() {
		Select selectviewdropdown = new Select(leads_dropDown);
		List<WebElement> viewdropdownoptions = selectviewdropdown.getOptions();
		String actualdropdownoptions = "All Open Leads;My Unread Leads;Recently Viewed Leads;Today's Leads;View - Custom 1;View - Custom 2";
		String arr[] = actualdropdownoptions.split(";");
		for (String Str : arr) {
			boolean flag = false;
			for (WebElement ele : viewdropdownoptions) {
				if (Str.equalsIgnoreCase(ele.getText())) {
					flag = true;
					System.out.println(Str + " exists in View dropdown");
					break;
				}
			}
			if (!flag) {
				System.out.println(Str + " does not exists in  View dropdown");
			}
		}
	}
}
