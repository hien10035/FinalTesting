package testcase;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import homepage.SignUp;
import homepage.SignUpPage;
import homepage.error_message;

public class Testcase_passwordTooLong {
	String path="C:\\chromedriver.exe";
	private ChromeOptions options;
	private String baseUrl;
	WebDriver driver;
	SignUpPage objSignUpPage;
	SignUp objSignUp;
	error_message objMsg;
	//error_message objerrorMsg;
	
	
@SuppressWarnings("deprecation")
	@BeforeTest
	public void testSetup() throws Exception{
		options = new ChromeOptions();
		options.addArguments("Start-maximized");
		driver=new ChromeDriver(options);
		//go to github.com
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		baseUrl="https://github.com/signup?ref_cta=Sign+up&ref_loc=header+logged+out&ref_page=%2F&source=header-home";
		driver.get(baseUrl);
		Reporter.log("successfully proceeded to SignUpPage");
	}

	@SuppressWarnings("deprecation")
	@Test(priority=0, groups="case 4")
	public void test() throws Exception {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		objSignUp=new SignUp(driver);
		objMsg = new error_message(driver);
		//signup
				//objLogin.loginToGithub(ExcelUtils.getCellData(1, 2), ExcelUtils.getCellData(1, 3));
				objSignUp.SignUp_Email("chumeosieuquay@gmail.com");
				Reporter.log("email entered");
				//Continue
				objSignUp.Button_email();
				Reporter.log("email button clicked");
				//Password
				objSignUp.SignUp_Password("eeeeeeeeeeeeeeeeeeeeeeeeeeeee"
						+ "eeeeeeeeeeeeeeeeeeeeeeeeee"
						+ "eeeeeeeeeeeeeeeeeeeeeeeee");
				Reporter.log("password entered");
				
				//checkpoint
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				String actualText = objMsg.getMsgTooLong().trim().toLowerCase();
				Assert.assertTrue(actualText.matches(".*password is too long.*"), 
						"Text not found: Password is too long");
				Reporter.log(actualText);
	}
	@AfterTest
	public void afterTest() throws Exception{
		 try {
	          Thread.sleep(5000);
	      } catch (InterruptedException e) {
	          e.printStackTrace();
	      }
		  driver.quit();
	}
}
