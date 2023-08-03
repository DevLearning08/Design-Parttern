package domain;

import domain.model.HoaDon;
import pesistence.HoaDonDAO;
import pesistence.HoaDonDAOImpl;

public class HoaDon_TBHHDNN implements HoadonService{
    public void action(HoaDon hoaDon){
        HoaDonDAO hoaDon_TB= new HoaDonDAOImpl();
        hoaDon_TB.tbHoaDonNN(hoaDon.getMaKH());
    }
}
