package POM;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage {
@FindBy(xpath="//div[@id='avatar-83']") private WebElement avatar;
@FindBy(xpath="//input[@icon='search']")private WebElement searchbox;
@FindBy(xpath="//ul[@class='omnisearch-results']//div//li[1]")private WebElement firstStock;
@FindBy(xpath="//button[@data-balloon='Buy']")private WebElement buy;




	public HomePage(WebDriver driver){
		PageFactory.initElements(driver, this);
	}
	
	public boolean avatarIsDisplayed(WebDriver driver)
	{	
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofMillis(2000));
		wait.until(ExpectedConditions.visibilityOf(avatar));
		return avatar.isDisplayed();
	}
	
	public void searchStock(String stockName) {
		searchbox.sendKeys(stockName);
	}
	
	public void selectFirstStock(WebDriver driver) {
		WebDriverWait wait =new WebDriverWait(driver,Duration.ofMillis(3000));
		wait.until(ExpectedConditions.visibilityOf(firstStock));
		Actions action = new Actions(driver);
		action.moveToElement(firstStock);
		action.perform();
	}

	public void clickOnBuy() {
		buy.click();
	}

}
