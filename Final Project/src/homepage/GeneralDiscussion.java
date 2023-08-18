package homepage;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

public class GeneralDiscussion {
WebDriver driver;
	
	@FindBy(xpath="//input[@id='js-discussion-title']")
	WebElement discussion_title;
	
    @FindBy(xpath="//*[@id=\"discussion_body\"]")
    WebElement write;
    
    @FindBy(xpath="//*[@id=\"new_discussion\"]/div/div[1]/div/div[2]/div[2]/div/button/span/span")
    WebElement button_click;
    
    
	@FindBy(xpath="//*[@class=\"color-fg-inherit text-bold\"]")
	WebElement Discusion_created;
	
	@FindBy(xpath="//*[@id='new_comment_field']")
	WebElement Comment_write;

	@FindBy(xpath="//*[@id=\"js-discussions-timeline-anchor-loader\"]/div[2]/div/form/div/tab-container/file-attachment/div")
	WebElement Comment_button;
	
	@FindBy(xpath="//*[@class=\"Button--primary Button--medium Button ml-1\"]")
	WebElement Commment_Status;
	
	@FindBy(xpath="//*[@id=\"discussion-comment-count\"]")
	WebElement Comment_created;
	
	@FindBy(xpath="//span[@class='js-issue-title markdown-title']")
	WebElement EditTitle_name;

	@FindBy(xpath="//*[@class='js-quick-submit form-control flex-auto input-lg input-contrast mr-0 mr-md-3']")
	WebElement SetEditTitle_name;
	
	@FindBy(xpath="//*[@class='js-details-target js-focus-on-dismiss btn-sm btn float-none m-0 ml-md-3']")
	WebElement Edit_button;
	
	@FindBy(xpath="//*[@class='note error js-comment-form-error mt-6']")
	WebElement Edit_empty;
	
	
	
	@FindBy(xpath="//*[@class='Button--secondary Button--medium Button'][1]")
	WebElement sort_by;
	@FindBy(xpath="//*[@id='repo-content-turbo-frame']/div/div[2]/div[2]/div[3]/details/summary")
	WebElement sort_by2;
	
	
	@FindBy(xpath="//input[@id='discussions-search-combobox']")
	WebElement search_bar;
	
	
	
	@FindBy(xpath="//*[@class='text-bold discussion-sidebar-heading discussion-sidebar-toggle']")
	WebElement current_category;
	
	@FindBy(xpath="//*[@class='Button--invisible Button--small Button Button--fullWidth Button--invisible-noVisuals'][1]")
	WebElement change_category;
	
	
	public GeneralDiscussion(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

	public void setName(String usernameValue) {
    	//set the name in the textbox
		discussion_title.sendKeys(usernameValue);
    }
    
    public void setWrite(String passwordValue) {
    	//write text in textbox
    	write.sendKeys(passwordValue);
    }
    public void setComment(String Value) {
    	//write text in textbox
        Comment_write.sendKeys(Value);
    }

    public void SetEditTitle_name(String Value) {
    	//write text in textbox
    	SetEditTitle_name.clear();
    	SetEditTitle_name.sendKeys(Value);
    }
    
    public void SetSearch_bar(String Value) {
    	search_bar.sendKeys(Value);
    	search_bar.sendKeys(Keys.ENTER);
    }
    public void SetSearch_bar2(String Value) {
    	search_bar.clear();
    	search_bar.sendKeys(Value);
    	search_bar.sendKeys(Keys.ENTER);
    }
    
    public void Click() {
    	//click the button
    	button_click.click();
    }
    
    public void Edit_button1() {
    	//click the button
    	Edit_button.click();
    }
    
    public void Sortby_Click() {
    	//click the button
    	sort_by.click();
    }   
    public void Sortby_Click2() {
    	//click the button
    	current_category.click();
    }
    public void Setting_category_click() {
    	//click the button
    	current_category.click();
    }
    public void Change_category_click() {
    	//click the button
    	change_category.click();
    }


    
    
    
    
    public  boolean Get_Commment_Status() {
		return Commment_Status.isEnabled();
		
	}
	public  String getDiscusionDashboard() {
		return Discusion_created.getText();
	}
	public  String getCommentNumber() {
		return Comment_created.getText();
	}
	
	public  String getEditTitle() {
		return  EditTitle_name.getText();
	}
	
	
	public  String getEdit_empty() {
		return  Edit_empty.getText();
	}    
	
	public String getSearch_bar() {
    	return search_bar.getText();
    }

	
	
    /**
     * @param discussionValue

     * @param writeValue

     * @param Value
	
     * @param Value


//     * @return

     */
	
    public void Changing() {
    	this.Setting_category_click();
    	Reporter.log("Button Clicked");
    	this.Change_category_click();
    	Reporter.log("Button Clicked");
    	
    }
    
    public void Searching2() {
    	this.SetSearch_bar2("is:closed category:General");
    	Reporter.log("Button Clicked");
    }
    
    public void EditDicusionName(String nameValue) {
    	
    	this.Edit_button1();
    	this.SetEditTitle_name(nameValue);
    	Reporter.log("comment  entered");
    	
    	driver.findElement(By.xpath("//*[@class='btn mr-2'][1]")).click();
    	Reporter.log("Button Clicked");
    }

    public void EditEmptyDicusionName(String nameValue) {
    	
    	this.Edit_button1();
    	this.SetEditTitle_name(nameValue);
    	Reporter.log("comment  entered");
    	driver.findElement(By.xpath("//*[@class='btn mr-2'][1]")).click();
    	Reporter.log("Button Clicked");
    }

    
    public void Searching() {
    	this.Sortby_Click();
    	this.SetSearch_bar(" sort:date_created");
    	Reporter.log("Button Clicked");
    }
    
    
    
    
    public void Comment(String CommentValue) {
    	
    	//fill Discussion Title
    	this.setComment(CommentValue);
    	Reporter.log("comment  entered");
    	
    	driver.findElement(By.xpath("//*[@class=\"Button--primary Button--medium Button ml-1\"]")).click();
    	Reporter.log("Button Clicked");
    }

    
    public void EmptyEdit(String CommentValue) {
    	
    	//fill Discussion Title
    	this.setComment(CommentValue);
    	Reporter.log("comment  entered");
    	
    	driver.findElement(By.xpath("//*[@class=\"Button--primary Button--medium Button ml-1\"]")).click();
    	Reporter.log("Button Clicked");
    }
  
    public void Discusion(String usernameValue, String passwordValue) {
    	
    	//fill Discussion Title
    	this.setName(usernameValue);
    	Reporter.log("Discussion Title entered");
    	//fill Write section
    	this.setWrite(passwordValue);
    	Reporter.log("Write section entered");
    	//click
    	this.Click();
    	Reporter.log("Button Clicked");
    }
}

