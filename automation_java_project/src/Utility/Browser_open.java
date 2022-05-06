package Utility;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;



public class Browser_open {
	
	public static WebDriver open_chrome_browser(String url)
	{
		ChromeOptions options = new ChromeOptions();//class of selenium
		options.addArguments("--disable-notifications");//disable the chrome notification
		//open chrome browser by giving  chrome driver.exe path
		System.setProperty("webdriver.chrome.driver","F:\\chromedriver_win32\\chromedriver.exe");
		
		//upcasting
		WebDriver driver = new ChromeDriver(options);
		
		//get method for open url on chrome browser
		driver.navigate().to(url);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		return driver;

}

}
