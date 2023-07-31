package domain.model;

public class HoaDonVietNam extends HoaDon {
    DoiTuongHK doiTuongHK;
    Double dinhMuc;

    public HoaDonVietNam(int maKH, String hotenKH, String ngayraHD, Double soLuong, Double donGia, DoiTuongHK doiTuongHK, Double dinhMuc) {
        super(maKH, hotenKH, ngayraHD, soLuong, donGia);
        this.doiTuongHK = doiTuongHK;
        this.dinhMuc = dinhMuc;
    }

    @Override
    public Double thanhTien() {
        if(soLuong <= dinhMuc){
            return soLuong * donGia;
        }
        else{
            return (soLuong * donGia * dinhMuc) + ((soLuong - dinhMuc)* donGia * 2.5);
        }
    }

    public DoiTuongHK getDoiTuongHK() {
        return doiTuongHK;
    }

    public void setDinhMuc(Double dinhMuc) {
        this.dinhMuc = dinhMuc;
    }    
    
}
