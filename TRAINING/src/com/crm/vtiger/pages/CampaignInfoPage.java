package com.crm.vtiger.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CampaignInfoPage {

	WebDriver driver;
	
	@FindBy(id="dtlview_Campaign Name")
	private WebElement campInfo;
	
	public CampaignInfoPage(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver,this);
	}

	public WebElement getCampInfo() {
		return campInfo;
	}
	
}
