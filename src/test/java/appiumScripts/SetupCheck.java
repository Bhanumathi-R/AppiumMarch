package appiumScripts;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class SetupCheck {

	public static void main(String[] args) throws MalformedURLException {
		// TODO Auto-generated method stub
		
		
// Desired Capabilities -- Key = value
	
	// APpium Class==>	DesiredCapabilities ==> setcapability(key, value)
		
	// We will create an Object	

	DesiredCapabilities cap = new DesiredCapabilities();
	
	cap.setCapability("deviceName", "March20121");
	cap.setCapability("platformName", "ANDROID");
	cap.setCapability("platformVersion", "6.0");
	cap.setCapability("appPackage", "com.example.android.apis");
	cap.setCapability("appActivity", "com.example.android.apis.ApiDemos");
	
	//Server Details ==> AndroidDriver(URL of server:port)
	
	AndroidDriver<MobileElement> driver= new AndroidDriver<MobileElement>(new URL("http://127.0.0.1:4723/wd/hub"),cap);
		
		
		
		
		
	
	
	
	
	
	
	
	
	
	
	
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		

	}

}
