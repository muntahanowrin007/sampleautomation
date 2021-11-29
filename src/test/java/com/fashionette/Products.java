package com.fashionette;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.fashionette.util.Commons;

public class Products extends Initializer{
	private Commons commons;
	
	@BeforeTest
	public void setup() {
		commons = new Commons(driver);
	}
	@Test
	public void addProductToCart() {
		
		WebElement webElement;
		boolean elementCheckedResult;
		driver.findElement(By.xpath("//img[@title='Watches']")).click();
		driver.findElement(By.xpath("/html[1]/body[1]/div[3]/div[2]/div[1]/div[2]/div[1]/div[2]/div[3]/div[1]/div[1]/a[1]/div[1]/div[1]/img[1]")).click();
		driver.findElement(By.xpath("//div[@class='btn btn--bigger-icon preventspinner btn-default']//div[@class='btn__content'][normalize-space()='Add to cart']")).click();
		driver.findElement(By.xpath("//span[@class='icon icon--user']")).click();
		commons.sleep(500);
		assertTrue(commons.login(email, password));
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
		System.out.println(webElement.getText());
		assertEquals("Free delivery in approx. 5-7 working days", webElement.getText());
		
		webElement = driver.findElement(By.xpath("//button[@id='checkout-start']"));
		elementCheckedResult = webElement.isEnabled();
		assertTrue(elementCheckedResult);
		
	}


}