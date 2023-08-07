package presentation.controller;

import presentation.view.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JSpinner;
import javax.swing.JTable;
import javax.swing.JTextField;
// import domain
import javax.swing.table.DefaultTableModel;

import domain.HoaDon_SolgTungLoai;
import domain.HoaDon_Sua;
import domain.HoaDon_TBHHDNN;
import domain.HoaDon_Them;
import domain.HoaDon_Timkiem;
import domain.HoaDon_Xoa;
import domain.HoaDon_XuatHDThang;
import domain.HoadonService;
// import domain.model
import domain.model.HoaDonVietNam;
import pesistence.HoaDonGateway;
import pesistence.HoaDonGatewayImpl;
import presentation.view.ManagementApp;
import domain.model.DoiTuongKH;
import domain.model.HoaDon;
import domain.model.HoaDonNuocNgoai;

public class InvoiceManagementController implements ActionListener {
    private  ManagementApp managementAppRemote;
    private HoaDon hoaDon;
     //DefaultTableModel tableModel = managementAppRemote.getTableModel();
    //JTable table = managementAppRemote.getTable();
    public InvoiceManagementController(ManagementApp managementAppRemote) {
        this.managementAppRemote = managementAppRemote;
       
        
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        //gửi thông điệp đên view
        hoaDon = managementAppRemote.getHoaDonRemote();
        JTextField fullNameCustomer = managementAppRemote.getFullNameField();
        JTextField customerIdField = managementAppRemote.getCustomerIdField();
        JTextField invoiceDateField = managementAppRemote.getInvoiceDateField();
        JTextField quantityField = managementAppRemote.getQuantityField();
        JTextField unitPriceField = managementAppRemote.getUnitPriceField();
        JTextField quotaField = managementAppRemote.getQuotaField();
        JTextField nationalityField = managementAppRemote.getNationalityField();
        JButton addButton = managementAppRemote.getAddButton();
        JButton findButton = managementAppRemote.getFindButton();
        JButton deleteButton = managementAppRemote.getDeleteButton();
        JButton calculateButton = managementAppRemote.getCalculateButton();
        JButton editButton = managementAppRemote.getEditButton();
        JButton TBHDNNButton = managementAppRemote.getTBHDNNButton();
        JButton exportButtom = managementAppRemote.getExportButton();
        DefaultTableModel tableModel = managementAppRemote.getTableModel();
        JTable table = managementAppRemote.getTable();
        JComboBox customerTypeComboBox = managementAppRemote.getCustomerTypeComboBox();
        JComboBox customerObjectComboBox = managementAppRemote.getCustomerObjectComboBox();
        String customerType = (String) customerTypeComboBox.getSelectedItem();
        
        // lấy dữ liệu từ view
        String fullName = fullNameCustomer.getText();
        int customerId = Integer.parseInt(customerIdField.getText());
        Date invoiceDate =Date.valueOf( invoiceDateField.getText());
        double quantity =Double.parseDouble( quantityField.getText());
        double unitPrice =Double.parseDouble( unitPriceField.getText());
       
        String nationality = nationalityField.getText();


            

         
        if(e.getActionCommand() == "Thêm"){
            if(customerTypeComboBox.getSelectedItem().equals("Khách hàng nước ngoài")){
            hoaDon = new HoaDonNuocNgoai();
            
            hoaDon.setMaHD( customerId);
            hoaDon.setHotenKH(fullName);
            hoaDon.setNgayraHD(invoiceDate);
            hoaDon.setSoLuong(quantity);
            hoaDon.setDonGia(unitPrice);
            ((HoaDonNuocNgoai) hoaDon).setQuocTich(nationality);
            ((HoaDonNuocNgoai)hoaDon).thanhTien();
            HoadonService service = new HoaDon_Them();
            service.action(hoaDon);
            
            showNN();
            // service2.action(hoaDon);
            // managementAppRemote.showAll();
        }else if(customerTypeComboBox.getSelectedItem().equals("Khách hàng Việt Nam")){
            //set lại giá trị cho HoadonVietNam
            
            hoaDon = new HoaDonVietNam();
            DoiTuongKH doiTuongKH = (DoiTuongKH) customerObjectComboBox.getSelectedItem();
            ((HoaDonVietNam) hoaDon).setDoiTuongHK(doiTuongKH);
            hoaDon.setMaHD( customerId);
            double quota =Double.parseDouble( quotaField.getText());
            hoaDon.setHotenKH(fullName);
            ((HoaDonVietNam) hoaDon).setDinhMuc(quota);
            hoaDon.setNgayraHD(invoiceDate);
            hoaDon.setSoLuong(quantity);
            hoaDon.setDonGia(unitPrice);
            HoadonService service = new HoaDon_Them();
            service.action(hoaDon);
            showVn();
            // HoadonService service2 = new HoaDon_GetAll();
            // service2.action(hoaDon);
            // managementAppRemote.showAll();
        }
        }else if(e.getSource()==deleteButton ){
            
            int selctindex = table.getSelectedRow();
            if(selctindex !=-1){
                tableModel.removeRow(selctindex);
                hoaDon = new HoaDonNuocNgoai();
                hoaDon = (HoaDon) table.getValueAt( selctindex, 0);
                if(hoaDon instanceof HoaDonNuocNgoai){
                    
                
                HoadonService service = new HoaDon_Xoa();
                service.action(hoaDon);
            }else if(hoaDon instanceof HoaDonVietNam){
                HoadonService service = new HoaDon_Xoa();
                service.action(hoaDon);
        }
    }
            
        }else if(e.getSource() == table)   {
            showSelectedHoadonInfo(hoaDon);
        }
    }
    public void showVn(){
        
       HoaDon hoaDonvn = new HoaDonVietNam(); 
       HoaDonGateway service = new HoaDonGatewayImpl();
       //HoadonService service = new HoaDon_GetAll();
       List<HoaDon> list = service.getHoaDonVN();
        DefaultTableModel tableModel = managementAppRemote.getTableModel();
        JTable table = managementAppRemote.getTable();
       
        tableModel.setRowCount(0);
            for (HoaDon hoaDon : list) {
                tableModel.addRow(new Object[]{ hoaDon.getMaHD(),hoaDon.getHotenKH(),hoaDon.getSoLuong(),((HoaDonVietNam) hoaDon).getDinhMuc(),((HoaDonVietNam) hoaDon).getDoiTuongHK(),hoaDon.getNgayraHD(),hoaDon.getDonGia()});
                table.setModel(tableModel);
            } 
    }
    public void showNN(){
        HoaDon hoaDonNN = new HoaDonNuocNgoai(); 
       HoaDonGateway service = new HoaDonGatewayImpl();
       //HoadonService service = new HoaDon_GetAll();
       List<HoaDon> list = service.getHoaDonNN();
        DefaultTableModel tableModel = managementAppRemote.getTableModel();
        JTable table = managementAppRemote.getTable();
       
        tableModel.setRowCount(0);
            for (HoaDon hoaDon : list) {
                tableModel.addRow(new Object[]{ hoaDon.getMaHD(),hoaDon.getHotenKH(),hoaDon.getSoLuong(),hoaDon.getNgayraHD(),((HoaDonNuocNgoai) hoaDon).getQuocTich(),hoaDon.getDonGia()});
                table.setModel(tableModel);
            } 
    }
    public void showSelectedHoadonInfo(HoaDon hoaDon) {
       JTable table = managementAppRemote.getTable();
       HoadonService service = new HoaDon_Timkiem();
        
        int selectedRow = table.getSelectedRow();
        if(hoaDon instanceof HoaDonNuocNgoai){
            
        if (selectedRow != -1) {
            int hoaDonId = (int) table.getValueAt(selectedRow, 0);

            service.action(hoaDon);
            if (hoaDon != null) {
                populateInputFields(hoaDon);
            }
        }}
    }
    public  void populateInputFields(HoaDon hoaDon) {
         JTextField fullNameCustomer = managementAppRemote.getFullNameField();
        JTextField customerIdField = managementAppRemote.getCustomerIdField();
        JTextField invoiceDateField = managementAppRemote.getInvoiceDateField();
        JTextField quantityField = managementAppRemote.getQuantityField();
        JTextField unitPriceField = managementAppRemote.getUnitPriceField();
        JTextField quotaField = managementAppRemote.getQuotaField();
        JTextField nationalityField = managementAppRemote.getNationalityField();
        JComboBox customerTypeComboBox = managementAppRemote.getCustomerTypeComboBox();
        JComboBox customerObjectComboBox = managementAppRemote.getCustomerObjectComboBox();
        fullNameCustomer.setText(hoaDon.getHotenKH());
        customerIdField.setText(String.valueOf(hoaDon.getMaHD()));
        invoiceDateField.setText(String.valueOf(hoaDon.getNgayraHD()));
        quantityField.setText(String.valueOf(hoaDon.getSoLuong()));
        unitPriceField.setText(String.valueOf(hoaDon.getDonGia()));
        quotaField.setText(String.valueOf(((HoaDonNuocNgoai) hoaDon).getQuocTich()));
        nationalityField.setText(((HoaDonNuocNgoai) hoaDon).getQuocTich());
        customerTypeComboBox.setSelectedItem(((HoaDonNuocNgoai) hoaDon).getQuocTich());
        customerObjectComboBox.setSelectedItem(((HoaDonVietNam) hoaDon).getDoiTuongHK());
        
    }
    // private ManagementApp managementAppRemote;
    // private HoadonService hoadonServiceRemote;
    // private  HoaDon hoaDon;
    // // lấy dữ liệu từ các celJTextField, fahJTextField , jComboBox tại Boundary
    // JComboBox customerTypeComboBoxRemote = managementAppRemote.getCustomerTypeComboBox();
    // String customerType = (String) customerTypeComboBoxRemote.getSelectedItem();
    // JTextField fullNameCustomer = managementAppRemote.getFullNameField();
    // String fullName = fullNameCustomer.getText();
    // JTextField  customerIdFieldRemote = managementAppRemote.getCustomerIdField();
    // String customerIdField = customerIdFieldRemote.getText();
    // JComboBox customerOjectComboBoxRemote = managementAppRemote.getCustomerObjectComboBox();
    // String customerOject = (String) customerOjectComboBoxRemote.getSelectedItem();
    // // lấy ngày tháng năm
    // JSpinner invoiceDateFieldRemote = managementAppRemote.getInvoiceDateField();
    // Date invoiceDateField = (Date) invoiceDateFieldRemote.getValue();
    
    // JTextField quantityFieldRemote = managementAppRemote.getQuantityField();
    // String quantityField = quantityFieldRemote.getText();
    // JTextField unitPriceFieldRemote = managementAppRemote.getUnitPriceField();
    // String unitPriceField = unitPriceFieldRemote.getText();
    // JTextField quotaFieldRemote = managementAppRemote.getQuotaField();
    // String quotaField = quotaFieldRemote.getText();
    // JTextField nationalityFieldRemote = managementAppRemote.getNationalityField();
    // String nationalityField = nationalityFieldRemote.getText();



    // public InvoiceManagementController(ManagementApp managementAppRemote) {
    //     this.managementAppRemote = managementAppRemote;
    //     this.initializeListeners();
    // }
  




    // public void initializeListeners() {
    //     JButton searchButtonRemote = managementAppRemote.getFindButton();
    //     searchButtonRemote.addActionListener(new ActionListener() {
    //         @Override
    //         public void actionPerformed(ActionEvent e) {
    //             try {
    //                 if (customerType == "Khách hàng Việt Nam"){
    //                     hoadonServiceRemote = new HoaDon_Timkiem();
    //                     customerIdFieldRemote= managementAppRemote.getCustomerIdField();
    //                     customerIdField = customerIdFieldRemote.getText();
    //                     int maKH = Integer.parseInt(customerIdField);
    //                     HoaDon hoaDon = new HoaDonVietNam();
    //                     hoadonServiceRemote.action(hoaDon);
    //                 }
                   
    //             } catch (Exception ex) {
    //                 JOptionPane.showMessageDialog(null, "Lưu không thành công 1");
    //             }
    //         }
    //     });

    //     JButton addButtonRemote = managementAppRemote.getAddButton();
    //     addButtonRemote.addActionListener(new ActionListener() {
    //         @Override
    //         public void actionPerformed(ActionEvent e) {
    //             hoaDon = new HoaDonVietNam();
    //             try {
    //                 if(validateInputFields()) {
    //                     if(customerType == "Khách hàng Việt Nam"){
    //                     hoaDon = new HoaDonVietNam();
    //                     hoadonServiceRemote = new HoaDon_Them();
    //                     hoadonServiceRemote.action(hoaDon);
                        
    //                 }
    //             } catch (Exception ex) {
    //                 JOptionPane.showMessageDialog(null, "Thêm không thành công");
    //             }
    //         }
    //     });

    //     JButton deleteButtonRemote = managementAppRemote.getDeleteButton();
    //     deleteButtonRemote.addActionListener(new ActionListener() {
    //         @Override
    //         public void actionPerformed(ActionEvent e) {
    //             try {
    //                 hoadonServiceRemote = new HoaDon_Xoa();
    //                 hoadonServiceRemote.action(hoaDon);
    //             } catch (Exception ex) {
    //                 JOptionPane.showMessageDialog(null, "Xoá không thành công");
    //             }
    //         }
    //     });

    //     JButton updateButtonRemote = managementAppRemote.getEditButton();
    //     updateButtonRemote.addActionListener(new ActionListener() {
    //         @Override
    //         public void actionPerformed(ActionEvent e) {
    //             if (validateInputFields()) {
    //                 try {
    //                     hoadonServiceRemote = new HoaDon_Sua();
    //                     hoadonServiceRemote.action(hoaDon);
    //                 } catch (Exception ex) {
    //                     JOptionPane.showMessageDialog(null, "Sửa không thành công");
    //                 }
    //             }
    //         }
    //     });

    //     JButton calculateButtonRemote = managementAppRemote.getCalculateButton();
    //     calculateButtonRemote.addActionListener(new ActionListener() {
    //         @Override
    //         public void actionPerformed(ActionEvent e) {
    //             try {
    //                 hoadonServiceRemote = new HoaDon_SolgTungLoai();
    //                 hoadonServiceRemote.action(hoaDon);
    //             } catch (Exception ex) {
    //                 JOptionPane.showMessageDialog(null, "Tính hóa đơn không thành công");
    //             }
    //         }
    //     });

    //     JButton exportButtonRemote = managementAppRemote.getExportButton();
    //     exportButtonRemote.addActionListener(new ActionListener() {
    //         @Override
    //         public void actionPerformed(ActionEvent e) {
                
    //             try {
    //                 hoadonServiceRemote = new HoaDon_XuatHDThang();
    //                 hoadonServiceRemote.action(hoaDon);
    //             } catch (Exception ex) {
    //                 JOptionPane.showMessageDialog(null, "Xuất hóa đơn tháng không thành công");
    //             }
    //         }
    //     });

    //     JButton TBHDNNButtonRemote = managementAppRemote.getTBHDNNButton();
    //     TBHDNNButtonRemote.addActionListener(new ActionListener() {
    //         @Override
    //         public void actionPerformed(ActionEvent e) {
    //             HoaDon hoaDon = new HoaDonNuocNgoai();
    //             try {
    //                 hoadonServiceRemote = new HoaDon_TBHHDNN();
    //                 hoadonServiceRemote.action(hoaDon);
    //             } catch (Exception ex) {
    //                 JOptionPane.showMessageDialog(null, "Tính trung bình hóa đơn nước ngoài không thành công");
    //             }
    //         }
    //     });
    // }

    // private boolean validateInputFields() {
        
    //     return true;
    // }

    // @Override
    // public void actionPerformed(ActionEvent e) {
        
    // }
}
