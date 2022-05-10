
package shoppingcart;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


/** tao ham chitiethoadon. */
public class Mysqlconnect {

  private static Connection con;
  private static String URL;
  private static String USER;
  private static String PASSWORD;

  /** tao ham chitiethoadon. */
  public Connection getConnection() {
    con = null;

    try {
      URL = "jdbc:mysql://localhost:3306/shopping";
      USER = "root";
      PASSWORD = "";
      con = DriverManager.getConnection(URL, USER, PASSWORD);
    } catch (SQLException ex) {
      System.out.println(ex.getMessage());
    }
    return (con);
  }

  /** tao ham chitiethoadon. */
  public static void freeConnection() {
    try {
      con.close();
    } catch (SQLException ex) {
      System.out.println(ex.getMessage());
    }
  }

}
