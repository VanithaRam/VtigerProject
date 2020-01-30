package com.crm.vtiger.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.vtiger.generic.WebDriverUtils;

public class HomePage {
	
	WebDriver driver;
	WebDriverUtils wdu = new WebDriverUtils();
	@FindBy(linkText="Calendar")
	private WebElement calenderLink;
	
	@FindBy(linkText="Leads")
	private WebElement leadsLink;
	
	@FindBy(linkText="Organizations")
	private WebElement organizationsLink;
	
	@FindBy(linkText="Contacts")
	private WebElement contactsLink;
	
	@FindBy(linkText="Opportunities")
	private WebElement opportunitiesLink;
	
	@FindBy(linkText="Products")
	private WebElement productsLink;
	
	@FindBy(linkText="Documents")
	private WebElement documentsLink;
	
	@FindBy(linkText="Email")
	private WebElement emailLink;
	
	@FindBy(linkText="More")
	private WebElement moreTab;
	
	@FindBy(linkText="Campaigns")
	private WebElement campaignLink;
	
	@FindBy(linkText="Trouble Tickets")
	private WebElement troubleTickLink;
	
	@FindBy(linkText="Dashboard")
	private WebElement dashboardLink;
	
	@FindBy(xpath="//img[@src='themes/softed/images/user.PNG']")
	private WebElement admin;
	
	@FindBy(linkText="Sign Out")
	private WebElement signOut;
	
	public WebElement getAdmin() {
		return admin;
	}

	public WebElement getSignOut() {
		return signOut;
	}

	public WebElement getTroubleTickLink() {
		return troubleTickLink;
	}

	public WebElement getDashboardLink() {
		return dashboardLink;
	}

	public WebElement getCalenderLink() {
		return calenderLink;
	}

	public WebElement getLeadsLink() {
		return leadsLink;
	}

	public WebElement getOrganizationsLink() {
		return organizationsLink;
	}

	public WebElement getContactsLink() {
		return contactsLink;
	}

	public WebElement getOpportunitiesLink() {
		return opportunitiesLink;
	}

	public WebElement getProductsLink() {
		return productsLink;
	}

	public WebElement getDocumentsLink() {
		return documentsLink;
	}

	public WebElement getEmailLink() {
		return emailLink;
	}

	public WebElement getMoreTab() {
		return moreTab;
	}

	public WebElement getCampaignLink() {
		return campaignLink;
	}

	public HomePage(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void logout()
	{
		wdu.moveMouseOnElement(admin, driver);
		signOut.click();
	}
	
	public OrganizationPage navigateToOrgPage()
	{
		organizationsLink.click();
		OrganizationPage op = new OrganizationPage(driver);
		return op;
	}
	
	public CampaignPage navigateToCampaignPage()
	{
		moreTab.click();
		campaignLink.click();
		return new CampaignPage(driver);
		
	}
}
