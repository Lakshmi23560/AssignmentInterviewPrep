package Stepdefinitions;

import org.junit.Assert;

import PageObjects.PoLogin;
import Utilities.TestBase;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginStepdef extends TestBase {

	// public WebDriver driver;
	PoLogin pologin;

	@Before
	public void setUp() {
		TestBase.Initialize();
	}

	@After
	public void teardown() {
		driver.close();
	}

	@Given("Open the salesaforce login page")
	public void open_the_salesaforce_login_page() {
		// TestBase.Initialize();
		System.out.println("Launch the application");

	}

	@When("Enter correct username {string} and password {string}")
	public void enter_correct_username_and_password(String username, String pwd) {
		pologin = new PoLogin(driver);
		pologin.loginToApp(username, pwd);

	}

	@Then("Check home page is displayed")
	public void check_home_page_is_displayed() {
		String Expected_title = driver.getTitle();
		// System.out.println(title);
		String Actual_title = "Home Page ~ Salesforce - Developer Edition";
		Assert.assertEquals(Expected_title, Actual_title);
		System.out.println("Home Page is displayed");

	}

}
