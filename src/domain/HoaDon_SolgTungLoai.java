package domain;

import java.util.List;

import domain.model.HoaDon;
import pesistence.HoaDonDAO;
import pesistence.HoaDonDAOImpl;

public class HoaDon_SolgTungLoai extends HoadonService {
    
    public void action(HoaDon hoaDon,int maKH,int maHD,String hotenKH, String customerType){
        
        HoaDonDAO soLuongTungLoai = new HoaDonDAOImpl();
        soLuongTungLoai.tinhSoLuongTungLoai(maKH);
    }
    
}
