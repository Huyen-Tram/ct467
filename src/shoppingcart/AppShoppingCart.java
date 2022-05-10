package shoppingcart;

import java.util.ArrayList;


/** tao ham chitiethoadon. */
public class AppShoppingCart {

  /** tao ham chitiethoadon. */
  public static void main(String[] args) {

    Controller ctrl = new Controller();
    String role;
    String choice;

    ArrayList<Chitiethoadon> dschitiet = new ArrayList<Chitiethoadon>();

    while (true) {
      choice = ctrl.getRole();
      System.out.println(choice);
      if (choice.equals("0")) {
        System.out.println("dang thoat chuong trinh.....");
        return;
      } else {
        role = choice;
      }
      choice = "0";

      // chuc nang admin
      if (role.equals("1")) {

        while (true) {
          choice = ctrl.admin();

          if (choice.equals("0")) {
            System.out.println("dang thoat chuong trinh.....");
            return;
          } else if (choice.equals("1")) {
            System.out.println("ds san pham.....");
            ctrl.in_ds_sp();
          }else if (choice.equals("2")) {
            System.out.println("them san pham.....");
            ctrl.admin_them();
          } else if (choice.equals("3")) {
            System.out.println("sua san pham.....");
            ctrl.admin_sua_sp();
          } else if (choice.equals("4")) {
            System.out.println("xoa san pham.....");
            ctrl.admin_xoa_sp();
          } else if (choice.equals("5")) {
            System.out.println("trở v�?.....");
            break;
          }

        }
      }
      if (role.equals("2")) {

        while (true) {
          choice = ctrl.user();

          if (choice.equals("0")) {
            System.out.println("dang thoat chuong trinh.....");
            return;
          } else if (choice.equals("1")) {
            System.out.println("ds san pham.....");
            ctrl.in_ds_sp();
          } else if (choice.equals("2")) {
            System.out.println("ds san pham trong gio hang.....");
            ctrl.xem_giohang(dschitiet);
          } else if (choice.equals("3")) {
            System.out.println("tim kiem san pham.....");
            ctrl.tim_kiem();
          } else if (choice.equals("4")) {
            System.out.println("them san pham vao gio hang.....");
            Chitiethoadon chitiet = ctrl.them_sp_giohang();
            if (chitiet != null) {
              dschitiet.add(chitiet);
            }
            else {
              System.out.println("khong the them san pham nay");
            }
            dschitiet = ctrl.xem_giohang(dschitiet);

          } else if (choice.equals("5")) {
            System.out.println("xoa san pham.....");

            dschitiet = ctrl.xoa_sp_giohang(dschitiet);
          } else if (choice.equals("6")) {
            System.out.println("thay doi so luong san pham");
            dschitiet = ctrl.thaydoisl(dschitiet);
          } else if (choice.equals("7")) {
            System.out.println("thanh toan hoa don");
            ctrl.thanh_toan(dschitiet);
            dschitiet.clear();
          }else if (choice.equals("8")) {
            System.out.println("xem danh sach hoa don");
            ctrl.InDsHd();
          }else if (choice.equals("9")) {
            System.out.println("xem chi tiet hoa don");
            ctrl.Inchitiethoadon();
          }else if (choice.equals("10")) {
            System.out.println("trở v�?.....");
            break;
          }
        }
      }
    }
  }
}
