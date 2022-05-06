package POM;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Buy_indraday_share {
	WebDriver driver;
	
	@FindBy(xpath="//label[@class='su-radio-label']") private List<WebElement> tabs;
	@FindBy(xpath="//input[@label='Qty.']") private WebElement quantity;
	@FindBy(xpath="//button[@type='submit']") private WebElement Buybutton;
	@FindBy(xpath="//label[text()='Intraday ']")private WebElement intraday;
	@FindBy(xpath="//label[text()='Longterm ']")private WebElement longterm;
	@FindBy(xpath="//label[text()='BSE: ']")private WebElement bse;
	@FindBy(xpath="//label[text()='NSE: ']")private WebElement nse;
	
	
	public Buy_indraday_share(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	public void nscbse(String name)
	{
		String BSE="bse";
		if(BSE.equals(name))	
		{
			bse.click();
		}
		else
		{
		nse.click();
		}
	}	
	public void tabclick(String name)
	{
		for(int i=0; i<tabs.size();i++)
		{
			if(tabs.get(i).getText().equalsIgnoreCase(name))
			{
				tabs.get(i).click();
				System.out.println("click");
			}
		}
	}
	
	public void intlong(String name)
	{
	String intra="intraday";
	if(intra.equals(name))	
	{
	intraday.click();
	}
	else
	{
	longterm.click();
	}
	}
	public void qunt(String name)
	{
		quantity.sendKeys(name);
	}
	public void mrklim(String name)
	{
		for(int i=0; i<tabs.size();i++)
		{
			if(tabs.get(i).getText().equalsIgnoreCase(name))
			{
				tabs.get(i).click();
				System.out.println("click");
			}
		}
	}
	public void slms(String name)
	{
		for(int i=0; i<tabs.size();i++)
		{
			if(tabs.get(i).getText().equalsIgnoreCase(name))
			{
				tabs.get(i).click();
				System.out.println("click");
			}
		}
	}
	public void submit()
	{
		Buybutton.click();
	}

	}
	


