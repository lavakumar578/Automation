package com.sdet34l1.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckOutPage {

	
	@FindBy(xpath="//div[@class='wc-proceed-to-checkout']//a")
	private WebElement proceedToCheckOut;
	
	
	public CheckOutPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	public void proceedToCheckOut()
	{
		proceedToCheckOut.click();
	}
}
