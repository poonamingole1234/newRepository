package Test;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import POM.HomePage;
import POM.LoginPage;
import Pojo.Browser;
import Utilities.Excel;
import Utilities.Reports;

@Listeners(ListenerTest.class)
public class ZerodhaLoginTest extends BaseTest {
	ExtentReports reports;
	ExtentTest test;
	//public static WebDriver driver;//property of parent
	@BeforeClass
	public void configureExtentReport() {
		reports =	Reports.addReport();
	}
	
	
	@BeforeMethod
	public void LaunchBrowser() {
		driver = Browser.OpenBrowser("https://kite.zerodha.com/");
	}
	
	@Test
	public void LoginWithValidCredentials() throws EncryptedDocumentException, IOException {
		test = reports.createTest("LoginWithValidCredentials");
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
	public void clickOnSigup() {
		 test = reports.createTest("clickOnSignup");
		LoginPage loginpage = new LoginPage(driver);
		loginpage.clickOnSignUp();
		Assert.assertTrue(false);
	}
	
	@Test(dependsOnMethods = {"clickOnSigup"})
	public void clickOnForgotPassword() {
		test = reports.createTest("clickOnForgotPassword");
		LoginPage loginpage = new LoginPage(driver);
		loginpage.clickOnForgotButton();
	}
	
	@Test
	public void verifyLoginText() throws EncryptedDocumentException, IOException {
		test = reports.createTest("verifyLoginText");
		LoginPage loginpage = new LoginPage(driver);
		String actualText =loginpage.getLoginText();
		String expectedText = "Login Kite";
		SoftAssert softAssert = new SoftAssert();//soft assert
		softAssert.assertEquals(actualText, expectedText);//adding soft assert
		String user =Excel.getTestData(0, 1, "Credentials");
		loginpage.enterUserName(user);
		String pass =Excel.getTestData(1, 1, "Credentials");
		loginpage.enterPassword(pass);
		loginpage.clickOnSubmit();
		String pin = Excel.getTestData(2, 1, "Credentials");
		loginpage.enterPin(pin, driver);
		loginpage.clickOnContinue();
		System.out.println("Login successfull");
		HomePage homePage = new HomePage(driver);
		boolean status = homePage.avatarIsDisplayed(driver);
		softAssert.assertTrue(status);
		softAssert.assertAll();//will display the failure 
	}
	
	@AfterMethod
	public void addTestResult(ITestResult result) {
		if(result.getStatus()==ITestResult.FAILURE) {
			test.log(Status.FAIL, result.getName());
		}
		else if(result.getStatus()== ITestResult.SUCCESS)
		{
			test.log(Status.PASS, result.getName());
		}
		else {
			test.log(Status.SKIP,result.getName());
		}
	}
	
	@AfterClass
	public void flushResults() {
		reports.flush();
	}
	

	
	
}
