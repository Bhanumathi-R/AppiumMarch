package parallelTesting;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;

public class SwipeTest {

	@Parameters({"deviceName","Version","URL"})
	@Test
	public void setup(String deviceName, String Version, String url) throws InterruptedException, MalformedURLException
	{
		
DesiredCapabilities	cap= new DesiredCapabilities();
		
	    cap.setCapability("deviceName", deviceName);
		cap.setCapability("platformName", "Android");
		cap.setCapability("platformVersion", Version);
		cap.setCapability("appPackage", "com.google.android.apps.maps");
		cap.setCapability("appActivity", "com.google.android.maps.MapsActivity");
			
		// we need to provide the path of Server to the script
		// http://127.0.0.1:4723/wd/hub
		
		AndroidDriver<MobileElement> driver= new AndroidDriver<MobileElement>(new URL(url),cap);
		
// tap at a location -->TouchAction--> tap
		
		//press(point) + wait + moveto(point)
		
		TouchAction t= new TouchAction(driver);
		
	t.tap(PointOption.point(309,879)).perform();
	
	t.press(PointOption.point(368,924))
	.waitAction(WaitOptions.waitOptions(Duration.ofSeconds(3)))
	.moveTo(PointOption.point(790, 1233)).release().perform();
	

	}

}
