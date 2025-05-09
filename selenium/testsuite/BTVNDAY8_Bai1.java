package selenium.testsuite;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import selenium.common.CommonBase;

public class BTVNDAY8_Bai1 extends CommonBase{
	String URL = "https://selectorshub.com/xpath-practice-page/";
	@Test
	public void UserEmail() {
		driver = initChromeBrowser(URL);

		WebElement emailname = driver.findElement(By.name("email"));
		System.out.println("Name of Email: "+emailname);
		
		WebElement textemail = driver.findElement(By.xpath("//input[@placeholder='Enter email']"));
		textemail.sendKeys("user@example.com");
		System.out.println("Email: " +textemail);
	
	}
	
	@Test
	public void Password() {
		driver =initChromeBrowser(URL);
		
		WebElement passname = driver.findElement(By.name("Password"));
		System.out.println("Name of Password: " +passname);
		
		WebElement textpass = driver.findElement(By.xpath("//input[@placeholder = 'Enter Password']"));
		textpass.sendKeys("Password");
		System.out.println("Password: "+textpass);
	}
	
	@Test
	public void Company() {
		driver = initChromeBrowser(URL);
		WebElement companyname = driver.findElement(By.name("company"));
		System.out.println("Nam of Company: " +companyname);
		
		WebElement textcompany = driver.findElement(By.xpath("//input[@placeholder='Enter your company']"));
		textcompany.sendKeys("company");
		System.out.println("Company: " +textcompany);
		
	}
   @Test
	public void MobileNumber() {
		driver = initChromeBrowser(URL);
		WebElement number = driver.findElement(By.name("mobile number"));
		System.out.println("Mobile Number: " +number);
		
		WebElement Number = driver.findElement(By.xpath("//input[@placeholder='Enter your mobile number']"));
		Number.sendKeys("number");
		System.out.println("Company: " +Number);
		
	}
}
