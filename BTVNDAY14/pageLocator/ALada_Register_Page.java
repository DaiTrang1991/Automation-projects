package autonation.pageLocator;

import java.time.Duration;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ALada_Register_Page {
   private WebDriver driver; 
   @FindBy(id="txtFirstname") WebElement TxtName;
   @FindBy(id="txtEmail") WebElement TxtEmail;
   @FindBy(id="txtCEmail") WebElement TxtNLEmail;
   @FindBy(id="txtPassword") WebElement TxtPass;
   @FindBy(id="txtCPassword") WebElement TxtNLPass;
   @FindBy(id = "txtPhone") WebElement TxtPhone;
   @FindBy(id="chkRight") WebElement Chk;
   @FindBy(xpath = "//button[@type ='submit']") WebElement BntDangKy;
   
 public ALada_Register_Page(WebDriver driver) {
	this.driver = driver;
	PageFactory.initElements(driver, this);
  }

public void RegisterFunction(String hovaten, String email, String NLemail, String pass, String NLpass, String phone) {
	TxtName.sendKeys(hovaten);
	TxtEmail.sendKeys(email);
	TxtNLEmail.sendKeys(NLemail);
	TxtPass.sendKeys(pass);
	TxtNLPass.sendKeys(NLpass);
	TxtPhone.sendKeys(phone);
	Chk.click();
	BntDangKy.click();
	
  }
public String getAlertTextAndAccept() {
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
    Alert alert = wait.until(ExpectedConditions.alertIsPresent());
    String text = alert.getText();
    alert.accept();
    return text;
 }

}
