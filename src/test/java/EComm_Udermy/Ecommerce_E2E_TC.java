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

public class Ecommerce_E2E_TC extends BAse {

	@Test 
	public void First_page_FinalExecution() throws InterruptedException
	{
		driver.findElement(By.id("com.androidsample.generalstore:id/nameField")).sendKeys("Rohit Singh");
		driver.hideKeyboard();//Hide Keyboard is method which is hide the keyboard on the UI/ Screen.
		driver.findElement(By.id("com.androidsample.generalstore:id/radioFemale")).click();
		//Scroll Down Functionality
		driver.findElement(By.id("android:id/text1")).click();
		Thread.sleep(5000);
		driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector().scrollable(true)"
				+ ".instance(0)).scrollIntoView(new UiSelector().text(\"Argentina\"));"));
		driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text='Argentina']")).click();
		driver.findElement(By.id("com.androidsample.generalstore:id/btnLetsShop")).click();


		//2nd Page of  TestCase_Execution

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


		//3rd Page Test_Case _Execution _Explicit Wait//
		WebDriverWait wait= new WebDriverWait(driver,Duration.ofSeconds(10));
		wait.until(ExpectedConditions.attributeContains(driver.findElement
				(By.id("com.androidsample.generalstore:id/toolbar_title")), "text", "Cart"));

		String productAddedCart =driver.findElement(By.id("com.androidsample.generalstore:id/productName")).getText();
		Assert.assertEquals(productAddedCart, "Jordan 6 Rings");

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


	}

}
