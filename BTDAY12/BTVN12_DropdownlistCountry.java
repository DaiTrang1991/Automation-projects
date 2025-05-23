package selenium.testsuite;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;
import selenium.common.CommonBase;

 public class BTVN12_DropdownlistCountry extends CommonBase {
	
	@Test
	public void handleCountry() {
		driver = initChromeBrowser(CT_PageURL.COUNTRY_URL);
		Select dropCountry = new Select(driver.findElement(By.tagName("select")));
		dropCountry.selectByValue("VNM");
		System.out.println("Gia tri sau khi chon: " +dropCountry.getFirstSelectedOption().getText());
	}

}
