package domain;

import javax.swing.table.DefaultTableModel;

import domain.model.HoaDon;
import pesistence.HoaDonDAO;
import pesistence.HoaDonDAOImpl;

public class HoaDon_XuatHDThang implements HoadonService{
    public void action(HoaDon hoaDon){
        HoaDonDAO hoaDon_xuat = new HoaDonDAOImpl();
        hoaDon_xuat.xuatHoaDonTrongThang(hoaDon);

    }
}
