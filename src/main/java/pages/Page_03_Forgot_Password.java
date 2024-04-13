package pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Actions;

public class Page_03_Forgot_Password extends Actions {

	public WebDriver driver;

	public Page_03_Forgot_Password(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

//Type I
	@FindBy(xpath = "//h3[text()='Enter New Password']")
	private WebElement enterNewpassword_title;

// Type II
	By pagetitle = By.xpath("//h3[text()='Enter New Password']");

// Type 3
//	How = how.xpath, xpath = "//h3[text()='Enter New Password']"

	@FindBy(css = "input[formcontrolname='userEmail']")
	private WebElement email_text;

	@FindBy(xpath = "//input[@id='userPassword']")
	private WebElement password_text;

	@FindBy(xpath = "//input[@id='confirmPassword']")
	private WebElement confirmPassword_text;

	@FindBy(xpath = "//button[@type='submit']")
	private WebElement submit_btn;

	
	
	
// Implement actions

	public void verify_New_passsword_screen() 
	{
		String actualTitle = enterNewpassword_title.getText();
		Assert.assertEquals("Enter New Password", actualTitle);
	}
	
	public void enter_EmaiIl_And_Password(String emaild, String password, String ConfirmPassword) {
		
		enter_Text(email_text, "email_text", emaild);
		enter_Text(password_text, "password", password);
		enter_Text(confirmPassword_text, "password", ConfirmPassword);
		

	}

	public void click_On_Login_Btn() {

		click(submit_btn, "Click on submit button");
	}

}
