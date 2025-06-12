package selenium.testsuite;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;
import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;
import autonation.pageLocator.Logincodestar;
import selenium.common.CommonBase;
import selenium.constant.CT_pageURL;


public class BTVNDAY16_Bai1 extends CommonBase {
@BeforeMethod
   public void openFireFoxBrowser() {
	   driver = initFireFoxBrowser(CT_pageURL.CODESTAR_URL);
   }
   
  @Test (priority = 1)
   public void LoginSuccessfully() {
		Logincodestar login = new Logincodestar(driver);
		login.LoginFunction("admin@gmail.com", "12345678");
		WebElement dntc = driver.findElement(By.xpath("//a[@id='dropdownMenuLink']"));
		assertTrue(dntc.isDisplayed(), "Tai khoan cua toi dang nhap khong thanh cong");
	}
   
  @Test(priority = 2)
   public void Add_KLV_Successfully() {
	   Logincodestar login = new Logincodestar(driver);
	   login.LoginFunction("admin@gmail.com", "12345678");
	   click(By.xpath("//a[@href='http://test-system.crmstar.vn/work-space-management']"));
	   click(By.xpath("//button[text()='Thêm mới']"));
	   type(By.name("work_areas_code"),"AB010");
	   type(By.name("name"),"NguyenDaiTrang91");
	   click(By.xpath("//button[text()='Lưu']"));
	  
	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
	    By confirmText = By.xpath("//div[contains(@class,'modal-content')]//div[contains(text(),'Bạn có thực sự muốn thêm khu vực này') or contains(.,'thêm khu vực này')]");
	    wait.until(ExpectedConditions.presenceOfElementLocated(confirmText));
	    wait.until(ExpectedConditions.visibilityOfElementLocated(confirmText));
	    String modalText = driver.findElement(confirmText).getText().trim();
	    System.out.println("Modal text: " + modalText);
	    assertTrue(modalText.contains("Bạn có thực sự muốn thêm khu vực này"));

	   click(By.xpath("//button[text()='Thêm']"));
	   
	   boolean Redirected = wait.until(driver -> driver.getCurrentUrl().contains("http://test-system.crmstar.vn/work-space-management"));
	    assertTrue(Redirected, "Them khu vuc that bai");
   }
   @Test(priority = 3)
   public void Add_KLV_Fail() {
	   Logincodestar login = new Logincodestar(driver);
	   login.LoginFunction("admin@gmail.com", "12345678");
	   click(By.xpath("//a[@href='http://test-system.crmstar.vn/work-space-management']"));
	   click(By.xpath("//button[text()='Thêm mới']"));
	   type(By.name("work_areas_code"),"AB010");
	   type(By.name("name"),"NguyenDaiTrang91");
	   click(By.xpath("//button[text()='Lưu']"));
	  
	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
	    By confirmText = By.xpath("//div[contains(@class,'modal-content')]//div[contains(text(),'Bạn có thực sự muốn thêm khu vực này') or contains(.,'thêm khu vực này')]");
	    wait.until(ExpectedConditions.presenceOfElementLocated(confirmText));
	    wait.until(ExpectedConditions.visibilityOfElementLocated(confirmText));
	    String modalText = driver.findElement(confirmText).getText().trim();
	    System.out.println("Modal text: " + modalText);
	    assertTrue(modalText.contains("Bạn có thực sự muốn thêm khu vực này"));

	   click(By.xpath("//button[text()='Thêm']"));
	    assertTrue(isElementPresent(By.xpath("//span[text()='Mã khu vực đã tồn tại']")));
  }
 
   @Test (priority = 4)
   public void Delete_KLV_Successfully() {
	   Logincodestar login = new Logincodestar(driver);
	   login.LoginFunction("admin@gmail.com", "12345678");
	   click(By.xpath("//a[@href='http://test-system.crmstar.vn/work-space-management']"));
	   click(By.xpath("//input[@placeholder='Nhập từ khóa cần tìm kiếm']"));
	   WebElement searchBox = driver.findElement(By.name("query"));
	   searchBox.clear();
	   searchBox.sendKeys("NguyenDaiTrang91");
	   click(By.xpath("//button[text()='Tìm kiếm']"));
	   
	   WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	   click(By.xpath("//a[@class='btn btn-success' and contains(text(),'Xóa')]"));
	   String actualText = driver.switchTo().alert().getText();
	   String expectText = "Bạn có thực sự muốn xóa khu vực này";
	   assertEquals(actualText, expectText);
	   driver.switchTo().alert().accept();
	   boolean Delete = wait.until(driver -> driver.getCurrentUrl().contains("query=NguyenDaiTrang91"));
	    assertTrue(Delete, "Them khu vuc that bai");
	 
   }
}

