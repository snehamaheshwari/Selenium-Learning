package login;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import java.lang.reflect.Method;

import init.DriverFactory;
import pages.DashboardPage;
import pages.LoginPage;
import utilities.FilesUtility;
import utilities.extentReports.ExtentTestManager;

public class LoginTest {
	public WebDriver driver=null;
	LoginPage loginPage = new LoginPage();
	FilesUtility file = new FilesUtility();
	DashboardPage dashBoard = new DashboardPage();
	
	@BeforeClass (alwaysRun=true)
	public void setUp() throws IOException {
		DriverFactory driverFac = new DriverFactory();
		driver = driverFac.launchBrowser();
	}
	
	@Test(groups="smoke")
	public void testLogin(Method method) throws IOException {
		ExtentTestManager.startTest(method.getName(), "Login with valid credentials.");
		loginPage.enterEmail(driver, file.getValueFromPropertyFile("userName"));
		loginPage.enterPassword(driver, file.getValueFromPropertyFile("password"));
		loginPage.clickLogin(driver);
		Assert.assertEquals(dashBoard.getPageHeading(driver), "System Dashboard");
	}
	
	@AfterClass (alwaysRun=true)
	public void tearDown() {
		driver.quit();
	}
}
