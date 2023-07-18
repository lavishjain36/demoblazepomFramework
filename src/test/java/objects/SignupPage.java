package objects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SignupPage {

	private WebDriver driver;

	public SignupPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		//intialized the driver object
			this.driver=driver;
			PageFactory.initElements(driver, this);
	}

	
	//Locators
	@FindBy(id="signin2")
	WebElement signuplandingbtn;
	
	@FindBy(id="sign-username")
	WebElement signupusername;
	
	
	@FindBy(id="sign-password")
	WebElement signuppassword;
	
	@FindBy(xpath="//button[@onclick='register()']")
	WebElement signupclickBtn;
	
	public void clickSignupLandingBtn() {
		signuplandingbtn.click();
	}
	
	
	public void enterSignupUsername(String username) {
		signupusername.sendKeys(username);//comes from test method
	}
	
	public void enterSignupPassword(String password) {
		signuppassword.sendKeys(password);	//comes from test method
	}
	
	
	public void clickSignupBtn() {
		signupclickBtn.click();
	}
	
	
	
	
}
