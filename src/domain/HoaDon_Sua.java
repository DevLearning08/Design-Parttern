package domain;

import domain.model.HoaDon;
import pesistence.HoaDonDAO;
import pesistence.HoaDonDAOImpl;

public class HoaDon_Sua implements HoadonService{
    public void action(HoaDon hoaDon){
        HoaDonDAO hoaDon_sua = new HoaDonDAOImpl();
        hoaDon_sua.suaHoaDon(hoaDon);
    }
}
