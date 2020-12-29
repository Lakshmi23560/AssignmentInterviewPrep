package Utilities;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.Assert;

import com.relevantcodes.extentreports.LogStatus;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BrowserUtilities extends Testbase {

	public WebDriver launchBrowser(String browser) throws Exception {
		System.out.println(browser);
		if (browser.toLowerCase().startsWith("ch")) {
			WebDriverManager.chromedriver().setup();
			// log.info("Browser is launched");
			ChromeOptions chromeOptions = new ChromeOptions();
			chromeOptions.addArguments("--disable-notifications");
			driver = new ChromeDriver(chromeOptions);
		} else if (browser.equalsIgnoreCase("ff") || browser.toLowerCase().startsWith("fi")) {
			// create firefox instance
			WebDriverManager.firefoxdriver().setup();
			FirefoxOptions options = new FirefoxOptions();
			options.setProfile(new FirefoxProfile());
			options.addPreference("dom.webnotifications.enabled", false);
			driver = new FirefoxDriver(options);
		} else if (browser.equalsIgnoreCase("Edge")) {
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
		} else if (browser.equalsIgnoreCase("ie")) {
			WebDriverManager.iedriver().setup();
			driver = new InternetExplorerDriver();
		} else {
			// If no browser passed throw exception
			throw new Exception("Browser is not correct");
		}
		driver.get(prop.getProperty("url"));
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		return driver;
	}

	// verify element is displayed
	public boolean isDisplayed(WebElement webelement, String elementName) {
		if (webelement.isDisplayed()) {
			logger.log(LogStatus.PASS, elementName + " is displayed");
			return true;
		} else {
			logger.log(LogStatus.FAIL, elementName + " is not displayed");
			return false;
		}
	}

	// verify element is present
	public boolean isPresent(WebElement webelement, String elementName) {

		if (webelement.isDisplayed() && webelement.isEnabled()) {
			logger.log(LogStatus.PASS, elementName + "is present");
			return true;
		} else {
			logger.log(LogStatus.FAIL, elementName + " is not displayed or enabled");
			return false;
		}
	}

	// click
	public boolean Click(WebElement webelement, String elementName) throws InterruptedException {

		if (isPresent(webelement, elementName)) {
			webelement.click();
			logger.log(LogStatus.PASS, elementName + " is clicked successfully");
			return true;
		} else {
			logger.log(LogStatus.FAIL, elementName + " is not clicked");
			return false;
		}
	}

	// enter text and validate
	public boolean enterText(WebElement webelement, String text, String TextboxName) {
		if (isPresent(webelement, TextboxName)) {

			webelement.clear();
			webelement.sendKeys(text);
			logger.log(LogStatus.INFO, "Text is entered in " + TextboxName);
			Assert.assertTrue(verify_Text(text, webelement.getAttribute("value"), TextboxName));
			logger.log(LogStatus.PASS, "Text is entered in " + TextboxName + " successfully and verified");
			return true;
		} else {
			logger.log(LogStatus.FAIL, "Text is not entered in " + TextboxName);
			return false;
		}
	}

	// verify expected text with actual text
	public boolean verify_Text(String actualText, String expectedText, String elementName) {
//				System.out.println(actualText +" "+expectedText);
		if (actualText.contains(expectedText)) {
			logger.log(LogStatus.PASS, elementName + " text is validated");
			return true;
		} else {
			logger.log(LogStatus.FAIL, elementName + " text is not validated");
			return false;

		}
	}
}
