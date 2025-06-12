package selenium.testsuite;

import static org.testng.Assert.assertEquals;
import java.time.Duration;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;
import selenium.common.CommonBase;
import selenium.constant.CT_pageURL;

public class BTVNDAY16_Bai2 extends CommonBase {
     @BeforeMethod
     
     public void openChromeBowser() {
    	 driver = initChromeBrowser(CT_pageURL.SELENIUM_PRACTISE_URL);
     }
     @Test
     public void AssertText() {
    	 click(By.xpath("//button[@onclick='myFunction()']"));
    	 WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    	 Alert alert = wait.until(ExpectedConditions.alertIsPresent());
    	 String alertText = alert.getText();
    	 System.out.println("Alert Message" +alertText);
  	     assertEquals(alertText,"Welcome to Selenium WebDriver Tutorials");
     } 
}
