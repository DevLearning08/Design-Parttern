package pesistence;

import java.util.List;

import domain.model.HoaDon;

public class HoaDonDAOImpl implements HoaDonDAO {
    // private HoaDonGateway hoaDonGateway;
     
    // public HoaDonDAOImpl(HoaDonGateway hoaDonGateway){
    //     this.hoaDonGateway = hoaDonGateway;
    // }


    @Override
    public void themHoaDon(HoaDon hoaDon) {
        HoaDonGateway hoaDonGateway = new HoaDonGatewayImpl();
        hoaDonGateway.themHoaDon(hoaDon);
        
    }

    @Override
    public void xoaHoaDon(int maKH) {
        HoaDonGateway hoaDonGateway = new HoaDonGatewayImpl();
        hoaDonGateway.xoaHoaDon(maKH);
        
    }

    @Override
    public void suaHoaDon(HoaDon hoaDon) {
        HoaDonGateway hoaDonGateway = new HoaDonGatewayImpl();
        hoaDonGateway.suaHoaDon(hoaDon);
    }

    @Override
    public void tinhSoLuongTungLoai(int maKH) {
        HoaDonGateway hoaDonGateway = new HoaDonGatewayImpl();
        hoaDonGateway.tinhSoLuongTungLoai(maKH);
    }

    @Override
    public void tbHoaDonNN(int maKH) {
        HoaDonGateway hoaDonGateway = new HoaDonGatewayImpl();
        hoaDonGateway.tbHoaDonNN(maKH);
    }

    @Override
    public List<HoaDon> xuatHoaDonTrongThang() {
        HoaDonGateway hoaDonGateway = new HoaDonGatewayImpl();
       return hoaDonGateway.xuatHoaDonTrongThang();
    }

    @Override
    public HoaDon timKiemID(int maKH) {
        HoaDonGateway hoaDonGateway = new HoaDonGatewayImpl();
        return hoaDonGateway.timKiemID(maKH);
    }
    
    @Override
    public HoaDon timKiemTen(String hotenKH) {
        HoaDonGateway hoaDonGateway = new HoaDonGatewayImpl();
        return hoaDonGateway.timKiemTen(hotenKH);
    }
}
