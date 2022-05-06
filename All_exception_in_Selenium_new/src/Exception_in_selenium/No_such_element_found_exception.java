package Exception_in_selenium;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;



public class No_such_element_found_exception {
	
	public static void main(String[] args) throws IOException {

        WebDriver driver = Browser_openn.open_chrome_browser("https://www.facebook.com/");
		
        Take_Screesnshot.Take_screenshot(driver, "login6");
        
        driver.findElement(By.xpath("//input[@name='email']")).sendKeys("poonam");
        
        Take_Screesnshot.Take_screenshot(driver, "login7");
        
        try
       {
        driver.findElement(By.xpath("//input[@name='pas']")).sendKeys("poonam12345");
        
        Take_Screesnshot.Take_screenshot(driver, "login_page3");
       }
        
        
       catch(Exception e)
       {
      	System.out.println("exception handled="+e);
      	
       }
      
      Take_Screesnshot.Take_screenshot(driver, "login8");

}

}
	
