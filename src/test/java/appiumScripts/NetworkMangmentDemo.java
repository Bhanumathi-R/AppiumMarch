package appiumScripts;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.ScreenOrientation;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class NetworkMangmentDemo {

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
	

   driver.openNotifications();
	
	//driver.findElementById("android:id/text").click();
	
   
   driver.lockDevice();
   
   Thread.sleep(2000);
   
   driver.unlockDevice();
	
	
   driver.rotate(ScreenOrientation.LANDSCAPE);
	
   Thread.sleep(2000);
	
   driver.rotate(ScreenOrientation.PORTRAIT);
	
		
	}

}
