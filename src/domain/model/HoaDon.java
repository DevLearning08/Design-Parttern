package domain.model;

public abstract class HoaDon {
    int maKH;
    String hotenKH;
    String ngayraHD;
    Double soLuong;
    Double donGia;


    public HoaDon(int maKH, String hotenKH, String ngayraHD, Double soLuong, Double donGia) {
        this.maKH = maKH;
        this.hotenKH = hotenKH;
        this.ngayraHD = ngayraHD;
        this.soLuong = soLuong;
        this.donGia = donGia;
    }

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

    public String getNgayraHD() {
        return ngayraHD;
    }

    public void setNgayraHD(String ngayraHD) {
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
