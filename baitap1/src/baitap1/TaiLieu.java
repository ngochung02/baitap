package baitap1;
import java.util.ArrayList;
import java.util.Scanner;

class TaiLieu {
    private String maTaiLieu;
    private String nhaXuatBan;
    private int soBanPhatHanh;

    public TaiLieu(String maTaiLieu, String nhaXuatBan, int soBanPhatHanh) {
        this.maTaiLieu = maTaiLieu;
        this.nhaXuatBan = nhaXuatBan;
        this.soBanPhatHanh = soBanPhatHanh;
    }

    public String getMaTaiLieu() {
        return maTaiLieu;
    }

    public String getNhaXuatBan() {
        return nhaXuatBan;
    }

    public int getSoBanPhatHanh() {
        return soBanPhatHanh;
    }

    public void displayInfo() {
        System.out.println("Mã tài liệu: " + maTaiLieu);
        System.out.println("Nhà xuất bản: " + nhaXuatBan);
        System.out.println("Số bản phát hành: " + soBanPhatHanh);
    }
}
class QuanLySach {
    private ArrayList<TaiLieu> danhSachTaiLieu = new ArrayList<>();

    public void themTaiLieu(TaiLieu taiLieu) {
        danhSachTaiLieu.add(taiLieu);
    }

    public void xoaTaiLieu(String maTaiLieu) {
        danhSachTaiLieu.removeIf(taiLieu -> taiLieu.getMaTaiLieu().equals(maTaiLieu));
    }

    public void hienThiThongTin() {
        for (TaiLieu taiLieu : danhSachTaiLieu) {
            taiLieu.displayInfo();
            System.out.println("----------------------");
        }
    }

    public void timKiemTheoLoai(String loai) {
        for (TaiLieu taiLieu : danhSachTaiLieu) {
            if (taiLieu.getClass().getSimpleName().equals(loai)) {
                taiLieu.displayInfo();
                System.out.println("----------------------");
            }
        }
    }

    public static void main(String[] args) {
        QuanLySach quanLySach = new QuanLySach();

        quanLySach.themTaiLieu(new Sach("S1", "NXB A", 100, "Tac Gia A", 200));
        quanLySach.themTaiLieu(new TapChi("T1", "NXB B", 50, 1, 6));
        quanLySach.themTaiLieu(new Bao("B1", "NXB C", 200, "01/01/2022"));

        System.out.println("Danh sách tài liệu:");
        quanLySach.hienThiThongTin();

        quanLySach.xoaTaiLieu("S1");

        System.out.println("Danh sách tài liệu sau khi xóa:");
        quanLySach.hienThiThongTin();

        System.out.println("Tìm kiếm sách:");
        quanLySach.timKiemTheoLoai("Sach");
    }
}