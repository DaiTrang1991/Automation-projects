package autonation.pageLocator;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TEDU_UpdatePassword_Page {
	private WebDriver driver;
   @FindBy (id = "my_account") WebElement iconTK;
   @FindBy (xpath = "//a[@title='Đổi mật khẩu']") WebElement buttonDoimatkhau;
   @FindBy (id = "OldPassword") WebElement textOldPassword;
   @FindBy (id = "NewPassword") WebElement textNewPassword;
   @FindBy (id = "ConfirmNewPassword") WebElement textConfirmNewPassword;
   @FindBy (xpath = "//input[@value='Cập nhật']") WebElement bntCapNhat;
 
 
   public TEDU_UpdatePassword_Page(WebDriver driver) {
	this.driver = driver;
	PageFactory.initElements(driver,this);
}
   public void UpdatePassword (String Oldpass, String newpass) {
	   iconTK.click();
	   JavascriptExecutor js = (JavascriptExecutor) driver;
	   js.executeScript("arguments[0].click();", buttonDoimatkhau);
	   textOldPassword.sendKeys(Oldpass);
	   textNewPassword.sendKeys(newpass);
	   textConfirmNewPassword.sendKeys(newpass);
	   bntCapNhat.click();
   }
   
}
   