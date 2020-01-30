package dynamic_wt;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class SelectCheckBoxInGmail {
	static
	{
		System.setProperty("webdriver.chrome.driver", "./driver/chromedriver.exe");
	}
	
	public static void main(String[] args) {
	WebDriver driver = new FirefoxDriver();
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	driver.get("https://accounts.google.com/");
	driver.findElement(By.id("identifierId")).sendKeys("vanitha.r54@gmail.com");
//	driver.findElement(By.xpath);
//	driver.findElement(By.xpath(xpathExpression));
//	
	}

}
