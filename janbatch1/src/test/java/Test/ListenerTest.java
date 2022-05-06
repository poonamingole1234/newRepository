      package Test;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestListener;
import org.testng.ITestResult;

import Utilities.ScreenShot;

public class ListenerTest extends BaseTest implements ITestListener {
	//public static WebDriver driver;//property of parent BaseTest
	
	public void onTestStart(ITestResult Result) {//this will run at the start of every test
		System.out.println("Test has started"+Result.getName());
	}
	
	
	public void onTestSuccess(ITestResult Result) {//Will execute when test passes
		System.out.println(Result.getName()+ " Test is passed");
	}
	
	
	public void onTestFailure(ITestResult Result) {//will execute when test fails
		try {
			ScreenShot.takeScreenshot(driver, Result.getName() );
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void onTestSkipped(ITestResult Result ) {//will execute whne test skipped
		System.out.println(Result.getName() +" Test skipped");
	}
}
