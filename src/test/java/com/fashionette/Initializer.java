package com.fashionette;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.fashionette.util.Commons;

public class Initializer {
	public WebDriver driver;
	public String applicationHost;
	public String browsers;
	public String email;
	public String password;
	public Commons commons;
	public ExtentReports extent;

	/*public Initializer() {
		System.out.println("Initializer called");
		
	} */
	
	public void setProperties(String applicationHost, String browsers, String email, String password) {
		
		commons = new Commons();
		this.applicationHost = applicationHost; 
		this.browsers = browsers; 
		this.email = email; 
		this.password = password; 
	}


	public void initializeDrivers() {
		String projectPath = System.getProperty("user.dir");

		if(browsers.equalsIgnoreCase("firefox")) {
			System.setProperty("webdriver.gecko.driver", projectPath + "\\drivers\\geckodriver\\geckodriver.exe");
			driver = new FirefoxDriver();
		} else {
			System.setProperty("webdriver.chrome.driver", projectPath + "\\drivers\\chromedriver\\chromedriver.exe");
			driver = new ChromeDriver();
		}
		
	}
	
	public void openBrowser() {
		driver.get(applicationHost);
		driver.manage().window().maximize();
		
	}

	public void activateCookies() { 
		commons.sleep(500);
		driver.findElement(By.id("uc-btn-accept-banner")).click();
		driver.findElement(null).click();
	}
	
	public void extentReport(String reportName) {
		ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter(reportName+".html");
		extent = new ExtentReports();
		extent.attachReporter(htmlReporter);
	}

	public void closeDriver() {
		driver.quit();
	}
}
