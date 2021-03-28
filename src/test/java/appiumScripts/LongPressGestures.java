package appiumScripts;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import io.appium.java_client.service.local.flags.GeneralServerFlag;
import io.appium.java_client.touch.TapOptions;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.ElementOption;
import io.appium.java_client.touch.offset.PointOption;

public class LongPressGestures {

	public static void main(String[] args) throws MalformedURLException, InterruptedException {
		// TODO Auto-generated method stub

AppiumDriverLocalService service = AppiumDriverLocalService.buildService(new AppiumServiceBuilder().usingDriverExecutable(new File("C:\\Program Files (x86)\\nodejs\\node.exe")).
withAppiumJS(new File("C:\\Users\\vishal mittal\\AppData\\Local\\Programs\\Appium\\resources\\app\\node_modules\\appium\\build\\lib\\main.js")).withLogFile(new File(System.getProperty("user.dir")+"\\src\\test\\resources\\logs\\log.txt")).withArgument(GeneralServerFlag.LOCAL_TIMEZONE));

service.start();
		DesiredCapabilities cap = new DesiredCapabilities();
		
		cap.setCapability("deviceName", "443418ec");
		cap.setCapability("platformName", "ANDROID");
		cap.setCapability("platformVersion", "8.1.0");
		cap.setCapability("appPackage", "com.google.android.apps.maps");
		cap.setCapability("appActivity", "com.google.android.maps.MapsActivity");
		
		//Server Details ==> AndroidDriver(URL of server:port)
		
		AndroidDriver<MobileElement> driver= new AndroidDriver<MobileElement>(new URL("http://127.0.0.1:4723/wd/hub"),cap);
		
		// Gesture: tap at a point
		
		
		TouchAction ta = new TouchAction(driver);
		
		Thread.sleep(2000);
		
		ta.tap(PointOption.point(618, 801)).perform();
		
		Thread.sleep(2000);
		
		// gesture2 : long press on a coordinate
		// longpress(Pointoption.point(x,y)) , wait(seconds) , release , perform -- direction tab will open
		
		ta.longPress(PointOption.point(466,726))
		.waitAction(WaitOptions.waitOptions(Duration.ofSeconds(3))).release().perform();
		
		
		Thread.sleep(2000);
		
	MobileElement dir=driver.findElementByXPath("//android.widget.Button[@text='Directions']");
		
	ta.tap(TapOptions.tapOptions().withElement(ElementOption.element(dir))).perform();
		
		
		
		service.stop();
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

}
