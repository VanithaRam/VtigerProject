package com.crm.vtiger.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CampaignPage {
	WebDriver driver;
	
	public WebDriver getDriver() {
		return driver;
	}

	public WebElement getCreateCampaignBTN() {
		return createCampaignBTN;
	}

	public WebElement getSearchBTN() {
		return searchBTN;
	}

	public WebElement getSubmitBTN() {
		return submitBTN;
	}

	public WebElement getProdLink() {
		return prodLink;
	}

	@FindBy(xpath="//img[@alt='Create Campaign...']")
	private WebElement createCampaignBTN;
	
	@FindBy(name="search_text")
	private WebElement searchBTN;
	
	@FindBy(name="submit")
	private WebElement submitBTN;
	
	@FindBy(linkText="phone sales")
	private WebElement prodLink;
	
	public CampaignPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public CreateCampaignPage navigateToCreateCampPage()
	{
		createCampaignBTN.click();
		return new CreateCampaignPage(driver);
	}
	
}
