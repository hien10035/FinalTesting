package testcase;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


import excel.ExcelUtils;
import homepage.SignUp;
import homepage.SignUpPage;
//import homepage.error_message;


public class Testcase_SignUp {
	String path="C:\\chromedriver.exe";
	private ChromeOptions options;
	private String baseUrl;
	WebDriver driver;
	SignUpPage objSignUpPage;
	SignUp objSignUp;
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
	@Test (priority=0, groups="case 3")
	public void test() throws Exception{
		//ExcelUtils.setExcelFile("C:\\Users\\viend\\eclipse-workspace\\auto1\\src\\excel\\testdata.xlsx","TC_01");
	
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		objSignUp=new SignUp(driver);
		
		//signup
		//objLogin.loginToGithub(ExcelUtils.getCellData(1, 2), ExcelUtils.getCellData(1, 3));
		objSignUp.SignUp_Email("chumeosieuquay@gmail.com");
		Reporter.log("email entered");
		//Continue
		objSignUp.Button_email();
		Reporter.log("email button clicked");
		//Password
		objSignUp.SignUp_Password("Lmaoxd@123");
		Reporter.log("password entered");
		//Continue
		objSignUp.Button_password();
		Reporter.log("pass button clicked");
		//Username
		objSignUp.SignUp_Username("viendanbac3");
		Reporter.log("username entered");
		//continue
		objSignUp.Button_username();
		Reporter.log("username button clicked");
		//receive noti
		objSignUp.SignUp_yn("n");
		
		
		//1st checkpoint
		
		objSignUpPage = new SignUpPage(driver);
		PageFactory.initElements(driver, objSignUpPage);
		// ...
		 PageFactory.initElements(driver, objSignUpPage);
		    boolean isClicked = objSignUpPage.getCreateButton();

		    // Verify if the button is clicked
		    Assert.assertTrue(isClicked, "Button was not clicked successfully");
		    Reporter.log("button create account clicked");
		// ...

	
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