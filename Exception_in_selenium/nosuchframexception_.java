package Exception_in_selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchFrameException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;



public class nosuchframexception_ {

	public static void main(String[] args) {

		 WebDriver driver = Browser_openn.open_chrome_browser("http://demo.automationtesting.in/Frames.html");
		
		driver.findElement(By.xpath("//a[@href='#Multiple']")).click();
		
		WebElement mul = driver.findElement(By.xpath("(//iframe[@src='MultipleFrames.html'])[1]"));
		driver.switchTo().frame(mul);
		
		try
		{
		driver.switchTo().frame(1);
		driver.switchTo().frame("Multiple");
		}
		catch(NoSuchFrameException e)
		{
			System.out.println(e);
		}
		finally
		{
			System.out.println("exception handled");
		}
		WebElement single=driver.findElement(By.xpath("//iframe[@src='SingleFrame.html']"));
		driver.switchTo().frame(single);
		//driver.switchTo().frame(0);
		
		driver.findElement(By.xpath("//input[@type='text']")).sendKeys("poonam");
		

	}

}
