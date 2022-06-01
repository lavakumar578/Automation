package com.sdet34l1.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.sdet34l1.genericUtlity.DriverUtility;

public class CheckOutPage {

	
	@FindBy(xpath="//div[@class='wc-proceed-to-checkout']/a[@class='checkout-button button alt wc-forward']")
	private WebElement proceedToCheckOut;
	
	
	public CheckOutPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	public void proceedToCheckOut(WebDriver driver)
	{
		DriverUtility driverUtility=new DriverUtility(driver);
		driverUtility.intializeJavaScriptExecutor(driver);
		driverUtility.scrollTillElement(proceedToCheckOut);
		proceedToCheckOut.click();
	}
}
