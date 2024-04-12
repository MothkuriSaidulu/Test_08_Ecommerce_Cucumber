package pages;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import utilities.Actions;

public class Page_02_RegisterPage extends Actions {

	public static WebDriver driver;

	@SuppressWarnings("static-access")
	public Page_02_RegisterPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//h1[@class='login-title']")
	private WebElement register_text;

	@FindBy(id = "firstName")
	private WebElement First_Name;

	@FindBy(css = "input[id='lastName']")
	private WebElement Last_name;

	@FindBy(xpath = "//input[@id='userEmail']")
	private WebElement Email_text_box;

	@FindBy(id = "userMobile")
	private WebElement Phone_Text;

	@FindBy(xpath = "//select[@formcontrolname='occupation']")
	private WebElement Occupation_text;

	@FindBy(xpath = "//input[@value='Male']")
	private WebElement Male_radio_button;

	@FindBy(xpath = "//input[@value='Female']")
	private WebElement Female_radio_button;

	@FindBy(id = "userPassword")
	private WebElement Password_text;

	@FindBy(id = "confirmPassword")
	private WebElement confirmPassword_text;

	@FindBy(xpath = "//input[@type='checkbox']")
	private WebElement check_box;

	@FindBy(xpath = "//input[@value='Register']")
	private WebElement register_btn;

	@FindBy(xpath = "//h1[contains(text(),'Account Created Successfully')]")
	private WebElement sucessfully_Created;

	@FindBy(xpath = "//div[@class='invalid-feedback']")
	private WebElement invalid_Feedback;

	public void verify_User_Landed_On_Register_Page() {
		try {
			Assert.assertEquals("Register", register_text.getText());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void user_Filling_Details() {

		enter_Text(First_Name, "First Name info", randomString());
		enter_Text(Last_name, "Last Name Information", randomString());
		String emailID = randomString() + "@gmail.com";
		enter_Text(Email_text_box, "Enter EmailID Information", emailID);
		System.out.println(emailID);
		enter_Text(Phone_Text, "Phone Number information", randomNumeric());

		Select sel = new Select(Occupation_text);
		sel.selectByVisibleText("Doctor");
//		enter_Text(Occupation_text, "occupation information", sel.selectByVisibleText("Doctor"));

		String gender = "male";
		if (gender.equalsIgnoreCase("male")) {
			Male_radio_button.click();
		} else {
			Female_radio_button.click();
		}

		String password = randomString() + "@123";
		enter_Text(Password_text, "Enter password", password);
		enter_Text(confirmPassword_text, "Confirm Password", password);
		System.out.println(password);
		click(check_box, "Check boxx");

	}

	public void click_on_register_button() {
		click(register_btn, "user clicked on register button");

	}

	public void verify_successful_message(String sucessmessage) {
		verifyText(sucessfully_Created, "successfull mesage", sucessmessage);

	}
}