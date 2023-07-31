package domain.model;

public class HoaDonVietNam extends HoaDon {
    private DoiTuongKH doiTuongHK;
    private Double dinhMuc;

    public HoaDonVietNam(int maKH, String hotenKH, String ngayraHD, Double soLuong, Double donGia, DoiTuongKH doiTuongHK, Double dinhMuc) {
        super(maKH, hotenKH, ngayraHD, soLuong, donGia);
        this.doiTuongHK = doiTuongHK;
        this.dinhMuc = dinhMuc;
    }

    @Override
    public Double thanhTien() {
        if(getSoLuong() <= dinhMuc){
            return getSoLuong() * getDonGia();
        }
        else{
            return (getSoLuong() * getDonGia() * dinhMuc) + ((getSoLuong() - dinhMuc)* getDonGia() * 2.5);
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
