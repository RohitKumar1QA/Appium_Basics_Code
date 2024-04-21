package Com.AppiumFirst_Project.Com.AppiumFirst_Project;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;

public class Swipe_Demo extends BAse {


	@Test
	public void SwipeFunc()
	{
		System.out.println("*******Swipe Functionality***********");

		driver.findElement(AppiumBy.accessibilityId("Views")).click();
		driver.findElement(AppiumBy.xpath(" //android.widget.TextView[@content-desc=\"Gallery\"]")).click();
		driver.findElement(AppiumBy.id("1. Photos")).click();
		WebElement firstImage =driver.findElement(By.xpath("(//android.widget.ImageView)[1]"));
		Assert.assertEquals(driver.findElement(By.xpath("(//android.widget.ImageView)[1]")).getAttribute("focusable"),"true");
		//Swipe
		swipeAction(firstImage, "left");		  
		Assert.assertEquals(driver.findElement(By.xpath("(//android.widget.ImageView)[1]")).getAttribute("focusable"),"false");

	}

}
