package selenium.constant;

import org.openqa.selenium.By;

public class CT_Account_DangNhap_Alada {
  public static By TXTDN_Email = By.id("txtLoginUsername");
  public static By TXTDN_Pass = By.id("txtLoginPassword");
  public static By BNTDN_DANGNHAP = By.xpath("//button[text()='ĐĂNG NHẬP' and contains(@class, 'pass btn_submit')]");
}
