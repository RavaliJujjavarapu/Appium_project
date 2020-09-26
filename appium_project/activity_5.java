package appium_project;

import org.testng.annotations.Test;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import org.testng.annotations.BeforeClass;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.AfterClass;

public class activity_5 {
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
	public void google_login() throws InterruptedException {	
		  
		  driver.get("https://www.training-support.net/selenium");
		  driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		  driver.findElement(MobileBy.AndroidUIAutomator("UiScrollable(UiSelector().scrollable(true)).scrollIntoView(textStartsWith(\"Login Form\"))"));
		  driver.findElement(MobileBy.xpath("//android.widget.TextView[@text='Login Form']")).click();
		  Thread.sleep(2000);
		  driver.findElement(MobileBy.AndroidUIAutomator("resourceId(\"username\")")).sendKeys("admin");
		  driver.findElement(MobileBy.AndroidUIAutomator("resourceId(\"password\")")).sendKeys("password");
		  driver.findElement(MobileBy.AndroidUIAutomator("text(\"Log in\")")).click();

		  	  
		  String confirm = driver.findElement(MobileBy.AndroidUIAutomator("resourceId(\"action-confirmation\")")).getText();
		  System.out.println("confirm");
		  Assert.assertEquals(confirm, "Welcome Back, admin");
	
		 //Test case 2
		  driver.findElement(MobileBy.AndroidUIAutomator("resourceId(\"username\")")).clear();
		  driver.findElement(MobileBy.AndroidUIAutomator("resourceId(\"username\")")).sendKeys("admin");
		  driver.findElement(MobileBy.AndroidUIAutomator("resourceId(\"password\")")).clear();
		  driver.findElement(MobileBy.AndroidUIAutomator("resourceId(\"password\")")).sendKeys("password123");
		  driver.findElement(MobileBy.AndroidUIAutomator("text(\"Log in\")")).click();
		  
		  String invalid = driver.findElement(MobileBy.AndroidUIAutomator("resourceId(\"action-confirmation\")")).getText();
		  System.out.println("invalid");
		  Assert.assertEquals(invalid, "Invalid Credentials");
	  
		  	    
						  
		  
  }

  @AfterClass
  public void afterClass() {
  }

}
