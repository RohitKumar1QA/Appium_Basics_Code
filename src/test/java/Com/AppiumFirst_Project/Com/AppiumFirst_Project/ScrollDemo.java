package Com.AppiumFirst_Project.Com.AppiumFirst_Project;

import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;

public class ScrollDemo extends BAse{
	
	
	@Test
	public void Scroll_Gesture() throws InterruptedException
	{
		driver.findElement(AppiumBy.accessibilityId("Views")).click();

		driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new Uiselector()).scrollIntoView(text(\"WebView\"));"));
		Thread.sleep(2000);
		driver.findElement(AppiumBy.accessibilityId("WebView")).click();

		//Scroll down process in another ways.//
		//		boolean canScrollMore;
		//		do
		//		{
		//			canScrollMore=(Boolean) ((JavascriptExecutor)driver).executeScript("mobile: scrollGesture",ImmutableMap.of(
		//					"left", 100, "top" , 100, "width" , 200, "height", 200,
		//					"direction","down",
		//					"percent", 3.0 ));
		//		}
		//		while(canScrollMore);

	}

}
