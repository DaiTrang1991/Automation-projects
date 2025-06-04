package autonation.pageLocator;

import java.time.Duration;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Alada_Edit_Page {
  private WebDriver driver;
  @FindBy(xpath = "//input[@value='nguyendaitrang90@gmail.com']") WebElement TxtTendangnhap;
  @FindBy(id="txtpassword") WebElement TxtPassHT;
  @FindBy(id="txtnewpass") WebElement TxtPassNew;
  @FindBy(id = "txtrenewpass") WebElement TxtNLPassNew;
  @FindBy (xpath = "//button[text()='Lưu mật khẩu mới']") WebElement BntLuuNewPass;
public Alada_Edit_Page(WebDriver driver) {
	this.driver = driver;
	PageFactory.initElements(driver, this);
}
public void EditInFor(String email, String pass, String newpass, String renewpass ) {
	String oldEmail = TxtTendangnhap.getAttribute("nguyendaitrang90@gmail.com");
	TxtPassHT.sendKeys(pass);
	TxtPassNew.sendKeys(newpass);
	TxtNLPassNew.sendKeys(renewpass);
	BntLuuNewPass.click();
  } 
public String getAlertTextAndAccept() {
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
    Alert alert = wait.until(ExpectedConditions.alertIsPresent());
    String text = alert.getText();
    alert.accept();
    return text;
 }
}
