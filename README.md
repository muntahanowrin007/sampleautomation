# Fashionette
Fashionette’s automated tests code challenge
	
## Steps to Run Test Project
 * Make Sure Java is installed where project will be cloned
 * Browser pre requisite <b>Chrome</b> or <b>Firefox</b>
 * Clone the project - <https://github.com/muntahanowrin007/fashionette.git> 
 * <b>Master</b> is the default branch and all latest codes are exist there.
 
 * Import the project in any IDE as a <b>Maven</b> project
 * Look for testng.xml file in the project root directory [ testng.xml located at ..\git\fashionette\testng.xml ]. Change parameters value if required; for example "name="browsers" value="<b>Chrome</b>"
 * Run testng.xml file as TestNG suite . <b>Example</b>: In eclipse, right click on testng.xml then click on <b>Run as</b> and then select <b>TestNG suite</b>
 
## Find Test Result
* Option 1 : IDE console will show the results like <b>Total tests run: 7, Failures: 0, Skips: 0</b>
* Option 2 : Refresh project from IDE (example: Select root folder in package explorer of eclipse and try to refresh). 
* Option 2.1 : After test suit run ended three report files will be generated in the project's root directory [<b>Products.html</b> , <b>UserInfo.html</b> , <b>Voucher.html</b>]


## Third party libraries

[Selenium](https://www.selenium.dev/)
  [TestNG](https://testng.org/doc/)
  [ExtentReports](https://www.extentreports.com/)
   [Webdrivermanager](https://github.com/bonigarcia/webdrivermanager)