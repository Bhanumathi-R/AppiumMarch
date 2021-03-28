package appiumScripts;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AnnotationsTestNGDemo {
	

	
@BeforeClass
public void loginTest()   // This method gets executed as the first method of the class and only once
{
	System.out.println("Code for login to the application");
}
	
@Test(priority='2')   // Test Methods
public void locationTest()
{
	System.out.println("Code for searching a location");

}
@Test(priority='3')   // Test method
public void orderTest()
{
	System.out.println("Code for place an order for that location");
}

@AfterClass    // post-req method, get executed only once at the end
public void LogoutTest()
{
	System.out.println("Code for logout of the application");
}


}
