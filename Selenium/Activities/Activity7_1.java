
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class Activity7_1 {
public static void main(String[] args) {
    WebDriver driver = new FirefoxDriver();
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

    //Open browser
    driver.get("https://training-support.net/selenium/dynamic-attributes");

    
    //Get hte tile
   System.out.println( driver.getTitle());
   
   
   //finding user name and password
   
   WebElement username = driver.findElement(By.xpath("//*[@id=\"dynamic-attributes-form\"]/div/div[1]/input"));
   WebElement password = driver.findElement(By.xpath("//*[@id=\"dynamic-attributes-form\"]/div/div[2]/input"));
   
   WebElement login = driver.findElement(By.xpath(" //*[@id=\"dynamic-attributes-form\"]/div/button"));

   
   username.sendKeys("admin");
 
   password.sendKeys("password");
   
   //click on login
   login.click();
   //wait untile welcome message apears
   
   wait.until(ExpectedConditions.textToBePresentInElementLocated(By.id("action-confirmation"), "Welcome Back, admin"));
   
   String welcometest=driver.findElement(By.id("action-confirmation")).getText();
   
   System.out.println(welcometest);
   
   //driver.close();
    
   
}
}
   
   