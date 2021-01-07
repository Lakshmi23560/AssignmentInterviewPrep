package TestCases;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import PageObjects.PoAgentsPage;
import PageObjects.PoHomePage;
import PageObjects.PoPropertiesListingPage;
import PageObjects.PoPropertyPage;
import Utilities.TestBase;

public class SearchProperties extends TestBase {
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
		String[][] data = { { "London", "Panther International Properties" } };
		return data;
	}

	@Test(dataProvider = "DataInput")
	public void searchPropertyTC(String Location, String agentname) throws Exception {
		driver.get(oCons.getAppURL());
		String homePageTitle = "Zoopla > Search Property to Buy, Rent, House Prices, Estate Agents";
		String ActualTitle = homepage.validateHomePage();
		boolean result = oBrowsUtil.verify_Text(ActualTitle, homePageTitle, "HomePage");
		Assert.assertTrue(result);
		homepage.enterTextSearchBox(Location);
		PropertiesListingPage.validatePropertiesPage();
		PropertiesListingPage.selectdropdownHighestprice();
		Thread.sleep(5000);
		PropertiesListingPage.selectFifthListing();
		String propertypagetitle = driver.getTitle();
		System.out.println(propertypagetitle);
		String propertypageAgent = propertypage.getAgentName();
		System.out.println("propertypage agent name : " + propertypageAgent);
		Thread.sleep(5000);
		propertypage.clickOnAgentName();
		Thread.sleep(5000);
		String agentspagename = agentspage.validateAgentName();
		if (agentspagename.contains(agentname)) {
			logger.log(LogStatus.PASS, "property's page agent name and agent's page name are same");
		} else {
			logger.log(LogStatus.FAIL, "property's page agent name and agent's page name are not same"
					+ logger.addScreenCapture(takeScreenshot()));
		}

	}
}
