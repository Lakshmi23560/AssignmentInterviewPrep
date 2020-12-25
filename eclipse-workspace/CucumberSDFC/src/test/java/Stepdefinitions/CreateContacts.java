package Stepdefinitions;

import PageObjects.PoContacts;
import PageObjects.PoHomePage;
import PageObjects.PoLogin;
import Utilities.TestBase;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class CreateContacts extends TestBase {

	PoLogin pologin;
	PoHomePage pohome;
	PoContacts pocontacts;

	@Given("Launch the salesforce applicatio")
	public void launch_the_salesforce_applicatio() {

	}

//	@When("Login using correct username {string} and password {string}")
//	public void login_using_correct_username_and_password(String uname, String pwd) {
//		pologin = new PoLogin(driver);
//		pologin.loginToApp(uname, pwd);
//	}

	@When("click on contacts tab in home page")
	public void click_on_contacts_tab_in_home_page() {
		pohome = new PoHomePage(driver);
		pohome.contactsTab.click();
	}

	@When("Click on New button")
	public void click_on_new_button() {
		pocontacts = new PoContacts(driver);
		pocontacts.new_Button.click();
	}

	@When("Enter lastname {string} in lastname field and accountname {string} in accountname field")
	public void enter_lastname_in_lastname_field_and_accountname_in_accountname_field(String lastname,
			String accountname) {
		pocontacts.lastName.sendKeys(lastname);
		pocontacts.accountName.sendKeys(accountname);
	}

	@When("Click on save button")
	public void click_on_save_button() {
		pocontacts.save_Button.click();
	}

	@Then("New contact should be created")
	public void new_contact_should_be_created() {
		System.out.println("New contact is created");
	}

	@When("check recently created from dropdown list")
	public void check_recently_created_from_dropdown_list() {
		pocontacts.recentlyCreated_dropDown.click();
	}

	@Then("Recently created contact page should be displayed")
	public void recently_created_contact_page_should_be_displayed() {

	}

}
