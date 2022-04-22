package Application_SuiteCRM;

import java.time.Duration;
import java.util.Iterator;
import java.util.List;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


public class Traversing_tables {
	WebDriver driver;
	WebDriverWait wait;


	@BeforeTest
	public void browserInvoke() throws InterruptedException {
		driver = new FirefoxDriver();
		Reporter.log("Driver object invoked successfully");
		driver.get("http://alchemy.hguy.co/crm");
		Reporter.log("Navigated to website successfully");


	}


	@Test(priority = 0)
	public void loginVerify() {
		WebElement userName = driver.findElement(By.id("user_name"));
		WebElement password = driver.findElement(By.id("username_password"));
		WebElement loginButton = driver.findElement(By.id("bigbutton"));
		userName.sendKeys("admin");
		password.sendKeys("pa$$w0rd");
		loginButton.click();
		//Assert.assertEquals("https://alchemy.hguy.co/crm/index.php?module=Home&action=index", driver.getCurrentUrl());


	}


	@Test(dependsOnMethods = { "loginVerify" })
	public void traversingTables() {
		WebElement navBar = driver.findElement(By.className("container-fluid"));
		WebElement sales = navBar.findElement(By.id("grouptab_0"));
		Actions action = new Actions(driver);
		WebElement leads = driver.findElement(By.id("moduleTab_9_Leads"));
		action.moveToElement(sales).moveToElement(leads).click().build().perform();
		wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("MassUpdate")));
		WebElement form = driver.findElement(By.id("MassUpdate"));
		List<WebElement> nameCol = form.findElements(By.xpath("//*[contains(@type,'name')]//b"));
		//List<WebElement> userCol = form.findElements(By.xpath("//*[contains(@type,'relate')]//a"));
		Iterator<WebElement> name = nameCol.iterator();
		int counter =0;

			while (name.hasNext()) {
				
				if (counter<10)
				  {					
	
			       if (counter % 2 != 0)		

			        {
					System.out.println("Name : " + nameCol.get(counter-1).getText());				
			         }	
			       
					counter++;	
				  }
				else 
					break;
				
			}	
	}
	
	@AfterMethod
	public void afterMethod() {
		// Close the browser
		driver.quit();
	}

}