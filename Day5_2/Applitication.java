package Day5_2;

public class Applitication {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
      Adder myAdd = new Adder();
      myAdd.Add(1, 56789);
      System.out.println(myAdd.Add(1, 56789));
      
      myAdd.Add(234, 600, 876);
      System.out.println(myAdd.Add(234, 600, 876));
      
      myAdd.Add(12.3, 15.6);
      System.out.println(myAdd.Add(12.3, 15.6));
	}
}
