package testCases;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import base.Base;
import pages.AccountPage;
import pages.HomePage;
import pages.LoginPage;
import utilities.Utilities;

public class Login extends Base{
	
	public Login() throws IOException {
		super();
	}
	
	public WebDriver driver;
	HomePage hp;
	LoginPage lp;
	AccountPage ap;
	
	@Test(priority = 1)
	public void tc_lf_001() {
		lp.enterCredentialsAndLogin(prop.getProperty("validEmail"), prop.getProperty("validPasswor"));
		Assert.assertTrue(ap.verifyAccountPage(), "Not navigated to account page (Invalid Credentials)");
	}
	
	@Test(priority = 2)
	public void tc_lf_002() {
		lp.enterCredentialsAndLogin(Utilities.invalidEmail(), Utilities.invalidPassword());
		Assert.assertTrue(lp.verifyInvalidCredentialsWarning(), "Invalid Credentials warning message is not displayed");
	}
	
	@Test(priority = 3, dataProvider = "supplyValidCredentials")
	public void tc_lf_001HDD(String email, String password) {
		lp.enterCredentialsAndLogin(email, password);
	}
	
	@DataProvider(name = "supplyValidCredentials")
	public Object[][] excelData() throws IOException{
		return Utilities.getDataFromExcel("Sheet1");
	}
	
	@BeforeMethod
	public void setUp() throws IOException {
		driver = initializeBrowser(prop.getProperty("browser"));
		hp = new HomePage(driver);
		lp = new LoginPage(driver);
		ap = new AccountPage(driver);
		
		hp.goToLoginPage();
	}
	
	@AfterMethod
	public void close() {
		driver.quit();
	}
}
