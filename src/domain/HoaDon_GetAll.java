package domain;

import domain.model.HoaDon;
import pesistence.HoaDonDAO;
import pesistence.HoaDonDAOImpl;

public class HoaDon_GetAll implements HoadonService {
   
    @Override
    public void action(HoaDon hoaDon) {
        HoaDonDAO  hoaDon_Tim = new HoaDonDAOImpl();
        hoaDon_Tim.getAllHoaDons();
    }
}
