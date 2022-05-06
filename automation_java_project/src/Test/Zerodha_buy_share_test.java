package Test;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;



import POM.Zerodha_buy_share;
import POM.Zerodha_login;
import Utility.Browser_open;
import Utility.Excel;
import Utility.Screenshot;

public class Zerodha_buy_share_test {
	WebDriver driver;
	@BeforeClass
	public void open_chrome()
	{
		driver = Browser_open.open_chrome_browser("https://kite.zerodha.com/");
		
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
	
//	@Test(priority =2)
//	public void buyshareusingtestng() throws EncryptedDocumentException, IOException, InterruptedException
//	{
//		Zerodha_buy_share obj1 = new Zerodha_buy_share(driver);
//		String sharenames =  Excel.getdata(0,0,"buyshare");
//		//String a="IDEA";
//		obj1.serachshare(sharenames);	
//		Thread.sleep(3000);
//		obj1.clickonshare();
//		obj1.buyshare(driver, sharenames);
//		System.out.println("buyshareusingtestng="+Thread.currentThread().getId());
//	}
//	
	@Test(priority =2)
	public void buyshareusingtestng() throws EncryptedDocumentException, IOException, InterruptedException
	{
		Zerodha_buy_share obj1 = new Zerodha_buy_share(driver);
		String sharenames =  Excel.getdata(0,0,"buyshare");
		//String a="IDEA";
		obj1.serachshare(sharenames);	
		Thread.sleep(3000);
		obj1.clickonshare();
		obj1.buyshare(driver, sharenames);
	}
	
	@AfterMethod
	public void screeshot() throws IOException
	{
		Screenshot.Take_screenshot(driver, "share_buy");
	}
	
	

}
