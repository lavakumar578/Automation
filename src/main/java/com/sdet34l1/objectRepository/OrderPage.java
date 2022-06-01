package com.sdet34l1.objectRepository;

import java.io.IOException;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.sdet34l1.genericUtlity.DriverUtility;

public class OrderPage {

	
	@FindBy(id="billing_first_name")
	private WebElement enterFirstNametxt;
	
	@FindBy(id="billing_last_name")
	private WebElement enterLastNametxt;
	
	@FindBy(id="billing_email")
	private WebElement enterEmailIdtxt;
	
	@FindBy(id="billing_phone")
	private WebElement enterPhoneNumbertxt;
	
	@FindBy(id="billing_address_1")
	private WebElement enterAddresstxt;
	
	@FindBy(id="billing_city")
	private WebElement enterCitytxt;
	
	@FindBy(xpath="//div[@class='select2-container state_select']//span[@role='presentation']")
	private WebElement selectStatetxt;
	
	@FindBy(id="billing_postcode")
	private WebElement enterPincodetxt;
	
	@FindBy(id="s2id_autogen2_search")
	private WebElement enterStateNameTxt;
	
	
	public void selectState(String state,String pincode,WebDriver driver) throws IOException
	{
		selectStatetxt.click();
		enterStateNameTxt.sendKeys(state+Keys.ENTER);
		enterPincodetxt.sendKeys(pincode);
		DriverUtility.takeScreenShot("./screenshot", driver);
	}
	
	
	
	public OrderPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	public void enterCustomerName(String firstName,String lastName)
	{
		enterFirstNametxt.sendKeys(firstName);
		enterLastNametxt.sendKeys(lastName);

		
	}
	public void enterCustomerMailAndPhoneNum(String phone,String mailId)
	{
		enterEmailIdtxt.sendKeys(mailId);
		enterPhoneNumbertxt.sendKeys(phone);
	}
	public void enterCustomerAddress(String address,String city)
	{
		enterAddresstxt.sendKeys(address);
		enterCitytxt.sendKeys(city);
	
		
		
	}
}
