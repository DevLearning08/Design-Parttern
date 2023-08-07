package domain.model;

import java.util.Date;

public class HoaDonVietNam extends HoaDon {
    private String doiTuongHK;
    private Double dinhMuc;
    
    public HoaDonVietNam(int maKH, String hotenKH, Date ngayraHD, Double soLuong, Double donGia, String doiTuongHK, Double dinhMuc, Double thanhTien) {
        super(maKH, hotenKH, ngayraHD, soLuong, donGia);
        this.doiTuongHK = doiTuongHK;
        this.dinhMuc = dinhMuc;
    }
    public HoaDonVietNam(int i, String string, java.sql.Date date, double d, double e, String doiTuongKH, double f){}
    public HoaDonVietNam(){}
    @Override
    public Double thanhTien() {
        if(getSoLuong() <= dinhMuc){
            Double thanhTien = getDonGia() * getSoLuong();
            return thanhTien;
        }
        else{
            Double thanhTien =  getDonGia() * dinhMuc + ((getSoLuong() - dinhMuc)* getDonGia() * 2.5);
            return thanhTien;
        }
    }

    public String getDoiTuongHK() {
        return doiTuongHK;
    }

    public void setDoiTuongHK(String doiTuongHK) {
        this.doiTuongHK = doiTuongHK;
    }

    public Double getDinhMuc() {
        return dinhMuc;
    }

    public void setDinhMuc(Double dinhMuc) {
        this.dinhMuc = dinhMuc;
    }    
    public String toString(){
        return getMaHD() + " " + getHotenKH() + " " + getNgayraHD() + " " + getSoLuong() + " " + getDonGia() + " " + doiTuongHK + " " + dinhMuc + " " + thanhTien();
    }
}
