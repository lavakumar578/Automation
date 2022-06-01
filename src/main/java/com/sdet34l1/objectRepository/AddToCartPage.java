package com.sdet34l1.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddToCartPage {

	@FindBy(xpath="//li[@class='post-182 product type-product status-publish has-post-thumbnail product_cat-html product_tag-html has-post-title has-post-date has-post-category has-post-tag has-post-comment has-post-author  instock taxable shipping-taxable purchasable product-type-simple']//a[text()='Add to basket']")
	private WebElement addToCart;
	
	public AddToCartPage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}
	
	public void clickAddToCart()
	{
		addToCart.click();
	}
	
	@FindBy(xpath="//a[@title='View Basket']")
	private WebElement viewBasket;
	
	public void viewBasket()
	{
		viewBasket.click();
	}
}
