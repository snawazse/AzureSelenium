package com.qa.opencart.Base;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.asserts.SoftAssert;

import com.qa.opencart.Factory.DriverFactory;
import com.qa.opencart.Pages.AccountsPage;
import com.qa.opencart.Pages.LoginPage;
import com.qa.opencart.Pages.ProductInfoPage;
import com.qa.opencart.Pages.RegisterPage;
import com.qa.opencart.Pages.SearchPage;
import com.qa.opencart.Pages.ViewCartPopUpPage;

public class BaseTest {

	DriverFactory df;
	WebDriver driver;
	protected Properties prop;
	protected LoginPage loginPage;
	protected AccountsPage accPage;
	protected SearchPage searchPage;
	protected ProductInfoPage productInfoPage;
	protected ViewCartPopUpPage viewCartPopUpPage;
	protected RegisterPage registerPage;

	
	protected SoftAssert softAssert;
	
	
	@Parameters({"browser", "browser-version", "testcase-name"})
	@BeforeTest
	public void setup(String browserName, String browserVersion, String testCaseName) {
		df = new DriverFactory();
		prop = df.initProp();
		
			if(browserName!=null) {
				prop.setProperty("browser", browserName);
				prop.setProperty("browser-version", browserVersion);
				prop.setProperty("testcase-name", testCaseName);

			}
		
		
		driver = df.initDriver(prop);
		loginPage = new LoginPage(driver);
		softAssert = new SoftAssert();

	}

	@AfterTest
	public void tearDown() {
		driver.quit();
	}

}
