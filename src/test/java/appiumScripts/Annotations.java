package appiumScripts;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class Annotations {
	
	AndroidDriver driver;
	
	// adding new comment here for git
	// pre-requisites
	// we want to exeucte few steps before my test execution begins only one time
	
	@BeforeClass
	public void setup() throws MalformedURLException
	{
		DesiredCapabilities	cap= new DesiredCapabilities();
		
	    cap.setCapability("deviceName", "March20121");
		cap.setCapability("platformName", "Android");
		cap.setCapability("platformVersion", "6.0");
		cap.setCapability("appPackage", "com.hostelworld.app");
		cap.setCapability("appActivity", "com.hostelworld.app.feature.common.view.BottomNavBaseActivity");
			
		// we need to provide the path of Server to the script
		// http://127.0.0.1:4723/wd/hub
		
		driver= new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"),cap);
		
	}
	
	
	@Test(priority='1')  // the below method is a test method and it is executing a functionality
	public void hostelworldTest() throws InterruptedException
	{
      driver.findElementByXPath("//*[@resource-id='com.hostelworld.app:id/searchBoxDestinationTv']").click();
		
		Thread.sleep(3000);
		
		driver.findElementByXPath("//*[@resource-id='com.hostelworld.app:id/suggestionEt']").sendKeys("New York");
		
		Thread.sleep(7000);
		
	List<MobileElement> results	=driver.findElementsByXPath("//*[@class='androidx.recyclerview.widget.RecyclerView']/descendant::*");
		
		
	// compare text - London, England among the list of values	
	// if the text matches , click on it
		for(MobileElement temp: results)
		{
			System.out.println(temp.getText());
			if(temp.getText().contains("New York"))
			{
				temp.click();
				break;
			}
		}
		
	Thread.sleep(3000);	
	
	Reporter.log("completed test method1",true);
	
	}
	
	@Test(priority='2')
	public void destinationTest()
	{
	
		SoftAssert softassert = new SoftAssert();
	String dest=driver.findElementById("com.hostelworld.app:id/searchBoxDestinationTv").getAttribute("text");
		
	System.out.println("The destiantion selected is: "+ dest)	;
	//Hard Assertion
	//Assert.assertEquals(dest,"New York, England","text didnot match");
		
	// SoftAssert
	
	softassert.assertEquals(dest,"New York, England","text didnot match");
	
	driver.findElementById("com.hostelworld.app:id/searchButton").click();
			
	Reporter.log("completed test method2",true);		
	
	softassert.assertAll();
	}

}
