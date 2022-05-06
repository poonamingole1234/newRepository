package Test;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import POM.HomePage;
import POM.LoginPage;
import Pojo.Browser;
import Utilities.Excel;

public class HomePageTest {
	WebDriver driver;
	@BeforeMethod
	public void launchBrowserAndLogin() throws EncryptedDocumentException, IOException {
		driver =Browser.OpenBrowser("https://kite.zerodha.com");
		LoginPage loginpage = new LoginPage(driver);
		String user =Excel.getTestData(0, 1, "Credentials");
		loginpage.enterUserName(user);
		String pass =Excel.getTestData(1, 1, "Credentials");
		loginpage.enterPassword(pass);
		loginpage.clickOnSubmit();
		String pin = Excel.getTestData(2, 1, "Credentials");
		loginpage.enterPin(pin, driver);
		loginpage.clickOnContinue();
	}
	
	@Test
	public void buyStockTest() {
		HomePage homepage = new HomePage(driver);
		Assert.assertTrue(homepage.avatarIsDisplayed(driver));
		homepage.searchStock("TataMotors");
		homepage.selectFirstStock(driver);
		homepage.clickOnBuy();
	}
	
}
