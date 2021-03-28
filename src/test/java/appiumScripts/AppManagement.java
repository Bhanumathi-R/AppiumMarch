package appiumScripts;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class AppManagement {

	public static void main(String[] args) throws MalformedURLException {
		// TODO Auto-generated method stub
		
DesiredCapabilities cap = new DesiredCapabilities();
		
		cap.setCapability("deviceName", "March20121");
		cap.setCapability("platformName", "ANDROID");
		cap.setCapability("platformVersion", "6.0");
		cap.setCapability("appPackage", "com.hostelworld.app");
		cap.setCapability("appActivity", "com.hostelworld.app.feature.common.view.BottomNavBaseActivity");
		AndroidDriver<MobileElement> driver= new AndroidDriver<MobileElement>(new URL("http://127.0.0.1:4723/wd/hub"),cap);

		driver.runAppInBackground(Duration.ofSeconds(4));
		
		//driver.removeApp("com.hostelworld.app-8.11.0-free-www.apksum.com");
		
		driver.installApp("C:\\Appium\\General-Store.apk");


		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

}
