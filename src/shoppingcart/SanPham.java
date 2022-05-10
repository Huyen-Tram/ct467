package shoppingcart;


/** tao tao class sanpham. */
public class SanPham {
  private int masp;
  private String tensp;
  private int sltonkho;
  private int dongia;

  /** tao ham xay dung. */
  public SanPham(int masp, String tensp, int sltonkho, int dongia) {
    this.masp = masp;
    this.tensp = tensp;
    this.dongia = dongia;
    this.sltonkho = sltonkho;

  }
  
  /** tao ham xay dung. */
  public SanPham(String tensp, int sltonkho, int dongia) {
    this.tensp = tensp;
    this.dongia = dongia;
    this.sltonkho = sltonkho;
  }
  
  public SanPham(int id, String tensp, int dongia) {
    this.masp = id;
    this.tensp = tensp;
    this.dongia = dongia;
  }
  
  /** tao ham print. */
  public void print() {
    System.out.format("|%-30d|%-30s|%-30d|%-30d|\n", masp, tensp, sltonkho,
        dongia);
    System.out.print("------------------------------------------------------");
    System.out.println("----------------------------------------------------------------------");

  }

  public int getMa() {
    return this.masp;
  }

  public String getTen_sp() {
    return this.tensp;
  }

  public int getSl() {
    return this.sltonkho;
  }

  public int getDongia() {
    return this.dongia;
  }

}
