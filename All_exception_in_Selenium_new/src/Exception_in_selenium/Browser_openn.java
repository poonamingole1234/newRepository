package Exception_in_selenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Browser_openn {
	
	public static WebDriver open_chrome_browser(String url)
	{
		//open chrome browser by giving  chrome driver.exe path
		System.setProperty("webdriver.chrome.driver","F:\\chromedriver_win32\\chromedriver.exe");
		
		//upcasting
		WebDriver driver = new ChromeDriver();
		
		//get method for open url on chrome browser
		driver.navigate().to(url);
		
		return driver;

}
}