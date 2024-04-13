package pages;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Actions;

public class Page_01_HomePage extends Actions {

	public static WebDriver driver;

	@SuppressWarnings("static-access")
	public Page_01_HomePage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

//	By login = By.xpath("//h1[@class='login-title']"); 	
	@FindBy(xpath = "//h1[@class='login-title']")
	private WebElement LogIn_Text;

	@FindBy(css = "input#userEmail")
	private WebElement Email_Text;

	@FindBy(xpath = "//input[@id='userPassword']")
	private WebElement Password_Text;

	@FindBy(xpath = "//input[@name='login']")
	private WebElement LogIn_Btn;

	@FindBy(xpath = "//p[@class='login-wrapper-footer-text'] //a")
	private WebElement Register_Here;

	@FindBy(xpath = "//div[contains(@role,'alert')]")
	private WebElement alert;

	@FindBy(xpath = "//a[contains(text(),'Forgot password?')]")
	private WebElement forgotLink;
	
	@FindBy(xpath = "//div[@id='toast-container'] //div[@aria-label='Password Changed Successfully']")
	private WebElement successAlert_msg;

	public void enterEmailID(String emaild) {

		enter_Text(Email_Text, "enter email id", emaild);

	}

	public void enterPassword(String password) {
		enter_Text(Password_Text, "Password text", password);

	}

	public void click_On_Login_Btn() {
		click(LogIn_Btn, "user clicked on login button");
	}

	public void user_Clicked_Register() {

		click(Register_Here, " Register here ");

	}

	public void IncorrectDeatils_alert_message() {
		waitForElementToVisable(alert, "alert message");
		String incorrectMessage = alert.getText();
//		System.out.println(incorrectMessage);
		Assert.assertEquals("Incorrect email or password.", incorrectMessage);
	}

	public void click_On_forgot_link() {
		click(forgotLink, "forgot link");
	}
	
	public void password_Change_success_msg() {
		
		try {
			Thread.sleep(1000);
			waitForElementToVisable(successAlert_msg, "successfull");
			System.out.println(successAlert_msg.getText());
			Assert.assertEquals("Password Changed Successfully",  successAlert_msg.getText());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}