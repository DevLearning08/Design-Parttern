package domain;

import java.util.ArrayList;
import java.util.List;

public class Publisher {
    List <Subcriber> subcribers = new ArrayList<>();
    public void themObserver(Subcriber s){
        subcribers.add(s);
    }
    public void xoaObserver(Subcriber s){
        subcribers.remove(s);
    }
    public void thongBao(){
        for(Subcriber s : subcribers){
            s.thongBao();
        }
    }
}
