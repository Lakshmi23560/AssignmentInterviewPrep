package PageObjects;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.relevantcodes.extentreports.LogStatus;

import Utilities.Testbase;

public class PoPropertiesListingPage extends Testbase {

	@FindBy(id = "sort-order-dropdown")
	WebElement sortOrderDropdown;

	@FindBy(xpath = "//div[@class='css-kdnpqc-ListingsContainer earci3d2']//div[5]")
	WebElement listing5th;

	public PoPropertiesListingPage(WebDriver driver) throws IOException {
		PageFactory.initElements(driver, this);
	}

//	validating properties list page
	public String validatePropertiesPage() {
		return driver.getTitle();
	}

//	select most recent dropdown
	public void selectdropdownHighestprice() throws InterruptedException {
		sortOrderDropdown.click();
		Thread.sleep(5000);
		Select s = new Select(sortOrderDropdown);
		s.selectByVisibleText("Highest price");

		logger.log(LogStatus.PASS, "dropdown value is selected");
	}

//	entering maximum value
	public void selectFifthListing() throws InterruptedException {

		Thread.sleep(3000);
		listing5th.click();
		logger.log(LogStatus.PASS, "selected fifth listing property");
	}

}
