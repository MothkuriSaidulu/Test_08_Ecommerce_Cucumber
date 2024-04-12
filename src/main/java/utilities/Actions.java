package utilities;

import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.NoSuchFrameException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Actions extends BaseClass {

	public static WebDriver driver;
	public static String randomString,getPropertyValue;

	public static final Logger logger = Logger.getLogger(Actions.class.getName());

	@SuppressWarnings("static-access")
	public Actions(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

//  Explicitly waits for web elements
	public static WebDriverWait applyWebDriverWait() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.ignoring(NoSuchElementException.class);
		wait.ignoring(ElementNotInteractableException.class);
		wait.ignoring(StaleElementReferenceException.class);
		wait.ignoring(NoSuchFrameException.class);
		return wait;
	}

	public static void waitForElementToVisable(WebElement element, String elementDesc) {
		try {
			logger.info(element);
			WebDriverWait wait = applyWebDriverWait();
			wait.until(ExpectedConditions.visibilityOf(element));

		} catch (Exception e) {
			logger.error("------- ERROR WHILE TRYING WAIT FOR VISABILITY OF ELEMENT GETTING ERROR ------- :"
					+ e.getMessage());
			Assert.fail(("WebDriverException : WHILE TRYING TO WAIT FOR ELEMENT TO VISABLE ON THE SPECIFIED WEB ELEMENT"
					+ "<b>" + elementDesc + "</b>" + " is not visible _due_to_the_Exception:- " + e.getMessage()));
		}
	}

	public static void waitForElementToClickable(WebElement element, String elementDesc) {

		try {
			logger.info(element);
			WebDriverWait wait = applyWebDriverWait();
			wait.until(ExpectedConditions.elementToBeClickable(element));

		} catch (Exception e) {
			logger.error("------- ERROR WHILE TRYING TO CLICK ON THE SPECIFIED WEB ELEMENT ------- :" + e.getMessage());
			Assert.fail(
					"WebDriverException : WHILE TRYING TO WAIT FOR ELEMENT TO CLICKABLE ON THE SPECIFIED WEB ELEMENT"
							+ "<b>" + elementDesc + "</b>" + " is not visible _due_to_the_Exception:- "
							+ e.getMessage());

		}

	}

	public void click(WebElement element, String elementDesc) {
		try {
			logger.info(element);
			waitForElementToVisable(element, elementDesc);
			element.click();

		} catch (Exception e) {
			logger.error("------- ERROR WHILE TRYING TO CLICK ON THE SPECIFIED WEB ELEMENT ------- :" + e.getMessage());
			Assert.fail("WebDriverException : WHILE TRYING TO CLICK ON THE SPECIFIED WEB ELEMENT" + "<b>" + elementDesc
					+ "</b>" + " is not visible _due_to_the_Exception:- " + e.getMessage());

		}

	}

	public void enter_Text(WebElement element, String elementDesc, String text) {

		try {
			logger.info(element);
			waitForElementToClickable(element, elementDesc);
			element.clear();
			element.sendKeys(text);

		} catch (Exception e) {
			logger.error("------- ERROR WHILE TRYING TO Enter Text inside text box -------  " + e.getMessage());
			Assert.fail("WebDriverException : WHILE TRYING TO ENTER TEXT INSIDE THE SPECIFIED WEB ELEMENT" + "<b>"
					+ elementDesc + "</b>" + " is not visible _due_to_the_Exception:- " + e.getMessage());
		}
	}

	public void verifyText(WebElement element, String elementDesc, String expectedText) {

		try {
			logger.info(element);
			waitForElementToVisable(element, elementDesc);
			String ActualTeext = element.getText().trim().toLowerCase();
			String ExpectedText = expectedText.trim().toLowerCase();
			Assert.assertEquals(ExpectedText, ActualTeext);

		} catch (Exception e) {
			// TODO: handle exception
			logger.error("------- ERROR WHILE TRYING TO  Verifying the Text ------- " + e.getMessage());
			Assert.fail("Exception : WHILE TRYING TO VERIFY THE TEXT INSIDE A WEB ELEMENT : "
					+ "Actual and expected texts are not matching for: " + "<b>" + elementDesc + "</b>"
					+ " due to the Exception: " + e.getMessage());

		}

	}

	public String getProperty(String value) throws IOException {
		property = new Properties();
		property.load(file);

		getPropertyValue = property.getProperty(value);
		return getPropertyValue;
	}

	public String randomString() {
		randomString = RandomStringUtils.randomAlphabetic(6);
		return randomString;
	}

	public String randomNumeric() {
		randomString = RandomStringUtils.randomNumeric(10);

		return randomString;
	}
	/*
	 * public void takeScreenshotOfEachPage() throws IOException { File filePath;
	 * String screenshotName = null; try { Date date = new Date(); String
	 * dateAndTime = date.toString(); System.out.println(dateAndTime); // Out put
	 * --> Sat Mar 30 11:54:52 IST 2024
	 * 
	 * screenshotName = date.toString().replace(":", "_").replace(" ", "_") +
	 * ".png"; // Output -->// // Sat_Mar_30_11_54_52_IST_2024.png
	 * System.out.println(screenshotName); File scr = ((TakesScreenshot)
	 * driver).getScreenshotAs(OutputType.FILE);
	 * 
	 * // System.getProperty("user.dir") + "//Reports//screenshot.png
	 * 
	 * filePath = new File(System.getProperty("user.dir") + "\\Screenshots\\" +
	 * screenshotName);
	 * 
	 * // File filePath = new File(
	 * "C:\\Users\\1003413\\eclipse-workspace\\Test_07_Ecommerce_TestNG\\Screenshots\\"
	 * + screenshotName); FileUtils.copyFile(scr, filePath); } catch
	 * (WebDriverException e) { // TODO Auto-generated catch block
	 * e.printStackTrace(); } catch (IOException e) { // TODO Auto-generated catch
	 * block e.printStackTrace(); }
	 * 
	 * }
	 */
}
