package selenium.testsuite;

import static org.testng.Assert.assertTrue;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;
import autonation.pageLocator.ALada_Register_Page;
import autonation.pageLocator.Alada_Edit_Page;
import autonation.pageLocator.Alada_LoginPage;
import selenium.common.CommonBase;
import selenium.constant.CT_pageURL;

public class Alada_Faction_EditinforTest extends CommonBase{
	@BeforeMethod
	public void initChromeBrowser() {
		   driver = initChromeBrowser(CT_pageURL.ALADA_URL);
	   }
	 public void LoginAlada(String email, String pass) {
		 Alada_LoginPage login = new Alada_LoginPage(driver);
		 login.LoginTK("nguyendaitrang90@gmail.com", "123456789");
		 WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
		 boolean Redirected = wait.until(driver -> driver.getCurrentUrl().contains("https://alada.vn/"));
		 assertTrue(Redirected, "Điều hướng url thất bại");
	 }
	 @Test
	  public void EditInfor() {
		 LoginAlada("nguyendaitrang90@gmail.com","123456789");
		// Bước 2: Click icon tài khoản
		    FluentWait<WebDriver> wait = new FluentWait<WebDriver>(driver);
	        WebElement userIcon = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='avatar2']")));
	        userIcon.click();

	        // Bước 3: Click "Chỉnh sửa thông tin"
	        WebElement editInfo = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[contains(text(),'Chỉnh sửa thông tin')]")));
	        editInfo.click();
	      // Buoc 4: Chinh sua thong tin
		   Alada_Edit_Page factory = new Alada_Edit_Page(driver);
		   factory.EditInFor("nguyendaitrang90@gmail.com", "123456789", "1234567", "1234567");
		   String alertText = factory.getAlertTextAndAccept();
		  Assert.assertFalse(alertText.contains("Rất tiếc Mật khẩu hiện tại chưa chính xác!"));
	   }
}
