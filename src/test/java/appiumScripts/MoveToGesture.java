package appiumScripts;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.MobileElement;
import io.appium.java_client.MultiTouchAction;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;

public class MoveToGesture {

	public static void main(String[] args) throws MalformedURLException, InterruptedException {
		// TODO Auto-generated method stub

DesiredCapabilities cap = new DesiredCapabilities();
		
		cap.setCapability("deviceName", "443418ec");
		cap.setCapability("platformName", "ANDROID");
		cap.setCapability("platformVersion", "8.1.0");
		cap.setCapability("appPackage", "com.google.android.apps.maps");
		cap.setCapability("appActivity", "com.google.android.maps.MapsActivity");
		
		//Server Details ==> AndroidDriver(URL of server:port)
		
		AndroidDriver<MobileElement> driver= new AndroidDriver<MobileElement>(new URL("http://127.0.0.1:4723/wd/hub"),cap);
			
		
//		SWIPE/SLIDE/SCROLL gestures
		
	
	TouchAction ta = new TouchAction(driver);
	
	ta.tap(PointOption.point(614, 912)).perform();
	
	Thread.sleep(2000);
	
	
	// Action perfomed by my finger 1
	TouchAction ta1= new TouchAction(driver).press(PointOption.point(580, 790))
	.waitAction(WaitOptions.waitOptions(Duration.ofSeconds(3)))
	.moveTo(PointOption.point(845, 350)).release();
	
	// Action performed by finger 2
	
	TouchAction ta2= new TouchAction(driver).press(PointOption.point(410, 1393))
	.waitAction(WaitOptions.waitOptions(Duration.ofSeconds(3)))
	.moveTo(PointOption.point(180, 1480)).release();
		
	
	// Zoom out
	
	// Action perfomed by my finger 1
	TouchAction ta3= new TouchAction(driver).press(PointOption.point(850, 935))
	.waitAction(WaitOptions.waitOptions(Duration.ofSeconds(3)))
	.moveTo(PointOption.point(580, 790)).release();
	
	// Action performed by finger 2
	
	TouchAction ta4= new TouchAction(driver).press(PointOption.point(180, 1140))
	.waitAction(WaitOptions.waitOptions(Duration.ofSeconds(3)))
	.moveTo(PointOption.point(410,1080)).release();
		
	MultiTouchAction ma = new MultiTouchAction(driver);
	
	
	//ma.add(ta1).add(ta2).perform();
	
	Thread.sleep(4000);	
		
		
	ma.add(ta3).add(ta4).perform();
	
		
		
		
		
		
		
		
		
		
		
		
	}

}
