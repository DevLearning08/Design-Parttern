package domain;

import domain.model.HoaDon;
import pesistence.HoaDonDAO;
import pesistence.HoaDonDAOImpl;

public class HoaDon_Xoa implements HoadonService{
    public void action(HoaDon hoaDon){
        HoaDonDAO hoaDon_xoa = new HoaDonDAOImpl();
        hoaDon_xoa.xoaHoaDon(hoaDon.getMaKH());
    }
}
