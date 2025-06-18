package selenium.testsuite;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;
import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;

import selenium.common.CommonBase;
import selenium.constant.CT_pageURL;

public class BTVNDAY18_Dienmaynhapkhaugiare_Test extends CommonBase {
	 @BeforeMethod
     @Parameters("browser")
     public void openBrowser(String browser) {
    	driver = setupBrowser(browser) ;
    	driver.get(CT_pageURL.DIENMAYNHAPKHAUGIARE_URL);
     }
     
     @Test
     public void Check_ZaloMe_DienmayNK() {
      // Click icon zalo
     scrollToElement(By.xpath("//a[@href='https://zalo.me/0988169282']"));	 
     By zaloIcon = By.xpath("//a[@href='https://zalo.me/0988169282']");
     assertTrue(isElementPresent(zaloIcon));
     
     click(zaloIcon);
     
     
     // Chuyen sang tab moi
      String maintab = driver.getWindowHandle();
      Set<String> tabs = driver.getWindowHandles();
      for (String tab : tabs) {
    	 if (!tab.equals(maintab)) {
    		 driver.switchTo().window(tab);
    		 break;
    	 }
      }
      WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
      wait.until(ExpectedConditions.urlContains("zalo.me/0988169282"));
      String actualUrl = driver.getCurrentUrl();
      assertTrue(actualUrl.contains("zalo.me/0988169282"), "Không mở đúng trang Zalo mong đợi!");
      
    }
     @AfterMethod
 	public void closeDriver() {
 		driver.close();
    } 
}
