package Pojo;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Browser {
	public static WebDriver OpenBrowser(String url) {//this method returns WebDriver which is driver.
		ChromeOptions options = new ChromeOptions();//class of Selenium
		options.addArguments("--disable-notifications");//will disable the chrome notification
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\91877\\OneDrive\\Documents\\Software\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver(options);
		driver.get(url);
		driver.manage().window().maximize();
		return driver;
	}
}
