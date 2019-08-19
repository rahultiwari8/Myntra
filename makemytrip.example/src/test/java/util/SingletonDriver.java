package util;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SingletonDriver {
	
	private static WebDriver driver;
	
	private SingletonDriver() {
		// TODO Auto-generated constructor stub
	}
	
	public static WebDriver getInsatnce()
	{
		if (null ==driver)
		{
			
			synchronized (SingletonDriver.class) {
				if(null==driver)
				{
					System.setProperty("webdriver.chrome.driver", "/Users/rahultiwari/Documents/Driver_for_selenium/chromedriver");
					driver = new ChromeDriver();
				}
				
			}
			
		}
		return driver;
	}

}
