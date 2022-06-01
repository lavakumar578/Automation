package com.sdet34l1.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrderPage {

	
	@FindBy(id="billing_first_name")
	private WebElement enterFirstNametxt;
	
	@FindBy(id="billing_last_name")
	private WebElement enterLastNametxt;
	
	
	public OrderPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	

	
}
