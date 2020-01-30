package com.crm.vtiger.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrganizationPage 
{
	WebDriver driver;
	
	@FindBy(xpath="//img[@alt='Create Organization...']")
	private WebElement createOrgLink;
	
	@FindBy(className="txtBox")
	private WebElement searchFor;
	
	@FindBy(name="submit")
	private WebElement searchNowBTN;
	
	@FindBy(name="search_field")
	private WebElement searchDropDown;
	
	@FindBy(linkText="TY")
	private WebElement OrgNameLink;
	
	@FindBy(id="viewname")
	private WebElement Filters;
	
	@FindBy(xpath="//input[@value='delete']")
	private WebElement delBTN;
	
	@FindBy(id="2")
	private WebElement checkbox;
	
	public OrganizationPage(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	public WebDriver getDriver() {
		return driver;
	}
	public WebElement getCreateOrgLink() {
		return createOrgLink;
	}
	public WebElement getSearchFor() {
		return searchFor;
	}
	public WebElement getSearchNowBTN() {
		return searchNowBTN;
	}
	public WebElement getSearchDropDown() {
		return searchDropDown;
	}
	public WebElement getOrgNameLink() {
		return OrgNameLink;
	}
	public WebElement getFilters() {
		return Filters;
	}
	public WebElement getDelBTN() {
		return delBTN;
	}
	public WebElement getCheckbox() {
		return checkbox;
	}
	
	public CreateOrganizationPage createNewOrganizationPage()
	{
		createOrgLink.click();
		return  new CreateOrganizationPage(driver);
	}
}