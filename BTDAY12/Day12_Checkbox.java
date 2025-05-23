package selenium.testsuite;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import selenium.common.CommonBase;


public class Day12_Checkbox extends CommonBase{
   
    @Test
	public void clickcheckbox_1() {
		driver = initChromeBrowser(CT_PageURL.DEMOQA_URL);
		WebElement chbSports = driver.findElement(By.xpath("//label[@for='hobbies-checkbox-1']"));
		scrollToElement(chbSports);
		if(chbSports.isSelected()==false) {
			chbSports.click();
			System.out.println(" The Sports has been checked");
		}
		
		WebElement chbReading = driver.findElement(By.xpath("//label[@for='hobbies-checkbox-2']"));
		  if(chbReading.isSelected()==false) {
			  chbReading.click();
			  System.out.println("The Reading has been checkbox");
		  }
		  
		WebElement chbMusic = driver.findElement(By.xpath("//label[@for='hobbies-checkbox-3']"));
		if (chbMusic.isSelected()==false) {
			chbMusic.click();
			System.out.println("The Music has been checkbox");
		}
	}
	
	@Test
	public void listcheckbox_2() {
		driver = initChromeBrowser(CT_PageURL.DEMOQA_URL);
		List<WebElement> listcheckbox = driver.findElements(By.xpath("//label[contains(@for,'hobbies-checkbox')]"));
		scrollToElement(listcheckbox.get(0));
		for (WebElement item:listcheckbox) {
			if(item.isSelected()==false) {
				item.click();
				System.out.println("The" +item + "has been checkbox");
			}
		}
	}
	
	@Test
	public void listlablecheckbox_3() {
		driver = initChromeBrowser(CT_PageURL.DEMOQA_URL);
		List<WebElement> listlabelcheckbox = driver.findElements(By.xpath("//label[contains(@for,'hobbies-checkbox')]"));
		scrollToElement(listlabelcheckbox.get(0));
		for (int i=0; i<listlabelcheckbox.size(); i++) {
			if(listlabelcheckbox.get(i).isSelected()==false) {
				listlabelcheckbox.get(i).click();
				System.out.println("Checkbox" + i+1+ "has been clicked");
			}
		}
	}
}
