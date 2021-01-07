package PageObjects;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.relevantcodes.extentreports.LogStatus;

import Utilities.TestBase;

public class PoPropertiesListingPage extends TestBase {

	Logger log = Logger.getLogger(getClass().getSimpleName());
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
	public void selectdropdownHighestprice() throws Exception {
		oBrowsUtil.ufClick(driver, sortOrderDropdown, 30);
		Select s = new Select(sortOrderDropdown);
		s.selectByVisibleText("Highest price");
		logger.log(LogStatus.PASS, "dropdown value is selected");
		log.info("dropdown  'Highest price' value is selected");
	}

	public void selectFifthListing() throws Exception {

		oBrowsUtil.ufClick(driver, listing5th, 30);
		// listing5th.click();
		logger.log(LogStatus.PASS, "selected fifth listing property");
		log.info("dropdown  'Highest price' value is selected");
	}

}
