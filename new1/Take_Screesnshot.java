package Exception_in_selenium;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;



public class Take_Screesnshot {
	
	public static void Take_screenshot(WebDriver driver, String name) throws IOException 
	{
		String E=Take_Screesnshot.date();
		File source = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		
	
		File destination  = new File ("D:\\New folder\\"+name+""+E+".jpg");
		
		//FileHandler.copy(source, destination);
		FileHandler.copy(source, destination);
				
	}
	public static String date()
	{
	DateTimeFormatter df= DateTimeFormatter.ofPattern("yyyy_mm_dd hh mm ss");//formatt
	LocalDateTime now = LocalDateTime.now();//currunt date and time
	String d = df.format(now);
	return d;
}


}
