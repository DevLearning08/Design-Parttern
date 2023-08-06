package domain;

import domain.model.HoaDon;
import pesistence.HoaDonDAO;
import pesistence.HoaDonDAOImpl;

public class HoaDon_SolgTungLoai implements HoadonService {
    
    public void action(HoaDon hoaDon){
        
        HoaDonDAO soLuongTungLoai = new HoaDonDAOImpl();
        soLuongTungLoai.tinhSoLuongTungLoai(hoaDon.getMaHD());
    }
}
