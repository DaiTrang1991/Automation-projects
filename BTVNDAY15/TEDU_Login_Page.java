package autonation.pageLocator;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TEDU_Login_Page {
	   private WebDriver driver;
	   @FindBy (xpath = "//a[@title='Đăng nhập']") WebElement linkDangNhap;
	   @FindBy (name = "UserName") WebElement textUserName;
	   @FindBy (name = "Password")WebElement textPassword;
	   @FindBy (xpath ="//button[@type='submit' and contains (text(),'Đăng nhập')]") WebElement bntDangNhap;
	   @FindBy (name = "keyword") WebElement TextKey;
	   @FindBy (xpath = "//button[@type='submit']") WebElement iconSearch;
	    
	   public TEDU_Login_Page(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void loginFunction (String email, String pass) {
		   JavascriptExecutor js = (JavascriptExecutor) driver;
		   js.executeScript("arguments[0].click();", linkDangNhap);
		   //linkDangNhap.click();
		   textUserName.sendKeys(email);
		   textPassword.sendKeys(pass);
		   bntDangNhap.click();
	   }
	public void Search_Key(String Key) {
		TextKey.clear();
		TextKey.sendKeys(Key);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", iconSearch);
	}
}
