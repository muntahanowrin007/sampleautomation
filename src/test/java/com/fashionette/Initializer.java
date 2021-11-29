package com.fashionette;


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
	public Commons commons;

	public Initializer() {
		System.out.println("Initializer called");
		commons = new Commons();
	}
	@BeforeSuite
	@Parameters({ "applicationHost","browsers", "email", "password" })
	public void beforeSuite(String applicationHost, String browsers, String email, String password) {
		
		System.out.println("Before suit called");
		this.applicationHost = applicationHost;
		this.browsers = browsers;
		this.email = email;
		this.password = password;

		initializeDrivers();
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

	@AfterSuite
	public void afterSuite() {
		System.out.println("aftersuit called");
		//driver.quit();
	}
}
