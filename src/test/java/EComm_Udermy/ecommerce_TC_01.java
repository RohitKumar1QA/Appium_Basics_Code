package EComm_Udermy;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import Com.AppiumFirst_Project.Com.AppiumFirst_Project.BAse;
import Com.AppiumFirst_Project.Com.AppiumFirst_Project.BAse2;
import io.appium.java_client.AppiumBy;

public class ecommerce_TC_01 extends BAse {
 
	@Test
	public void fillForm() throws InterruptedException
	{

		//Other Elements
	//	driver.findElement(By.id("com.androidsample.generalstore:id/nameField")).sendKeys("Rohit Singh");
		driver.hideKeyboard();//Hide Keyboard is method which is hide the keyboard on the UI/ Screen.
		driver.findElement(By.id("com.androidsample.generalstore:id/radioFemale")).click();
		//Scroll Down Functionality
		driver.findElement(By.id("android:id/text1")).click();
		Thread.sleep(5000);


		driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector().scrollable(true)"
				+ ".instance(0)).scrollIntoView(new UiSelector().text(\"Argentina\"));"));
		driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text='Argentina']")).click();

		driver.findElement(By.id("com.androidsample.generalstore:id/btnLetsShop")).click();
	//	Thread.sleep(5000);

		/* 
		 * Toast Massage : when you have does not fill mandatory field and try to go to the next step 
		 * then Error Massage shown on the Screen (field is Mandtory) 
		 * so that is called as a Toast Massage.
		 */
		
		

		String toastMassage= driver.findElement(By.xpath("(//android.widget.Toast)[1]")).getAttribute("name");
		Assert.assertEquals(toastMassage, "Please enter your name");
		driver.findElement(By.id("com.androidsample.generalstore:id/nameField")).sendKeys("Rohit Singh");
		driver.findElement(By.id("com.androidsample.generalstore:id/btnLetsShop")).click();

	}

}
