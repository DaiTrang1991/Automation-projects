package selenium.constant;

import org.openqa.selenium.By;

public class CT_Account {
      public static By TEXT_EMAIL = By.id("txtLoginUsername");
      public static By TEXT_PASS = By.id("txtLoginPassword");
      public static By BNT_DANGNHAP = By.xpath("//button[text()='ĐĂNG NHẬP' and contains(@class,'btn_submit')]");
    
}
