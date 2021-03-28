package parallelTesting;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class HostelWorldTest {

	@Parameters({"deviceName","Version","URL"})
	@Test
	public void setup(String deviceName, String Version, String url) throws InterruptedException, MalformedURLException
	{
		DesiredCapabilities	cap= new DesiredCapabilities();
		
	    cap.setCapability("deviceName", deviceName);
		cap.setCapability("platformName", "Android");
		cap.setCapability("platformVersion", Version);
		cap.setCapability("appPackage", "com.hostelworld.app");
		cap.setCapability("appActivity", "com.hostelworld.app.feature.common.view.BottomNavBaseActivity");
			
		// we need to provide the path of Server to the script
		// http://127.0.0.1:4723/wd/hub
		
		AndroidDriver driver= new AndroidDriver(new URL(url),cap);
		
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
	
	
	String dest=driver.findElementById("com.hostelworld.app:id/searchBoxDestinationTv").getAttribute("text");
		
	System.out.println("The destiantion selected is: "+ dest)	;
		
	driver.findElementById("com.hostelworld.app:id/searchButton").click();
		
		
			

	}

}
