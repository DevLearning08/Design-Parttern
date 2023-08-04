package presentation.controller;

import presentation.view.ManagementApp;
import presentation.view.ManagementAppInfor;

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
    private ManagementAppInfor managementAppInforRemote;
    private ManagementApp managementAppInputRemote;
    private HoadonService hoadonServiceRemote;

    public InvoiceManagementController() {
        
    }

    





    public ManagementAppInfor getManagementAppInforRemote() {
        return managementAppInforRemote;
    }


    public void setManagementAppInforRemote(ManagementAppInfor managementAppInforRemote) {
        this.managementAppInforRemote = managementAppInforRemote;
    }


    public ManagementApp getManagementAppInputRemote() {
        return managementAppInputRemote;
    }


    public void setManagementAppInputRemote(ManagementApp managementAppInputRemote) {
        this.managementAppInputRemote = managementAppInputRemote;
    }
    

    public void actionPerformed(ActionEvent e) {
        // gửi message đến view (view input data)


        // lấy dữ liệu từ các celJTextField, fahJTextField , jComboBox tại Boundary
        JComboBox customerTypeComboBoxRemote = managementAppInputRemote.getCustomerTypeComboBoxRemote();
        String customerType = (String) customerTypeComboBoxRemote.getSelectedItem();

        JTextField fullNameCustomer = managementAppInputRemote.getFullNameFieldRemote();
        String fullName = fullNameCustomer.getText();

        JTextField  customerIdFieldRemote = managementAppInputRemote.getCustomerIdFieldRemote();
        String customerIdField = customerIdFieldRemote.getText();

        JComboBox customerOjectComboBoxRemote = managementAppInputRemote.getCustomerObjectComboBoxRemote();
        String customerOject = (String) customerOjectComboBoxRemote.getSelectedItem();

        JTextField invoiceDateFieldRemote = managementAppInputRemote.getInvoiceDateFieldRemote();
        String invoiceDateField = invoiceDateFieldRemote.getText();

        JTextField quantityFieldRemote = managementAppInputRemote.getQuantityFieldRemote();
        String quantityField = quantityFieldRemote.getText();

        JTextField unitPriceFieldRemote = managementAppInputRemote.getUnitPriceFieldRemote();
        String unitPriceField = unitPriceFieldRemote.getText();

        JTextField quotaFieldRemote = managementAppInputRemote.getQuotaFieldRemote();
        String quotaField = quotaFieldRemote.getText();

        JTextField nationalityFieldRemote = managementAppInputRemote.getNationalityFieldRemote();
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
        JButton searchButtonRemote = managementAppInputRemote.getSearchButtonRemote();
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
        JButton addButtonRemote = managementAppInputRemote.getAddButtonRemote();
        addButtonRemote.addActionListener(new ActionListener() {
            // Xử lý sự kiện khi nhấn nut them
            @Override
            public void actionPerformed(ActionEvent e) {
                
            // Gọi phương thức thêm mới 
            them.action();
        }
        });
        
        // delete
        JButton deleteButtonRemote = managementAppInputRemote.getDeleteButtonRemote();
        deleteButtonRemote.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                xoa.action();
            }
        });
        
        // sua 
        
        JButton updateButtonRemote = managementAppInputRemote.getUpdateButtonRemote();
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
        JButton calculateButtonRemote = managementAppInputRemote.getCalculateButtonRemote();
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
        JButton invoiceButtonRemote = managementAppInputRemote.getInvoiceButtonRemote();
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
