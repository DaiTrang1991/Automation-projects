package selenium.testsuite;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.*;

import autonation.pageLocator.LoginPage;
import selenium.common.CommonBase;
import selenium.constant.CT_pageURL;

public class LoginTest extends CommonBase {
    
	@BeforeMethod
	 public void openChrome () {
		driver = initChromeBrowser(CT_pageURL.ALADA_URL);
	}
	
	@AfterMethod
	public void closeChrome() {
		driver.close();
	}
	
	@Test
	public void LoginSuccessfully() {
		LoginPage login = new LoginPage(driver);
		login.LoginFunction("nguyendaitrangmk1991@gmail.com", "123456789");
		WebElement khctText = driver.findElement(By.xpath("//a[text()='Khóa học của tôi' and contains(@class,'khct')]"));
		assertTrue(khctText.isDisplayed(),"Khoa hoc cua toi khong hien thi, dang nhap that bai");
	}
	
	@Test
	public void LoginFailDD_IncorrectEmail() {
		LoginPage login = new LoginPage(driver);
		login.LoginFunction("abc123gmail.com", "123456789");
		WebElement emailsaiDD = driver.findElement(By.xpath("//label[text()='Vui lòng nhập email hợp lệ']"));
		assertTrue(emailsaiDD.isDisplayed());
	} 
	@Test
	public void LoginFailEmail() {
		LoginPage login = new LoginPage(driver);
		login.LoginFunction("nguyendaitrang123mk@gmail.com", "123456789");
		WebElement EmailSai = driver.findElement(By.xpath("//p[text()='Email này chưa được đăng ký.']"));
		assertTrue(EmailSai.isDisplayed());
	}
	
	@Test
	public void LoginFail_IncorrectPass() {
		LoginPage login = new LoginPage(driver);
		login.LoginFunction("nguyendaitrangmk@gmail.com", "12345");
		WebElement PassFail = driver.findElement(By.xpath("//p[text()='Mật khẩu sai.']"));
		assertTrue(PassFail.isDisplayed());
	}
}
