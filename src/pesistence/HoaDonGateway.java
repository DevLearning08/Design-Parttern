package pesistence;
import java.sql.SQLException;
import java.util.List;

import javax.swing.table.DefaultTableModel;

import domain.model.HoaDon;

public interface HoaDonGateway {
    public List<HoaDon> themHoaDon(HoaDon hoaDon);
    //public void gopHoaDon(HoaDon hoaDon);
    //public void themHoaDonNuocNgoai(HoaDon hoaDon);
    public void xoaHoaDon(int maHD);
    public void suaHoaDon(HoaDon hoaDon);
    public void tinhSoLuongTungLoai(int maKH);
    public void tbHoaDonNN();
    public List<HoaDon> xuatHoaDonTrongThang(HoaDon hoaDon);
    public HoaDon timKiemID( HoaDon hoaDon);   
    public HoaDon timKiemTenNN(String hotenKH);
    public HoaDon timKiemTenVN(String hotenKH);
    public List<HoaDon> getHoaDonVN() ;
    public List<HoaDon> getHoaDonNN();
    
}
