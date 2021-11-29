package com.fashionette;

import static org.testng.Assert.assertTrue;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;


public class UserInfo extends Initializer{
	
	@BeforeClass
	public void setup2() {
		driver.get(applicationHost);
		driver.manage().window().maximize();
		commons.sleep(500);
		driver.findElement(By.id("uc-btn-accept-banner")).click();
	}
	
	@Test
	public void login() {
		driver.findElement(By.xpath("//span[@class='icon icon--user']")).click();
		commons.sleep(1000);
		driver.findElement(By.xpath("//input[@name='email']")).sendKeys(email);
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys(password);
		driver.findElement(By.xpath("//button[normalize-space()='Login']")).click();
		commons.sleep(500);
		WebElement webElement = driver.findElement(By.xpath("//div[@class='account__welcome text__center font-size--hero']"));
		boolean elementCheckedResult = webElement.isDisplayed();
		assertTrue(elementCheckedResult);
	}
	
	@Test
	public void modifyuserInfo() {
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
		driver.findElement(By.xpath("//div[contains(text(),'Save')]")).click();
		commons.sleep(500);
		webElement = driver.findElement(By.xpath("//div[contains(@class,'account--personaldata')]//div[2]"));
		elementCheckedResult = webElement.isDisplayed();
		assertTrue(elementCheckedResult);
		assertTrue(webElement.getText().contains("Muntaha Nowrin"));
		
	}
	
	
}
