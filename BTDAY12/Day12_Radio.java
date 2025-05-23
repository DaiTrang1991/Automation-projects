package selenium.testsuite;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import selenium.common.CommonBase;

public class Day12_Radio extends CommonBase{
	
	@Test
	public void ClickRadio_1() {
		driver = initChromeBrowser(CT_PageURL.DEMOQA_URL);
		WebElement MaleRadio = driver.findElement(By.xpath("//label[@for= 'gender-radio-1']"));
		scrollToElement(MaleRadio);
		MaleRadio.click();
		System.out.println("Male has been Clicked");
		
		WebElement FemaleRadio = driver.findElement(By.xpath("//label[@for= 'gender-radio-2']"));
		FemaleRadio.click();
		System.out.println("Female has been Clicked");
		
		WebElement OtherRdio = driver.findElement(By.xpath("//label[@for= 'gender-radio-3']"));
		OtherRdio.click();
		System.out.println("Other has been Clicked");
	}
	
	@Test
	public void ClickRadio_2() {
		driver = initChromeBrowser(CT_PageURL.DEMOQA_URL);
		List<WebElement> listRadio = driver.findElements(By.xpath("//label[contains(@for, 'gender-radio')]"));
		scrollToElement(listRadio.get(0));
		for (WebElement item:listRadio) {
			if(item.isSelected()==false) {
				item.click();
				System.out.println("Radio" +item+ "has been clicked");
			}
		}
	}
	
	@Test
	public void clickRadio_3() {
		driver = initChromeBrowser(CT_PageURL.DEMOQA_URL);
		List<WebElement> listlableRadio = driver.findElements(By.xpath("//label[contains(@for, 'gender-radio')]"));
		scrollToElement(listlableRadio.get(0));
		for(int i=0; i<listlableRadio.size();i++) {
			if (listlableRadio.get(i).isSelected()==false) {
				listlableRadio.get(i).click();
				System.out.println("Radio" + i+1 +"has been clicked" );
			}
		}
	} 

	}
