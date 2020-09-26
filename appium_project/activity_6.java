package appium_project;

import org.testng.annotations.Test;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import org.testng.annotations.BeforeClass;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.AfterClass;

public class activity_6 {
	AppiumDriver<MobileElement> driver = null;
      
		  
	  @BeforeClass
	  public void beforeClass() throws MalformedURLException, InterruptedException  {
		DesiredCapabilities task = new DesiredCapabilities();
		task.setCapability("deviceId", "5554");
		task.setCapability("platformName", "android");
		task.setCapability("automationName", "UiAutomator2");
		task.setCapability("appPackage", "com.android.chrome");
		task.setCapability("appActivity", "com.google.android.apps.chrome.Main");
		task.setCapability("noReset", true);
		
		//instance Appium
		URL server = new URL("http://0.0.0.0:4723/wd/hub");
		driver = new AppiumDriver<MobileElement> (server,task);
		
  }
	  
	  @Test
	public void google_popup() throws InterruptedException {	
		  
		  driver.get("https://www.training-support.net/selenium");
		  Thread.sleep(10000);
		  driver.findElement(MobileBy.AndroidUIAutomator("UiScrollable(UiSelector().scrollable(true)).scrollIntoView(textStartsWith(\"Popups\"))"));
		  driver.findElement(MobileBy.xpath("//android.widget.TextView[@text='Popups']")).click();
		  driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		  driver.findElement(MobileBy.AndroidUIAutomator("text(\"Sign In\")")).click();
		 //driver.findElement(MobileBy.xpath("//android.widget.Button[@text='Sign In']")).click();
		  //driver.findElement(MobileBy.AndroidUIAutomator("text(\"Sign In\")")).click();	
		  Thread.sleep(2000);
		  driver.findElement(MobileBy.AndroidUIAutomator("resourceId(\"username\")")).sendKeys("admin");
		  driver.findElement(MobileBy.AndroidUIAutomator("resourceId(\"password\")")).sendKeys("password");
		  driver.findElement(MobileBy.AndroidUIAutomator("text(\"Log in\")")).click();
		  
		  String success = driver.findElement(MobileBy.AndroidUIAutomator("resourceId(\"action-confirmation\")")).getText();
		  System.out.println("success");
		  Assert.assertEquals(success, "Welcome Back, admin");
		  
		  //Test Case -2 
		  driver.findElement(MobileBy.AndroidUIAutomator("text(\"Sign In\")")).click();
		  driver.findElement(MobileBy.AndroidUIAutomator("resourceId(\"username\")")).clear();
		  driver.findElement(MobileBy.AndroidUIAutomator("resourceId(\"username\")")).sendKeys("admin");
		  driver.findElement(MobileBy.AndroidUIAutomator("resourceId(\"password\")")).clear();
		  driver.findElement(MobileBy.AndroidUIAutomator("resourceId(\"password\")")).sendKeys("password123");
		  driver.findElement(MobileBy.AndroidUIAutomator("text(\"Log in\")")).click();
		  
		  String failure = driver.findElement(MobileBy.AndroidUIAutomator("resourceId(\"action-confirmation\")")).getText();
		  System.out.println("failure");
		  Assert.assertEquals(failure, "Invalid Credentials");
						  
		  
  }

  @AfterClass
  public void afterClass() {
  }

}
