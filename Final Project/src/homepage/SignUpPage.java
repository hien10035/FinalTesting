package homepage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SignUpPage {
	WebDriver driver;
	@FindBy(xpath="//button[normalize-space()='Create account']")
	WebElement title;
	
	public SignUpPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	 /**
     * @param title
	 * @return 

     */
	
	//get the "create button" from signUpPage
	public  boolean getCreateButton() {
		try {
	        title.click();
	        return true;
	    } catch (Exception e) {
	        return false;
	    }
	}
}