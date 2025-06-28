package selenium.testsuite;
import static org.testng.Assert.assertTrue;
import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;
import selenium.common.CommonBase;
import selenium.constant.CT_pageURL;

public class DAY19_Bepantoan_Bepgas_Test extends CommonBase {
   @BeforeMethod
   @Parameters("browser")
   public void openBrowser (@Optional("firefox")  String browser) {
	  driver= setupBrowser(browser);
	  driver.get(CT_pageURL.BEPANTOAN_URL);
   }
public void jsClick(WebElement element) {
	   JavascriptExecutor js = (JavascriptExecutor) driver;
	   js.executeScript("arguments[0].click()",element);
   }
   

   @Test
   public void Check_BepGas_Danhmuc() {
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
	   
	   
   }
   
   @Test
   public void Check_BepGas_Hangsx() throws InterruptedException {
	     WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
	     
	     scrollToElement(By.xpath("//a[contains(text(),'Bếp Gas')]")); 
		  click(By.xpath("//a[contains(text(),'Bếp Gas')]"));
		  WebElement heading = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h1[contains(text(),'Bếp gas chính hãng, bảo hành dài hạn, giá rẻ nhất toàn quốc')]")));
	 	  String actualtext = heading.getText();
	 	  System.out.println("Alert Message" +actualtext);
	 	  assertTrue(actualtext.equalsIgnoreCase("Bếp gas chính hãng, bảo hành dài hạn, giá rẻ nhất toàn quốc"), "Text không khớp nội dung mong đợi!");
		  
		   By bepGashang = By.xpath("//a[contains(@href, '/danh-muc/bep-gas/bosch')]");
		   wait.until(ExpectedConditions.presenceOfElementLocated(bepGashang));
		   scrollToElement(bepGashang);
		   Thread.sleep(500);
		   wait.until(ExpectedConditions.visibilityOfElementLocated(bepGashang));
		   WebElement bepGashanglink = wait.until(ExpectedConditions.elementToBeClickable(bepGashang));
		   jsClick(bepGashanglink);
		   WebElement headingbepgashang = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h4[contains(text(),'BOSCH')]")));
		   String textbepgashang = headingbepgashang.getText();
		   System.out.println("Alert Message" +textbepgashang);
		   assertTrue(textbepgashang.trim().toLowerCase().contains("bosch"), "Khong dung hang san xuat" +textbepgashang + " ' ");
   }
   
   @Test
   public void Check_BepGas_Mucgia() {
		  WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
		  
		  scrollToElement(By.xpath("//a[contains(text(),'Bếp Gas')]")); 
		  click(By.xpath("//a[contains(text(),'Bếp Gas')]"));
		  WebElement heading = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h1[contains(text(),'Bếp gas chính hãng, bảo hành dài hạn, giá rẻ nhất toàn quốc')]")));
	 	  String actualtext = heading.getText();
	 	  System.out.println("Alert Message" +actualtext);
	 	  assertTrue(actualtext.equalsIgnoreCase("Bếp gas chính hãng, bảo hành dài hạn, giá rẻ nhất toàn quốc"), "Text không khớp nội dung mong đợi!");
		  
		   By bepGaskhoangtien = By.xpath("//span[contains(text(), '3.000.000 > 5.000.000')]");
		   scrollToElement(By.xpath("//span[contains(text(), '3.000.000 > 5.000.000')]")); 
		   WebElement bepGaskhoangtienlink = wait.until(ExpectedConditions.elementToBeClickable(bepGaskhoangtien));
		   jsClick(bepGaskhoangtienlink);
		   String actualUrl = driver.getCurrentUrl();
		   System.out.println("Actual URL: " + actualUrl);
		   assertTrue(actualUrl.contains("/bep-gas?price=3000000-5000000&page=1"), "Link không chứa URL mong đợi. Actual: " + actualUrl);
 }
   
   @Test
   public void Check_BepGas_Xuatxu() {
		  WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
		  
		  scrollToElement(By.xpath("//a[contains(text(),'Bếp Gas')]")); 
		  click(By.xpath("//a[contains(text(),'Bếp Gas')]"));
		  WebElement heading = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h1[contains(text(),'Bếp gas chính hãng, bảo hành dài hạn, giá rẻ nhất toàn quốc')]")));
	 	  String actualtext = heading.getText();
	 	  System.out.println("Alert Message" +actualtext);
	 	  assertTrue(actualtext.equalsIgnoreCase("Bếp gas chính hãng, bảo hành dài hạn, giá rẻ nhất toàn quốc"), "Text không khớp nội dung mong đợi!");
		  
		   By bepGasxuatxu = By.xpath("//input[@id='england-1027']");
		   scrollToElement(By.xpath("//input[@id='england-1027']")); 
		   WebElement bepGasxuatxulink  = wait.until(ExpectedConditions.elementToBeClickable(bepGasxuatxu));
		   jsClick(bepGasxuatxulink);
		   String xuatxuUrl = driver.getCurrentUrl();
		   System.out.println("Actual URL: " + xuatxuUrl);
		   assertTrue(xuatxuUrl.contains("/bep-gas?opt-xuat-xu=1027&page=1"), "Link xuat xu không chứa URL mong đợi. XuatxuURL: " + xuatxuUrl);
 }  
   
   @Test
   public void Check_BepGas_Sobep() {
		  WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
		  
		  scrollToElement(By.xpath("//a[contains(text(),'Bếp Gas')]")); 
		  click(By.xpath("//a[contains(text(),'Bếp Gas')]"));
		  WebElement heading = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h1[contains(text(),'Bếp gas chính hãng, bảo hành dài hạn, giá rẻ nhất toàn quốc')]")));
	 	  String actualtext = heading.getText();
	 	  System.out.println("Alert Message" +actualtext);
	 	  assertTrue(actualtext.equalsIgnoreCase("Bếp gas chính hãng, bảo hành dài hạn, giá rẻ nhất toàn quốc"), "Text không khớp nội dung mong đợi!");
		  
		   By bepGassobep = By.xpath("//input[@id='2-bep-1007']");
		   scrollToElement(By.xpath("//input[@id='2-bep-1007']")); 
		   WebElement bepGassobeplink  = wait.until(ExpectedConditions.elementToBeClickable(bepGassobep));
		   jsClick(bepGassobeplink);
		   String sobepUrl = driver.getCurrentUrl();
		   System.out.println("Actual URL: " + sobepUrl);
		   assertTrue(sobepUrl.contains("/bep-gas?opt-so-bep=1007&page=1"), "Link xuat xu không chứa URL mong đợi. XuatxuURL: " + sobepUrl);
 }  
   @Test
   public void Check_BepGas_Kichthuoc() {
		  WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
		  
		  scrollToElement(By.xpath("//a[contains(text(),'Bếp Gas')]")); 
		  click(By.xpath("//a[contains(text(),'Bếp Gas')]"));
		  WebElement heading = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h1[contains(text(),'Bếp gas chính hãng, bảo hành dài hạn, giá rẻ nhất toàn quốc')]")));
	 	  String actualtext = heading.getText();
	 	  System.out.println("Alert Message" +actualtext);
	 	  assertTrue(actualtext.equalsIgnoreCase("Bếp gas chính hãng, bảo hành dài hạn, giá rẻ nhất toàn quốc"), "Text không khớp nội dung mong đợi!");
		  
		   By bepGasKT = By.xpath("//input[@id='800-mm-1067']");
		   scrollToElement(By.xpath("//input[@id='800-mm-1067']")); 
		   WebElement bepGasKTlink  = wait.until(ExpectedConditions.elementToBeClickable(bepGasKT));
		   jsClick(bepGasKTlink);
		   String KTUrl = driver.getCurrentUrl();
		   System.out.println("Actual URL: " + KTUrl);
		   assertTrue(KTUrl.contains("/bep-gas?opt-kich-thuoc=1067&page=1"), "Link xuat xu không chứa URL mong đợi. KichthuocURL: " + KTUrl);
  }
   
   @Test
   public void Check_BepGas_Phobien() {
		  WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
		  
		  scrollToElement(By.xpath("//a[contains(text(),'Bếp Gas')]")); 
		  click(By.xpath("//a[contains(text(),'Bếp Gas')]"));
		  WebElement heading = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h1[contains(text(),'Bếp gas chính hãng, bảo hành dài hạn, giá rẻ nhất toàn quốc')]")));
	 	  String actualtext = heading.getText();
	 	  System.out.println("Alert Message" +actualtext);
	 	  assertTrue(actualtext.equalsIgnoreCase("Bếp gas chính hãng, bảo hành dài hạn, giá rẻ nhất toàn quốc"), "Text không khớp nội dung mong đợi!");
		  
		   By bepGasPB = By.xpath("//a[contains(text(),'Phổ biến')]");
		   scrollToElement(By.xpath("//a[contains(text(),'Phổ biến')]")); 
		   WebElement bepGasPBlink  = wait.until(ExpectedConditions.elementToBeClickable(bepGasPB));
		   jsClick(bepGasPBlink);
		   String PBUrl = driver.getCurrentUrl();
		   System.out.println("Actual URL: " + PBUrl);
		   assertTrue(PBUrl.contains("/bep-gas?sort=default&page=1"), "Link xuat xu không chứa URL mong đợi. PhobienURL: " + PBUrl);
  }
   
   @Test
   public void Check_BepGas_Giamgianhieu() {
		  WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
		  
		  scrollToElement(By.xpath("//a[contains(text(),'Bếp Gas')]")); 
		  click(By.xpath("//a[contains(text(),'Bếp Gas')]"));
		  WebElement heading = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h1[contains(text(),'Bếp gas chính hãng, bảo hành dài hạn, giá rẻ nhất toàn quốc')]")));
	 	  String actualtext = heading.getText();
	 	  System.out.println("Alert Message" +actualtext);
	 	  assertTrue(actualtext.equalsIgnoreCase("Bếp gas chính hãng, bảo hành dài hạn, giá rẻ nhất toàn quốc"), "Text không khớp nội dung mong đợi!");
		  
		   By bepGasGiamgia = By.xpath("//a[contains(text(),'Giảm giá nhiều')]");
		   scrollToElement(By.xpath("//a[contains(text(),'Giảm giá nhiều')]")); 
		   WebElement bepGasGGlink  = wait.until(ExpectedConditions.elementToBeClickable(bepGasGiamgia));
		   jsClick(bepGasGGlink);
		   String GGUrl = driver.getCurrentUrl();
		   System.out.println("Actual URL: " + GGUrl);
		   assertTrue(GGUrl.contains("/bep-gas?sort=discount&page=1"), "Link xuat xu không chứa URL mong đợi. GiamgiaURL: " + GGUrl);
  }
   
   @Test
   public void Check_BepGas_Giathap() {
		  WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
		  
		  scrollToElement(By.xpath("//a[contains(text(),'Bếp Gas')]")); 
		  click(By.xpath("//a[contains(text(),'Bếp Gas')]"));
		  WebElement heading = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h1[contains(text(),'Bếp gas chính hãng, bảo hành dài hạn, giá rẻ nhất toàn quốc')]")));
	 	  String actualtext = heading.getText();
	 	  System.out.println("Alert Message" +actualtext);
	 	  assertTrue(actualtext.equalsIgnoreCase("Bếp gas chính hãng, bảo hành dài hạn, giá rẻ nhất toàn quốc"), "Text không khớp nội dung mong đợi!");
		  
		   By bepGasGiathap = By.xpath("//a[contains(text(),'Giá thấp')]");
		   scrollToElement(By.xpath("//a[contains(text(),'Giá thấp')]")); 
		   WebElement bepGasGTlink  = wait.until(ExpectedConditions.elementToBeClickable(bepGasGiathap));
		   jsClick(bepGasGTlink);
		   String GTUrl = driver.getCurrentUrl();
		   System.out.println("Actual URL: " + GTUrl);
		   assertTrue(GTUrl.contains("/bep-gas?sort=price_asc&page=1"), "Link xuat xu không chứa URL mong đợi. GiathapURL: " + GTUrl);
  }
   
   @Test
   public void Check_BepGas_Giacao() {
		  WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
		  
		  scrollToElement(By.xpath("//a[contains(text(),'Bếp Gas')]")); 
		  click(By.xpath("//a[contains(text(),'Bếp Gas')]"));
		  WebElement heading = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h1[contains(text(),'Bếp gas chính hãng, bảo hành dài hạn, giá rẻ nhất toàn quốc')]")));
	 	  String actualtext = heading.getText();
	 	  System.out.println("Alert Message" +actualtext);
	 	  assertTrue(actualtext.equalsIgnoreCase("Bếp gas chính hãng, bảo hành dài hạn, giá rẻ nhất toàn quốc"), "Text không khớp nội dung mong đợi!");
		  
		   By bepGasGiacao = By.xpath("//a[contains(text(),'Giá cao')]");
		   scrollToElement(By.xpath("//a[contains(text(),'Giá cao')]")); 
		   WebElement bepGasGClink  = wait.until(ExpectedConditions.elementToBeClickable(bepGasGiacao));
		   jsClick(bepGasGClink);
		   String GCUrl = driver.getCurrentUrl();
		   System.out.println("Actual URL: " + GCUrl);
		   assertTrue(GCUrl.contains("/bep-gas?sort=price_desc&page=1"), "Link xuat xu không chứa URL mong đợi. GiathapURL: " + GCUrl);
  }
   
   @Test
   public void Check_BepGas_DMandSB() {
		  WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
		  
		  scrollToElement(By.xpath("//a[contains(text(),'Bếp Gas')]")); 
		  click(By.xpath("//a[contains(text(),'Bếp Gas')]"));
		  WebElement heading = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h1[contains(text(),'Bếp gas chính hãng, bảo hành dài hạn, giá rẻ nhất toàn quốc')]")));
	 	  String actualtext = heading.getText();
	 	  System.out.println("Alert Message" +actualtext);
	 	  assertTrue(actualtext.equalsIgnoreCase("Bếp gas chính hãng, bảo hành dài hạn, giá rẻ nhất toàn quốc"), "Text không khớp nội dung mong đợi!");
		  
	 	   By bepGasAm = By.xpath("//a[contains(text(),'Bếp Gas Âm')]");
		   scrollToElement(By.xpath("//a[contains(text(),'Bếp Gas Âm')]")); 
		   WebElement bepGasAmlink = wait.until(ExpectedConditions.elementToBeClickable(bepGasAm));
		   jsClick(bepGasAmlink);
		   WebElement headingbepgasam = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h1[contains(text(),'Bếp Gas Âm Nhập Khẩu Model 2023 chính hãng, giá rẻ')]")));
		   String textbepgasam = headingbepgasam.getText();
		   System.out.println("Alert Message" +textbepgasam);
		   assertTrue(textbepgasam.equalsIgnoreCase("Bếp Gas Âm Nhập Khẩu Model 2023 chính hãng, giá rẻ"), "Text không khớp nội dung mong đợi!");
		   
		   By bepGassobep = By.xpath("//input[@id='2-bep-1007']");
		   scrollToElement(By.xpath("//input[@id='2-bep-1007']")); 
		   WebElement bepGassobeplink  = wait.until(ExpectedConditions.elementToBeClickable(bepGassobep));
		   jsClick(bepGassobeplink);
		   String sobepUrl = driver.getCurrentUrl();
		   System.out.println("Actual URL: " + sobepUrl);
		   assertTrue(sobepUrl.contains("/bep-gas-am?opt-so-bep=1007&page=1"), "Link xuat xu không chứa URL mong đợi. XuatxuURL: " + sobepUrl);
    }
   
   @Test
   public void Check_BepGas_KH() {
		  WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
		  
		  scrollToElement(By.xpath("//a[contains(text(),'Bếp Gas')]")); 
		  click(By.xpath("//a[contains(text(),'Bếp Gas')]"));
		  WebElement heading = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h1[contains(text(),'Bếp gas chính hãng, bảo hành dài hạn, giá rẻ nhất toàn quốc')]")));
	 	  String actualtext = heading.getText();
	 	  System.out.println("Alert Message" +actualtext);
	 	  assertTrue(actualtext.equalsIgnoreCase("Bếp gas chính hãng, bảo hành dài hạn, giá rẻ nhất toàn quốc"), "Text không khớp nội dung mong đợi!");
		  
	 	   By bepGashang = By.xpath("//a[contains(@href, '/danh-muc/bep-gas/bosch')]");
		   wait.until(ExpectedConditions.presenceOfElementLocated(bepGashang));
		   scrollToElement(bepGashang);
		   wait.until(ExpectedConditions.visibilityOfElementLocated(bepGashang));
		   WebElement bepGashanglink = wait.until(ExpectedConditions.elementToBeClickable(bepGashang));
		   jsClick(bepGashanglink);
		   WebElement headingbepgashang = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h4[contains(text(),'BOSCH')]")));
		   String textbepgashang = headingbepgashang.getText();
		   System.out.println("Alert Message" +textbepgashang);
		   assertTrue(textbepgashang.trim().toLowerCase().contains("bosch"), "Khong dung hang san xuat" +textbepgashang + " ' ");
	 	  
	 	   By bepGasKT = By.xpath("//input[@id='800-mm-1067']");
		   scrollToElement(By.xpath("//input[@id='800-mm-1067']")); 
		   WebElement bepGasKTlink  = wait.until(ExpectedConditions.elementToBeClickable(bepGasKT));
		   jsClick(bepGasKTlink);
		   String KTUrl = driver.getCurrentUrl();
		   System.out.println("Actual URL: " + KTUrl);
		   assertTrue(KTUrl.contains("/bep-gas/bosch?opt-kich-thuoc=1067&page=1"), "Link xuat xu không chứa URL mong đợi. KichthuocURL: " + KTUrl);
		   
		   
		   By bepGasGiacao = By.xpath("//a[contains(text(),'Giá cao')]");
		   scrollToElement(By.xpath("//a[contains(text(),'Giá cao')]")); 
		   WebElement bepGasGClink  = wait.until(ExpectedConditions.elementToBeClickable(bepGasGiacao));
		   jsClick(bepGasGClink);
		   String GCUrl = driver.getCurrentUrl();
		   System.out.println("Actual URL: " + GCUrl);
		   assertTrue(GCUrl.contains("/bep-gas/bosch?opt-kich-thuoc=1067&page=1&sort=price_desc"), "Link xuat xu không chứa URL mong đợi. GiathapURL: " + GCUrl);
    }
   
}
