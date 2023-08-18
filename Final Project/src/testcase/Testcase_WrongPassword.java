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


import excel.ExcelUtils;
import homepage.error_message;
import homepage.Login;

public class Testcase_WrongPassword {
	String path="C:\\chromedriver.exe";
	private ChromeOptions options;
	private String baseUrl;
	WebDriver driver;
	error_message objErrorMsg;
	Login objLogin;
	//error_message objerrorMsg;
	
	
@SuppressWarnings("deprecation")
	@BeforeTest
	public void testSetup() throws Exception{
		options = new ChromeOptions();
		options.addArguments("Start-maximized");
		driver=new ChromeDriver(options);
		//go to github.com
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		baseUrl="https://github.com/login";
		driver.get(baseUrl);
		Reporter.log("failed to proceeded to loginPage");
	}

	@SuppressWarnings("deprecation")
	@Test (priority=0, groups="case 2")
	public void test() throws Exception{
		//ExcelUtils.setExcelFile("C:\\Users\\viend\\eclipse-workspace\\auto1\\src\\excel\\testdata.xlsx","TC_01");
		//login page obj
		objLogin=new Login(driver);
		
		//login
		//objLogin.loginToGithub(ExcelUtils.getCellData(1, 2), ExcelUtils.getCellData(1, 3));
		objLogin.loginToGithub("viendanbac024@gmail.com","Lmaoxd@12345");
		Reporter.log("login failed");
		
		
		objErrorMsg = new error_message(driver);
		
		//1st checkpoint
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		String actualText = objErrorMsg.getErrorMsg().trim().toLowerCase();
		Assert.assertTrue(actualText.matches(".*incorrect username or password..*"), "Text not found: Incorrect username or password.");
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
