package Stepdefinitions;

import org.openqa.selenium.support.ui.Select;

import PageObjects.PoHomePage;
import PageObjects.PoLogin;
import Utilities.TestBase;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ManageUsersRoles extends TestBase {

	PoLogin pologin;
	PoHomePage pohome;

	@Given("login to saleseforce with username {string} and password {string}")
	public void login_to_saleseforce_with_username_and_password(String username, String pwd) {
		// TestBase.Initialize();
		pologin = new PoLogin(driver);
		pologin.loginToApp(username, pwd);
	}

	@When("click on manage users in home page and then click on roles")
	public void click_on_manage_users_in_home_page_and_then_click_on_roles() {
		pohome = new PoHomePage(driver);
		pohome.manageUsers.click();
		pohome.Roles.click();

	}

	@When("click on product based sample in downdrop")
	public void click_on_product_based_sample_in_downdrop() {
		pohome.Rolesdropdown.click();
		Select select = new Select(pohome.Rolesdropdown);
		select.selectByIndex(1);
	}

	@Then("product based sample roles should display")
	public void product_based_sample_roles_should_display() {
		System.out.println("product based sample roles hierarchy is displayed");
	}

}
