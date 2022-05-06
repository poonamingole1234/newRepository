package Test;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import POM.Zerodha_login;
import Utility.Browser_open;
import Utility.Excel;
import Utility.Screenshot;


public class Zerodha_login_test {

	WebDriver driver;
	
	
	@BeforeMethod
	public void open_chrome()
	{
		driver = Browser_open.open_chrome_browser("https://kite.zerodha.com/");
		//Browser_open.open_chrome_browser("firefox");
		
	}
	
	@BeforeMethod
	@Parameters("browsername")
	public void crossbrowser(String browsername )
	{
       
		
		if(browsername.equalsIgnoreCase("chrome"))//chromedriver
		{
			System.setProperty("webdriver.chrome.driver", "F:\\chromedriver_win32\\chromedriver.exe");
			driver = new ChromeDriver();
			driver.get("https://kite.zerodha.com/");
			
		}
		
		else if(browsername.equalsIgnoreCase("firefox"))
		{
			System.setProperty("webdriver.edge.driver", "F:\\edgedriver_win64\\msedgedriver.exe");
			driver = new EdgeDriver();
			driver.get("https://kite.zerodha.com/");
			
		}
		
		else if(browsername.equalsIgnoreCase("egde"))
		{
			System.setProperty("webdriver.gecko.driver","F:\\geckodriver-v0.30.0-win64\\geckodriver.exe");
			driver = new FirefoxDriver();
			driver.get("https://kite.zerodha.com/");
		}
	}
		
	@Test(priority=1)
	public void loginwithvalidcreadintial() throws EncryptedDocumentException, IOException, InterruptedException
	{
	
	 
	Zerodha_login obj = new Zerodha_login(driver);
	
	
	String username = Excel.getdata(0,1,"Login_zerodha");
	obj.enterusername(username);
	
	String password = Excel.getdata(1,1,"Login_zerodha");
	obj.enterpassword(password);
	
	obj.clickonsubmit();
	
	Thread.sleep(3000);
	String pins=Excel.getdata(2,1,"Login_zerodha");
	obj.pinenter(pins);
	
	obj.clickoncontinue();
	Thread.sleep(3000);
	System.out.println("loginwithvalidcreadintial="+Thread.currentThread().getId());
	}
	
	@Test(priority=2)
	public void forgott_link()
	{
		Zerodha_login obj1 = new Zerodha_login(driver);
		obj1.forgott();
		System.out.println("loginwithvalidcreadintial="+Thread.currentThread().getId());

	}
	
	@Test(priority=3)
	public void singup_link() throws InterruptedException, IOException
	{
		
		Zerodha_login obj2 = new Zerodha_login(driver);
		Thread.sleep(30000);
		obj2.singup();
		Thread.sleep(30000);
		System.out.println("loginwithvalidcreadintial="+Thread.currentThread().getId());

		
	}
	
	@AfterMethod
	public void chromeclose() throws InterruptedException, IOException
	{
		//driver.quit();
		Screenshot.Take_screenshot(driver, "zerodha_login");
		Thread.sleep(3000);
		//driver.quit();
	}
}
