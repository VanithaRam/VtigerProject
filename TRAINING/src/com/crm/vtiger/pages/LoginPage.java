package com.crm.vtiger.pages;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.vtiger.generic.FileLibrary;

public class LoginPage 
{
	@FindBy(name="user_name")
	private WebElement usernameEdit;
	
	@FindBy(name="user_password")
	private WebElement passwordEdit;
	
	@FindBy(id="submitButton")
	private WebElement loginButton;

	public LoginPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	public void login(String username, String password)
	{
		usernameEdit.sendKeys(username);
		passwordEdit.sendKeys(password);
		loginButton.click();
	}
	
	public void login() throws IOException
	{
		FileLibrary flib = new FileLibrary();
		usernameEdit.sendKeys(flib.getDataFromProperties("username"));
		passwordEdit.sendKeys(flib.getDataFromProperties("password"));
		loginButton.click();
	}
}
