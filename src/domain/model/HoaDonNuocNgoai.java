package domain.model;

import java.util.Date;
public class HoaDonNuocNgoai extends HoaDon{
    private String quocTich;
    
    public HoaDonNuocNgoai(int maKH, String hotenKH, Date ngayraHD, Double soLuong, Double donGia, String quocTich, Double thanhTien) {
        super(maKH, hotenKH, ngayraHD, soLuong, donGia);
        this.quocTich = quocTich;
    }
    public HoaDonNuocNgoai(int i, String string, java.sql.Date date, double d, double e, double f){

    }
    public HoaDonNuocNgoai(){}
   
    public String getQuocTich() {
        return quocTich;
    }

    public void setQuocTich(String quocTinc) {
        this.quocTich = quocTinc;
    }

    @Override
    public Double thanhTien() {
        Double thanhTien = getDonGia() * getSoLuong();
        return thanhTien;
    }

    public String toString(){
        return getMaHD() + " " + getHotenKH() + " " + getNgayraHD() + " " + getSoLuong() + " " + getDonGia() + " " + quocTich + " " + thanhTien();
    }
}
