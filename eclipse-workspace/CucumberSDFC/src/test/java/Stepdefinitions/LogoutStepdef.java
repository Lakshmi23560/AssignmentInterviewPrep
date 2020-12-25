package Stepdefinitions;

import org.junit.Assert;

import PageObjects.PoHomePage;
import PageObjects.PoLogin;
import Utilities.TestBase;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LogoutStepdef extends TestBase {

	// public WebDriver driver;
	PoLogin pologin;
	PoHomePage pohome;

	@Given("Login into salesforce application")
	public void login_into_salesforce_application() {
		// TestBase.Initialize();
		System.out.println("Launch the application");
	}

	@When("Enter username {string} and password {string} click on login button")
	public void enter_username_and_password_click_on_login_button(String username, String pwd) {
		pologin = new PoLogin(driver);
		pologin.loginToApp(username, pwd);
	}

	@When("In home page click on usermenu and click on logout")
	public void in_home_page_click_on_usermenu_and_click_on_logout() {
		pohome = new PoHomePage(driver);
		pohome.LogOutApp();
	}

	@Then("Salesforce login page should display.")
	public void salesforce_login_page_should_display() {
		String Expected_title = "https://na111.salesforce.com/secur/logout.jsp";
		String Actual_title = driver.getCurrentUrl();
		Assert.assertEquals(Expected_title, Actual_title);
		// driver.close();
	}
}
