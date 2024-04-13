package utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.junit.AfterClass;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import pages.Page_01_HomePage;
import pages.Page_02_RegisterPage;
import pages.Page_03_Forgot_Password;

public class BaseClass {

	public WebDriver driver;
	public Properties property;
	public String browserName;
	public FileInputStream file;
	public static Page_01_HomePage homePageObject;
	public static Page_02_RegisterPage registerPageObject;
	public Page_03_Forgot_Password forgot_object;

	public void initiateBrowser() throws IOException {

		property = new Properties();

		FileInputStream file = new FileInputStream("config.properties");
		property.load(file);

		browserName = property.getProperty("Browser");

		if (browserName.contains("Chrome")) {
			ChromeOptions options = new ChromeOptions();
			options.setPageLoadStrategy(PageLoadStrategy.EAGER);
			WebDriverManager.chromedriver().setup();

			System.out.println("******** Browser Launched  *******");

			driver = new ChromeDriver(options);
			driver.manage().deleteAllCookies();

		} else if (browserName.contains("Edge")) {
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
		}

		driver.manage().window().maximize();
//		return driver;
	}

// Every test execution below method will execute first

	public void launchWebUrl() throws IOException {
//		driver = initiateBrowser();

		try {
			property = new Properties();
			file = new FileInputStream("config.properties");
			property.load(file);
			String url = property.getProperty("Url");
			driver.get(url);
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(6));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@AfterClass
	public void closeBrowser() 
	{
		driver.quit();
		
	}

}
