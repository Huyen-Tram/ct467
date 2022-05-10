package shoppingcart;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/** tao ham chitiethoadon. */
public class Sqluser {
  private Mysqlconnect mysql = new Mysqlconnect();
  private Connection conn = mysql.getConnection();
  private Statement stmt = null;
  private ResultSet rs = null;
  
  /** tao ham chitiethoadon. */
  public ArrayList<SanPham> getAllSp() {
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
  public ArrayList<SanPham> tim_sp_ten(String tensp) {
    SanPham sp = null;
    ArrayList<SanPham> dssp = new ArrayList<SanPham>();

    try {
      // dùng phương thức executeQuery để yêu cầu thực hiện lệnh SQL
      stmt = conn.createStatement();
      rs = stmt.executeQuery(
          "select * from sanpham where tensp like \"%" + tensp + "%\";");
      while (rs.next()) {

        sp = new SanPham(rs.getInt("id_sp"), rs.getString("tenSp"),
            rs.getInt("SO_LUONG_TON_KHO"), rs.getInt("DON_GIA"));

        dssp.add(sp);
      }

      // thao tác trên tập kết quả trả v�? rs....
    } catch (SQLException ex) { // xử lý ngoại lệ
      System.out.println("tim sp: " + ex.getMessage());
    }

    return dssp;
  }
  
  /** tao ham chitiethoadon. */
  public void xoa_sp(int idXoa) {
    try {
      stmt = conn.createStatement();
      // Update
      String sqlUpdate = "UPDATE SanPham SET DAXOA=" + true + " where ID_SP="
          + idXoa + ";";
      int id = stmt.executeUpdate(sqlUpdate);

      System.out.println("da xoa sp thanh cong, san pham co id la: " + id);

    } catch (SQLException ex) { // xử lý ngoại lệ
      System.out.println("xoa_sp: " + ex.getMessage());
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

    } catch (SQLException ex) { // xử lý ngoại lệ
      System.out.println("sua_sp: " + ex.getMessage());
    }
  }
  
  /** tao ham chitiethoadon. */
  public SanPham tim_sp_id(int id) {
    SanPham sp = null;

    try {
      // dùng phương thức executeQuery để yêu cầu thực hiện lệnh SQL
      stmt = conn.createStatement();
      rs = stmt.executeQuery("SELECT * FROM sanpham where DAXOA is null and id_sp=" + id);
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
  
  public void addHoadon(Hoadon hd) {
    try {
      // dùng phương thức executeQuery để yêu cầu thực hiện lệnh SQL
      stmt = conn.createStatement();
      rs = stmt.executeQuery(
          "call addhoadon( " + hd.Gettien() + ");");
      int id = 0;
      while (rs.next()) {
        id = rs.getInt("id");
      }
      
      for(int i = 0; i < hd.getds().size(); i++) {
        stmt.executeQuery("call addchitiethoadon( "
            + hd.getds().get(i).get_sp().getMa() + " ,"
            + id + " ,"
            + hd.getds().get(i).get_sl()+ " ,"
            + hd.getds().get(i).get_tongtienchitiet()
            + " );");
      }

      // thao tác trên tập kết quả trả v�? rs....
    } catch (SQLException ex) { // xử lý ngoại lệ
      System.out.println("add hoa don " + ex.getMessage());
    }
  }
  
  public ArrayList<Hoadon> GetDsHd() {
    ArrayList<Hoadon> ds = new ArrayList<Hoadon>();
    Hoadon hd;
    try {
      // dùng phương thức executeQuery để yêu cầu thực hiện lệnh SQL
      stmt = conn.createStatement();
      rs = stmt.executeQuery("SELECT * FROM giohanng");
      while (rs.next()) {

        hd = new Hoadon(rs.getInt("id_giohang"), rs.getDate("ngay_lap").toString(),
            rs.getInt("tongtienhoadon"));
        ds.add(hd);
      }

      // thao tác trên tập kết quả trả v�? rs....
    } catch (SQLException ex) { // xử lý ngoại lệ
      System.out.println("get ds hoa don: " + ex.getMessage());
    }
    return ds;
  }
  
  public ArrayList<Chitiethoadon> getchitiethoadon(int id_hd) {
    ArrayList<Chitiethoadon> ds = new ArrayList<Chitiethoadon>();
    Chitiethoadon chitiet;
    try {
      // dùng phương thức executeQuery để yêu cầu thực hiện lệnh SQL
      stmt = conn.createStatement();
      rs = stmt.executeQuery("call getchitiethd( "
          + id_hd
          + " );");
      while (rs.next()) {

        chitiet = new Chitiethoadon(rs.getInt("id_sp"), rs.getString("tensp"), rs.getInt("so_luong") , rs.getInt("don_gia"), rs.getInt("tongtienchitiet"));
        ds.add(chitiet);
      }

      // thao tác trên tập kết quả trả v�? rs....
    } catch (SQLException ex) { // xử lý ngoại lệ
      System.out.println("get chi tiet hoa don: " + ex.getMessage());
    }
    return ds;
    
  }

}
