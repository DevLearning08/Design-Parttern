package presentation.controller;

import presentation.view.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;
import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JTable;
import javax.swing.JTextField;
// import domain
import javax.swing.table.DefaultTableModel;

import domain.HoaDon_Sua;
import domain.HoaDon_Them;
// import domain.HoaDonServiceImp;
import domain.HoaDon_Xoa;
import domain.Subcriber;
import domain.model.HoaDonVietNam;
import pesistence.HoaDonGateway;
import pesistence.HoaDonGatewayImpl;
import presentation.view.ManagementApp;

import domain.model.HoaDon;
import domain.model.HoaDonNuocNgoai;
public class InvoiceManagementController implements ActionListener ,MouseListener {

    private  ManagementApp managementAppRemote;
    private HoaDon hoaDon;
   


    public InvoiceManagementController(ManagementApp managementAppRemote) {
        this.managementAppRemote = managementAppRemote;
        
        JComboBox<String> customerTypeComboBox = managementAppRemote.getCustomerTypeComboBox();
    if (customerTypeComboBox != null) {
        customerTypeComboBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                handleCustomerTypeSelection();
            }
        });}
    }
    public void handleCustomerTypeSelection() {
        String customerType = (String) managementAppRemote.getCustomerTypeComboBox().getSelectedItem();
        if (customerType.equals("Khách hàng Việt Nam")) {
            ShowVN();
        } else if (customerType.equals("Khách hàng nước ngoài")) {
            ShowNN();
        }
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        String customerType = (String) managementAppRemote.getCustomerTypeComboBox().getSelectedItem();
        String customerOject = (String) managementAppRemote.getCustomerObjectComboBox().getSelectedItem();
        String fullName = managementAppRemote.getFullNameField().getText();
        
        Date invoiceDate = Date.valueOf(managementAppRemote.getInvoiceDateField().getText());
        
        
        if (e.getActionCommand().equals("Thêm")) {
            double quantity = Double.parseDouble(managementAppRemote.getQuantityField().getText());
            double unitPrice = Double.parseDouble(managementAppRemote.getUnitPriceField().getText());
            double quota = Double.parseDouble(managementAppRemote.getQuotaField().getText());
            int customerId = Integer.parseInt(managementAppRemote.getCustomerIdField().getText());
            String nationality = managementAppRemote.getNationalityField().getText();
                if (customerType.equals("Khách hàng nước ngoài")) {
                    
                    HoaDon hoaDon = new HoaDonNuocNgoai();
                    hoaDon.setMaHD(customerId);
                    hoaDon.setHotenKH(fullName);
                    hoaDon.setNgayraHD(invoiceDate);
                    hoaDon.setSoLuong(quantity);
                    hoaDon.setDonGia(unitPrice);
                    ((HoaDonNuocNgoai) hoaDon).setQuocTich(nationality);
                    ((HoaDonNuocNgoai) hoaDon).thanhTien();
                    HoaDon_Them hoaDon_Them = new HoaDon_Them();
                    hoaDon.themObserver(managementAppRemote);
                    hoaDon_Them.action(hoaDon, customerId, customerId, fullName, customerType);
                    hoaDon.xoaObserver(managementAppRemote);
                    // ShowNN();
                } else if (customerType.equals("Khách hàng Việt Nam")) {
                    HoaDon hoaDon = new HoaDonVietNam();
                    ((HoaDonVietNam) hoaDon).setDoiTuongHK(customerOject);
                    hoaDon.setMaHD(customerId);
                    hoaDon.setHotenKH(fullName);
                    ((HoaDonVietNam) hoaDon).setDinhMuc(quota);
                    hoaDon.setNgayraHD(invoiceDate);
                    hoaDon.setSoLuong(quantity);
                    hoaDon.setDonGia(unitPrice);
                    HoaDon_Them hoaDon_Them = new HoaDon_Them();
                    hoaDon.themObserver(managementAppRemote);
                    hoaDon_Them.action(hoaDon, customerId, customerId, fullName, customerType);
                    hoaDon.xoaObserver(managementAppRemote);
                    // ShowVN();
                }
        } else if (e.getActionCommand().equals("Xoá")) {
            int selectedRow = managementAppRemote.getTable().getSelectedRow(); 
                if (customerType.equals("Khách hàng Việt Nam")) {
                    hoaDon = new HoaDonVietNam();
                    if(selectedRow != -1){
                        int customerId =(int) managementAppRemote.getTableModelVN().getValueAt(selectedRow, 0);
                        HoaDon_Xoa hoaDon_Xoa = new HoaDon_Xoa();
                        hoaDon.themObserver(managementAppRemote);
                        hoaDon_Xoa.action(hoaDon,customerId, customerId, fullName,customerType);
                        hoaDon.xoaObserver(managementAppRemote);
                    }
                    // ShowVN();
                } else if (customerType.equals("Khách hàng nước ngoài")) {
                    if(selectedRow != -1){
                        hoaDon = new HoaDonNuocNgoai();
                        int customerId =(int) managementAppRemote.getTableModelNN().getValueAt(selectedRow, 0);
                        HoaDon_Xoa hoaDon_Xoa = new HoaDon_Xoa();
                        hoaDon.themObserver(managementAppRemote);
                        hoaDon_Xoa.action(hoaDon,customerId, customerId, fullName,customerType);
                        hoaDon.xoaObserver(managementAppRemote);
                    }
                    // ShowNN();
                }
        }else if (e.getActionCommand().equals("Sửa")) {
            int selectedRow = managementAppRemote.getTable().getSelectedRow();
            if (customerType.equals("Khách hàng Việt Nam")) {
                if (selectedRow != -1) {
                    Object customerMA =managementAppRemote.getTableModelVN().getValueAt(selectedRow, 0);
                    int customerId= Integer.parseInt(customerMA.toString());
                    String Name = (String) managementAppRemote.getTableModelVN().getValueAt(selectedRow, 1);
                    Object quan = managementAppRemote.getTableModelVN().getValueAt(selectedRow, 2);
                    Double quanTity = Double.parseDouble(quan.toString());
                    Object quota = managementAppRemote.getTableModelVN().getValueAt(selectedRow, 3);
                    Double quotaPrice = Double.parseDouble(quota.toString());
                    Object Type = managementAppRemote.getTableModelVN().getValueAt(selectedRow, 4);
                    String tipe = Type.toString();
                    Date date = (Date) managementAppRemote.getTableModelVN().getValueAt(selectedRow, 5);
                    Object unit =  managementAppRemote.getTableModelVN().getValueAt(selectedRow, 6);
                    Double unitPrice = Double.parseDouble(unit.toString());
                    HoaDon hoaDon = new HoaDonVietNam();
                    ((HoaDonVietNam) hoaDon).setDoiTuongHK(tipe);
                    hoaDon.setMaHD(customerId);
                    hoaDon.setHotenKH(Name);
                    ((HoaDonVietNam) hoaDon).setDinhMuc(quotaPrice);
                    hoaDon.setNgayraHD(date);
                    hoaDon.setSoLuong(quanTity);
                    hoaDon.setDonGia(unitPrice);
                    HoaDon_Sua hoaDon_Sua = new HoaDon_Sua();
                    hoaDon.themObserver(managementAppRemote);
                    hoaDon_Sua.action(hoaDon,customerId, customerId, fullName,customerType);
                }
                // ShowVN();
            }else if (customerType.equals("Khách hàng nước ngoài")) {
                if (selectedRow != -1) {
                    Object customerMA =managementAppRemote.getTableModelNN().getValueAt(selectedRow, 0);
                    int customerId= Integer.parseInt(customerMA.toString());
                    String Name = (String) managementAppRemote.getTableModelNN().getValueAt(selectedRow, 1);

                    Object quan =  managementAppRemote.getTableModelNN().getValueAt(selectedRow, 2);
                    Double quanTity = Double.parseDouble(quan.toString());
                    Date date = (Date) managementAppRemote.getTableModelNN().getValueAt(selectedRow, 3);

                    Object natio =  managementAppRemote.getTableModelNN().getValueAt(selectedRow, 4);
                    String nationality = natio.toString();
                    Object unit = managementAppRemote.getTableModelNN().getValueAt(selectedRow, 5);
                    Double unitPrice = Double.parseDouble(unit.toString());
                    HoaDon hoaDon = new HoaDonNuocNgoai();
                    hoaDon.setMaHD(customerId);
                    hoaDon.setHotenKH(Name);
                    hoaDon.setNgayraHD(date);
                    hoaDon.setSoLuong(quanTity);
                    ((HoaDonNuocNgoai) hoaDon).setQuocTich(nationality);
                    hoaDon.setDonGia(unitPrice);
                    HoaDon_Sua hoaDon_Sua = new HoaDon_Sua();
                    hoaDon.themObserver(managementAppRemote);
                    hoaDon_Sua.action(hoaDon,customerId, customerId, fullName,customerType);
                }
                // ShowNN(); 
            }
        }else if (e.getActionCommand().equals("Xuất hóa đơn")){
                if (customerType.equals("Khách hàng Việt Nam")) {
                    ShowVN();
                }
                else if (customerType.equals("Khách hàng nước ngoài")) {
                    ShowNN();
                }
            }
    
    }
    @Override
    public void mouseClicked(MouseEvent e) {
        // Xử lý khi chuột được nhấn
        
        String customerType = (String) managementAppRemote.getCustomerTypeComboBox().getSelectedItem();
        if (customerType.equals("Khách hàng Việt Nam")) {
            managementAppRemote.setVietNamSelected(true);
            ShowVN();
        } else if (customerType.equals("Khách hàng nước ngoài")) {
            managementAppRemote.setVietNamSelected(false);
            ShowNN();
    }
    }
   
    @Override
    public void mousePressed(MouseEvent e) {
        // Xử lý khi chuột được nhấn
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        // Xử lý khi chuột được nhả ra sau khi nhấn
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        // Xử lý khi chuột vào vùng được lắng nghe sự kiện
    }

    @Override
    public void mouseExited(MouseEvent e) {
        // Xử lý khi chuột rời khỏi vùng được lắng nghe sự kiện
    }
    
    public void ShowVN(){
        DefaultTableModel tableModelVN = managementAppRemote.getTableModelVN();
        tableModelVN.setRowCount(0);
        HoaDon_Xoa hoaDon_Xoa = new HoaDon_Xoa();
        List<HoaDon> list = hoaDon_Xoa.getHoaDonVN();
        for (HoaDon hoaDon : list) {
            
            
            tableModelVN.addRow(new Object[]{hoaDon.getMaHD(),hoaDon.getHotenKH(),hoaDon.getSoLuong(),((HoaDonVietNam) hoaDon).getDinhMuc(),((HoaDonVietNam) hoaDon).getDoiTuongHK(),hoaDon.getNgayraHD(),hoaDon.getDonGia(),hoaDon.thanhTien()});
            managementAppRemote.getTable().setModel(tableModelVN);
        }
    }
      public void ShowNN(){
        DefaultTableModel tableModelNN = managementAppRemote.getTableModelNN();
        tableModelNN.setRowCount(0);
        HoaDon_Xoa hoaDon_Xoa = new HoaDon_Xoa();
        List<HoaDon> list = hoaDon_Xoa.getHoaDonNN();
        for (HoaDon hoaDon : list) {
            
            
            tableModelNN.addRow(new Object[]{hoaDon.getMaHD(),hoaDon.getHotenKH(),hoaDon.getSoLuong(),hoaDon.getNgayraHD(),((HoaDonNuocNgoai) hoaDon).getQuocTich(),hoaDon.getDonGia(),hoaDon.thanhTien()});
            managementAppRemote.getTable().setModel(tableModelNN);
        }
    }
   
}
