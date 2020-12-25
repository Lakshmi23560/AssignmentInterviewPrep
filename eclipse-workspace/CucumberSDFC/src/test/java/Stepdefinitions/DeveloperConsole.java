package Stepdefinitions;

import PageObjects.PoHomePage;
import PageObjects.PoLogin;
import Utilities.TestBase;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class DeveloperConsole extends TestBase {

	PoLogin pologin;
	PoHomePage pohome;

	@Given("login to salesforce application with username {string} and password {string}")
	public void login_to_salesforce_application_with_username_and_password(String username, String pwd) {
		// TestBase.Initialize();
		pologin = new PoLogin(driver);
		pologin.loginToApp(username, pwd);

	}

	@When("click on usermenu")
	public void click_on_usermenu() {
		pohome = new PoHomePage(driver);
		pohome.userMenuName.click();

	}

	@When("click on Developer Console option from usermenu dropdown")
	public void click_on_developer_console_option_from_usermenu_dropdown() {
		pohome.developerConsole.click();
	}

	@Then("Developer Console window should display")
	public void developer_console_window_should_display() {
		pohome.ufgetWindowHandles(driver);
		System.out.println("Developer Console window is displayed");
	}
}
