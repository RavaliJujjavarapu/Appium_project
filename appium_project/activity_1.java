package appium_project;

import org.testng.annotations.Test;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.testng.annotations.BeforeClass;
import static org.testng.Assert.assertEquals;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.AfterClass;

public class activity_1 {
	AppiumDriver<MobileElement> driver = null;
      
		  
	  @BeforeClass
	  public void beforeClass() throws MalformedURLException, InterruptedException  {
		DesiredCapabilities task = new DesiredCapabilities();
		task.setCapability("deviceId", "5554");
		task.setCapability("platformName", "android");
		task.setCapability("automationName", "UiAutomator2");
		task.setCapability("appPackage", "com.google.android.apps.tasks");
		task.setCapability("appActivity", "com.google.android.apps.tasks.ui.TaskListsActivity");
		task.setCapability("noReset", true);
		
		//instance Appium
		URL server = new URL("http://0.0.0.0:4723/wd/hub");
		driver = new AppiumDriver<MobileElement> (server,task);
		
  }
	  
	  @Test
	public void google_task() throws InterruptedException {	
		  
		  Thread.sleep(5000);	  
		  driver.findElementById("com.google.android.apps.tasks:id/tasks_fab").click();
		  Thread.sleep(2000);
		  driver.findElementById("com.google.android.apps.tasks:id/add_task_title").sendKeys("Complete Activity with Google Tasks");
		  driver.findElementById("com.google.android.apps.tasks:id/add_task_done").click();
		  driver.findElementById("com.google.android.apps.tasks:id/tasks_fab").click();
		  Thread.sleep(2000);
		  driver.findElementById("com.google.android.apps.tasks:id/add_task_title").sendKeys("Complete Activity with Google Keep");
		  driver.findElementById("com.google.android.apps.tasks:id/add_task_done").click();  
		  driver.findElementById("com.google.android.apps.tasks:id/tasks_fab").click();
		  Thread.sleep(2000);
		  driver.findElementById("com.google.android.apps.tasks:id/add_task_title").sendKeys("Complete the second Activity Google Keep");
		  driver.findElementById("com.google.android.apps.tasks:id/add_task_done").click();
		  Thread.sleep(2000);
		  
		  List<MobileElement> rows = driver.findElementsById("task_name");
		  int row_num = rows.size();
		  int act_num = 3;
		  Assert.assertEquals(act_num, row_num);
				  
				
  }

  @AfterClass
  public void afterClass() {
  }

}
