package homepage;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class Homepage {
	WebDriver driver;
	WebDriverWait wait;
	
	@FindBy(xpath="//a[normalize-space()='Send feedback']")
	WebElement title;
	
	@FindBy(xpath="//div[@data-target='loading-context.details']"
			+ "//a[@class='Button--primary Button--small Button']")
	WebElement button_Repo;
	
	@FindBy(xpath="//input[@id='react-aria-2']")
	WebElement repo_name;
	
	@FindBy(xpath="//span[@id='RepoNameInput-is-available']")
	WebElement repo_check;
	
	@FindBy(xpath="//button[@class='types__StyledButton-sc-ws60qy-0 engiZU']")
	WebElement button_createRepo;
	
	@FindBy(xpath="//aside[@aria-label='Account']//li[1]//div[1]//div[1]//a[1]")
	WebElement repo_click;
	
	@FindBy(xpath="//a[normalize-space()='README1.md']")
	WebElement file_click;
	
	@FindBy(xpath="//a[@aria-label='Edit file']")
	WebElement editFile_click;
	
	@FindBy(xpath="(//div[@dir='auto'])[4]")
	WebElement file_typing;
	
	@FindBy(xpath="//button[@class='types__StyledButton-sc-ws60qy-0 eDrzrH']")
	WebElement commit_click;
	
	@FindBy(xpath="//button[@data-hotkey='Control+Enter, Control+Enter']")
	WebElement confirm_click;
	
	@FindBy(xpath="//p[@dir='auto']")
	WebElement edit_Result;
	
	@FindBy(xpath="//summary[@class='btn ml-2']")
	WebElement menu_click;
	
	@FindBy(xpath="//button[normalize-space()='Create new file']")
	WebElement createFile_click;
	
	@FindBy(xpath="//input[@placeholder='Name your file...']")
	WebElement file_input;
	
	@FindBy(xpath="//div[@class='cm-line']")
	WebElement content_input;
	
	@FindBy(xpath="//a[contains(@class,'pl-3 pr-3 py-3 p-md-0 mt-n3 mb-n3 mr-n3 m-md-0 Link--primary no-underline no-wrap')]")
	WebElement fileCreate_check;
	
	@FindBy(xpath="//a[@data-analytics-event='{\"category\":\"SiteHeaderComponent\",\"action\":"
			+ "\"context_region_crumb\",\"label\":\"Selenium\",\"screen_size\":\"full\"}']")
	WebElement procceed;
	
	public Homepage(WebDriver driver) {
		this.driver = driver;
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		PageFactory.initElements(driver, this);
	}
	
	
	public void setRepoName(String RepoNameValue) {
		repo_name.sendKeys(RepoNameValue);
	}
	
	public void setFileTyping(String fileValue) {
		file_typing.sendKeys(fileValue);
	}
	
	public void setFileInput(String inputValue) {
		file_input.sendKeys(inputValue);
	}
	
	public void setContentInput(String contentValue) {
		content_input.sendKeys(contentValue);
	}
	
	public void ClickOnRepo() {
		wait.until(ExpectedConditions.elementToBeClickable(repo_click)).click();
	}
	
	public void ClickOnFile() {
		wait.until(ExpectedConditions.elementToBeClickable(file_click)).click();
	}
	
	public void ClickOnEditFile() {
		wait.until(ExpectedConditions.elementToBeClickable(editFile_click)).click();
	}
	
	public void Click_buttonRepo() {
		wait.until(ExpectedConditions.elementToBeClickable(button_Repo)).click();

	}
	
	public void Click_buttonCreateRepo() {
		wait.until(ExpectedConditions.elementToBeClickable(button_createRepo)).click();

	}
	
	public void Click_buttonCommit() {
		wait.until(ExpectedConditions.elementToBeClickable(commit_click)).click();

	}
	
	public void Click_buttonConfirm() {
		wait.until(ExpectedConditions.elementToBeClickable(confirm_click)).click();
		
	}
	
	public void Click_menu() {
		wait.until(ExpectedConditions.elementToBeClickable(menu_click)).click();

	}
	
	public void Click_createFile() {
		wait.until(ExpectedConditions.elementToBeClickable(createFile_click)).click();

	}
	
	public void Click_procceedToPage() {
		wait.until(ExpectedConditions.elementToBeClickable(procceed)).click();

	}
		
	 /**


     */
	//method
	public  String getHomepageDashboard() {
		return title.getText();
	}
	
	public String getRepoTitleCheck() {
		return repo_check.getText();
	}
	
	public String getEditResultCheck() {
		return edit_Result.getText();
	}
	
	public String getFileCreateCheck() {
		return fileCreate_check.getText();
	}
	
	public void RepoName(String r) {
		this.setRepoName(r);
	}
	
	public void FileType(String f) {
		this.setFileTyping(f);
	}
	
	public void FileInput(String f2) {
		this.setFileInput(f2);
	}
	
	public void ContentInput(String c) {
		this.setContentInput(c);
	}
	
	public void Button_Repo() {
		this.Click_buttonRepo();
	}
	
	public void Button_createRepo() {
		this.Click_buttonCreateRepo();
	}
	
	public void RepoClick() {
		this.ClickOnRepo();
	}
	
	public void FileClick() {
		this.ClickOnFile();
	}
	
	public void EditFileClick() {
		this.ClickOnEditFile();
	}
	
	public void CommitClick() {
		this.Click_buttonCommit();
	}
	
	public void ConfirmClick() {
		this.Click_buttonConfirm();
	}
	
	public void MenuClick() {
		this.Click_menu();
	}
	
	public void CreateFileClick() {
		this.Click_createFile();
	}
	
	public void ProcceedToPage() {
		this.Click_procceedToPage();
	}
}