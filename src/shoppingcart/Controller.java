package shoppingcart;

import java.util.ArrayList;
import java.util.Scanner;

/** tao ham chitiethoadon. */
public class Controller {

  /** tao ham chitiethoadon. */
  public String getRole() {
    while (true) {
      System.out.println("chon vai tro:");
      System.out.println("1. admin");
      System.out.println("2. user");
      System.out.println("0. thoat chuong trinh");
      System.out.print("Nhap lua chon cua ban : ");

      Scanner sc = new Scanner(System.in);
      String choice = sc.nextLine();
      if (choice.equals("0") || choice.equals("1") || choice.equals("2")) {
        return choice;
      } else {
        System.out.println("lua chon sai, vui long chon lai!!!!");
      }
    }

  }

  /** tao ham chitiethoadon. */
  public String admin() {
    String choice;
    while (true) {
      System.out.println("==========================");
      System.out.println("trang admin");
      System.out.println("chon chuc nang ban muon:");
      System.out.println("1. xem danh san pham");
      System.out.println("2. them san pham");
      System.out.println("3. sua san pham");
      System.out.println("4. xoa san pham");
      System.out.println("5. tro ve truoc");
      System.out.println("0. thoat chuong trinh");
      System.out.print("Nhap lua chon cua ban : ");
      Scanner sc = new Scanner(System.in);
      choice = sc.nextLine();
      if (choice.equals("0") || choice.equals("1") || choice.equals("2")
          || choice.equals("3") || choice.equals("4") || choice.equals("5")) {
        return choice;
      } else {
        System.out.println("lua chon sai, vui long chon lai!!!!");
      }
    }

  }

  /** tao ham chitiethoadon. */
  public void admin_them() {
    Scanner a = new Scanner(System.in);
    System.out.print("nhap ten san pham: ");
    String ten = a.nextLine();
    System.out.print("nhap so luong san pham: ");
    int soluong = a.nextInt();
    System.out.print("nhap don gia san pham: ");
    int dongia = a.nextInt();
    SanPham sp;
    sp = new SanPham(ten, soluong, dongia);
    Sqladmin ad = new Sqladmin();
    ad.add_sp(sp);
  }

  /** tao ham chitiethoadon. */
  public void in_ds_sp() {
    Sqladmin ad = new Sqladmin();
    ArrayList<SanPham> dssp;
    dssp = ad.getallSp();
    System.out.print("-----------------------------------------------------------------------");
    System.out.println("-----------------------------------------------------");
    System.out.format("|%-30s|%-30s|%-30s|%-30s|\n", "id", "ten",
        "soluong ton kho", "don gia");
    System.out.print("-----------------------------------------------------------------------");
    System.out.println("-----------------------------------------------------");
    for (int i = 0; i < dssp.size(); i++) {
      dssp.get(i).print();
    }
  }
  
  /** tao ham chitiethoadon. */
  public void admin_sua_sp() {
    Sqladmin ad = new Sqladmin();

    System.out.print("nhap id san pham can sua:");
    Scanner sc = new Scanner(System.in);
    int id = sc.nextInt();
    SanPham sp = ad.tim_sp(id);

    System.out.println("ten cu cua san pham la:" + sp.getTen_sp());
    System.out.println(
        "vui long nhap ten moi, neu khong thay doi, nhap -1 de bo qua!");
    sc.nextLine();
    String ten = sc.nextLine();
    if (ten.equals("-1")) {
      ten = sp.getTen_sp();
    }

    System.out.println("so luong cu cua san pham la:" + sp.getSl());
    System.out.println(
        "vui long nhap ten moi, neu khong thay doi, nhap -1 de bo qua!");
    int soluong = sc.nextInt();
    if (soluong == -1) {
      soluong = sp.getSl();
    }
    System.out.println("don gia cu cua san pham la:" + sp.getDongia());
    System.out.println(
        "vui long nhap don_gia moi, neu khong thay doi, nhap -1 de bo qua!");
    int dongia = sc.nextInt();
    if (dongia == -1) {
      dongia = sp.getDongia();
    }

    SanPham spupdate = new SanPham(id, ten, soluong, dongia);

    ad.sua_sp(spupdate);

  }
  
  /** tao ham chitiethoadon. */
  public void admin_xoa_sp() {
    Sqladmin ad = new Sqladmin();

    System.out.print("nhap id san pham can xoa:");
    Scanner sc = new Scanner(System.in);
    int id = sc.nextInt();
    ad.xoa_sp(id);
  }
  
  /** tao ham chitiethoadon. */
  public String user() {
    String choice;
    while (true) {
      System.out.println("==========================");
      System.out.println("trang user");
      System.out.println("chon chuc nang ban muon:");
      System.out.println("1. xem danh san pham");
      System.out.println("2. xem danh san pham trong gio hang");
      System.out.println("3. tim kiem san pham");
      System.out.println("4. them vao gio hang");
      System.out.println("5. xoa khoi gio hang");
      System.out.println("6. thay doi so luong");
      System.out.println("7. thanh toan hoa don");
      System.out.println("8. xem danh sach hoa don");
      System.out.println("9. xem chi tiet hoa don");
      System.out.println("10. tro ve truoc");
      System.out.println("0. thoat chuong trinh");
      System.out.print("Nhap lua chon cua ban : ");
      Scanner sc = new Scanner(System.in);
      choice = sc.nextLine();
      if (choice.equals("0") || choice.equals("1") || choice.equals("2")
          || choice.equals("3") || choice.equals("4") || choice.equals("5")
          || choice.equals("6") || choice.equals("7") || choice.equals("8") || choice.equals("9") || choice.equals("10")) {
        return choice;
      } else {
        System.out.println("lua chon sai, vui long chon lai!!!!");
      }
    }

  }
  
  /** tao ham chitiethoadon. */
  public void tim_kiem() {
    System.out.print("nhap ten san pham can tim:");
    Scanner sc = new Scanner(System.in);
    String tensp = sc.nextLine();
    Sqluser user = new Sqluser();

    System.out.print("-----------------------------------------------------------------------");
    System.out.println("-----------------------------------------------------");
    System.out.format("|%-30s|%-30s|%-30s|%-30s|\n", "id", "ten",
        "soluong ton kho", "don gia");
    System.out.print("-----------------------------------------------------------------------");
    System.out.println("-----------------------------------------------------");
    ArrayList<SanPham> dssp = user.tim_sp_ten(tensp);
    for (int i = 0; i < dssp.size(); i++) {
      dssp.get(i).print();
    }

  }

  /** tao ham chitiethoadon. */
  public Chitiethoadon them_sp_giohang() {
    Chitiethoadon chitiet = null;
    System.out.print("nhap id san pham can them vao gio hang:");
    Scanner sc = new Scanner(System.in);
    int idsp = sc.nextInt();
    System.out.print("nhap so luong:");
    int sl = sc.nextInt();
    Sqluser user = new Sqluser();
    SanPham sp = user.tim_sp_id(idsp);
    if (sp != null) {
      if (sp.getSl() < sl) {
        sl = sp.getSl();
      }
      chitiet = new Chitiethoadon(sp, sl, sp.getDongia() * sl);
    }

    return chitiet;
  }
  
  /** tao ham chitiethoadon. */
  public ArrayList<Chitiethoadon> xem_giohang(
      ArrayList<Chitiethoadon> dschitiet) {
    if (dschitiet.size() > 0) {
      if (dschitiet.size() > 1) {
        for (int i = 0; i < dschitiet.size() - 1; i++) {
          for (int j = i + 1; j < dschitiet.size(); j++) {
            if (dschitiet.get(i).get_sp().getMa() == dschitiet.get(j).get_sp()
                .getMa()) {
              dschitiet.get(i).set_sl(dschitiet.get(j).get_sl());
              dschitiet.get(i)
                  .set_tongtienchitiet(dschitiet.get(j).get_tongtienchitiet());
              dschitiet.remove(j);
              j--;
            }
          }
        }
      }

      System.out.println("danh sach gio hang:");
      System.out.println("------------------------------------------------------------------------------------------------------------------------------------------------------------");
      System.out.format("|%-30s|%-30s|%-30s|%-30s|%-30s|\n", "id", "ten sp",
          "soluong", "don gia", "tong gia tien");
      System.out.println("------------------------------------------------------------------------------------------------------------------------------------------------------------");
      for (int i = 0; i < dschitiet.size(); i++) {
        dschitiet.get(i).print();
      }
    } else {
      System.out.println("gio hang rong!!!!!");
    }
    return dschitiet;
  }
  
  
  /** tao ham chitiethoadon. */
  public ArrayList<Chitiethoadon> xoa_sp_giohang(ArrayList<Chitiethoadon> ds) {

    System.out.print("nhap id san pham ban muon xoa ra khoi gio hang:");
    Scanner sc = new Scanner(System.in);
    int id = sc.nextInt();
    int size = ds.size();
    for (int i = 0; i < ds.size(); i++) {
      if (ds.get(i).get_sp().getMa() == id) {
        ds.remove(i);
      }

    }
    if (size == ds.size()) {
      System.out.println(" gio hang khong co san pham ban can xoa!!!");
    } else {
      System.out.println(" da xoa thanh cong san pham co id la: " + id + "!!!");
    }
    return ds;
  }
  
  /** tao ham chitiethoadon. */
  public ArrayList<Chitiethoadon> thaydoisl(ArrayList<Chitiethoadon> ds) {
    System.out.print("nhap id san pham ban muon thay doi so luong:");
    Scanner sc = new Scanner(System.in);
    int id = sc.nextInt();
    int dasua = 0;
    for (int i = 0; i < ds.size(); i++) {
      if (ds.get(i).get_sp().getMa() == id) {
        System.out.println("so luong cu la:" + ds.get(i).get_sl());
        System.out.println("nhap so luong moi la:");
        int sl = sc.nextInt();
        if (ds.get(i).get_sp().getSl() < sl) {
          sl = ds.get(i).get_sp().getSl();
        }

        ds.get(i).set_thaydoi(sl, ds.get(i).get_sp().getDongia());
        System.out.println("da thay doi so luong thanh:" + sl);
        dasua = 1;
      }

    }

    if (dasua == 0) {
      System.out
          .println(" gio hang khong co san pham ban can thay doi so luong!!!");
    }
    return ds;

  }
  
  /** tao ham chitiethoadon. */
  public void thanh_toan(ArrayList<Chitiethoadon> thanhtoan) {
    if (thanhtoan.size() > 0) {
      System.out.println("----------------------------------------------------------------------------------------------");
      System.out.format("%-30s%s\n", "", "hoa don");
      System.out.println("----------------------------------------------------------------------------------------------");
      System.out.format("|%-30s|%-30s|%-30s|\n", "ten san pham", "so luong",
          "thanh tien");
      System.out.print("-----------------------------------------------------------------------");
      System.out.println("-----------------------------------------------------");
      Hoadon hoadon = new Hoadon(thanhtoan);
      hoadon.print();
      Sqluser user = new Sqluser();
      user.addHoadon(hoadon);
    } else {
      System.out.format("gio hang rong khong the thanh toan!!!\n");
    }

  }
  
  public void InDsHd() {
    Sqluser user = new Sqluser();
    ArrayList<Hoadon> dsHd;
    dsHd = user.GetDsHd();
    System.out.println("----------------------------------------------------------------------------------------------");
    System.out.format("%-30s%s\n", "", "danh sach hoa don");
    System.out.println("----------------------------------------------------------------------------------------------");
        System.out.format("|%-30s|%-30s|%-30s|\n", "id hoa don", "ngay lap",
        "thanh tien");
    System.out.print("-----------------------------------------------------------------------");
    System.out.println("----------------------");
    for (int i = 0; i < dsHd.size(); i++) {
      dsHd.get(i).printds();
    }
    
    
  }
  
  public void Inchitiethoadon() {
    Sqluser user = new Sqluser();
    ArrayList<Chitiethoadon> ds = new ArrayList<Chitiethoadon>();
    System.out.println("nhap id cua hoa don can xem");
    Scanner sc = new Scanner(System.in);
    int id = sc.nextInt();
    ds = user.getchitiethoadon(id);
    System.out.println("------------------------------------------------------------------------------------------------------------------------------------------------------------");
    System.out.format("%-30s%-30s%-30s%-30s%-30s\n", "", "", "chi tiet hoa don", "", "" );
    System.out.println("------------------------------------------------------------------------------------------------------------------------------------------------------------");
    System.out.format("|%-30s|%-30s|%-30s|%-30s|%-30s|\n", "id", "ten san pham", "so luong", "don gia", "tong tien" );
    System.out.println("------------------------------------------------------------------------------------------------------------------------------------------------------------");
    for (int i = 0; i < ds.size(); i++) {
      ds.get(i).print();
    }
  }

}
