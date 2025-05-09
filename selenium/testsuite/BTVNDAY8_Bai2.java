package selenium.testsuite;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import selenium.common.CommonBase;

public class BTVNDAY8_Bai2 extends CommonBase{
	String URL = "https://automationfc.github.io/basic-form/index.html";
	
  @Test
  public void Name() {
	  driver = initChromeBrowser(URL);
	  WebElement textName = driver.findElement(By.id("name"));
	  System.out.println("Name is: " +textName);
  }
  
  @Test
  public void Address() {
	  driver = initChromeBrowser(URL);
	  WebElement textAddress = driver.findElement(By.id("address"));
	  System.out.println("Address is: " +textAddress);
		  
	  }
	
   @Test
   public void Email() {
	   driver =initChromeBrowser(URL);
	   WebElement textEmail = driver.findElement(By.id("email"));
	   System.out.println("Email is: " +textEmail);
   }
   
   @Test
   public void Password() {
	   driver = initChromeBrowser(URL);
	   WebElement pass = driver.findElement(By.id("password"));
	   System.out.println("Password is: " +pass);
   }
   
   @Test
   public void Button() {
	  driver = initChromeBrowser(URL) ;
	  WebElement btSubmit = driver.findElement(By.xpath("//button[@value ='Submit']"));
	  System.out.println("Submit :" +btSubmit);
	  
	  WebElement btReset = driver.findElement(By.xpath("//button[@value ='Reset']"));
	  System.out.println("Reset :" +btReset);
   }
  }
