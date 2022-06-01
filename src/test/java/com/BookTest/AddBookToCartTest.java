package com.BookTest;

import java.io.IOException;

import org.testng.annotations.Test;

import com.sdet34l1.genericUtlity.BaseClass;
import com.sdet34l1.genericUtlity.DriverUtility;
import com.sdet34l1.genericUtlity.XlsxUtility;
import com.sdet34l1.objectRepository.AddToCartPage;
import com.sdet34l1.objectRepository.CheckOutPage;
import com.sdet34l1.objectRepository.HomePage;
import com.sdet34l1.objectRepository.OrderPage;

public class AddBookToCartTest extends BaseClass{

	@Test
	public void addBookToCart() throws IOException
	{
		
		HomePage homePage=new HomePage(driver);
		homePage.clickBook(driver);
		AddToCartPage addToCartPage=new AddToCartPage(driver);
		addToCartPage.clickAddToCart(driver);
		addToCartPage.viewBasket();
		CheckOutPage checkOutPage=new CheckOutPage(driver);
		checkOutPage.proceedToCheckOut(driver);
		OrderPage orderPage=new OrderPage(driver);
		orderPage.enterCustomerName(XlsxUtility.getDataFromExcelSheet("customerdetails", 1, 1), XlsxUtility.getDataFromExcelSheet("customerdetails", 1, 2));
		orderPage.enterCustomerMailAndPhoneNum(XlsxUtility.getDataFromExcelSheet("customerdetails", 1, 4), XlsxUtility.getDataFromExcelSheet("customerdetails", 1, 3));
		orderPage.enterCustomerAddress(XlsxUtility.getDataFromExcelSheet("customerdetails", 1, 5), XlsxUtility.getDataFromExcelSheet("customerdetails", 1, 6));
		orderPage.selectState(XlsxUtility.getDataFromExcelSheet("customerdetails", 1, 8) , XlsxUtility.getDataFromExcelSheet("customerdetails", 1, 7), driver);
		
		
		
	}
	
}
