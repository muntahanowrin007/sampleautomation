package com.sampleautomation;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;

public class Voucher extends Initializer {
	
	ExtentTest extentTest; 
	
	@BeforeClass
	@Parameters({ "applicationHost","browsers", "email", "password" }) 
	public void setup(String applicationHost, String browsers, String email, String password) {
		setProperties(applicationHost, browsers, email, password);
		initializeDrivers();
		openBrowser();
		activateCookies();
		extentReport("Voucher");
	}
	
	@Test
	public void addProductToCart() {
		extentTest = extent.createTest("addProductToCart to Redeem Voucher");
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
	public void applyVoucher() {
		extentTest = extent.createTest("applyVoucher");
		extentTest.info("Entering applyVoucher");
		WebElement webElement;
		boolean elementCheckedResult;
		driver.navigate().refresh();
		driver.findElement(By.xpath("//span[@class='cart-amount']")).click();
		extentTest.info("Navigate to the Cart");
		commons.sleep(500);
		driver.findElement(By.xpath("//a[@class='cart__sum__voucher-link']")).click();
		driver.findElement(By.xpath("//input[@placeholder='Coupon']")).sendKeys("qachallenge");
		driver.findElement(By.xpath("//button[normalize-space()='redeem']")).click();
		extentTest.pass("Voucher Succesfully added");
		commons.sleep(500);
		webElement = driver.findElement(By.xpath("//i[@class='icon icon--inline icon--cross']"));
	    elementCheckedResult = webElement.isDisplayed();
		assertTrue(elementCheckedResult);
		webElement = driver.findElement(By.xpath("//span[@data-code='qachallenge']"));
	    assertTrue(webElement.getText().contains("-£"));
	    extentTest.pass("Apply voucher worked");
	}

	@AfterClass
	public void close() {
		closeDriver();
		extent.flush();
	}
}
