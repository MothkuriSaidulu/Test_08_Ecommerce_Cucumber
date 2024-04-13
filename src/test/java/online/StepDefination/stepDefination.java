package online.StepDefination;

import java.io.IOException;

import io.cucumber.java.en.*;
import pages.Page_01_HomePage;
import pages.Page_02_RegisterPage;
import pages.Page_03_Forgot_Password;
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

// forgot password
	@When("User enter emaild as {string} and password as {string}.")
	public void user_enter_emaild_as_and_password_as(String emaild, String password) {
		homePageObject = new Page_01_HomePage(driver);
		homePageObject.enterEmailID(emaild);
		homePageObject.enterPassword(password);

	}

	@When("User click on login button.")
	public void user_click_on_login_button() {
		homePageObject.click_On_Login_Btn();
	}

	@When("If user getting incorrect password.")
	public void if_user_getting_incorrect_password() {
		homePageObject.IncorrectDeatils_alert_message();
	}

	@When("User click on forgot password link.")
	public void user_click_on_forgot_password_link() {
		homePageObject.click_On_forgot_link();

	}

	@Then("User land on Enter New Password screen.")
	public void user_land_on_enter_new_password_screen() {
		forgot_object = new Page_03_Forgot_Password(driver);
		forgot_object.verify_New_passsword_screen();

	}

	@Then("User entered emaild as {string} and password as {string} and confirm passowrd as {string}.")
	public void user_entered_emaild_as_and_password_as_and_confirm_passowrd_as(String emailID, String password,
			String ConfirmPassword) {
		forgot_object = new Page_03_Forgot_Password(driver);
		forgot_object.enter_EmaiIl_And_Password(emailID, password, ConfirmPassword);

	}

	@Then("User click on save new passowrd button.")
	public void user_click_on_save_new_passowrd_button() {
		forgot_object = new Page_03_Forgot_Password(driver);
		forgot_object.click_On_Login_Btn();
		
	}

	@Then("User should be able to see success message.")
	public void user_should_be_able_to_see_success_message() {
		homePageObject = new Page_01_HomePage(driver);
		homePageObject .password_Change_success_msg();

	}

}
