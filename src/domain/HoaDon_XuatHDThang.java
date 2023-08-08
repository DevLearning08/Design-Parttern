package domain;

import java.util.List;

import domain.model.HoaDon;
import pesistence.HoaDonDAO;
import pesistence.HoaDonDAOImpl;

public class HoaDon_XuatHDThang extends HoadonService{
    public void action(HoaDon hoaDon,int maKH,int maHD,String hotenKH, String customerType){
        HoaDonDAO hoaDon_xuat = new HoaDonDAOImpl();
        hoaDon_xuat.xuatHoaDonTrongThang(hoaDon);
    }
    
}
