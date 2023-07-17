package testScenarios;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import objects.GoogleSearchPage;//import grab it from other

public class TestMethodgoogle {

WebDriver driver;
GoogleSearchPage googleobj;//declare variable 
	
@BeforeTest
public void beforeTest() {
	//write code that should execute before every test method execution
	System.setProperty("webdriver.http.factory","jdk-http-client");
	//instance of chromedriver 
	 driver=new ChromeDriver();
	//implicitly managing
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	driver.manage().window().maximize();//maxmize the window
	driver.get("https://www.google.com/");
	
}

@Test(priority = 0)
public void verifyLandingPagegoogle() {
	String expectedTitle="Google";
	String actualTitle=driver.getTitle();
	Assert.assertEquals(actualTitle, expectedTitle);
}


@Test(priority = 1)
public void searchgoogleOperation() {
	 googleobj=new GoogleSearchPage(driver);//create object GoogleSearchPage
	 googleobj.searchGoogle("guvi signin page");
}



@Test(priority=2)
public void verifyandAcessGuviLogin() {
	googleobj =new GoogleSearchPage(driver);
	googleobj.clickGuviPageLink();//call method
}

@Test(priority = 3)
public void verifyLandingPageguvi() {
	String expectedTitle="GUVI | Sign-in";
	String actualTitle=driver.getTitle();
	Assert.assertEquals(actualTitle, expectedTitle);
}


@Test(priority = 4)
public void LoginGuviPagewithValid() {
	googleobj=new GoogleSearchPage(driver);
	googleobj.LoginEmailguvi("lavish@guvi.com");
	googleobj.LoginPasswordguvi("admin123");
	googleobj.LoginClickGuvi();
	
	//logic implementation
	
}


@Test(priority = 5)
public void LoginGuviPagewithInValid() {
	googleobj=new GoogleSearchPage(driver);
	googleobj.LoginEmailguvi("l@guvi.com");
	googleobj.LoginPasswordguvi("123");
	googleobj.LoginClickGuvi();
	//verify it for false reason
}






@AfterTest
public void afterTest() {
	driver.quit();
}


}
