package objects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

	private WebDriver driver;

	public LoginPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
				//intialized the driver object
			this.driver=driver;
			PageFactory.initElements(driver, this);
	}
	
	//locate element here by @FindBy annotated method
	@FindBy(id="login2")
	WebElement loginLandingBtn;
	
	
	@FindBy(id="loginusername")
	WebElement loginUsername;
	
	
	@FindBy(id="loginpassword")
	WebElement loginpassword;
	
	@FindBy(xpath="//button[@onclick='logIn()']")
	WebElement loginClickBtn;
	
	
	@FindBy(id="nameofuser")
	WebElement Welcomelogin;
	
	public void  clickloginLandingBtn() {
		loginLandingBtn.click();
	}
	
	public void enterloginUsername(String username) {
		loginUsername.sendKeys(username);//comes from test method
	}
	public void enterloginPassword(String password) {
		loginpassword.sendKeys(password);	//comes from test method
	}
	
	public void clickloginBtn() {
		loginClickBtn.click();
	}
	
	public String displayWelcome() {
		String actual=driver.findElement(By.id("nameofuser")).getText();
		return actual;
	}
}
