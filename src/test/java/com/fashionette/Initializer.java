package com.fashionette;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import com.fashionette.util.Commons;

public class Initializer {
	public WebDriver driver;
	public String applicationHost;
	public String browsers;
	public String email;
	public String password;
	private Commons commons;

	public Initializer() {
		commons = new Commons();
	}
	@BeforeSuite
	@Parameters({ "applicationHost","browsers", "email", "password" })
	public void beforeSuite(String applicationHost, String browsers, String email, String password) {
		this.applicationHost = applicationHost;
		this.browsers = browsers;
		this.email = email;
		this.password = password;

		initializeDrivers();
		openBrowser();
		closePopup(); 

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
		//driver.manage().timeouts().implicitlyWait(Duration.ofMillis(10000));
	}
    
	public void closePopup() { 
		commons.sleep(500);
		driver.findElement(By.id("uc-btn-accept-banner")).click();
	}


	@AfterSuite
	public void afterSuite() {
		driver.quit();
	}
}
