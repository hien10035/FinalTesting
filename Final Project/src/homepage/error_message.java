package homepage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class error_message {
	WebDriver driver;
	
	@FindBy(xpath="//div[@role='alert']")
	WebElement msg;
	
	@FindBy(xpath="//p[@class='password-validity-summary "
			+ "password-validity-summary-fail mb-1']")
	WebElement msg_tooLong;
	
	@FindBy(xpath="//p[@class='password-validity-summary "
			+ "password-validity-summary-close mb-1']")
	WebElement msg_compromised;
	
	@FindBy(xpath="//p[@class='password-validity-summary "
			+ "password-validity-summary-close mb-1']")
	WebElement msg_satisfy;
	
	@FindBy(xpath="//p[@class='mb-0']")
	WebElement msg_InvalidOrTakenEmail;
	
	@FindBy(xpath="//span[@class='Box-sc-g0xbh4-0 lbunpI']")
	WebElement msg_repo;
	
	@FindBy(xpath="//span[@class='Box-sc-g0xbh4-0 lbunpI']")
	WebElement msg_repoExist;
	
	public error_message(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	/**
     

     */
	public  String getErrorMsg() {
		return msg.getText();
	}
	
	public String getMsgTooLong() {
		return msg_tooLong.getText();
	}
	
	public String getMsgCompromised() {
		return msg_compromised.getText();
	}
	
	public String getMsgSatisfy(){
		return msg_satisfy.getText();
	}
	
	public String getMsgIvalidOrTakenEmail(){
		return msg_InvalidOrTakenEmail.getText();
	}
	
	public String getMsgRepo() {
		return msg_repo.getText();
	}
	
	public String getMsgRepoExist() {
		return msg_repoExist.getText();
	}
}
