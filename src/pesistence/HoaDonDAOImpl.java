package pesistence;

import java.util.List;

import domain.model.HoaDon;

public class HoaDonDAOImpl implements HoaDonDAO {
    private HoaDonGateway hoaDonGateway;
     
    public HoaDonDAOImpl(HoaDonGateway hoaDonGateway){
        this.hoaDonGateway = hoaDonGateway;
    }


    @Override
    public void themHoaDon(HoaDon hoaDon) {
        hoaDonGateway.themHoaDon(hoaDon);
        
    }

    @Override
    public void xoaHoaDon(int maKH) {
        hoaDonGateway.xoaHoaDon(maKH);
        
    }

    @Override
    public void suaHoaDon(HoaDon hoaDon) {
        hoaDonGateway.suaHoaDon(hoaDon);
    }

    @Override
    public void tinhSoLuongTungLoai(int maKH) {
        hoaDonGateway.tinhSoLuongTungLoai(maKH);
    }

    @Override
    public void tbHoaDonNN(int maKH) {
        hoaDonGateway.tbHoaDonNN(maKH);
    }

    @Override
    public List<HoaDon> xuatHoaDonTrongThang() {
       return hoaDonGateway.xuatHoaDonTrongThang();
    }

    @Override
    public HoaDon timKiemID(int maKH) {
        return hoaDonGateway.timKiemID(maKH);
    }
    
    @Override
    public HoaDon timKiemTen(String hotenKH) {
        return hoaDonGateway.timKiemTen(hotenKH);
    }
}
