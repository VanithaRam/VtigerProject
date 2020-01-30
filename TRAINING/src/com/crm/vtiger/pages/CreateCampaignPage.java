package com.crm.vtiger.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.vtiger.generic.WebDriverUtils;

public class CreateCampaignPage extends WebDriverUtils {
	
	WebDriver driver; 
	
	@FindBy(name="campaignname")
	private WebElement campaignNameEdit;
	
	@FindBy(id="targetaudience")
	private WebElement targetAudienceEdit;
	
	@FindBy(name="sponsor")
	private WebElement sponsorEdit;
	
	@FindBy(name="targetsize")
	private WebElement targetSizeEdit;
	
	@FindBy(xpath="//input[@value='  Save  ']")
	private WebElement saveBTN;
	
	@FindBy(xpath="//img[@alt='Select']")
	private WebElement addProdBTN;
	
	public WebElement getAddProdBTN() {
		return addProdBTN;
	}

	public CreateCampaignPage(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public WebDriver getDriver() {
		return driver;
	}

	public WebElement getCampaignNameEdit() {
		return campaignNameEdit;
	}

	public WebElement getTargetAudienceEdit() {
		return targetAudienceEdit;
	}

	public WebElement getSponsorEdit() {
		return sponsorEdit;
	}

	public WebElement getTargetSizeEdit() {
		return targetSizeEdit;
	}

	public WebElement getSaveBTN() {
		return saveBTN;
	}
	
	public CampaignInfoPage createNewCampaign(String campName, String sponsor)
	{
		campaignNameEdit.sendKeys(campName);
		sponsorEdit.sendKeys(sponsor);
		saveBTN.click();
		return new CampaignInfoPage(driver);
	}
	
	public ProdChildPage createNewCampaign(String campName, String targetAudience, String sponsor)
	{
		campaignNameEdit.sendKeys(campName);
		targetAudienceEdit.sendKeys(targetAudience);
		sponsorEdit.sendKeys(sponsor);
		addProdBTN.click();
		switchToChildWindow(driver);
		return new ProdChildPage(driver);
	}
	
	public CampaignInfoPage clickOnSave()
	{
		saveBTN.click();
		return new CampaignInfoPage(driver);
	}
	
}
