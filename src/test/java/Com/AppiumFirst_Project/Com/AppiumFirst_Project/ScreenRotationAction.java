package Com.AppiumFirst_Project.Com.AppiumFirst_Project;

import org.openqa.selenium.By;
import org.openqa.selenium.DeviceRotation;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.Activity;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;

public class ScreenRotationAction extends BAse 
{
	@Test
	public void miscellniousAction()
	{
		Activity act= new Activity(null, null);
		
		driver.findElement(AppiumBy.accessibilityId("Preference")).click();
		driver.findElement(AppiumBy.xpath("//android.widget.TextView[@content-desc='3. Preference dependencies']")).click();
		driver.findElement(AppiumBy.id("android:id/checkbox")).click();
		DeviceRotation landScape=new DeviceRotation(0,0,90);
		driver.rotate(landScape);	
		driver.findElement(By.xpath("(//andriod.widget.RelativeLayout)[2]")).click();
		String alertTitle= driver.findElement(By.id("android:id/alertTitle")).getText();
		Assert.assertEquals(alertTitle, "WiFi settings");
		driver.findElement(By.id("android:id/edit")).sendKeys("Rohit WiFi");
		
		//*****Copy Paste Action on Mobile Application
		driver.setClipboardText("Rohit Wifi");
		driver.findElement(By.id("android:id/edit")).sendKeys(driver.getClipboardText());
		
		//******keyboard Events -- back Button , and homeButton etc...
		driver.pressKey(new KeyEvent(AndroidKey.ENTER));
		driver.findElement(AppiumBy.className("android.widget.Button")).click();
		driver.pressKey(new KeyEvent(AndroidKey.HOME));
		driver.pressKey(new KeyEvent(AndroidKey.BACK));
	}
	

}
