package selenium.testsuite;

import static org.testng.Assert.assertTrue;
import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import selenium.common.CommonBase;
import selenium.constant.CT_pageURL;

public class Day19_BepGas_CTSP extends CommonBase {
	   @BeforeMethod
	   @Parameters("browser")
	public void openBrowser (@Optional("chrome")  String browser) {
		  driver= setupBrowser(browser);
		  driver.get(CT_pageURL.BEPANTOAN_URL);
	   }
	public void jsClick(WebElement element) {
		   JavascriptExecutor js = (JavascriptExecutor) driver;
		   js.executeScript("arguments[0].click()",element);
	   }
	@Test
	public void ChitietSP_DM() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
		  
		  scrollToElement(By.xpath("//a[contains(text(),'Bếp Gas')]")); 
		  click(By.xpath("//a[contains(text(),'Bếp Gas')]"));
		  WebElement heading = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h1[contains(text(),'Bếp gas chính hãng, bảo hành dài hạn, giá rẻ nhất toàn quốc')]")));
	 	  String actualtext = heading.getText();
	 	  System.out.println("Alert Message" +actualtext);
	 	  assertTrue(actualtext.equalsIgnoreCase("Bếp gas chính hãng, bảo hành dài hạn, giá rẻ nhất toàn quốc"), "Text không khớp nội dung mong đợi!");
		  
		   By bepGasDuong = By.xpath("//a[contains(text(),'Bếp Gas Dương')]");
		   scrollToElement(By.xpath("//a[contains(text(),'Bếp Gas Dương')]")); 
		   WebElement bepGasDuonglink = wait.until(ExpectedConditions.elementToBeClickable(bepGasDuong));
		   jsClick(bepGasDuonglink);
		   WebElement headingbepgasduong = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h1[contains(text(),'Bếp Gas Dương')]")));
		   String textbepgaduong = headingbepgasduong.getText();
		   System.out.println("Alert Message" +textbepgaduong);
		   assertTrue(textbepgaduong.equalsIgnoreCase("Bếp Gas Dương"), "Text không khớp nội dung mong đợi!");
		   
		   By CTSP = By.xpath("//h4[contains(text(),'Bếp gas dương Canaval CA 338')]");
		   scrollToElement(CTSP);
		   WebElement CTSPlink = wait.until(ExpectedConditions.elementToBeClickable(CTSP));
		   System.out.println("Link chuẩn bị click: " + CTSPlink.getAttribute("href"));
		   jsClick(CTSPlink);

		   String CTSPUrl = driver.getCurrentUrl();
		   System.out.println("CTSP URL: " + CTSPUrl);
		   assertTrue(CTSPUrl.contains("/bep-gas-duong-canaval-ca-338"), "Link không chứa URL mong đợi. CTSP: " + CTSPUrl);

	}
	
}
