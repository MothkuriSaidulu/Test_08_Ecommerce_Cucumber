package online.StepDefination;

import java.io.IOException;

import io.cucumber.java.en.*;
import pages.Page_01_HomePage;
import pages.Page_02_RegisterPage;
import utilities.BaseClass;

public class stepDefination extends BaseClass {

	@Given("User launched the browser.")
	public void user_launched_the_browser() throws IOException {
		initiateBrowser();

	}

	@When("User entered url.")
	public void user_entered_url() throws IOException {
		launchWebUrl();

	}

	@When("User clicked on Register here.")
	public void user_clicked_on_register_here() {
		homePageObject = new Page_01_HomePage(driver);
		homePageObject.user_Clicked_Register();
	}

	@Then("User should be land on Register page.")
	public void user_should_be_land_on_register_page() {
		registerPageObject = new Page_02_RegisterPage(driver);
		registerPageObject.verify_User_Landed_On_Register_Page();

	}

	@Then("User fill the details.")
	public void user_fill_the_details() {
		registerPageObject = new Page_02_RegisterPage(driver);
		registerPageObject.user_Filling_Details();

	}

	@When("User clicked on register button.")
	public void user_clicked_on_register_button() {
		registerPageObject = new Page_02_RegisterPage(driver);
		registerPageObject.click_on_register_button();
	}

	@Then("User should be able see {string} message.")
	public void user_should_be_able_see_message(String string) {
		registerPageObject = new Page_02_RegisterPage(driver);

		registerPageObject.verify_successful_message(string);

	}

	@Then("Close the browser.")
	public void close_the_browser() {
		closeBrowser();
	}

}
