package pesistence;
import  domain.model.HoaDon;

public interface HoaDonGateway {
    void themHoaDon(HoaDon hoaDon);
    void xoaHoaDon(HoaDon hoaDon);
    void suaHoaDon(HoaDon hoaDon);
    void tinhSoLuongTungLoai();
    void tbHoaDonNN();
    void xuatHoaDonTrongThang();
    void timKiem();    
}
