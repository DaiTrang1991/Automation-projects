package selenium.testsuite;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;
import selenium.common.CommonBase;

public class Day12_Drodownlist extends CommonBase {
/*
- Làm sao để chọn các giá trị: 1 khoá học của dropdown ở hình trên?
- Làm sao để kiểm tra trong dropdown có bao nhiêu giá trị => như hình trên có 5 giá trị?
- Làm sao để kiểm tra 1 giá trị trong dropdown hiển thị đúng hay chưa sau khi đã chọn thành công?
- Làm sao để kiểm tra dropdown có phải là multi-select hay single select => multi-select: cho phép chọn nhiều giá trị trong dropdown/ list?
 */
	@Test
	public void handleDropdown() {
		driver = initChromeBrowser(CT_PageURL.CODESTAR_URL);
		//Khoi tao select de chua dropdownlist
		Select dropKhoahoc = new Select(driver.findElement(By.id("product_categories_filter")));
		// Chon gia tri WAS bang ham selectByVisibleText
		dropKhoahoc.selectByVisibleText("AWS");
		System.out.println("So luong options cua dropdown la: " +dropKhoahoc.getOptions().size());
		System.out.println("Gia tri sau khi chon:" +dropKhoahoc.getFirstSelectedOption().getText());
		System.out.println("Multiple dropdown:" +dropKhoahoc.isMultiple());
	}
}
