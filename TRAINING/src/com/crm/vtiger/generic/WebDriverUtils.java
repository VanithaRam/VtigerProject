package com.crm.vtiger.generic;

import java.util.Iterator;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebDriverUtils implements InterfaceAutoConst {

		public void waitForElementToLoad(WebDriver driver)
		{
			driver.manage().timeouts().implicitlyWait(ITO, TimeUnit.SECONDS);
		}
		
		public void maximizeTheWindow(WebDriver driver)
		{
			driver.manage().window().maximize();
		}
		
		public int getRandomNumber()
		{
			Random ram = new Random();
			return ram.nextInt(10000);
		}
		
		public void waitForElementToBeClickable(WebDriver driver, WebElement element)
		{
			WebDriverWait wait = new WebDriverWait(driver,ETO);
			wait.until(ExpectedConditions.elementToBeClickable(element));
		}
		
		public void waitForElementToBeVisible(WebDriver driver, WebElement element)
		{
			WebDriverWait wait = new WebDriverWait(driver,10);
			wait.until(ExpectedConditions.visibilityOf(element));
		}
		
		public void waitAndClick(WebDriver driver, WebElement element) throws InterruptedException
		{
			int count = 1;
			while(count<=20)
			{
				try
				{
					element.click();
					break;
				}
				catch(Throwable t)
				{
					Thread.sleep(1000);
					count++;
				}
			}
		}
			
			public void select(WebElement element, String option)
			{
			 Select sel= new Select(element);
			 sel.selectByVisibleText(option);
			}
				
			public void select(WebElement element, int optionIndex)
			{
			 Select sel = new Select(element);
			 sel.selectByIndex(optionIndex);
			}
				
	        public void moveMouseOnElement(WebElement element, WebDriver driver)
	        {
		     Actions act= new Actions(driver);
		     act.moveToElement(element).perform();
	        }
	   
	        public void acceptAlert(WebDriver driver)
	        {
	         driver.switchTo().alert().accept();
	        }
	   
	        public void cancelAlert(WebDriver driver)
	       {
		   driver.switchTo().alert().dismiss();
	       }

		static String parentWinID;  
		static String childWindowID;
		
		public void switchToChildWindow(WebDriver driver)
		{
			Set<String> set = driver.getWindowHandles();
			Iterator<String> it = set.iterator();
			parentWinID = it.next();
			childWindowID=it.next();
			driver.switchTo().window(childWindowID);
		}
		
		public void switchToParentWindow(WebDriver driver)
		{
			driver.switchTo().window(parentWinID);
		}
	}


