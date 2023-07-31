package pesistence;
import java.util.List;

import domain.model.HoaDon;

public interface HoaDonGateway {
    public void themHoaDon();
    public void xoaHoaDon();
    public void suaHoaDon();
    public void tinhSoLuongTungLoai();
    public void tbHoaDonNN();
    public List<HoaDon> xuatHoaDonTrongThang();
    public List<HoaDon> timKiem();    
}
