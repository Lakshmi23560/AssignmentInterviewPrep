package PageObjects;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.relevantcodes.extentreports.LogStatus;

import Utilities.Testbase;

public class PoHomePage extends Testbase {

	@FindBy(id = "search-box-input")
	WebElement searchBox;

	@FindBy(className = "guts")
	WebElement Popup;

	@FindBy(tagName = "a")
	List<WebElement> cityList;

	public PoHomePage(WebDriver driver) throws IOException {
		PageFactory.initElements(driver, this);
	}

//	validating homepage
	public String validateHomePage() {
		return driver.getTitle();
	}

//	entering text in searchbox
	public void enterTextSearchBox(String text) throws InterruptedException {
		searchBox.sendKeys(text);
		searchBox.sendKeys(Keys.ENTER);
		logger.log(LogStatus.PASS, "Text entered in textbox and pressed enter");
	}

//	validating popup appears
	public void popupValidation() {
		Assert.assertTrue(oBrowsUtil.isDisplayed(Popup, "Pop up Did you mean"));
	}

//	select city from popup

	public void selectCityPopUp(String cityToBeSelected) {
		List<WebElement> li = driver.findElements(By.xpath("//div[@class='guts']//a"));
		System.out.println(li.size());
		for (WebElement city : li) {
			String attributeValue = city.getAttribute("href");

			if (cityToBeSelected.equals(attributeValue)) {

				JavascriptExecutor executor = (JavascriptExecutor) driver;
				executor.executeScript("arguments[0].click();", city);
				logger.log(LogStatus.PASS, "city selected from popup");
				break;
			}
		}
	}
}
