package Com.AppiumFirst_Project.Com.AppiumFirst_Project;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.annotations.Test;

import com.google.common.collect.ImmutableMap;

import io.appium.java_client.AppiumBy;

public class Long_press_Gesture extends BAse {
	
	@Test
	public void LongPress_Getures()
	{
		System.out.println("************************Long_Press_Gesture_Perform**********************");
		driver.findElement(AppiumBy.accessibilityId("Views")).click();
		driver.findElement(AppiumBy.xpath("//android.widget.TextView[@content-desc=\"Expandable Lists\"]")).click();
		driver.findElement(AppiumBy.accessibilityId("1. Custom Adapter")).click();

		//Long_Click_Getrues//
		WebElement ele1= driver.findElement(By.xpath("//android.widget.TextView[@text='People Names']"));

		((JavascriptExecutor)driver).executeScript("mobile: longClickGesture",ImmutableMap.of
				("elementId",((RemoteWebElement)ele1).getId(),"duration",2000));
	}


}
