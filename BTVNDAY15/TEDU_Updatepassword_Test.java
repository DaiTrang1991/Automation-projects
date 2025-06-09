package selenium.testsuite;
import static org.testng.Assert.assertTrue;
import org.openqa.selenium.By;
import org.testng.annotations.*;
import autonation.pageLocator.TEDU_Login_Page;
import autonation.pageLocator.TEDU_UpdatePassword_Page;
import selenium.common.CommonBase;
import selenium.constant.CT_pageURL;

public class TEDU_Updatepassword_Test extends CommonBase {
	String pass1="1234567";
	String pass2="12345678";
	@BeforeMethod
	 public void openChromeBrowser() {
		 driver = initChromeBrowser(CT_pageURL.TEDU_URL);
		 TEDU_Login_Page login = new TEDU_Login_Page(driver);
		 login.loginFunction("nguyendaitrangmk@gmail.com", pass1);
	 }
	
	
	@Test
     public void updatePass_NoSuccessfully() {
    	 TEDU_UpdatePassword_Page updatepass = new TEDU_UpdatePassword_Page(driver);
    	 updatepass.UpdatePassword(pass1, pass2);
    	 assertTrue(driver.findElement(By.xpath("//div[text() ='Đổi mật khẩu thành công. Mời bạn đăng nhập lại.']")).isDisplayed());
}
     
    @Test
     public void Search() {
    	 TEDU_Login_Page search = new TEDU_Login_Page(driver);
    	 search.Search_Key("ASP Net");
    	assertTrue(driver.findElement(By.xpath("//input[@placeholder='Tìm bất cứ thứ gì mà bạn muốn']")).isDisplayed());
     }
}
