package Exception_in_selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Element_not_selectable_Exception {

	public static void main(String[] args) {

		 WebDriver driver = Browser_openn.open_chrome_browser("https://www.facebook.com/");
			
		 WebElement selenium = driver.findElement(By.xpath("//a[text()=\"Velocity Corporate Training Center\"]"));
		 selenium.click();
		 selenium.isSelected();
		 

	}

}
