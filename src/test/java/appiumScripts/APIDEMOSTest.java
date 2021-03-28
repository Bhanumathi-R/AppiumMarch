package appiumScripts;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class APIDEMOSTest {

	public static void main(String[] args) throws MalformedURLException, InterruptedException {
		// TODO Auto-generated method stub
		DesiredCapabilities cap = new DesiredCapabilities();
		
		cap.setCapability("deviceName", "March20121");
		cap.setCapability("platformName", "ANDROID");
		cap.setCapability("platformVersion", "6.0");
		cap.setCapability("appPackage", "com.example.android.apis");
		cap.setCapability("appActivity", "com.example.android.apis.ApiDemos");
		
		//Server Details ==> AndroidDriver(URL of server:port)
		
		AndroidDriver<MobileElement> driver= new AndroidDriver<MobileElement>(new URL("http://127.0.0.1:4723/wd/hub"),cap);
	
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		
		// testStep1 : Click on preference menu
		
		// findtheelement(locator).action();
		
     driver.findElementByXPath("//android.widget.TextView[@text='Preference']").click();
     
     Thread.sleep(2000);
     
     // Test step2 : Click on Advance preference
     
     driver.findElementByXPath("//*[@text='3. Preference dependencies']").click();
     
     Thread.sleep(2000);
		
     // TestStep 3
     
     //driver.findElementById("android:id/checkbox").click();
     //OR
     
     driver.findElementByXPath("//*[@resource-id='android:id/checkbox']").click();
     
     Thread.sleep(2000);
     
     //Test Step 4:
     
     driver.findElementByXPath("//*[@text='WiFi settings']").click();
     
     Thread.sleep(2000);
     driver.findElementById("android:id/edit").sendKeys("sonal");
     Thread.sleep(2000);
     
     driver.findElementById("android:id/button1").click();
     
     
     
     
     
     
     
     
     
     
     
     
     
     
     
		
		
		
		
		
		
		
		
		
		
		
		
		
			
	}

}
