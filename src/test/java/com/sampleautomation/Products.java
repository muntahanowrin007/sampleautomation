package com.sampleautomation;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;

public class Products extends Initializer{
	ExtentTest extentTest; 
	
	@BeforeClass
	@Parameters({ "applicationHost","browsers", "email", "password" }) 
	public void setup(String applicationHost, String browsers, String email, String password) {
		setProperties(applicationHost, browsers, email, password);
		initializeDrivers();
		openBrowser();
		activateCookies();
		extentReport("Products");
	}
	
	@Test
	public void addProductToCart() {
	    extentTest = extent.createTest("addProductToCart");
		extentTest.info("Starting of addProductToCart");
		driver.findElement(By.xpath("//img[@title='Watches']")).click();
		extentTest.info("List of waches are showing");
		//Click on the first watch from the list
		driver.findElement(By.xpath("/html[1]/body[1]/div[3]/div[2]/div[1]/div[2]/div[1]/div[2]/div[3]/div[1]/div[1]/a[1]/div[1]/div[1]/img[1]")).click();
		extentTest.pass("Successfully one watch selected");
		driver.findElement(By.xpath("//div[@class='btn btn--bigger-icon preventspinner btn-default']//div[@class='btn__content'][normalize-space()='Add to cart']")).click();
		extentTest.pass("Successfully item added in the cart");
		commons.sleep(500);
		WebElement webElement = driver.findElement(By.xpath("//div[@class='btn btn--bigger-icon preventspinner btn-default product-details__btn--already-exist']//div[@class='btn__content'][normalize-space()='Already in Cart']"));
		boolean elementCheckedResult =  webElement.isDisplayed();
		assertTrue(elementCheckedResult);
		extentTest.pass("Product Successfully added in the cart");
	}
	
	@Test
	public void login() {
		extentTest = extent.createTest("login");
		extentTest.info("Starting of login");
		driver.findElement(By.xpath("//span[@class='icon icon--user']")).click();
		extentTest.info("login window opened");
		commons.sleep(500);
		driver.findElement(By.xpath("//input[@name='email']")).sendKeys(email);
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys(password);
		extentTest.info("email and password inserted succesfully");
		driver.findElement(By.xpath("//button[normalize-space()='Login']")).click();
		commons.sleep(500);
		WebElement webElement = driver.findElement(By.xpath("//div[@class='account__welcome text__center font-size--hero']"));
		boolean elementCheckedResult = webElement.isDisplayed();
		assertTrue(elementCheckedResult);
		extentTest.pass("Login Successful");
	}
	
	@Test
	public void visitCart() {
		extentTest = extent.createTest("visitCart");
		extentTest.info("Navigate to Cart");
		WebElement webElement;
		boolean elementCheckedResult;
		driver.findElement(By.xpath("//span[@class='cart-amount']")).click();
		commons.sleep(500);
		webElement = driver.findElement(By.xpath("//div[@class='cart-item--img']//img"));
		elementCheckedResult = webElement.isDisplayed();
		assertTrue(elementCheckedResult);
		
		webElement = driver.findElement(By.xpath("//i[@class='icon icon--inline icon--trash-can']"));
		elementCheckedResult = webElement.isEnabled();
		assertTrue(elementCheckedResult);
		
		webElement = driver.findElement(By.xpath("//span[@class='typography__type-2--bold']"));
		elementCheckedResult = webElement.isDisplayed();
		assertTrue(elementCheckedResult);
		assertEquals("Free delivery in approx. 5-7 working days", webElement.getText());
		
		webElement = driver.findElement(By.xpath("//button[@id='checkout-start']"));
		elementCheckedResult = webElement.isEnabled();
		assertTrue(elementCheckedResult);
		extentTest.pass("All the necessary checks passed");
	}
	
	@AfterClass
	public void close() {
		closeDriver();
		extent.flush();
	}

}