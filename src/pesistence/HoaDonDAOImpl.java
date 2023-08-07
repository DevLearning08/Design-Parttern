package pesistence;

import java.util.ArrayList;
import java.util.List;

import javax.swing.table.DefaultTableModel;

import domain.model.HoaDon;

public class HoaDonDAOImpl implements HoaDonDAO {
    //private HoaDonGateway hoaDonGateway;
     HoaDonGateway service = new HoaDonGatewayImpl();
    // public HoaDonDAOImpl(HoaDonGateway hoaDonGateway){
    //     this.hoaDonGateway = hoaDonGateway;
    // }
    public HoaDonDAOImpl(){
        
    }
   
    @Override
    public void themHoaDon(HoaDon hoaDon) {
        
        HoaDonGateway hoaDonGateway = new HoaDonGatewayImpl();
        hoaDonGateway.themHoaDon(hoaDon);
        
    }

    @Override
    public void xoaHoaDon( HoaDon hoaDon) {
        HoaDonGateway hoaDonGateway = new HoaDonGatewayImpl();
        hoaDonGateway.xoaHoaDon( hoaDon);
        
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

    // @Override
    // public void themHoaDonNuocNgoai(HoaDon hoaDon) {
    //     HoaDonGateway hoaDonGateway = new HoaDonGatewayImpl();
    //     hoaDonGateway.themHoaDonNuocNgoai(hoaDon);
    // }

    @Override
    public HoaDon timKiemTenNN(String hotenKH) {
        HoaDonGateway hoaDonGateway = new HoaDonGatewayImpl();
        return hoaDonGateway.timKiemTenNN(hotenKH);
    }

    @Override
    public List<HoaDon> getHoaDonVN() {
       HoaDonGateway hoaDonGateway = new HoaDonGatewayImpl();
      
       return hoaDonGateway.getHoaDonVN();
    }
    public List<HoaDon> getHoaDonNN(){
        HoaDonGateway hoaDonGateway = new HoaDonGatewayImpl();
        return hoaDonGateway.getHoaDonNN();
    }
     
}
