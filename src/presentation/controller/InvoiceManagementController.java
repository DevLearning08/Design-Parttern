package controller;

import view.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import domain.HoaDon_SolgTungLoai;
import domain.HoaDon_Sua;
import domain.HoaDon_TBHHDNN;
import domain.HoaDon_Them;
import domain.HoaDon_Timkiem;
import domain.HoaDon_Xoa;
import domain.HoaDon_XuatHDThang;
import domain.HoadonService;



public class InvoiceManagementController implements ActionListener {
    private ManagementApp managementAppRemote;
    private HoadonService hoadonServiceRemote;

    public InvoiceManagementController() {
        
    }


    public ManagementApp getManagementAppRemote() {
        return managementAppRemote;
    }

    public HoadonService getHoadonServiceRemote() {
        return hoadonServiceRemote;
    }


    public void actionPerformed(ActionEvent e) {
        // gửi message đến view (view input data)


        // lấy dữ liệu từ các celJTextField, fahJTextField , jComboBox tại Boundary
        JComboBox customerTypeComboBoxRemote = managementAppRemote.getCustomerTypeComboBox();
        String customerType = (String) customerTypeComboBoxRemote.getSelectedItem();

        JTextField fullNameCustomer = managementAppRemote.getFullNameField();
        String fullName = fullNameCustomer.getText();

        JTextField  customerIdFieldRemote = managementAppRemote.getCustomerIdField();
        String customerIdField = customerIdFieldRemote.getText();

        JComboBox customerOjectComboBoxRemote = managementAppRemote.getCustomerObjectComboBoxRemote();
        String customerOject = (String) customerOjectComboBoxRemote.getSelectedItem();

        JTextField invoiceDateFieldRemote = managementAppRemote.getInvoiceDateFieldRemote();
        String invoiceDateField = invoiceDateFieldRemote.getText();

        JTextField quantityFieldRemote = managementAppRemote.getQuantityFieldRemote();
        String quantityField = quantityFieldRemote.getText();

        JTextField unitPriceFieldRemote = managementAppRemote.getUnitPriceFieldRemote();
        String unitPriceField = unitPriceFieldRemote.getText();

        JTextField quotaFieldRemote = managementAppRemote.getQuotaFieldRemote();
        String quotaField = quotaFieldRemote.getText();

        JTextField nationalityFieldRemote = managementAppRemote.getNationalityFieldRemote();
        String nationalityField = nationalityFieldRemote.getText();
        
        HoadonService modelRemote = managementAppRemote.getHoadonServiceRemote();


        HoadonService tinhHoaDonTungloai = new HoaDon_SolgTungLoai();
        HoadonService them = new HoaDon_Them();
        HoadonService sua = new HoaDon_Sua();
        HoadonService xoa = new HoaDon_Xoa();
        HoadonService timKiem = new HoaDon_Timkiem();
        HoadonService TBHHDNN = new HoaDon_TBHHDNN();
        HoadonService xuatHoaDonThang = new HoaDon_XuatHDThang();


        // tim kiem trong database
        JButton searchButtonRemote = managementAppRemote.getSearchButtonRemote();
        try {
            searchButtonRemote.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                    timKiem.action();
                }
            
        });
        } catch (Exception ex) {
            // TODO: handle exception
            JOptionPane.showMessageDialog(null,"Lưu không thành công 1");
        }
        
        // them moi 
        JButton addButtonRemote = managementAppRemote.getAddButtonRemote();
        addButtonRemote.addActionListener(new ActionListener() {
            // Xử lý sự kiện khi nhấn nut them
            @Override
            public void actionPerformed(ActionEvent e) {
                
            // Gọi phương thức thêm mới 
            them.action();
        }
        });
        
        // delete
        JButton deleteButtonRemote = managementAppRemote.getDeleteButtonRemote();
        deleteButtonRemote.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                xoa.action();
            }
        });
        
        // sua 
        
        JButton updateButtonRemote = managementAppRemote.getUpdateButtonRemote();
        updateButtonRemote.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (customerType.isEmpty() && fullName.isEmpty() && customerIdField.isEmpty() && customerOject.isEmpty()
                        && invoiceDateField.isEmpty() && quantityField.isEmpty() && unitPriceField.isEmpty() && quotaField.isEmpty() && nationalityField.isEmpty()
                ) {
                    sua.action();
                }
            }
        });
        // tinh hoa don
        JButton calculateButtonRemote = managementAppRemote.getCalculateButtonRemote();
        calculateButtonRemote.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (customerType.isEmpty() && fullName.isEmpty() && customerIdField.isEmpty() && customerOject.isEmpty()
                        && invoiceDateField.isEmpty() && quantityField.isEmpty() && unitPriceField.isEmpty() && quotaField.isEmpty()&& nationalityField.isEmpty()
                ) {
                    tinhHoaDonTungloai.action();
                }
            }
        });
        
        
        // so luong
        JButton invoiceButtonRemote = managementAppRemote.getInvoiceButtonRemote();
        invoiceButtonRemote.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (customerType.isEmpty() && fullName.isEmpty() && customerIdField.isEmpty() && customerOject.isEmpty()
                        && invoiceDateField.isEmpty() && quantityField.isEmpty() && unitPriceField.isEmpty() && quotaField.isEmpty() && nationalityField.isEmpty()
                ) {
                    xuatHoaDonThang.action();
                }
            }
        });
    }

}
