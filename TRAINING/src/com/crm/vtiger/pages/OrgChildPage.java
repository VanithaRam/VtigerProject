package com.crm.vtiger.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.vtiger.generic.WebDriverUtils;

public class OrgChildPage extends WebDriverUtils{
	
	WebDriver driver;
	
	@FindBy(id="search_txt")
	private WebElement searchBox;
	
	@FindBy(name="search")
	private WebElement searchBTN;
	
	@FindBy(linkText="TestYantra")
	private WebElement member;
	
	@FindBy(name="search_field")
	private WebElement inDropDown;
	
	@FindBy(id="1")
	private WebElement memberLink;
	
	
	
	public WebDriver getDriver() {
		return driver;
	}

	public WebElement getSearchBox() {
		return searchBox;
	}

	public WebElement getSearchBTN() {
		return searchBTN;
	}

	public WebElement getMember() {
		return member;
	}

	public WebElement getInDropDown() {
		return inDropDown;
	}

	public WebElement getMemberLink() {
		return memberLink;
	}

	public OrgChildPage(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public CreateOrganizationPage selectMember(String memberName)
	{
		searchBox.sendKeys(memberName);
		select(inDropDown, "Organization Name");
		searchBTN.click();
		memberLink.click();
		acceptAlert(driver);
		switchToParentWindow(driver);
		return new CreateOrganizationPage(driver);	
	}
}
