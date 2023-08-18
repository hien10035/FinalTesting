package homepage;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;

public class SignUp {
	WebDriver driver;
	WebDriverWait wait;
	
	@FindBy(xpath="//input[@id='email']")
	WebElement email;
	
    @FindBy(xpath="//input[@id='password']")
    WebElement password;
    
    @FindBy(xpath="//input[@id='login']")
    WebElement username;
    
    @FindBy(xpath="//input[@id='opt_in']")
    WebElement yn;
    
    @FindBy(xpath="//button[@data-optimizely-event='click.signup_continue.email']")
    WebElement button_click_email;
    
    @FindBy(xpath="//button[@data-optimizely-event='click.signup_continue.password']")
    WebElement button_click_password;
    
    @FindBy(xpath="//button[@data-continue-to='opt-in-container']")
    WebElement button_click_username;
    
    @FindBy(xpath="//button[@data-continue-to='captcha-and-submit-container']")
    WebElement button_click_captcha;
    
	public SignUp(WebDriver driver){
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        PageFactory.initElements(driver, this);
    }

	public void setUsername(String usernameValue) {
    	
    	username.sendKeys(usernameValue);
    }
    
    public void setPassword(String passwordValue) {
    	
    	password.sendKeys(passwordValue);
    }
    
    public void setEmail(String emailValue) {
    	email.sendKeys(emailValue);
    }
    
    public void setYN(String ynValue) {
    	yn.sendKeys(ynValue);
    }
    
    public void Click_email() {
    	wait.until(ExpectedConditions.elementToBeClickable(button_click_email));
    	button_click_email.click();
    }
    
    public void Click_password() {
    	wait.until(ExpectedConditions.elementToBeClickable(button_click_password));
    	button_click_password.click();
    }
    
    public void Click_username() {
    	wait.until(ExpectedConditions.elementToBeClickable(button_click_username));
    	button_click_username.click();
    }
    
    public void Click_captcha() {
    	
    	button_click_captcha.click();
    }
    
    /**
     * @param usernameValue

     * @param passwordValue
     
     * @param emailValue
     * 
     * @param ynValue

     */
    
    public void SignUp_Email(String e) {
    	this.setEmail(e);
    }
    
    public void SignUp_Password(String p) {
    	this.setPassword(p);
    }
    
    public void SignUp_Username(String u) {
    	this.setUsername(u);
    }
    
    public void SignUp_yn(String y) {
    	this.setYN(y);
    }
    
    //button click
    public void Button_email() {
    	this.Click_email();
    }
    
    public void Button_password() {
    	this.Click_password();
    }
    
    public void Button_username() {
    	this.Click_username();
    }
    
    public void Button_captcha() {
    	this.Click_captcha();
    }
    
}