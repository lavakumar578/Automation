package com.sdet34l1.objectRepository;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.sdet34l1.genericUtlity.DriverUtility;

public class HomePage {

	
	@FindBy(xpath="//img[@alt='Thinking in HTML']")
	private WebElement clickBook;
	
	public HomePage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
		
	}
	
	public void clickBook(WebDriver driver)
	{
		DriverUtility driverUtility=new DriverUtility(driver);
		driverUtility.intializeJavaScriptExecutor(driver);
		driverUtility.scrollTillElement(clickBook);
		clickBook.click();
	}
}
