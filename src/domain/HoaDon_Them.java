package domain;

import domain.model.HoaDon;
import pesistence.HoaDonDAO;
import pesistence.HoaDonDAOImpl;

public class HoaDon_Them implements HoadonService{
    
    public void action(HoaDon hoaDon) {
        HoaDonDAO hoaDon_them= new HoaDonDAOImpl();
        hoaDon_them.themHoaDon(hoaDon);
    }
    

}
