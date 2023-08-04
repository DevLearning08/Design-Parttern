package pesistence;
import java.util.List;

import domain.model.HoaDon;

public interface HoaDonGateway {
    public void themHoaDonVN(HoaDon hoaDon);
    public void themHoaDonNuocNgoai(HoaDon hoaDon);
    public void xoaHoaDon(int maKH, HoaDon hoaDon);
    public void suaHoaDon(HoaDon hoaDon);
    public void tinhSoLuongTungLoai(int maKH);
    public void tbHoaDonNN(int maKH);
    public List<HoaDon> xuatHoaDonTrongThang();
    public HoaDon timKiemID(int maKH, HoaDon hoaDon);   
    public HoaDon timKiemTenNN(String hotenKH);
    public HoaDon timKiemTenVN(String hotenKH);
    public List<HoaDon> getAllHoaDons(int maKH); 
}
