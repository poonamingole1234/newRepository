package Exception_in_selenium;

import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchFrameException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class StaleElementReferenceException_ {

	public static void main(String[] args) {
		
		 WebDriver driver = Browser_openn.open_chrome_browser("http://demo.automationtesting.in/Frames.html");
		 
		 driver.findElement(By.xpath("//a[@href='#Single']")).click();
			
			WebElement single=driver.findElement(By.xpath("//iframe[@id='singleframe']"));
			
			driver.switchTo().frame(0);
			try
			{
			//driver.switchTo().frame(single);
			driver.switchTo().frame("singleframe");
			}
			catch(StaleElementReferenceException e)
			{
				System.out.println(e);
			}
			catch(NoSuchFrameException d)
			{
				System.out.println(d);
			}
			
			driver.findElement(By.xpath("//input[@type='text']")).sendKeys("poonam");
	}

}
