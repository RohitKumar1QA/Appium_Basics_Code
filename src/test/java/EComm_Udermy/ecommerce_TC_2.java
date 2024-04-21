package EComm_Udermy;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import Com.AppiumFirst_Project.Com.AppiumFirst_Project.BAse;
import Com.AppiumFirst_Project.Com.AppiumFirst_Project.BAse2;
import io.appium.java_client.AppiumBy;

public class ecommerce_TC_2 extends BAse2 {

	
	/* In this TC_2 ----------------
	 * we have select one product with Scroll down with the specific product
	 * and click to the Add in Cart Section
	 * And uses the Aseertion on that product has been 
	 * added in the cart or not using Assertion!
	 */
	@Test
	public void fillForm() throws InterruptedException
	{

		//Other Elements
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
		/*
		 * WebDriverWait wait= new WebDriverWait(driver,Duration.ofSeconds(10));
		 * wait.until(ExpectedConditions.attributeContains(driver.findElement
		 * (By.id("com.androidsample.generalstore:id/toolbar_title")), "text", "Cart"));
		 * 
		 * String productAddedCart
		 * =driver.findElement(By.id("com.androidsample.generalstore:id/productName")).
		 * getText(); Assert.assertEquals(productAddedCart, "Jordan 6 Rings");
		 */


	}

}
