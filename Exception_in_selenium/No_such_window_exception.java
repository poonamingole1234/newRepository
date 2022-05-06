package Exception_in_selenium;

import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchWindowException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class No_such_window_exception {

	public static void main(String[] args) {

		WebDriver driver = Browser_openn.open_chrome_browser("https://vctcpune.com/");
		
		WebElement selenium =driver.findElement(By.xpath("//a[text()='Start Selenium Practice'][1]"));
		selenium.click();
		selenium.click();
		selenium.click();
		
		ArrayList<String> list = new ArrayList<String>(driver.getWindowHandles());
		System.out.println(list.get(0));//main page
		System.out.println(list.get(1));//last
		System.out.println(list.get(2));//second last
		System.out.println(list.get(3));//first
		
		driver.close();
		
		try 
		{
		driver.switchTo().window(list.get(0));
		}
		catch(NoSuchWindowException e)
		{
			System.out.println(e);
		}
		
	
		
	   // driver.switchTo().window(list.get(0));
		
        driver.switchTo().window(list.get(2));
		
		driver.findElement(By.xpath("//input[@value='Radio1']")).click();
	}

}
