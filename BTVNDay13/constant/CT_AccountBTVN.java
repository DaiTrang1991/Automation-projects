package selenium.constant;

import org.openqa.selenium.By;

public class CT_AccountBTVN {
   public static By Text_Email = By.id("email");
   public static By Text_Pass = By.id("password");
   public static By Bnt_DangNhap = By.xpath("//button[text()='Đăng nhập' and contains(@class, 'btn btn-success')]");
}
