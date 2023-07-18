package testScenarios;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import objects.LoginPage;
import objects.SignupPage;

public class LoginTest {

	private WebDriver driver;
	private SignupPage signupobj;//declare variable 
		
	@BeforeTest
	public void beforeTest() {
		//write code that should execute before every test method execution
		System.setProperty("webdriver.http.factory","jdk-http-client");
		//instance of chromedriver 
		 driver=new ChromeDriver();
		//implicitly managing
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.manage().window().maximize();//maxmize the window
		driver.get("https://www.demoblaze.com/");
		
	}
	
	@Test
	public void loginTest() throws InterruptedException {
		//create an object of 
		String username="nitish123";
		String password="admin123";
		LoginPage loginpage=new LoginPage(driver);//object creation
		loginpage.clickloginLandingBtn();
		Thread.sleep(3000);
		loginpage.enterloginUsername(username);
		loginpage.enterloginPassword(password);
		Thread.sleep(1000);
		loginpage.clickloginBtn();
		
		
		Thread.sleep(3000);
		//assertion or verfication
		String expectedoutput="Welcome "+username;
//		String actual=driver.findElement(By.id("nameofuser")).getText();
		String actual=loginpage.displayWelcome();
		Thread.sleep(1000);
		Assert.assertEquals(actual,expectedoutput );
		}
	
	
	
	@AfterTest
	public void afterTest() {
		driver.quit();
	}
}
