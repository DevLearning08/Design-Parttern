package pesistence;

import java.util.List;

import domain.model.HoaDon;

public interface HoaDonDAO {
    public void themHoaDonVN(HoaDon hoaDon);
    public void themHoaDonNuocNgoai(HoaDon hoaDon);
    public void xoaHoaDon(int maKH, HoaDon hoaDon);
    public void suaHoaDon(HoaDon hoaDon);
    public void tinhSoLuongTungLoai(int maKH);
    public void tbHoaDonNN();
    public List<HoaDon> xuatHoaDonTrongThang(HoaDon hoaDon, int thang, int nam);
    public HoaDon timKiemID(int maKH,HoaDon hoaDon);   
    public HoaDon timKiemTenVN(String hotenKH); 
    public HoaDon timKiemTenNN(String hotenKH);
    
}
  