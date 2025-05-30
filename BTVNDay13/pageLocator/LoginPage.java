package autonation.pageLocator;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import selenium.constant.CT_Account;

public class LoginPage {
     private WebDriver driver;

	public LoginPage(WebDriver _driver) {
		super();
		this.driver = _driver;
	}
     public void LoginFunction(String email, String pass) {
    	 WebElement textEmail = driver.findElement(CT_Account.TEXT_EMAIL);
    	 if(textEmail.isDisplayed()) {
    		textEmail.sendKeys(email); 
    	 }
    	 
    	 WebElement textPass = driver.findElement(CT_Account.TEXT_PASS);
    			 if (textPass.isDisplayed()) {
    				textPass.sendKeys(pass); 
    			 }
    	 WebElement bntDangnhap = driver.findElement(CT_Account.BNT_DANGNHAP);
    	         if(bntDangnhap.isEnabled()) {
    	        	 bntDangnhap.click();
    	         }
     }
  }
