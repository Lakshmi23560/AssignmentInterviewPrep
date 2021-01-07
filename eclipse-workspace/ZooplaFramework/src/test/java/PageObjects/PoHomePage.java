package PageObjects;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.relevantcodes.extentreports.LogStatus;

import Utilities.TestBase;

public class PoHomePage extends TestBase {

	Logger log = Logger.getLogger(getClass().getSimpleName());
	@FindBy(xpath = "//button[@class='ui-button-secondary']")
	public WebElement saveMyPreferences;

	@FindBy(xpath = "//input[@id='search-input-location']")
	public WebElement searchBox;

	@FindBy(xpath = "//a[@href='/house-prices/']")
	public WebElement housePrices;

	@FindBy(xpath = "//input[@id='search-input-location']")
	public WebElement searchPrices;

	@FindBy(xpath = "//li[@class='ui-first-child']")
	public WebElement selectPlaces;

	public PoHomePage(WebDriver driver) throws IOException {
		PageFactory.initElements(driver, this);
	}

//	validating homepage
	public String validateHomePage() {
		return driver.getTitle();
	}

//	entering text in searchbox
	public void enterTextSearchBox(String text) throws Exception {
		// Thread.sleep(5000);
		oBrowsUtil.ufClick(driver, saveMyPreferences, 30);
		oBrowsUtil.ufSendKeys(driver, searchBox, text, 30);
		searchBox.sendKeys(Keys.ENTER);
		logger.log(LogStatus.PASS, "Text entered in textbox and pressed enter");
		log.info("Text entered in textbox and pressed enter");
	}

}
