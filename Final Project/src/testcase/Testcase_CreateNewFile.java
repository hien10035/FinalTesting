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

	public class Testcase_CreateNewFile {
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
		@Test (priority=0, groups="case 12")
		public void test() throws Exception{
			//ExcelUtils.setExcelFile("C:\\Users\\viend\\eclipse-workspace\\auto1\\src\\excel\\testdata.xlsx","TC_01");
			//login page obj
			objLogin=new Login(driver);
			
			//login
			//objLogin.loginToGithub(ExcelUtils.getCellData(1, 2), ExcelUtils.getCellData(1, 3));
			objLogin.loginToGithub("viendanbac024@gmail.com","Lmaoxd@123");
			Reporter.log("login successful");
			
			objHomepage=new Homepage(driver);
			//click on repo
			objHomepage.ClickOnRepo();
			Reporter.log("chosen repo clicked");
			//click on menu to add
			objHomepage.MenuClick();
			Reporter.log("chosen file clicked");
			//click on "Create file"
			objHomepage.CreateFileClick();
			Reporter.log("'create file' button clicked");
			//name input
			objHomepage.FileInput("khong");
			Reporter.log("name input");
			//content input 
			objHomepage.ContentInput("testing 123");
			Reporter.log("content typed in");
			//Commit change
			objHomepage.CommitClick();
			Reporter.log("Commit changes button clicked");
			//Confirm
			objHomepage.ConfirmClick();
			Reporter.log("'commit changes' confirmation button clicked");
			//Go back to selected repository main page
			objHomepage.ProcceedToPage();
			//checkpoint
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			String actualText = objHomepage.getFileCreateCheck().trim().toLowerCase();
			Assert.assertFalse(actualText.matches(".*63.*"), "Text not found: 63");
			Reporter.log(actualText);
			System.out.println(actualText);
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
