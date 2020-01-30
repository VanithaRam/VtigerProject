package com.crm.vtiger.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductsPage {
	
	WebDriver driver ;
	@FindBy(linkText="Products")
	private WebElement productsTab;
	
	@FindBy(name="search_text")
	private WebElement searchFor;
	
	@FindBy(name="submit")
	private WebElement submit;
	
	@FindBy(linkText="Mi Phone")
	private WebElement productLink;
	
	@FindBy(xpath="//img(@alt='Create Product...')")
	private WebElement createProdBTN;
	
	public ProductsPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public void createNewProduct()
	{
		createProdBTN.click();
		//return new ProdChildPage(driver);
	}
}
