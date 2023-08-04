package pesistence;
import java.util.List;

import domain.model.HoaDon;

public interface HoaDonGateway {
    public void themHoaDon(HoaDon hoaDon);
    public void xoaHoaDon(int maKH);
    public void suaHoaDon(HoaDon hoaDon);
    public void tinhSoLuongTungLoai(int maKH);
    public void tbHoaDonNN(int maKH);
    public List<HoaDon> xuatHoaDonTrongThang();
    public HoaDon timKiemID(int maKH);   
    public HoaDon timKiemTen(String hotenKH);
    public List<HoaDon> getAllHoaDons(int maKH); 
}
