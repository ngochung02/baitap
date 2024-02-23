package baitap1;
class Bao extends TaiLieu {
    private String ngayPhatHanh;

    public Bao(String maTaiLieu, String nhaXuatBan, int soBanPhatHanh, String ngayPhatHanh) {
        super(maTaiLieu, nhaXuatBan, soBanPhatHanh);
        this.ngayPhatHanh = ngayPhatHanh;
    }

    public String getNgayPhatHanh() {
        return ngayPhatHanh;
    }

    public void displayInfo() {
        super.displayInfo();
        System.out.println("Ngày phát hành: " + ngayPhatHanh);
    }
}
