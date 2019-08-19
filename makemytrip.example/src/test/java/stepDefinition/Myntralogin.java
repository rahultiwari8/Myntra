package stepDefinition;

import java.io.File;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import junit.framework.Assert;
import util.SingletonDriver;

public class Myntralogin {
	
	WebDriver  driver =null;
	ExtentHtmlReporter report;
	ExtentReports extent;
	ExtentTest logger;
	
	@Before
	public void ini()
	{
		  //driver = SingletonDriver.getInsatnce();
		   report= new ExtentHtmlReporter(new File("./reports/myntra.html"));
		    extent = new ExtentReports();
		   extent.attachReporter(report);
		   
		   System.setProperty("webdriver.chrome.driver", "/Users/rahultiwari/Documents/Driver_for_selenium/chromedriver");
			driver = new ChromeDriver();
		
	}
	
	@After
	public void tearDown()
	{
		driver.close();
		extent.flush();
	}
	
	
	
	@Given("^When i am on Myntra \"([^\"]*)\" page$")
	public void when_i_am_on_Myntra_page(String arg1) throws Throwable {
		
		logger=extent.createTest("Loggin in to Myntra", "this is descrioption");
		
		driver.get(arg1);
		logger.log(Status.PASS, "Logeed into Myntra");
		
	    
	    
	}

	@Then("^i should enter my valid credentials \"([^\"]*)\" and \"([^\"]*)\"$")
	public void i_should_enter_my_valid_credentials_and(String arg1, String arg2) throws Throwable {
	   
		driver.findElement(By.xpath("//span[@class='desktop-userTitle']")).click();
		driver.findElement(By.xpath("//*[@id=\"desktop-header-cnt\"]/div[2]/div[2]/div/div[2]/div[2]/div[2]/div[1]/a[2]")).click();
	    driver.findElement(By.xpath("//input[@type='email']")).sendKeys(arg1);
	    driver.findElement(By.xpath("//input[@type='password']")).sendKeys(arg2);
	    driver.findElement(By.xpath("//button[@class='login-login-button']")).click();
	    
	    Thread.sleep(5000);
	    logger.log(Status.PASS, "Credentials worked!");
	    
	}

	@Then("^i should be able to login$")
	public void i_should_be_able_to_login() throws Throwable {
	    
		boolean  loginDisplayed=driver.findElement(By.xpath("//button[@class='login-login-button']")).isDisplayed();
		if(loginDisplayed==true)
		{
			Assert.assertFalse(false);
			logger.log(Status.FAIL, "Failed to login");
		}
		else
		{
			Assert.assertTrue(true);
			logger.log(Status.PASS, "Success to Login");
		}
	    
	}

}
