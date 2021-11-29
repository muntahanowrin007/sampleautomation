package com.fashionette;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

public class Initializer {
	public WebDriver driver;
	public String applicationHost;
	public String browsers;
	public String username;
	public String password;
	
	
	@BeforeSuite
	@Parameters({ "applicationHost","browsers", "username", "password" })
	public void beforeSuite(String applicationHost, String browsers, String username, String password) {
		this.applicationHost = applicationHost;
		this.browsers = browsers;
		this.username = username;
		this.password = password;
		
		initializeDrivers();
		openBrowser();
		
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
		
		System.out.println(applicationHost);
		driver.get(applicationHost);
		driver.manage().window().maximize();
	}

	@AfterSuite
	public void afterSuite() {
		driver.quit();
	}
}
