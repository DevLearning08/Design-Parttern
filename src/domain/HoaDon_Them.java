package domain;

import domain.model.HoaDon;
import domain.model.HoaDonNuocNgoai;
import domain.model.HoaDonVietNam;
import pesistence.HoaDonDAO;
import pesistence.HoaDonDAOImpl;

public class HoaDon_Them implements HoadonService{
    
    public void action(HoaDon hoaDon) {
        if(hoaDon instanceof HoaDonVietNam){
            HoaDonDAO hoaDon_them = new HoaDonDAOImpl();
            hoaDon_them.themHoaDonVN(hoaDon);
        }
        else if(hoaDon instanceof HoaDonNuocNgoai){
            HoaDonDAO hoaDon_them = new HoaDonDAOImpl();
            hoaDon_them.themHoaDonNuocNgoai(hoaDon);
        }
      
    }
    

}
