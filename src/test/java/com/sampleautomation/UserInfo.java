package com.sampleautomation;

import static org.testng.Assert.assertTrue;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;


public class UserInfo extends Initializer{
	ExtentTest extentTest; 
	@BeforeClass
	@Parameters({ "applicationHost","browsers", "email", "password" }) 
	public void setup(String applicationHost, String browsers, String email, String password) {
		setProperties(applicationHost, browsers, email, password);
		initializeDrivers();
		openBrowser();
		activateCookies();
		extentReport("UserInfo");
	}
	
	@Test
	public void login() {
		extentTest = extent.createTest("UserInfo test login");
		extentTest.info("Starting of login");
		driver.findElement(By.xpath("//span[@class='icon icon--user']")).click();
		commons.sleep(1000);
		extentTest.info("login window opened");
		driver.findElement(By.xpath("//input[@name='email']")).sendKeys(email);
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys(password);
		driver.findElement(By.xpath("//button[normalize-space()='Login']")).click();
		extentTest.info("email and password inserted succesfully");
		commons.sleep(500);
		WebElement webElement = driver.findElement(By.xpath("//div[@class='account__welcome text__center font-size--hero']"));
		boolean elementCheckedResult = webElement.isDisplayed();
		assertTrue(elementCheckedResult);
		extentTest.pass("Login Successful");
	}
	
	@Test
	public void modifyuserInfo() {
		extentTest = extent.createTest("modifyuserInfo");
		extentTest.info("Navigate to personal data form to modify user info");
		WebElement webElement;
		boolean elementCheckedResult;
		driver.findElement(By.xpath("//a[normalize-space()='Personal data']")).click();
		commons.sleep(500);
		driver.findElement(By.xpath("//div[@class='account--address__action account--address__action--update']")).click();
		commons.sleep(500);
		webElement= driver.findElement(By.xpath("//input[@placeholder='First name']"));
		webElement.clear();
		webElement.sendKeys("Muntaha");
		webElement=driver.findElement(By.xpath("//input[@placeholder='Surname']"));
		webElement.clear();
		webElement.sendKeys("Nowrin");
		extentTest.info("Firstname and Surname Inserted");
		driver.findElement(By.xpath("//div[contains(text(),'Save')]")).click();
		extentTest.info("Firstname and Surname Saved");
		commons.sleep(500);
		webElement = driver.findElement(By.xpath("//div[contains(@class,'account--personaldata')]//div[2]"));
		elementCheckedResult = webElement.isDisplayed();
		assertTrue(elementCheckedResult);
		assertTrue(webElement.getText().contains("Muntaha Nowrin"));
		extentTest.pass("UserData Modified Successfully");
	}
	
	@AfterClass
	public void close() {
		closeDriver();
		extent.flush();
	}
	
}
