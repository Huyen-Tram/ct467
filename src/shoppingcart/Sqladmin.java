package shoppingcart;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/** tao ham chitiethoadon. */
public class Sqladmin {
  private Mysqlconnect connect = new Mysqlconnect();
  private Connection conn = connect.getConnection();
  private Statement stmt = null;
  private ResultSet rs = null;

  /** tao ham chitiethoadon. */
  public ArrayList<SanPham> getallSp() {
    ArrayList<SanPham> dssp = new ArrayList<SanPham>();
    try {
      // dùng phương thức executeQuery để yêu cầu thực hiện lệnh SQL
      stmt = conn.createStatement();
      rs = stmt.executeQuery("SELECT * FROM sanpham where DAXOA is null");
      while (rs.next()) {

        SanPham sp = new SanPham(rs.getInt("id_sp"), rs.getString("tenSp"),
            rs.getInt("SO_LUONG_TON_KHO"), rs.getInt("DON_GIA"));
        dssp.add(sp);
      }

      // thao tác trên tập kết quả trả v�? rs....
    } catch (SQLException ex) { // xử lý ngoại lệ
      System.out.println("GetallSp: " + ex.getMessage());
    }

    return dssp;
  }
  
  /** tao ham chitiethoadon. */
  public SanPham tim_sp(int id) {
    SanPham sp = null;

    try {
      // dùng phương thức executeQuery để yêu cầu thực hiện lệnh SQL
      stmt = conn.createStatement();
      rs = stmt.executeQuery("SELECT * FROM sanpham where id_sp=" + id);
      while (rs.next()) {

        sp = new SanPham(rs.getInt("id_sp"), rs.getString("tenSp"),
            rs.getInt("SO_LUONG_TON_KHO"), rs.getInt("DON_GIA"));

      }

      // thao tác trên tập kết quả trả v�? rs....
    } catch (SQLException ex) { // xử lý ngoại lệ
      System.out.println("tim sp: " + ex.getMessage());
    }

    return sp;
  }
  
  /** tao ham chitiethoadon. */
  public void add_sp(SanPham sp) {
    try {
      stmt = conn.createStatement();
      stmt.executeUpdate(
          "insert sanpham (tensp, so_luong_ton_kho, don_gia) value ('"
              + sp.getTen_sp() + "','" + sp.getSl() + "','" + sp.getDongia()
              + "');");
      System.out.println("da them sp thanh cong!!!!!!!!");
    } catch (SQLException ex) { // xử lý ngoại lệ
      System.out.println("add_sp: " + ex.getMessage());
    }

  }
  
  /** tao ham chitiethoadon. */
  public void sua_sp(SanPham sp) {
    try {
      stmt = conn.createStatement();
      // Update
      String sqlUpdate = "UPDATE SanPham SET TENSP='" + sp.getTen_sp()
          + "', SO_LUONG_TON_KHO='" + sp.getSl() + "', DON_GIA='"
          + sp.getDongia() + "' where ID_SP=" + sp.getMa() + ";";
      int id = stmt.executeUpdate(sqlUpdate);

      System.out.println("da sua sp thanh cong san pham co id la: " + id);

    } catch (SQLException ex) {
      System.out.println("sua_sp: " + ex.getMessage());
    }
  }
  
  /** tao ham chitiethoadon. */
  public void xoa_sp(int idXoa) {
    try {
      stmt = conn.createStatement();
      // Update
      String sqlUpdate = "UPDATE SanPham SET DAXOA=" + true + " where ID_SP="
          + idXoa + ";";
      stmt.executeUpdate(sqlUpdate);

      System.out.println("da xoa sp thanh cong, san pham co id la: " + idXoa);

    } catch (SQLException ex) { // xử lý ngoại lệ
      System.out.println("xoa_sp: " + ex.getMessage());
    }
  }
}
