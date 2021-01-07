package TestCases;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.Keys;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import PageObjects.PoAgentsPage;
import PageObjects.PoHomePage;
import PageObjects.PoPropertiesListingPage;
import PageObjects.PoPropertyPage;
import Utilities.TestBase;

public class CheckPrices extends TestBase {
	Logger log = Logger.getLogger(getClass().getSimpleName());
	PoHomePage homepage;
	PoPropertiesListingPage PropertiesListingPage;
	PoPropertyPage propertypage;
	PoAgentsPage agentspage;

	@BeforeClass
	public void setUp() throws IOException, InterruptedException {
		homepage = new PoHomePage(driver);
		PropertiesListingPage = new PoPropertiesListingPage(driver);
		propertypage = new PoPropertyPage(driver);
		agentspage = new PoAgentsPage(driver);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}

	@DataProvider(name = "DataInput")
	public String[][] destinationInputMethod() {
		String[][] data = { { "London Road, Addington, West Malling ME19" } };
		return data;
	}

	@Test(dataProvider = "DataInput")
	public void checkPriceTC(String Place) throws Exception {
		driver.get(oCons.getAppURL());
		oBrowsUtil.ufClick(driver, homepage.saveMyPreferences, 30);
		oBrowsUtil.ufClick(driver, homepage.housePrices, 30);
		oBrowsUtil.ufSendKeys(driver, homepage.searchPrices, Place, 30);
		homepage.searchPrices.sendKeys(Keys.ENTER);
		log.info("Place with prices has been shown in page");
	}
}
