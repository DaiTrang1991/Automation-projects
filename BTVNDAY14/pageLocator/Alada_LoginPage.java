package autonation.pageLocator;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Alada_LoginPage {
   private WebDriver driver;
   @FindBy(id="txtLoginUsername") WebElement TXTDN_Email;
   @FindBy(id="txtLoginPassword") WebElement TXTDN_Pass;
   @FindBy(xpath = "//button[text()='ĐĂNG NHẬP' and contains(@class, 'pass btn_submit')]") WebElement BNTDN_DANGNHAP;
public Alada_LoginPage(WebDriver driver) {
	this.driver = driver;
     PageFactory.initElements(driver, this);
}
public void LoginTK( String email, String pass) {
	TXTDN_Email.sendKeys(email);
	TXTDN_Pass.sendKeys(pass);
	BNTDN_DANGNHAP.click();
  }     
}
