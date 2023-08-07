package domain;

import domain.model.HoaDon;
import domain.model.HoaDonNuocNgoai;
import domain.model.HoaDonVietNam;
import pesistence.HoaDonDAO;
import pesistence.HoaDonDAOImpl;

public class HoaDon_Them implements HoadonService{
    
    public void action(HoaDon hoaDon) {
        
            HoaDonDAO hoaDon_them = new HoaDonDAOImpl();
            hoaDon_them.themHoaDon(hoaDon);
        
    }
    

}
