package appium_project;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;

    @Test
    public class activity_3 {
	AppiumDriver<MobileElement> driver = null;
    
	  
	  @BeforeClass
	  public void beforeClass() throws MalformedURLException  {
		DesiredCapabilities task = new DesiredCapabilities();
		task.setCapability("deviceId", "5554");
		task.setCapability("platformName", "android");
		task.setCapability("automationName", "UiAutomator2");
		task.setCapability("appPackage", "com.google.android.keep");
		task.setCapability("appActivity", "com.google.android.keep.activities.BrowseActivity");
		task.setCapability("noReset", true);	  
		
		URL server = new URL("http://0.0.0.0:4723/wd/hub");
		driver = new AppiumDriver<MobileElement> (server,task);
  }

  public void google_keep_reminder() {
	  
	  driver.findElementById("com.google.android.keep:id/new_note_button").click();
	  driver.findElementById("com.google.android.keep:id/editable_title").sendKeys("Android_title");
	  driver.findElementById("com.google.android.keep:id/edit_note_text").sendKeys("note1");
	  driver.findElementById("com.google.android.keep:id/menu_reminder").click();
	  driver.findElementById("com.google.android.keep:id/save").click();
	  
	  driver.findElementByAccessibilityId("Open navigation drawer").click();
	  
	  boolean reminder_check = driver.findElementById("reminder_chip_text").isDisplayed();
	  if(reminder_check==true) {
		  Assert.assertEquals(reminder_check, true);
	  }
	  else {
		Assert.assertEquals(reminder_check, false);
	}
		  
	
	  }
  
  
  @AfterClass
  public void afterClass() {
  }
}

