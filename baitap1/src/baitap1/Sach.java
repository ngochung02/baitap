package baitap1;

class Sach extends TaiLieu {
	    private String tenTacGia;
	    private int soTrang;

	    public Sach(String maTaiLieu, String nhaXuatBan, int soBanPhatHanh, String tenTacGia, int soTrang) {
	        super(maTaiLieu, nhaXuatBan, soBanPhatHanh);
	        this.tenTacGia = tenTacGia;
	        this.soTrang = soTrang;
	    }
	    public String getTenTacGia() {
	        return tenTacGia;
	    }

	    public int getSoTrang() {
	        return soTrang;
	    }

	    public void displayInfo() {
	        super.displayInfo();
	        System.out.println("Tên tác giả: " + tenTacGia);
	        System.out.println("Số trang: " + soTrang);
	    }
}

