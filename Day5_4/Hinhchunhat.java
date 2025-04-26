package Day5_4;

public class Hinhchunhat extends Hinhhoc {
   public double chieudai;
   public double chieurong;
   @Override
   public void tinhDientich(){
	   double S = chieudai * chieurong;
	   System.out.println("Dien tich hinh chu nhat la: " +super.getTenHinh()+ S);
   }
}
