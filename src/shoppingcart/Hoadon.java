package shoppingcart;

import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

/** tao ham chitiethoadon. */
public class Hoadon {

  private int idnguoidung = 2;
  private String ngaylap;
  private int tongtienhoadon;
  private ArrayList<Chitiethoadon> dschitiet;
  private int id_hd = 0;

  
  /** tao ham chitiethoadon. */
  public Hoadon(ArrayList<Chitiethoadon> ds) {
    this.idnguoidung = 2;
    java.util.Date date = Calendar.getInstance().getTime();
    DateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd hh:mm:ss");
    this.ngaylap = dateFormat.format(date);
    for (int i = 0; i < ds.size(); i++) {
      this.tongtienhoadon += ds.get(i).get_tongtienchitiet();
    }
    this.dschitiet = ds;
  }
  public Hoadon(int id, String ngaylap, int tongtien) {
    this.id_hd = id;
    this.ngaylap = ngaylap;
    this.tongtienhoadon = tongtien;
  }
  
  public int Gettien() {
    return this.tongtienhoadon;
  }
  public ArrayList<Chitiethoadon> getds() {
    return this.dschitiet;
  }
  
  /** tao ham chitiethoadon. */
  public void print() {

    for (int i = 0; i < dschitiet.size(); i++) {
      System.out.format("|%-30s|%-30d|%-30d|\n",
          dschitiet.get(i).get_sp().getTen_sp(),
          dschitiet.get(i).get_sl(),
          dschitiet.get(i).get_tongtienchitiet());
      System.out.println(
          "----------------------------------------------------------------------------------------------");
    }
    System.out.println("tong so tien can thanh toan:" + tongtienhoadon);
    System.out.println("Cam on ban da mua hang!!!");
  }
  public void printds() {
      System.out.format("|%-30d|%-30s|%-30d|\n",this.id_hd, this.ngaylap, this.tongtienhoadon);
      System.out.print("---------------------------------------------");
      System.out.println(
          "-------------------------------------------------");
  }
}
