package POM;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Zerodha_buy_share {
	
	@FindBy(xpath="//input[@icon='search']") private WebElement search;
	@FindBy(xpath="(//span[@class='tradingsymbol'])[1]") private WebElement shareclick;
	//@FindBy(xpath=("//span[@class='symbol']//span//span") private List<WebElement> sharelist;
	@FindBy(xpath="//div//div//div//span[@class='nice-name']") private List<WebElement> sharelist;
	@FindBy(xpath="//button[@class='button-blue buy']") private WebElement Buy;
	
	public Zerodha_buy_share(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	public void serachshare(String sharename)
	{
		search.sendKeys(sharename);
	}
	
	public void clickonshare()
	{
		shareclick.click();
	}
	public void buyshare(WebDriver driver,String name) throws InterruptedException
	{
//		Thread.sleep(3000);
//		for(int i=0 ;i<sharelist.size();i++)
//		{
//			
//			if(sharelist.get(i).getText().equalsIgnoreCase(name))
//			{
//				//Thread.sleep(3000);
//				sharelist.get(i).click();
//			    Thread.sleep(3000);
//				WebElement clickon=driver.findElement(By.xpath("//button[@class='button-blue buy']"));
//				clickon.click();
//				
//			}
//		}
		for(int i=0;i<sharelist.size();i++)
		{
			if(sharelist.get(i).getText().equalsIgnoreCase(name))
			{
				Thread.sleep(3000);
				sharelist.get(i).click();
				break;
				
				
			}
		}
		Actions act = new Actions(driver);
		act.moveToElement(Buy);
		act.click();
		act.perform();
		act.build();
		
		
	}

}
