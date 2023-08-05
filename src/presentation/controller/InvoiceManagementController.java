package controller;

import view.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JSpinner;
import javax.swing.JTextField;
// import domain

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
import domain.model.HoaDon;
import domain.model.HoaDonNuocNgoai;

public class InvoiceManagementController implements ActionListener {
    private ManagementApp managementAppRemote;
    private HoadonService hoadonServiceRemote;
    // lấy dữ liệu từ các celJTextField, fahJTextField , jComboBox tại Boundary
    JComboBox customerTypeComboBoxRemote = managementAppRemote.getCustomerTypeComboBox();
    String customerType = (String) customerTypeComboBoxRemote.getSelectedItem();
    JTextField fullNameCustomer = managementAppRemote.getFullNameField();
    String fullName = fullNameCustomer.getText();
    JTextField  customerIdFieldRemote = managementAppRemote.getCustomerIdField();
    String customerIdField = customerIdFieldRemote.getText();
    JComboBox customerOjectComboBoxRemote = managementAppRemote.getCustomerObjectComboBox();
    String customerOject = (String) customerOjectComboBoxRemote.getSelectedItem();
    // lấy ngày tháng năm
    JSpinner invoiceDateFieldRemote = managementAppRemote.getInvoiceDateField();
    Date invoiceDateField = (Date) invoiceDateFieldRemote.getValue();
    
    JTextField quantityFieldRemote = managementAppRemote.getQuantityField();
    String quantityField = quantityFieldRemote.getText();
    JTextField unitPriceFieldRemote = managementAppRemote.getUnitPriceField();
    String unitPriceField = unitPriceFieldRemote.getText();
    JTextField quotaFieldRemote = managementAppRemote.getQuotaField();
    String quotaField = quotaFieldRemote.getText();
    JTextField nationalityFieldRemote = managementAppRemote.getNationalityField();
    String nationalityField = nationalityFieldRemote.getText();



    public InvoiceManagementController(ManagementApp managementAppRemote) {
        this.managementAppRemote = managementAppRemote;
        this.initializeListeners();
    }
  




    public void initializeListeners() {
        JButton searchButtonRemote = managementAppRemote.getFindButton();
        searchButtonRemote.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    if (customerType == "Khách hàng Việt Nam"){
                        hoadonServiceRemote = new HoaDon_Timkiem();
                        
                        HoaDon hoaDon = new HoaDonVietNam();
                        hoadonServiceRemote.action(hoaDon);
                    }
                   
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, "Lưu không thành công 1");
                }
            }
        });

        JButton addButtonRemote = managementAppRemote.getAddButton();
        addButtonRemote.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    if(validateInputFields()) {
                        hoadonServiceRemote = new HoaDon_Them();
                        hoadonServiceRemote.action();
                        
                    }
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, "Thêm không thành công");
                }
            }
        });

        JButton deleteButtonRemote = managementAppRemote.getDeleteButton();
        deleteButtonRemote.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    hoadonServiceRemote = new HoaDon_Xoa();
                    hoadonServiceRemote.action();
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, "Xoá không thành công");
                }
            }
        });

        JButton updateButtonRemote = managementAppRemote.getEditButton();
        updateButtonRemote.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (validateInputFields()) {
                    try {
                        hoadonServiceRemote = new HoaDon_Sua();
                        hoadonServiceRemote.action();
                    } catch (Exception ex) {
                        JOptionPane.showMessageDialog(null, "Sửa không thành công");
                    }
                }
            }
        });

        JButton calculateButtonRemote = managementAppRemote.getCalculateButton();
        calculateButtonRemote.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    hoadonServiceRemote = new HoaDon_SolgTungLoai();
                    hoadonServiceRemote.action();
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, "Tính hóa đơn không thành công");
                }
            }
        });

        JButton exportButtonRemote = managementAppRemote.getExportButton();
        exportButtonRemote.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    hoadonServiceRemote = new HoaDon_XuatHDThang();
                    hoadonServiceRemote.action();
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, "Xuất hóa đơn tháng không thành công");
                }
            }
        });

        JButton TBHDNNButtonRemote = managementAppRemote.getTBHDNNButton();
        TBHDNNButtonRemote.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    hoadonServiceRemote = new HoaDon_TBHHDNN();
                    hoadonServiceRemote.action();
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, "Tính trung bình hóa đơn nước ngoài không thành công");
                }
            }
        });
    }

    private boolean validateInputFields() {
        
        return true;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
    }
}
