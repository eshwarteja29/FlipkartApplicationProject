package com.qa.testScripts;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import java.io.IOException;
import java.util.Iterator;
import java.util.Set;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.pages.FlipkartPages;
import com.qa.utility.ExcelUtility;

public class FlipKartAddingtoCart extends TestBase{

	@Test(dataProvider="getData")
	public void cart(String Itemname) throws InterruptedException, IOException{
		
		FlipkartPages flipkart =new FlipkartPages(driver);
		
		flipkart.getFlipkartSearchBox().sendKeys(Itemname);
        flipkart.getFlipkartSearch().click();
		Thread.sleep(3000);
		flipkart.getFlipkartSelect().click();
		
		String parent=driver.getWindowHandle();
		Set<String> windowhandles=driver.getWindowHandles();
		  Iterator<String> iterator=windowhandles.iterator();
		  while(iterator.hasNext())
		  {
			  String Windid=iterator.next();
			  WebDriver window=driver.switchTo().window(Windid);
		  }		
		  
			 flipkart.getFlipkartadd().click();
				Thread.sleep(10000);

		 String cart= driver.getTitle();
		 if(cart.contains("Shopping Cart"))
		 {
			 Reporter.log("product succesfully added",true);
			  AssertJUnit.assertTrue(true);


		 }
		 else {
				captureScreenshot( driver,"cart");

			 Reporter.log("product is not  added",true);
			  AssertJUnit.assertTrue(false);


		 }
		 driver.switchTo().window(parent);	
		 driver.navigate().back();
			Thread.sleep(5000);

			

	}
	@DataProvider
	public String[][] getData() throws IOException
	{
		String xFile ="/Users/eshwarteja/eclipse-workspace/FlipkartApplicationProject/src/test/java/com/qa/testData/Test Data.xlsx";
		String xSheet ="Sheet1";
		
		int rowCount =ExcelUtility.getRowCount(xFile, xSheet);
		int cellCount =ExcelUtility.getCellCount(xFile, xSheet, rowCount);
		
		String[][] data =new String[rowCount][cellCount];
		
		for(int i=1;i<=rowCount;i++) {
			for(int j=0;j<cellCount;j++)
			{
				data[i-1][j]=ExcelUtility.getCellData(xFile, xSheet, i, j);
		}
		}
		return data;
		
	}
}
