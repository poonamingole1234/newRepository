package POM;

import java.io.IOException;
import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Utility.Screenshot;

public class Zerodha_login {
	
	WebDriver driver;
	@FindBy(xpath="//input[@id='userid']") private WebElement username;
	@FindBy(xpath="//input[@id='password']") private WebElement password;
	@FindBy(xpath="//button[@type='submit']") private WebElement submit;
	@FindBy(xpath="//input[@id='pin']")  private WebElement pin;
	@FindBy(xpath="//button[@type='submit']") private WebElement continues;
	@FindBy(xpath="//a[text()='Forgot user ID or password?']")private WebElement forgottpassword;
	@FindBy(xpath="//a[text()=\"Don't have an account? Signup now!\"]")private WebElement Singuplink;
	
	public Zerodha_login(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}
	
	public void enterusername(String name)
    {
		username.sendKeys(name);
	}
	
	public void enterpassword(String pass)
	{
		password.sendKeys(pass);
	}
	public void clickonsubmit()
	{
		submit.click();
	}
	public void pinenter(String pins)
	{
		pin.sendKeys(pins);
	}
	public void clickoncontinue()
	{
		continues.click();
	}
	public void forgott()
	{
		forgottpassword.click();
	}
	public void singup() throws InterruptedException 
	{
		
		Singuplink.click();
	    ArrayList<String> list = new ArrayList<String>(driver.getWindowHandles());
	    System.out.println(list.get(1));
		driver.switchTo().window(list.get(1));
		
}
}
