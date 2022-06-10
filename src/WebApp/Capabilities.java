package WebApp;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;

public class Capabilities {

	public static AndroidDriver<AndroidElement>capability() throws MalformedURLException {
		
		// checking the capabilites of an android emulator before I run
		// since i want to run a webapp, we use chrome browser
		// then the url
		
		// this is common for any device, this is general
		DesiredCapabilities cp = new DesiredCapabilities();
		
		
		// this is common for any device too
		// link up with the emulator 
		cp.setCapability(MobileCapabilityType.DEVICE_NAME, "First");
		
		
		// link up the platform which we are working on
		// since it is general, we have to mention which platform
		cp.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
		
		
		// I want to test a web application
		// for that, what is required?
		// It requires me to open the browser
		cp.setCapability(MobileCapabilityType.BROWSER_NAME, "Chrome");
		
		
		// since I am testing a browser, I need to add a driver
		cp.setCapability(AndroidMobileCapabilityType.CHROMEDRIVER_EXECUTABLE, 
				"C:\\Users\\user\\Downloads\\chromedriver_win32\\chromedriver.exe");
		
		// I want to run this on my device (emulator)
		AndroidDriver<AndroidElement> driver = new AndroidDriver<AndroidElement>(new URL("http://0.0.0.0:4723/wd/hub"), cp);
		
		// since we want to return the driver
		return driver;
		
		
		

	}

}
