package objects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class GoogleSearchPage {
//instance variable of driver 
	WebDriver driver;
	
	//create a constructor and intialize driver object
	public GoogleSearchPage(WebDriver driver) {
		//intialized the driver object
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	//Write all locators of the page here
	
	@FindBy(xpath="//textarea[@title='Search']")
	WebElement inputSearch;
	
	
	@FindBy(xpath="(//input[@value='Google Search'])[2]")
	WebElement searchgooglebtn;
	
	
	@FindBy(xpath="(//cite[@role='text'])[1]")
	WebElement guvilink;
	
	
	@FindBy(id="login_email")
	WebElement loginEmailField;
	
	@FindBy(id="login_password")
	WebElement loginpasswordField;
	
	@FindBy(id="login_button")
	WebElement loginButtonGuvi;
	
	public void searchGoogle(String searchinput) {
		inputSearch.sendKeys(searchinput);//guvi signin 
		searchgooglebtn.click();
	}
	
	public void clickGuviPageLink() {
		guvilink.click();
	}
	
	public void LoginEmailguvi(String  emailField) {
		loginEmailField.sendKeys(emailField);
	}
	
	public void LoginPasswordguvi(String passwordField) {
		loginpasswordField.sendKeys(passwordField);
	}
	
	public void LoginClickGuvi() {
		loginButtonGuvi.click();
	}
	
}
