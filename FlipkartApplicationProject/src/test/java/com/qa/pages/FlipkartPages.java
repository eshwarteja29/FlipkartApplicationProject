package com.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FlipkartPages {


WebDriver driver;


@FindBy(name="q")
WebElement FlipkartSearchBox;
public WebElement getFlipkartSearchBox()
{
return FlipkartSearchBox;
}
@FindBy(className="L0Z3Pu")
WebElement FlipkartSearch;
public WebElement getFlipkartSearch()
{
return FlipkartSearch;
}
@FindBy(className="_4rR01T")
WebElement FlipkartSelect;
public WebElement getFlipkartSelect()
{
return FlipkartSelect;
}

@FindBy(xpath="//*[@id=\"container\"]/div/div[1]/div[1]/div[2]/div[3]/div/div/div/div")
WebElement FlipkartEshwar;
public WebElement getFlipkartEshwar()
{
return FlipkartEshwar;
}
@FindBy(xpath="//button[@class='_2KpZ6l _2U9uOA _3v1-ww']")
WebElement Flipkartadd;
public WebElement getFlipkartadd()
{
return Flipkartadd;
}


@FindBy(xpath="//*[@id=\"container\"]/div/div[1]/div[1]/div[2]/div[3]/div/div/div/a")
WebElement Flipkartlogin;
public WebElement getFlipkartlogin()
{
return Flipkartlogin;
}
@FindBy(className="go_DOp")
WebElement Flipkartlogout;
public WebElement getFlipkartlogout()
{
return Flipkartlogout;
}
@FindBy(xpath="/html/body/div[2]/div/div/div/div/div[2]/div/form/div[1]/input")
WebElement Flipkartemail;
public WebElement getFlipkartemail()
{
return Flipkartemail;
}

@FindBy(xpath="/html/body/div[2]/div/div/div/div/div[2]/div/form/div[2]/input")
WebElement Flipkartpasword;
public WebElement getFlipkartpasword()
{
return Flipkartpasword;
}
@FindBy(xpath="/html/body/div[2]/div/div/div/div/div[2]/div/form/div[4]/button")
WebElement Flipkartloginsubmit;
public WebElement getFlipkartloginsubmit()
{
return Flipkartloginsubmit;
}
public FlipkartPages(WebDriver driver) {
	this.driver = driver;
	
	PageFactory.initElements(driver, this);
}
}
