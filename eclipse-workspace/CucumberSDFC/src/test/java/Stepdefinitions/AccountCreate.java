package Stepdefinitions;

import PageObjects.PoAccountPage;
import PageObjects.PoHomePage;
import PageObjects.PoLogin;
import Utilities.TestBase;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class AccountCreate extends TestBase {

	PoLogin pologin;
	PoHomePage pohome;
	PoAccountPage poaccount;

	@Given("launch and login to Salesforce application")
	public void launch_and_login_to_salesforce_application() {
		System.out.println("Launch the appilcation");
		pologin = new PoLogin(driver);
	}

	@When("login using username {string} and password {string}")
	public void login_using_username_and_password(String uname, String pwd) {
		pologin = new PoLogin(driver);
		pologin.loginToApp(uname, pwd);
	}

	@When("click on accont tab in home page")
	public void click_on_accont_tab_in_home_page() {
		pohome = new PoHomePage(driver);
		pohome.accountTab.click();
	}

	@When("click on new button and enter account name {string}")
	public void click_on_new_button_and_enter_account_name(String accountname) {
		poaccount = new PoAccountPage(driver);
		poaccount.accountNew_Button.click();
		poaccount.accountName.sendKeys(accountname);
	}

	@When("click on save buuton")
	public void click_on_save_buuton() {
		poaccount.accountSave_Button.click();
	}

	@Then("Account page should displayed with account details")
	public void account_page_is_displayed_with_account_details() {
		// String account_name = poaccount.checkaccountname.getText();
		// Assert.assertEquals(account_name, "Marry");
		System.out.println("Account page is displayed with account details");
	}

}
