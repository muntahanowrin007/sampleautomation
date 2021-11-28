package com.fashionette;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

public class Initializer {
	public WebDriver driver;
	public String applicationHost;
	public String port;
	public String browsers;
	public String username;
	public String password;
	
	
	@BeforeSuite
	@Parameters({ "applicationHost", "port", "browsers", "username", "password" })
	public void beforeSuite(String applicationHost, String port, String browsers, String username, String password) {
		this.applicationHost = applicationHost;
		this.port = port;
		this.browsers = browsers;
		this.username = username;
		this.password = password;
		
		System.out.println(applicationHost);
		
		
		//driver =new FirefoxDriver();
	}

	@AfterSuite
	public void afterSuite() {
		//driver.quit();
	}
}
