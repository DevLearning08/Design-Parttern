package domain;

import pesistence.HoaDonGateway;
import pesistence.HoaDonGatewayImpl;

public class HoadonService {
    //instance field
    private HoaDonGateway HD;

    //consttructor
    public HoadonService(){
        HoaDonGateway HD;
    }
    public void themHoaDon(){
        HD= new HoaDonGatewayImpl();
        HD.themHoaDon();

    }
    public void xoaHoaDon(){
        HD  = new HoaDonGatewayImpl();
        HD.xoaHoaDon();
    }
}
