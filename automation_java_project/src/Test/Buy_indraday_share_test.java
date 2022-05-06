package Test;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import POM.Buy_indraday_share;
import POM.Zerodha_buy_share;
import POM.Zerodha_login;
import Utility.Browser_open;
import Utility.Excel;
import Utility.Screenshot;

public class Buy_indraday_share_test {
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
		System.out.println("buyshareusingtestng="+Thread.currentThread().getId());
	}
	
	@Test(priority =3)
	public void nse_bse() throws EncryptedDocumentException, IOException
	{
		Buy_indraday_share obj= new Buy_indraday_share(driver);
		String nsebse =  Excel.getdata(0,0,"intra_long");
		obj.nscbse(nsebse);
	}
	@Test(priority =4)
	public void buynsebsc() throws EncryptedDocumentException, IOException
	{
		Buy_indraday_share obj= new Buy_indraday_share(driver);
		String tabname =  Excel.getdata(1,0,"intra_long");
		obj.tabclick(tabname);
		
	}
	
	
	@Test(priority =5)
	public void intrday_longterm() throws EncryptedDocumentException, IOException
	{
		Buy_indraday_share obj= new Buy_indraday_share(driver);
		String intralong =  Excel.getdata(2,0,"intra_long");
		obj.intlong(intralong);
	}
	
	@Test(priority =6)
	public void select_quantity()
	{
		Buy_indraday_share obj= new Buy_indraday_share(driver);
		obj.qunt("2");
	}
	@Test(priority =7)
	public void market_limite() throws EncryptedDocumentException, IOException
	{
		Buy_indraday_share obj= new Buy_indraday_share(driver);
		String marklimit =  Excel.getdata(3,0,"intra_long");
		obj.mrklim(marklimit);
	}
	
	@Test(priority =8)
	public void sl_slm() throws EncryptedDocumentException, IOException
	{
		Buy_indraday_share obj= new Buy_indraday_share(driver);
		String sl_slms =  Excel.getdata(4,0,"intra_long");
		obj.slms(sl_slms);
	}
//	@Test(priority =8)
//	public void Buyshare()
//	{
//		Buy_indraday_share obj= new Buy_indraday_share(driver);
//		obj.submit();
//	}
	@AfterMethod
	public void screeshot() throws IOException
	{
		Screenshot.Take_screenshot(driver, "share_buy");
	}
	
	

}



