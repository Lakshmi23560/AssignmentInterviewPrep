package Utilities;

import java.time.Duration;
import java.util.NoSuchElementException;
import java.util.function.Function;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.FluentWait;

import com.relevantcodes.extentreports.LogStatus;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BrowserUtilities extends TestBase {

	Logger log = Logger.getLogger(getClass().getSimpleName());

	public WebDriver launchBrowser(String browser) throws Exception {
		if (browser.toLowerCase().startsWith("ch")) {
			WebDriverManager.chromedriver().setup();
			log.info("Browser is launched");
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
		driver.manage().window().maximize();

		return driver;
	}

	public boolean waitForElementVisible(WebDriver driver, final WebElement ele, int iTimeInSeconds) {

		FluentWait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(iTimeInSeconds))
				.pollingEvery(Duration.ofMillis(500)).ignoring(NoSuchElementException.class);

		wait.until(new Function<WebDriver, WebElement>() {

			public WebElement apply(WebDriver driver) {
				if (ele.isDisplayed()) {
					return ele;
				} else {
					return null;
				}
			}
		});
		return ele.isDisplayed();

	}

	public void ufSendKeys(WebDriver driver, WebElement username, String keysToSend) throws Exception {
		log.info("ufSendKeys function called");
		ufSendKeys(driver, username, keysToSend, oCons.WAIT_COMMON);
	}

	public void ufSendKeys(WebDriver driver, WebElement ele, String keysToSend, int iTimeInSeconds) throws Exception {
		waitForElementVisible(driver, ele, iTimeInSeconds);
		log.info("ufSendKeys function called");
		ele.sendKeys(keysToSend);
	}

	public void ufClick(WebDriver driver, WebElement ele) throws Exception {
		log.info("ufClick function called");
		ufClick(driver, ele, oCons.WAIT_COMMON);
	}

	public void ufClick(WebDriver driver, WebElement ele, int iTimeInSeconds) throws Exception {
		waitForElementVisible(driver, ele, iTimeInSeconds);
		log.info("ufClick function called");
		ele.click();
	}

	// verify expected text with actual text
	public boolean verify_Text(String actualText, String expectedText, String elementName) {
//					System.out.println(actualText +" "+expectedText);
		if (actualText.contains(expectedText)) {
			logger.log(LogStatus.PASS, elementName + " text is validated");
			log.info(elementName + " text is validated");
			return true;
		} else {
			logger.log(LogStatus.FAIL, elementName + " text is not validated");
			log.info(elementName + " text is not validated");
			return false;

		}
	}

}
