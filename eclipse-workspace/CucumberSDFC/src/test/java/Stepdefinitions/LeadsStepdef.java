package Stepdefinitions;

import PageObjects.PoAccountPage;
import PageObjects.PoHomePage;
import PageObjects.PoLeadsPage;
import PageObjects.PoLogin;
import Utilities.TestBase;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LeadsStepdef extends TestBase {

	PoLogin pologin;
	PoHomePage pohome;
	PoAccountPage poaccount;
	PoLeadsPage poleads;

	@Given("Launch the salesforce application")
	public void launch_the_salesforce_application() {
		System.out.println("Launch the appilcation");
	}

	@When("Login using correct username {string} and password {string}")
	public void login_using_correct_username_and_password(String uname, String pwd) {
		pologin = new PoLogin(driver);
		pologin.loginToApp(uname, pwd);
	}

	@When("click on Leads tab in home page")
	public void click_on_leads_tab_in_home_page() {
		pohome = new PoHomePage(driver);
		pohome.leadsTab.click();
	}

	@Then("Leads page should displayed")
	public void leads_page_should_displayed() {
		System.out.println("Leads page is displayed");
	}

//		@Given("Launch the salesforce application")
//		public void launch_the_salesforce_application() {
//		    // Write code here that turns the phrase above into concrete actions
//		    throw new io.cucumber.java.PendingException();
//		}
//
//
//		@When("Login using correct username {string} and password {string}")
//		public void login_using_correct_username_and_password(String string, String string2) {
//		    // Write code here that turns the phrase above into concrete actions
//		    throw new io.cucumber.java.PendingException();
//		}
//		@When("click on Leads tab in home page")
//		public void click_on_leads_tab_in_home_page() {
//		    // Write code here that turns the phrase above into concrete actions
//		    throw new io.cucumber.java.PendingException();
//		}
	@When("click on viewdropdown")
	public void click_on_viewdropdown() {
		poleads = new PoLeadsPage(driver);
		poleads.leads_dropDown.click();
	}

	@Then("View dropdown list should display")
	public void view_dropdown_list_should_display() {
		poleads.LeadssDropdown();
	}

}
