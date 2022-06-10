package WebApp;

import java.net.MalformedURLException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class Demo1 extends Capabilities {
	public String URL="https://www.google.com";
	
	// calling the android driver from capabilities
	AndroidDriver<AndroidElement> driver;
	
	// bringing a before class here
	@BeforeTest
	public void BT() throws MalformedURLException
	{
		driver = capability();
	}
	
	@Test
	public void testcase1() throws InterruptedException 
	{
		driver.get(URL);
		String title = driver.getTitle();
		System.out.println(title);
		
		// adding the linkedin url to the page
		driver.findElement(By.tagName("input")).sendKeys("Moolya");
		Thread.sleep(5000);
		
		// need to click on the first option
		// we have a keyboard there too
		// so we can use actions interface
		Actions act = new Actions(driver);
		act.sendKeys(Keys.ENTER).build().perform();
		Thread.sleep(5000);
		
		// now we will click with using contains text
		WebElement element = driver.findElement(By.partialLinkText("Moolya | LinkedIn"));
		Thread.sleep(5000);
		// to do that, we need java script executor
		JavascriptExecutor js = (JavascriptExecutor)driver;
		// scrolling to the element by using arguments
		js.executeScript("arguments[0].scrollIntoView()", element);
		Thread.sleep(5000);
		// clicking the element
		driver.findElement(By.xpath("//*[contains(text(),'Moolya | LinkedIn')]")).click();
	}

}
