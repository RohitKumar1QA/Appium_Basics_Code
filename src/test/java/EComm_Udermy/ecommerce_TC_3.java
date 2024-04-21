package EComm_Udermy;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import Com.AppiumFirst_Project.Com.AppiumFirst_Project.BAse;
import io.appium.java_client.AppiumBy;

public class ecommerce_TC_3 extends BAse {

	/*
	 * In this TC_3 having the added 2 product in the cart section in different
	 * different value and added both values and added and check the checkout price
	 * of that product has been added both or not
	 */
	@Test
	public void fillForm() throws InterruptedException
	{

		/*
		 * //Other Elements driver.findElement(AppiumBy.
		 * androidUIAutomator("new UiScrollable(new UiSelector().scrollable(true)" +
		 * ".instance(0)).scrollIntoView(new UiSelector().text(\"Argentina\"));"));
		 * driver.findElement(AppiumBy.xpath(
		 * "//android.widget.TextView[@text='Argentina']")).click();
		 * driver.findElement(By.id("com.androidsample.generalstore:id/nameField")).
		 * sendKeys("Rohit Singh"); driver.hideKeyboard();//Hide Keyboard is method
		 * which is hide the keyboard on the UI/ Screen.
		 * driver.findElement(By.id("com.androidsample.generalstore:id/radioFemale")).
		 * click(); //Scroll Down Functionality
		 * driver.findElement(By.id("android:id/text1")).click(); Thread.sleep(5000);
		 * driver.findElement(By.id("com.androidsample.generalstore:id/btnLetsShop")).
		 * click();
		 * 
		 * Thread.sleep(3000); driver.findElements(By.
		 * xpath("//android.widget.TextView[@text='ADD TO CART'])")).get(0).click(); //
		 * driver.findElement(By.
		 * xpath("(//android.widget.TextView[@text='ADD TO CART'])[1]")).click();
		 * driver.findElements(By.
		 * xpath("//android.widget.TextView[@text='ADD TO CART'])")).get(0).click();
		 * driver.findElement(AppiumBy.id(
		 * "com.androidsample.generalstore:id/appbar_btn_cart")).click();
		 * Thread.sleep(5000);
		 */
		driver.findElement(By.id("com.androidsample.generalstore:id/nameField")).sendKeys("Rohit Singh");
		driver.hideKeyboard();//Hide Keyboard is method which is hide the keyboard on the UI/ Screen.
		driver.findElement(By.id("com.androidsample.generalstore:id/radioFemale")).click();
		driver.findElement(By.id("android:id/text1")).click();
		Thread.sleep(5000);
		driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector().scrollable(true)"
				+ ".instance(0)).scrollIntoView(new UiSelector().text(\"Argentina\"));"));
		driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text='Argentina']")).click();
		driver.findElement(By.id("com.androidsample.generalstore:id/btnLetsShop")).click();
		Thread.sleep(5000);

		driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector().scrollable(true)"
				+ ".instance(0)).scrollIntoView(new UiSelector().text(\"Jordan 6 Rings\"));"));


		int productCount = driver.findElements(By.id("com.androidsample.generalstore:id/productName")).size();

		for(int i=0;i<productCount;i++)
		{
			String ProductName= driver.findElements(By.id("com.androidsample.generalstore:id/productName")).get(i).getText();

			if(ProductName.equalsIgnoreCase("Jordan 6 Rings"))
			{
				driver.findElements(By.id("com.androidsample.generalstore:id/productAddCart")).get(i).click();
			}
		}
		driver.findElement(AppiumBy.id("com.androidsample.generalstore:id/appbar_btn_cart")).click();
		Thread.sleep(3000);

		
		
		
		//Explicit Wait//
		WebDriverWait wait= new WebDriverWait(driver,Duration.ofSeconds(10));
		wait.until(ExpectedConditions.attributeContains(driver.findElement
				(By.id("com.androidsample.generalstore:id/toolbar_title")), "text", "Cart"));



	}

}
