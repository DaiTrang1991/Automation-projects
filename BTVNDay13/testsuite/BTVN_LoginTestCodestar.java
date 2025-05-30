package selenium.testsuite;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;
import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.*;
import autonation.pageLocator.LoginPage;
import autonation.pageLocator.Logincodestar;
import selenium.common.CommonBase;
import selenium.constant.CT_AccountBTVN;
import selenium.constant.CT_pageURL;

public class BTVN_LoginTestCodestar extends CommonBase {
	
	@BeforeMethod
    public void openFireFox() {
    	driver = initFireFoxBrowser(CT_pageURL.CODESTAR_URL);
    }
	
	@AfterMethod
	public void closeFireFox() {
		driver.close();
	}
	
	@Test
	public void LoginSuccessfully() {
		Logincodestar login = new Logincodestar(driver);
		login.LoginFunction("admin@gmail.com", "12345678");
		WebElement dntc = driver.findElement(By.xpath("//a[@id='dropdownMenuLink']"));
		assertTrue(dntc.isDisplayed(), "Tai khoan cua toi dang nhap khong thanh cong");
	}
	@Test
	public void LoginFail_IncorrectEmail() {
		Logincodestar login = new Logincodestar(driver);
		login.LoginFunction("admi@gmail.com", "12345678");
		WebElement dntbEmail = driver.findElement(By.xpath("//span[contains(text(),'Email hoặc mật khẩu không đúng')]"));
		assertTrue(dntbEmail.isEnabled());
	}
	 
	@Test
	 public void LoginFail_IncorrectPass() {
		 Logincodestar login = new Logincodestar(driver);
		 login.LoginFunction("admin@gmail.com", "12345");
		 WebElement dntbPass = driver.findElement(By.xpath("//span[contains(text(),'Email hoặc mật khẩu không đúng')]"));
		 assertTrue(dntbPass.isEnabled());
	 }
	 
	 @Test
	 public void LoginFail_IncorrectEmailPass() {
		 Logincodestar login = new Logincodestar(driver);
		 login.LoginFunction("admi@gmail.com", "12345");
		 WebElement dntb = driver.findElement(By.xpath("//span[contains(text(),'Email hoặc mật khẩu không đúng')]"));
		 assertTrue(dntb.isEnabled());
	 }
	 
	@Test
	 public void Logout() {
		 Logincodestar logout = new Logincodestar(driver);
		 logout.LoginFunction("admin@gmail.com", "12345678");
		 WebElement logtc = driver.findElement(By.xpath("//button[@type = 'button' and contains (text(),'Đăng xuất')]"));
		 assertTrue(logtc.isEnabled(),"Logout that bai");
		 
	 }
}
