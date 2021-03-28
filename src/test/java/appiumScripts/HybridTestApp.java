package appiumScripts;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import io.appium.java_client.service.local.flags.GeneralServerFlag;

public class HybridTestApp {

	public static void main(String[] args) throws MalformedURLException, InterruptedException {
	// TODO Auto-generated method stub
	
		
AppiumDriverLocalService  service =  AppiumDriverLocalService.buildService(new AppiumServiceBuilder()
		.usingDriverExecutable(new File("C:\\Program Files (x86)\\nodejs\\node.exe")).
withAppiumJS(new File("C:\\Users\\vishal mittal\\AppData\\Local\\Programs\\Appium\\resources\\app\\node_modules\\appium\\build\\lib\\main.js")).usingAnyFreePort().withLogFile(new File(System.getProperty("user.dir")+"\\src\\test\\resources\\logs\\log.txt")));
		
		
		
		
DesiredCapabilities cap = new DesiredCapabilities();
		
		cap.setCapability("deviceName", "443418ec");
		cap.setCapability("platformName", "ANDROID");
		cap.setCapability("platformVersion", "8.1.0");
		cap.setCapability("appPackage", "com.android.chrome");
		cap.setCapability("appActivity", "com.google.android.apps.chrome.Main");
		cap.setCapability("chromedriverExecutable", "C:\\chromedriver.exe");
		AndroidDriver<MobileElement> driver= new AndroidDriver<MobileElement>(new URL("http://127.0.0.1:4723/wd/hub"),cap);
			
	driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
	//driver.manage().timeouts().pageLoadTimeout(3, TimeUnit.SECONDS);

		// Inspect element in Native
		
	driver.findElementById("com.android.chrome:id/terms_accept").click();
	Thread.sleep(2000);
	
	driver.findElementById("com.android.chrome:id/next_button").click();
	
	Thread.sleep(2000);
	
	driver.findElementById("com.android.chrome:id/negative_button").click();
	
	
	Thread.sleep(3000);
	
	driver.findElementByXPath("//android.widget.TextView[@text='Wikipedia']").click();
	
	Set<String> cns= driver.getContextHandles();
	
	System.out.println(cns+"\n\n");
	
	driver.context("WEBVIEW_chrome");
	
	Thread.sleep(3000);
	
	driver.findElementByXPath("//button[@type='submit']").click();
	
	
	driver.findElement(By.xpath("/html/body/div[3]/div/div[1]/div/div[1]/form/input")).sendKeys("Appium");
	
	driver.pressKey(new KeyEvent(AndroidKey.ENTER));
	
	Thread.sleep(3000);
	driver.context("NATIVE_APP");
	
	Thread.sleep(3000);
	
	driver.findElementById("com.android.chrome:id/menu_button").click();
	
	driver.findElementByXPath("//android.widget.TextView[@content-desc=\"History\"]").click();
	
	Thread.sleep(3000);
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
		
		
		
		
		
		
		
		
		
		
		
		

	}

}
