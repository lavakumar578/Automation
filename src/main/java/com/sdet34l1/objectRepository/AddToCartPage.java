package com.sdet34l1.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.sdet34l1.genericUtlity.DriverUtility;

public class AddToCartPage {

	@FindBy(xpath="//li[contains(@class,'post-181 product type-product')]//a[contains(@class,'button')]")
	private WebElement addToCart;
	
	public AddToCartPage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}
	
	public void clickAddToCart(WebDriver driver)
	{
		DriverUtility driverUtility=new DriverUtility(driver);
		driverUtility.intializeJavaScriptExecutor(driver);
		driverUtility.scrollTillElement(addToCart);
		addToCart.click();
	}
	
	@FindBy(xpath="//a[@title='View Basket']")
	private WebElement viewBasket;
	
	public void viewBasket()
	{
		viewBasket.click();
	}
}
