package appiumScripts;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;

public class PerformanceDataTest {

	public static void main(String[] args) throws MalformedURLException, InterruptedException {
		// TODO Auto-generated method stub

DesiredCapabilities cap = new DesiredCapabilities();
		
		cap.setCapability("deviceName", "443418ec");
		cap.setCapability("platformName", "ANDROID");
		cap.setCapability("platformVersion", "8.1.0");
		cap.setCapability("appPackage", "com.google.android.apps.maps");
		cap.setCapability("appActivity", "com.google.android.maps.MapsActivity");
		
		//Server Details ==> AndroidDriver(URL of server:port)
		
	AndroidDriver<MobileElement> driver= new AndroidDriver<MobileElement>(new URL("http://127.0.0.1:4733/wd/hub"),cap);
	TouchAction ta = new TouchAction(driver);
	
	Thread.sleep(2000);
	
	ta.tap(PointOption.point(618, 801)).perform();
	

	
	// gesture2 : long press on a coordinate
	// longpress(Pointoption.point(x,y)) , wait(seconds) , release , perform -- direction tab will open
	
	ta.longPress(PointOption.point(466,726))
	.waitAction(WaitOptions.waitOptions(Duration.ofSeconds(3))).release().perform();
	
	//[cpuinfo, memoryinfo, batteryinfo, networkinfo]
List<String>	pl=driver.getSupportedPerformanceDataTypes();

   System.out.println(pl);
   
  System.out.println( driver.getPerformanceData("com.google.android.apps.maps", "networkinfo", 5));
	
		
	}

}
