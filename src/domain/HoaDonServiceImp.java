package domain;

import java.util.List;

import domain.model.HoaDon;
import pesistence.HoaDonDAO;
import pesistence.HoaDonDAOImpl;

public class HoaDonServiceImp implements HoadonService {
    HoaDonDAO dao;

    public HoaDonServiceImp() {
        dao = new HoaDonDAOImpl();
    }
    @Override
    public void themHoaDon(HoaDon hoaDon) {
      dao.themHoaDon(hoaDon);
    }

    @Override
    public void xoaHoaDon(int maHD) {
      dao.xoaHoaDon(maHD);
    }

    @Override
    public void suaHoaDon(HoaDon hoaDon) {
      dao.suaHoaDon(hoaDon);
    }

    @Override
    public void tinhSoLuongTungLoai(int maKH) {
      dao.tinhSoLuongTungLoai(maKH);
    }

    @Override
    public void tbHoaDonNN() {
      dao.tbHoaDonNN();
    }

    @Override
    public List<HoaDon> xuatHoaDonTrongThang(HoaDon hoaDon) {
      return dao.xuatHoaDonTrongThang(hoaDon);
    }

    @Override
    public HoaDon timKiemID(HoaDon hoaDon) {
      return dao.timKiemID(hoaDon);
    }

    @Override
    public HoaDon timKiemTenVN(String hotenKH) {
      return dao.timKiemTenVN(hotenKH);
    }

    @Override
    public HoaDon timKiemTenNN(String hotenKH) {
      return dao.timKiemTenNN(hotenKH);
    }

    @Override
    public List<HoaDon> getHoaDonVN() {
      return dao.getHoaDonVN();
    }

    @Override
    public List<HoaDon> getHoaDonNN() {
      return dao.getHoaDonNN();
    }
    
}
