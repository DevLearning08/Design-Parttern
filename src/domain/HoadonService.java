package domain;

import java.util.List;

import javax.swing.table.DefaultTableModel;

import domain.model.HoaDon;

abstract class HoadonService {
    public abstract void action(HoaDon hoaDon,int maKH,int maHD,String hotenKH, String customerType);
    // public void themHoaDon(HoaDon hoaDon);
    // // public void themHoaDonNuocNgoai(HoaDon hoaDon);
    // public void xoaHoaDon(int maHD);
    // public void suaHoaDon(HoaDon hoaDon);
    // public void tinhSoLuongTungLoai(int maKH);
    // public void tbHoaDonNN();
    // public List<HoaDon> xuatHoaDonTrongThang(HoaDon hoaDon);
    // public HoaDon timKiemID(HoaDon hoaDon);   
    // public HoaDon timKiemTenVN(String hotenKH); 
    // public HoaDon timKiemTenNN(String hotenKH);
    // public List<HoaDon> getHoaDonVN();
    // public List<HoaDon> getHoaDonNN();
}
