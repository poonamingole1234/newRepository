package Test;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import POM.Zerodha_login;
import Utility.Browser_open;

public class Home {
		
WebDriver driver;
	@Test
	public void open_browser() throws EncryptedDocumentException, IOException, InterruptedException
	{
		Zerodha_buy_share_test obj = new Zerodha_buy_share_test();
		obj.open_chrome();
		obj.loginwithvalidcreadintial();
		Thread.sleep(3000);
		obj.buyshareusingtestng();
	//	Thread.sleep(3000);
	}

//	@Test
//	public void search() throws EncryptedDocumentException, IOException, InterruptedException
//	{
//		Zerodha_buy_share_test obj1 = new Zerodha_buy_share_test();
//		obj1.buyshareusingtestng();
//		
//	}
	
}
