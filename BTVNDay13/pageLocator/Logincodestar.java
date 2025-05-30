package autonation.pageLocator;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import selenium.constant.CT_AccountBTVN;

public class Logincodestar {
  private WebDriver driver;

public Logincodestar(WebDriver driver) {
	super();
	this.driver = driver;
}
 public void LoginFunction(String Email, String Pass) {
	 WebElement textmail = driver.findElement(CT_AccountBTVN.Text_Email);
	 if (textmail.isDisplayed()) {
		 textmail.sendKeys(Email);
	 }
	 
	 WebElement textpass = driver.findElement(CT_AccountBTVN.Text_Pass);
	 if (textpass.isDisplayed()) {
		 textpass.sendKeys(Pass);
	 }
	 
	 WebElement BntDangNhap = driver.findElement(CT_AccountBTVN.Bnt_DangNhap);
	 if (BntDangNhap.isEnabled()) {
		 BntDangNhap.click();;
	 }
 }  
}
