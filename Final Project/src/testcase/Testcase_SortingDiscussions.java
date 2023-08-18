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


public class Testcase_SortingDiscussions {
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
		baseUrl="https://github.com/trieunhat2806/FINAL-PROJECT-TESTING/discussions";
		driver.get(baseUrl);
		Reporter.log("successfully proceeded to General Discusion page");
	}


	@SuppressWarnings("deprecation")
	@Test (priority=0, groups="case 1")
	public void test() throws Exception{

		objGeneralDiscussion =new GeneralDiscussion(driver);
		
		objGeneralDiscussion.Searching();
		Reporter.log("discussion created successful");

		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		String actualText = objGeneralDiscussion.getSearch_bar().trim().toLowerCase();
		System.out.println(actualText + "help");
		Assert.assertTrue(actualText.matches(""), "Text not found: Send feedback");
		//Assert.assertTrue(actualText.matches("is:opensort:date_created "), "Text not found: Send feedback");
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


