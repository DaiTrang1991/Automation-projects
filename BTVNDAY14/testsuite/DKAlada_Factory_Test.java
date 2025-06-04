package selenium.testsuite;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.*;
import autonation.pageLocator.ALada_Register_Page;
import selenium.common.CommonBase;
import selenium.constant.CT_Account_Dangky_Alada;
import selenium.constant.CT_pageURL;

public class DKAlada_Factory_Test extends CommonBase {
   @BeforeMethod
   public void initChromeBrowser() {
	   driver = initChromeBrowser(CT_pageURL.ALADA_URL_DANGKY);
   }
   
   @Test
   public void InputDangky() {
	   ALada_Register_Page factory = new ALada_Register_Page(driver);
	   factory.RegisterFunction("Nguyen Dai Trang", "nguyendaitrang90@gmail.com", "nguyendaitrang90@gmail.com", "123456789", "123456789", "0868406335");
	   assertTrue(driver.findElement(By.xpath("//button[@type='submit']")).isDisplayed());
   }
   
   @Test
   public void DangkyFail_Emailduplicate() {
	   ALada_Register_Page factory = new ALada_Register_Page(driver);
	   factory.RegisterFunction("Nguyen Dai Trang", "nguyendaitrang90@gmail.com", "nguyendaitrang90@gmail.com", "123456789", "123456789", "0868406335");
	   String alertText = factory.getAlertTextAndAccept();
	  Assert.assertFalse(alertText.contains("alada cho biet da bị trung email vui long chon email khac"));
   }
   @Test
   public void DangkyFail_InvalidEmail() {
	   ALada_Register_Page factory = new ALada_Register_Page(driver);
	   factory.RegisterFunction("Nguyen Dai Trang", "nguyendaitrangmail.com", "nguyendaitrangmail.com", "123456789", "123456789", "0868406335");
	   assertTrue(driver.findElement(By.xpath("//label[@Id='txtEmail-error']")).isDisplayed());
   }
   
   @Test
   public void DangkyFail_EmailSai() {
	   ALada_Register_Page factory = new ALada_Register_Page(driver);
	   factory.RegisterFunction("Nguyen Dai Trang", "nguyendaitrang@mail.com", "nguyendaitrangmail.com", "123456789", "123456789", "0868406335");
	   assertTrue(driver.findElement(By.xpath("//label[@Id='txtCEmail-error']")).isDisplayed());
   }
   @Test
   public void DangkyFail_PassSai() {
	   ALada_Register_Page factory = new ALada_Register_Page(driver);
	   factory.RegisterFunction("Nguyen Dai Trang", "nguyendaitrang@mail.com", "nguyendaitrangmail.com", "123456789", "1234567", "0868406335");
	   assertTrue(driver.findElement(By.xpath("//label[@id='txtCPassword-error']")).isDisplayed());
   }
   
   @Test
   public void DangkyFail_PhoneSai() {
	   ALada_Register_Page factory = new ALada_Register_Page(driver);
	   factory.RegisterFunction("Nguyen Dai Trang", "nguyendaitrang@mail.com", "nguyendaitrangmail.com", "123456789", "1234567", "08684035");
	   assertTrue(driver.findElement(By.xpath("//label[@id='txtPhone-error']")).isDisplayed());
   }
}
