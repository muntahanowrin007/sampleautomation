package com.fashionette.util;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Commons {
	public WebDriver driver;
	
	public Commons() {}
	
	public Commons(WebDriver driver) {
		this.driver = driver;
	}

	
	public boolean login(String email, String password) {
		driver.findElement(By.xpath("//input[@name='email']")).sendKeys(email);
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys(password);
		driver.findElement(By.xpath("//button[normalize-space()='Login']")).click();
		sleep(1000);
		WebElement webElement = null;
		try {
			webElement = driver.findElement(By.xpath("//div[@class='account__welcome text__center font-size--hero']"));
		} catch (NoSuchElementException e) {
			return false;
		}
		if(webElement != null && webElement.isDisplayed()) {
			return true;
		}else {
			return false;
		}
	}

	public void sleep(int milliseconds) {
		try {
			Thread.sleep(milliseconds);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
