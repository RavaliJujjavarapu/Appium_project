package appium_project;

import java.awt.Dimension;
import java.awt.List;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;

    @Test
    public class activity_4 {
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
		
		URL server = new URL("http://0.0.0.0:4723/wd/hub");
		driver = new AppiumDriver<MobileElement> (server,task);
		Thread.sleep(2000);
  }

  public void google_todolist() throws InterruptedException {
	  
	  
		driver.get("https://www.training-support.net/selenium");
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.findElement(MobileBy.AndroidUIAutomator("UiScrollable(UiSelector().scrollable(true)).scrollIntoView(textStartsWith(\"To-Do List\"))"));
		driver.findElement(MobileBy.xpath("//android.widget.TextView[@text='To-Do List']")).click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	  
		driver.findElement(MobileBy.AndroidUIAutomator("resourceId(\"taskInput\")")).sendKeys("Add tasks to list");
		driver.findElement(MobileBy.AndroidUIAutomator("text(\"Add Task\")")).click();
		driver.findElement(MobileBy.AndroidUIAutomator("resourceId(\"taskInput\")")).sendKeys("Get number of tasks");
		driver.findElement(MobileBy.AndroidUIAutomator("text(\"Add Task\")")).click();
		driver.findElement(MobileBy.AndroidUIAutomator("resourceId(\"taskInput\")")).sendKeys("Clear the list");
		driver.findElement(MobileBy.AndroidUIAutomator("text(\"Add Task\")")).click();
		driver.findElement(MobileBy.AndroidUIAutomator("text(\"Add tasks to list\")")).click();
		driver.findElement(MobileBy.AndroidUIAutomator("text(\"Get number of tasks\")")).click();
		driver.findElement(MobileBy.AndroidUIAutomator("text(\"Clear the list\")")).click();
	
		//driver.findElement(MobileBy.xpath("android.widget.TextView[@text='Clear List']")).click();
		//driver.findElement(MobileBy.AndroidUIAutomator("text(\"Clear List\")")).click();
		
	    //driver.findElementByXPath("//android.widget.TextView[@text ='Clear List']").click();
		System.out.println("Clear List");
	    
	    
	}
	 
	 
	  
  
  
  @AfterClass
  public void afterClass() {
  }
}