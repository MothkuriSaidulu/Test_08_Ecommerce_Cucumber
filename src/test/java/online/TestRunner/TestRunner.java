package online.TestRunner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features = {
		"C:\\Users\\SAIDACHARY\\eclipse-workspace\\Test_08_Ecommerce_Cucumber\\Features\\TC01_Register_New_User.feature" }, 
//		"C:\\Users\\SAIDACHARY\\eclipse-workspace\\Test_08_Ecommerce_Cucumber\\Features\\TC02_Verify Forgot Passwrod Reset Funtionality.feature" }, 
		glue = "online.StepDefination", 
		monochrome = true, 
		dryRun = false, 
		plugin = {"pretty", "html:target\\htmlReports\\htmlReport.html" })

public class TestRunner {

}