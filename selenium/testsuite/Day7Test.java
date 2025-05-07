package selenium.testsuite;

import org.testng.annotations.Test;

public class Day7Test {
	int[] arr = {1,2,3,4,5,6,7,8,9};
	@Test
  public void nhapmang(){
	  for (int n:arr) {
		System.out.print(n);
		System.out.println(" ");
	  }
  }
	
	@Test
  public void tinhtongmang(){
	 int Sum =0;
	 for (int n:arr) {
		Sum+=n; 
	 }
	 System.out.println("Tổng của dãy số là: " +Sum);
  }
  
}
