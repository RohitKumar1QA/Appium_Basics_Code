package Com.AppiumFirst_Project.Com.AppiumFirst_Project;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.google.common.collect.ImmutableMap;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;

public class testBase {
	
	public static AndroidDriver driver;
	public static AppiumDriverLocalService service;


	@BeforeClass
	public void AppiumTest() throws MalformedURLException
	{

		BAse.service= new AppiumServiceBuilder()
				.withAppiumJS(new File("C:\\Users\\rohit.kumar2\\AppData\\Roaming\\npm\\node_modules\\appium\\build\\lib\\main.js"))
				.withIPAddress("127.0.0.1").usingPort(4723).withTimeout(Duration.ofSeconds(100)).build();
		service.start();

		UiAutomator2Options options = new UiAutomator2Options();
		options.setDeviceName("RohitEmulator1");
	//	options.setPlatformName("Android");
	//	options.setCapability("platformVersion","11.0");
		//	options.setApp("C:\\Users\\rohit.kumar2\\eclipse-workspace\\Com.AppiumFirst_Project\\APK_FIles\\ApiDemos-debug.apk");
		options.setApp(System.getProperty("user.dir")+"\\APK_FIles\\General-Store.apk");



		driver = new AndroidDriver(new URL("http://127.0.0.1:4723"),options);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));


	}

	public void swipeAction(WebElement ele,String direction)
	{

		((JavascriptExecutor)driver).executeScript("mobile: swipeGesture",ImmutableMap.of(
				"elementid",((RemoteWebElement)ele).getId(),
				"direction",direction,
				"percent", 0.75
				));

	}

	public Double getFormatedAmount(String amount)
	{
		Double price=Double.parseDouble(amount.substring(1));
		return price;

	}

	public void LongPressAction(WebElement ele1)
	{
		((JavascriptExecutor)driver).executeScript("mobile: longClickGesture",ImmutableMap.of
				("elementId",((RemoteWebElement)ele1).getId(),"duration",2000));
	}






	@AfterClass
	public void teardown()
	{

		driver.quit();
		service.stop();

	}




}


