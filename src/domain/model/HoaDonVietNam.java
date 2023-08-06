package domain.model;

import java.util.Date;

public class HoaDonVietNam extends HoaDon {
    private DoiTuongKH doiTuongHK;
    private Double dinhMuc;
    
    public HoaDonVietNam(int maKH, String hotenKH, Date ngayraHD, Double soLuong, Double donGia, DoiTuongKH doiTuongHK, Double dinhMuc, Double thanhTien) {
        super(maKH, hotenKH, ngayraHD, soLuong, donGia);
        this.doiTuongHK = doiTuongHK;
        this.dinhMuc = dinhMuc;
    }
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

    public DoiTuongKH getDoiTuongHK() {
        return doiTuongHK;
    }

    public void setDoiTuongHK(DoiTuongKH doiTuongHK) {
        this.doiTuongHK = doiTuongHK;
    }

    public Double getDinhMuc() {
        return dinhMuc;
    }

    public void setDinhMuc(Double dinhMuc) {
        this.dinhMuc = dinhMuc;
    }    
    
}
