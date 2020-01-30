package com.crm.vtiger.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateProductPage {

	@FindBy(name="productname")
	private WebElement prodName;
	
	@FindBy(id="productcode")
	private WebElement partNo;
	
	public CreateProductPage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}
	
	public void createProduct(String productName , String partNumber )
	{
		prodName.sendKeys(productName);
		partNo.sendKeys(partNumber);
	}
	
	
}
