package selenium.testsuite;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.By;
import org.testng.annotations.*;

import selenium.common.CommonBase;
import selenium.constant.CT_pageURL;

public class BTVNDAY17_MediaMart_Test extends CommonBase {
   @BeforeMethod
   public void openChromeBrowser() {
	   driver = initChromeBrowser(CT_pageURL.MEDIAMART_URL);
   }
   
   @Test
   public void handleIframe() {
	   scrollToElement(By.xpath("//iframe[contains(@src, 'zalo')]"));
	   driver.switchTo().frame(0);
	   click(By.xpath("//div[@class='za-chat__head-box']"));
	   click(By.xpath("//div[text()='Chat nhanh']"));
	   assertTrue(isElementPresent(By.xpath("//div[text()='Xin chào! Siêu thị điện máy MediaMart rất vui được hỗ trợ bạn.']")));
   }
   
}
