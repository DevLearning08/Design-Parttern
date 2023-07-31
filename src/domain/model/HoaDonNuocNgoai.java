package domain.model;

public class HoaDonNuocNgoai extends HoaDon{
    public String quocTinh;
    
    public HoaDonNuocNgoai(int maKH, String hotenKH, String ngayraHD, Double soLuong, Double donGia, String quocTinh) {
        super(maKH, hotenKH, ngayraHD, soLuong, donGia);
        this.quocTinh = quocTinh;
    }

    public String getQuocTinh() {
        return quocTinh;
    }

    public void setQuocTinh(String quocTinh) {
        this.quocTinh = quocTinh;
    }

    @Override
    public Double thanhTien() {
        return soLuong * donGia;
    }

    
}
