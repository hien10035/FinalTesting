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

import homepage.Homepage;
import homepage.Login;
import homepage.error_message;

public class Testcase_BlankRepoName {
	String path="C:\\chromedriver.exe";
	private ChromeOptions options;
	private String baseUrl;
	WebDriver driver;
	Login objLogin;
	Homepage objHomepage;
	error_message objMsg;
	
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
		Reporter.log("successfully proceeded to LoginPage");
		}
	
	@SuppressWarnings("deprecation")
	@Test (priority=0, groups="case 1")
	public void test() throws Exception{
		//ExcelUtils.setExcelFile("C:\\Users\\viend\\eclipse-workspace\\auto1\\src\\excel\\testdata.xlsx","TC_01");
		//login page obj
		objLogin=new Login(driver);
		
		//login
		//objLogin.loginToGithub(ExcelUtils.getCellData(1, 2), ExcelUtils.getCellData(1, 3));
		objLogin.loginToGithub("viendanbac024@gmail.com","Lmaoxd@123");
		Reporter.log("login successful");
		
		// Initialize Homepage object after login
		objHomepage = new Homepage(driver);
		
		//clicked
		objHomepage.Button_Repo();
		Reporter.log("repository clicked");
		
		//click
		objHomepage.Button_createRepo();
		Reporter.log("create repo clicked");

		//1st checkpoint
		objMsg = new error_message(driver);
		String actualText = objMsg.getMsgRepo().trim().toLowerCase();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		Assert.assertTrue(actualText.matches(".*new repository name must not be blank.*"), "Text not found:"
				+ "New repository name must not be blank");
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
