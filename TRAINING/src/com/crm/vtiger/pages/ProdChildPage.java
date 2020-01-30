package com.crm.vtiger.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.vtiger.generic.WebDriverUtils;

public class ProdChildPage extends WebDriverUtils {
	
WebDriver driver;
	
	@FindBy(id="search_txt")
	private WebElement searchBox;
	
	@FindBy(name="search")
	private WebElement searchBTN;
	
	@FindBy(name="search_field")
	private WebElement inDropDown;
	
	@FindBy(id="1")
	private WebElement productLink;
	
	public WebDriver getDriver() {
		return driver;
	}

	public WebElement getSearchBox() {
		return searchBox;
	}

	public WebElement getSearchBTN() {
		return searchBTN;
	}

	public WebElement getInDropDown() {
		return inDropDown;
	}

	public WebElement getProductLink() {
		return productLink;
	}

	public ProdChildPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	
	public CreateCampaignPage addProduct(String productName)
	{
		searchBox.sendKeys(productName);
		select(inDropDown, "Product Name");
		searchBTN.click();
		productLink.click();
		switchToParentWindow(driver);
		return new CreateCampaignPage(driver);
	}
	
	
}
