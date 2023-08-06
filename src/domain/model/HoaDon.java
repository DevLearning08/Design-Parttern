package domain.model;

import java.util.Date;

public abstract class HoaDon {
    private int maKH;
    private String hotenKH;
    private Date ngayraHD;
    private Double soLuong;
    private Double donGia;

    public HoaDon(int maKH, String hotenKH, Date ngayraHD, Double soLuong, Double donGia) {
        this.maKH = maKH;
        this.hotenKH = hotenKH;
        this.ngayraHD = ngayraHD;
        this.soLuong = soLuong;
        this.donGia = donGia;
    }
    public HoaDon(){}
    

    public abstract Double thanhTien();


    //getter & setter
    public int getMaKH() {
        return maKH;
    }

    public void setMaKH(int maKH) {
        this.maKH = maKH;
    }

    public String getHotenKH() {
        return hotenKH;
    }

    public void setHotenKH(String hotenKH) {
        this.hotenKH = hotenKH;
    }

    public Date getNgayraHD() {
        return ngayraHD;
    }

    public void setNgayraHD(Date ngayraHD) {
        this.ngayraHD = ngayraHD;
    }

    public Double getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(Double soLuong) {
        this.soLuong = soLuong;
    }

    public Double getDonGia() {
        return donGia;
    }

    public void setDonGia(Double donGia) {
        this.donGia = donGia;
    }


}
