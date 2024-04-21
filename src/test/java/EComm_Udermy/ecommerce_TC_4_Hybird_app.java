package EComm_Udermy;

import java.time.Duration;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import Com.AppiumFirst_Project.Com.AppiumFirst_Project.BAse;
import io.appium.java_client.AppiumBy;

public class ecommerce_TC_4_Hybird_app extends BAse {

	/*
	 * In this TC_3 having the added 2 product in the cart section in different
	 * different value and added both values and added and check the checkout price
	 * of that product has been added both or not
	 */
	@Test
	public void fillForm() throws InterruptedException
	{

		//Other Elements
		driver.findElement(By.id("com.androidsample.generalstore:id/nameField")).sendKeys("Rohit Singh");
		driver.hideKeyboard();//Hide Keyboard is method which is hide the keyboard on the UI/ Screen.
		driver.findElement(By.id("com.androidsample.generalstore:id/radioFemale")).click();
		driver.findElement(By.id("android:id/text1")).click();
		driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector().scrollable(true)"
				+ ".instance(0)).scrollIntoView(new UiSelector().text(\"Argentina\"));"));
		driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text='Argentina']")).click();
		driver.findElement(By.id("com.androidsample.generalstore:id/btnLetsShop")).click();
		Thread.sleep(3000);
		
		
		
		//Scroll Down Functionality
		driver.findElements(By.xpath("//android.widget.TextView[@text='ADD TO CART'])")).get(0).click();
		driver.findElements(By.xpath("//android.widget.TextView[@text='ADD TO CART'])")).get(1).click();      
		driver.findElement(AppiumBy.id("com.androidsample.generalstore:id/appbar_btn_cart")).click();
		//Explicit Wait//
		WebDriverWait wait= new WebDriverWait(driver,Duration.ofSeconds(10));
		wait.until(ExpectedConditions.attributeContains(driver.findElement
				(By.id("com.androidsample.generalstore:id/toolbar_title")), "text", "Cart"));
		List<WebElement> productPrices=driver.findElements(By.xpath("com.androidsample.generalstore:id/productPrice"));
		int Count=productPrices.size();
		double totalsum=0;
		for(int i=0;i<Count;i++)
		{
			String Amount =productPrices.get(i).getText();
			//Remove that 1st Element in java (like - $ Symbol)
			Amount.substring(1); // 160.07
			//convert String into Dobule format //
			//   Double price=Double.parseDouble(Amount.substring(1));
			Double price= getFormatedAmount(Amount);
			totalsum=totalsum+price;
			//160.07 + 120=280.97      
		}

		String DisplaySum=driver.findElement(By.id("com.androidsample.generalstore:id/totalAmountLbl")).getText();
		Double Displayformattedsum =getFormatedAmount(DisplaySum);
		Assert.assertEquals(totalsum, Displayformattedsum);
		WebElement ele1=driver.findElement(By.id("com.androidsample.generalstore:id/termsButton"));
		LongPressAction(ele1);
		driver.findElement(By.id("android:id/button1")).click();
		driver.findElement(AppiumBy.className("android.widget.CheckBox")).click();
		driver.findElement(By.id("com.androidsample.generalstore:id/btnProceed")).click();
		Thread.sleep(6000);
		
		Set<String> context= driver.getContextHandles();
		for(String contextName : context)
		{
			System.out.println(contextName);
		}
		driver.context("Webview");
		
		/*Hybrid-- Page --Starting*/
		



	}

}
