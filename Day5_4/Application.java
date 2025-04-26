package Day5_4;

public class Application {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
      Hinhchunhat hcn = new Hinhchunhat();
      hcn.chieudai = 5.5;
      hcn.chieurong = 4.5;
      hcn.setTenHinh("HCN A: ");
      hcn.tinhDientich();	
      System.out.println("---------------");
      
      hinhTron ht = new hinhTron();
      ht.bankinh = 5;
      ht.setTenHinh("HT B:");
      ht.tinhDientich();
	}
}
