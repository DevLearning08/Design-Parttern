package domain;


import domain.model.HoaDon;
import pesistence.HoaDonDAO;
import pesistence.HoaDonDAOImpl;

public class HoaDon_Sua extends HoadonService{
    public void action(HoaDon hoaDon,int maKH,int maHD,String hotenKH, String customerType){
        HoaDonDAO hoaDon_sua = new HoaDonDAOImpl();
        hoaDon_sua.suaHoaDon(hoaDon);
    }
    
}
