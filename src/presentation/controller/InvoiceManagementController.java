package presentation.controller;

import view.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;

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
import presentation.view.ManagementApp;
import domain.model.HoaDon;
import domain.model.HoaDonNuocNgoai;

public class InvoiceManagementController implements ActionListener {
    private  ManagementApp managementAppRemote;
    
    public InvoiceManagementController(ManagementApp managementAppRemote) {
        this.managementAppRemote = managementAppRemote;
       
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        //gửi thông điệp đên view
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
        // lấy dữ liệu từ view
        String fullName = fullNameCustomer.getText();
        String customerId = customerIdField.getText();
        String invoiceDate = invoiceDateField.getText();
        String quantity = quantityField.getText();
        String unitPrice = unitPriceField.getText();
        String quota = quotaField.getText();
        String nationality = nationalityField.getText();

        if(e.getSource() == addButton){
            HoaDon hoaDon = new HoaDonNuocNgoai();
            HoadonService service = new HoaDon_Them();
            service.action(hoaDon);
            tableModel.setRowCount(0);
            tableModel.addRow(new Object[]{tableModel.getRowCount() +1, hoaDon.getMaHD(),hoaDon.getHoVaTen(),hoaDon.getSoLuong(),hoaDon.getDonGia(),hoaDon.thanhTien()});
          
        }
        
        
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
