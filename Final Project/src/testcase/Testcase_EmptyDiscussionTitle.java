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

import org.openqa.selenium.chrome.ChromeOptions;

import homepage.GeneralDiscussion;
public class Testcase_EmptyDiscussionTitle {
	String path="C:\\chromedriver.exe";
	private ChromeOptions options;
	private String baseUrl;
	WebDriver driver;
	GeneralDiscussion objGeneralDiscussion;
	//error_message objerrorMsg;
	
	
@SuppressWarnings("deprecation")
	@BeforeTest
	public void testSetup() throws Exception{
		options = new ChromeOptions();
		options.addArguments("Start-maximized");
		driver=new ChromeDriver(options);
		//go to github.com
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		baseUrl="https://github.com/trieunhat2806/FINAL-PROJECT-TESTING/discussions/new?category=general";
		driver.get(baseUrl);
		Reporter.log("successfully proceeded to General Discusion page");
	}


	@SuppressWarnings("deprecation")
	@Test (priority=0, groups="case 1")
	public void test() throws Exception{
		//ExcelUtils.setExcelFile("C:\\Users\\viend\\eclipse-workspace\\auto1\\src\\excel\\testdata.xlsx","TC_01");
		//login page obj
		objGeneralDiscussion =new GeneralDiscussion(driver);
		
		//login
		//objLogin.loginToGithub(ExcelUtils.getCellData(1, 2), ExcelUtils.getCellData(1, 3));
		objGeneralDiscussion.Discusion("","12312312131231212");
		Reporter.log("discussion created successful");
		
		// Initialize Homepage object after login
		objGeneralDiscussion = new GeneralDiscussion(driver);
		
		//1st checkpoint
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		String actualText = objGeneralDiscussion.getDiscusionDashboard().trim().toLowerCase();
		Assert.assertTrue(actualText.matches(".*send feedback.*"), "Text not found: Send feedback");
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


