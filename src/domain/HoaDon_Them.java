package domain;

import java.util.List;

import domain.model.HoaDon;
import domain.model.HoaDonNuocNgoai;
import domain.model.HoaDonVietNam;
import pesistence.HoaDonDAO;
import pesistence.HoaDonDAOImpl;

public class HoaDon_Them extends HoadonService{
    
    public void action(HoaDon hoaDon,int maKH,int maHD,String hotenKH, String customerType){ {
        HoaDonDAO hoaDon_xoa = new HoaDonDAOImpl();
        hoaDon_xoa.themHoaDon(hoaDon);
    }
    

    }
    HoaDonDAO hoaDon_Tim = new HoaDonDAOImpl();
    
    public List<HoaDon> getHoaDonVN() {
      return hoaDon_Tim.getHoaDonVN();
    }

    
    public List<HoaDon> getHoaDonNN() {
      return hoaDon_Tim.getHoaDonNN();
    }
}
