package domain;

import java.util.List;

import domain.model.HoaDon;
import pesistence.HoaDonDAO;
import pesistence.HoaDonDAOImpl;

public class HoaDon_Timkiem extends HoadonService{
    HoaDonDAO hoaDon_Tim = new HoaDonDAOImpl();
    public void action(HoaDon hoaDon,int maKH,int maHD,String hotenKH, String customerType){
       
        hoaDon_Tim.timKiemID( hoaDon);
    }

    
    public List<HoaDon> getHoaDonVN() {
      return hoaDon_Tim.getHoaDonVN();
    }

    
    public List<HoaDon> getHoaDonNN() {
      return hoaDon_Tim.getHoaDonNN();
    }
}
