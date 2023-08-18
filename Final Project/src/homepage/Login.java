package homepage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

public class Login {
	
	WebDriver driver;
	
	@FindBy(xpath="//input[@id='password']//preceding::input[@id='login_field']")
	WebElement username;
	
    @FindBy(xpath="//input[@id='password']")
    WebElement password;
    
    @FindBy(xpath="//input[@name='commit']")
    WebElement button_click;
    
  

	public Login(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

	public void setUsername(String usernameValue) {
    	//set the username in the textbox
    	username.sendKeys(usernameValue);
    }
    
    public void setPassword(String passwordValue) {
    	//set the password in the textbox
    	password.sendKeys(passwordValue);
    }
    
    public void Click() {
    	//click the button
    	button_click.click();
    }
    
    /**
     * @param usernameValue

     * @param passwordValue

     * @return

     */
    
    public void loginToGithub(String usernameValue, String passwordValue) {
    	
    	//fill username
    	this.setUsername(usernameValue);
    	Reporter.log("username entered");
    	//fill password
    	this.setPassword(passwordValue);
    	Reporter.log("password entered");
    	//click
    	this.Click();
    	Reporter.log("button clicked");
    }
}