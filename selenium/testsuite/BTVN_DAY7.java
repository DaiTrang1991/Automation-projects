package selenium.testsuite;

import java.util.ArrayList;
import java.util.List;
import org.testng.annotations.Test;

public class BTVN_DAY7 {
	@Test
	public void DanhsachNV() {
		List<String> list = new ArrayList<String>();
		list.add("Le Minh Huy");
		list.add("Linh Thanh Thao");
		list.add("Le Huong Giang");
		list.add("Dao Anh Cuong");
		list.add("Pham Phuong Linh");
		for (String obj:list) {
			System.out.println(obj);
		}
    }
}
