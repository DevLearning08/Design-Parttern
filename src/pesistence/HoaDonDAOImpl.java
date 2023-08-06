package pesistence;

import java.util.List;

import domain.model.HoaDon;

public class HoaDonDAOImpl implements HoaDonDAO {
    // private HoaDonGateway hoaDonGateway;
     
    // public HoaDonDAOImpl(HoaDonGateway hoaDonGateway){
    //     this.hoaDonGateway = hoaDonGateway;
    // }


    @Override
    public void themHoaDonVN(HoaDon hoaDon) {
        HoaDonGateway hoaDonGateway = new HoaDonGatewayImpl();
        hoaDonGateway.themHoaDonVN(hoaDon);
        
    }

    @Override
    public void xoaHoaDon(int maKH, HoaDon hoaDon) {
        HoaDonGateway hoaDonGateway = new HoaDonGatewayImpl();
        hoaDonGateway.xoaHoaDon(maKH, hoaDon);
        
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
    public void tbHoaDonNN() {
        HoaDonGateway hoaDonGateway = new HoaDonGatewayImpl();
        hoaDonGateway.tbHoaDonNN();
    }

    @Override
    public List<HoaDon> xuatHoaDonTrongThang(HoaDon hoaDon) {
        HoaDonGateway hoaDonGateway = new HoaDonGatewayImpl();
       return hoaDonGateway.xuatHoaDonTrongThang(hoaDon);
    }

    @Override
    public HoaDon timKiemID( HoaDon hoaDon) {
        HoaDonGateway hoaDonGateway = new HoaDonGatewayImpl();
        return hoaDonGateway.timKiemID( hoaDon);
    }
    
    @Override
    public HoaDon timKiemTenVN(String hotenKH) {
        HoaDonGateway hoaDonGateway = new HoaDonGatewayImpl();
        return hoaDonGateway.timKiemTenVN(hotenKH);
    }

    @Override
    public void themHoaDonNuocNgoai(HoaDon hoaDon) {
        HoaDonGateway hoaDonGateway = new HoaDonGatewayImpl();
        hoaDonGateway.themHoaDonNuocNgoai(hoaDon);
    }

    @Override
    public HoaDon timKiemTenNN(String hotenKH) {
        HoaDonGateway hoaDonGateway = new HoaDonGatewayImpl();
        return hoaDonGateway.timKiemTenNN(hotenKH);
    }
}
