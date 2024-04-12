package pages;

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

	public void user_Clicked_Register() {
		
		click(Register_Here, " Register here ");

	}

}