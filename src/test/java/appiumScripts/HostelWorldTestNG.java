package appiumScripts;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class HostelWorldTestNG {
	
	AndroidDriver<MobileElement> driver;
public static	String dest;

	@BeforeClass
	public void Setup() throws MalformedURLException
	{
DesiredCapabilities cap = new DesiredCapabilities();
		
		cap.setCapability("deviceName", "March20121");
		cap.setCapability("platformName", "ANDROID");
		cap.setCapability("platformVersion", "6.0");
		cap.setCapability("appPackage", "com.hostelworld.app");
		cap.setCapability("appActivity", "com.hostelworld.app.feature.common.view.BottomNavBaseActivity");
		
		//Server Details ==> AndroidDriver(URL of server:port)
		
		 driver= new AndroidDriver<MobileElement>(new URL("http://127.0.0.1:4724/wd/hub"),cap);
					
	}
	
	@Test(priority='1')
	public void SearchdestTest() throws InterruptedException
	{
		driver.findElementByXPath("//*[@resource-id='com.hostelworld.app:id/searchBoxDestinationTv']").click();
		
		Thread.sleep(3000);
			
		driver.findElementByXPath("//*[@resource-id='com.hostelworld.app:id/suggestionEt']").sendKeys("London");
		
		
	List<MobileElement> result	=driver.findElementsByXPath("//*[@class='androidx.recyclerview.widget.RecyclerView']//child::*");
		
		// start a loop on results list items and match a string with each item, click on it if item matches

	Thread.sleep(7000);
	for(MobileElement temp: result)
	{
		
		if(temp.getText().contains("London"))
		{
			System.out.println(temp.getText());
			temp.click();
			break;
		}
	}
		
	Thread.sleep(2000);

	}
	
	@Test(priority='2')
	public void destinationCheck() throws InterruptedException
	{
		Thread.sleep(3000);
dest = driver.findElementByXPath("//*[@resource-id='com.hostelworld.app:id/searchBoxDestinationTv']").getAttribute("text");
		
System.out.println(dest);

	}
	
	@Test(priority='3')
	public void ValidateDest()
	{
		// Hard Assertions
		
		Assert.assertEquals(dest, "London, England","text didnot match");
	}
	
	@Test(priority='4')
	public void serchbuttonClick()
	{
		driver.findElementByXPath("//*[@resource-id='com.hostelworld.app:id/searchButton']").click();
	}
	
	
	
	
	
	
	
	
	

}
