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


import homepage.GeneralDiscussion;
import homepage.Homepage;
import homepage.Login;


public class Testcase_StartNewDiscusion2 {
	String path="C:\\chromedriver.exe";
	private ChromeOptions options;
	private String baseUrl;
	WebDriver driver;
	GeneralDiscussion objGeneralDiscussion;
	Login objLogin;
	Homepage objHomepage;


	//error_message objerrorMsg;
	
	
@SuppressWarnings("deprecation")
	@BeforeTest
	public void testSetup() throws Exception{
		options = new ChromeOptions();
		options.addArguments("Start-maximized");
		driver=new ChromeDriver(options);
		//go to github.com
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		baseUrl="https://github.com/login?return_to=https%3A%2F%2Fgithub.com%2Ftrieunhat2806%2FFINAL-PROJECT-TESTING%2Fdiscussions%2Fnew%3Fcategory%3Dideas";
		driver.get(baseUrl);
		Reporter.log("successfully proceeded to General Discusion page");
	}


	@SuppressWarnings("deprecation")
	@Test (priority=0, groups="case 1")
	public void test() throws Exception{
		//ExcelUtils.setExcelFile("C:\\Users\\viend\\eclipse-workspace\\auto1\\src\\excel\\testdata.xlsx","TC_01");
		//login page obj
		objLogin=new Login(driver);
		
		//login
		//objLogin.loginToGithub(ExcelUtils.getCellData(1, 2), ExcelUtils.getCellData(1, 3));
		objLogin.loginToGithub("viendanbac024@gmail.com","Trieunhat@2806");
		Reporter.log("login successful");
		
		// Initialize Homepage object after login
		objHomepage = new Homepage(driver);
		
		
		objGeneralDiscussion =new GeneralDiscussion(driver);
		
		objGeneralDiscussion.Discusion("test32231","223");
		Reporter.log("discussion created successful");
		objGeneralDiscussion = new GeneralDiscussion(driver);
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		String actualText = objGeneralDiscussion.getDiscusionDashboard().trim().toLowerCase();
		Assert.assertTrue(actualText.matches(".*ideas.*"), "Text not found: Send feedback");
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


