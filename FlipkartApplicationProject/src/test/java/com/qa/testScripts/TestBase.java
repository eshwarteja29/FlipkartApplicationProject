package com.qa.testScripts;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import com.qa.pages.FlipkartPages;

public class TestBase {

	WebDriver driver;
	FlipkartPages flipkart ;
	FileInputStream fileloc ;
	Properties prop ;
	
	@Parameters({"Browser","Url"})
	@BeforeClass
    public void setUp(String Browser, String Url) throws IOException, InterruptedException
	{
	
	if(Browser.equalsIgnoreCase("Chrome"))
	{
		driver= new ChromeDriver();
		driver.manage().window().maximize();
	}
	else if(Browser.equalsIgnoreCase("safari"))
	{
		driver= new SafariDriver();
		driver.manage().window().maximize();
	}
	
flipkart =new FlipkartPages(driver);
driver.get(Url);
fileloc =new FileInputStream("/Users/eshwarteja/eclipse-workspace/FlipkartApplicationProject/src/test/java/com/qa/testData/Credintials.properties");
prop =new Properties();
prop.load(fileloc);
Actions act = new Actions(driver);
Action action =act.sendKeys(Keys.ESCAPE).build();
action.perform();
  flipkart.getFlipkartlogin().click();
  flipkart.getFlipkartemail().sendKeys(prop.getProperty("username"));
  flipkart.getFlipkartpasword().sendKeys(prop.getProperty("password"));
  flipkart.getFlipkartloginsubmit().click(); 
  Thread.sleep(1000);
  flipkart.getFlipkartSearchBox().clear();

}


  @AfterClass 
  public void tearDown() {
	  driver.quit();
	  }
 
	
	public void captureScreenshot(WebDriver drver,String tname) throws IOException
	{
		TakesScreenshot screenShot =(TakesScreenshot) driver;
		File Source = screenShot.getScreenshotAs(OutputType.FILE);
		String Dest =System.getProperty("user.dir")+"/Screenshots/"+tname+".png";
	    FileUtils.copyFile(Source, new File(Dest));
	}
}

