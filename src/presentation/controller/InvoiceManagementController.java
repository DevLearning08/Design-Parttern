package presentation.controller;

import presentation.view.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.sql.SQLException;
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

import domain.HoaDonServiceImp;
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
    private HoadonService hoaDonService;
    public InvoiceManagementController(ManagementApp managementAppRemote) {
        this.managementAppRemote = managementAppRemote;
        hoaDonService = new HoaDonServiceImp();
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("Thêm")) {
            themHoaDon();
        } else if (e.getActionCommand().equals("Xoá")) {
            xoaHoaDon();
        } else if (e.getSource() == managementAppRemote.getTable()) {
            // Thực hiện các thao tác khi người dùng chọn một hàng trong bảng
            int selectedRow = managementAppRemote.getTable().getSelectedRow();
            if (selectedRow != -1) {
                HoaDon hoaDon = (HoaDon) managementAppRemote.getTable().getValueAt(selectedRow, 0);
                showSelectedHoadonInfo(hoaDon);
            }
    }
}
    public void themHoaDon() {
        String customerType = (String) managementAppRemote.getCustomerTypeComboBox().getSelectedItem();
        String fullName = managementAppRemote.getFullNameField().getText();
        int customerId = Integer.parseInt(managementAppRemote.getCustomerIdField().getText());
        Date invoiceDate = Date.valueOf(managementAppRemote.getInvoiceDateField().getText());
        double quantity = Double.parseDouble(managementAppRemote.getQuantityField().getText());
        double unitPrice = Double.parseDouble(managementAppRemote.getUnitPriceField().getText());
        if (customerType.equals("Khách hàng nước ngoài")) {
            String nationality = managementAppRemote.getNationalityField().getText();
            HoaDon hoaDon = new HoaDonNuocNgoai();
            hoaDon.setMaHD(customerId);
            hoaDon.setHotenKH(fullName);
            hoaDon.setNgayraHD(invoiceDate);
            hoaDon.setSoLuong(quantity);
            hoaDon.setDonGia(unitPrice);
            ((HoaDonNuocNgoai) hoaDon).setQuocTich(nationality);
            ((HoaDonNuocNgoai) hoaDon).thanhTien();
           hoaDonService.themHoaDon(hoaDon);
           
            managementAppRemote.getShowNN();
        } else if (customerType.equals("Khách hàng Việt Nam")) {
            HoaDon hoaDon = new HoaDonVietNam();
            DoiTuongKH doiTuongKH = (DoiTuongKH) managementAppRemote.getCustomerObjectComboBox().getSelectedItem();
            ((HoaDonVietNam) hoaDon).setDoiTuongHK(doiTuongKH);
            double quota = Double.parseDouble(managementAppRemote.getQuotaField().getText());
            hoaDon.setMaHD(customerId);
            hoaDon.setHotenKH(fullName);
            ((HoaDonVietNam) hoaDon).setDinhMuc(quota);
            hoaDon.setNgayraHD(invoiceDate);
            hoaDon.setSoLuong(quantity);
            hoaDon.setDonGia(unitPrice);
            hoaDonService.themHoaDon(hoaDon);
            managementAppRemote.getShowVN();
        }
    }
    public void xoaHoaDon() {
        int selectedRow = managementAppRemote.getTable().getSelectedRow();
        if (selectedRow != -1) {
            int maHD = (int) managementAppRemote.getTable().getValueAt(selectedRow, 0);
           hoaDonService.xoaHoaDon(maHD);
    
            // if (hoaDon instanceof HoaDonNuocNgoai) {
            //     hoaDonService.xoaHoaDon(hoaDon.getMaHD());
            // } else if (hoaDon instanceof HoaDonVietNam) {
            // hoaDonService.xoaHoaDon(hoaDon.getMaHD());}
            // if (service != null) {
            //     try {
            //         // Thực hiện xóa hóa đơn từ cơ sở dữ liệu
            //         HoaDonGateway gateway = new HoaDonGatewayImpl();
            //         gateway.xoaHoaDon(hoaDon.getMaHD());
            //         service.action(hoaDon);
            //         managementAppRemote.getTableModel().removeRow(selectedRow);
            //     } catch (Exception e) {
            //         e.printStackTrace();
            //         // Xử lý lỗi nếu cần thiết
            //     }
            // }
        }
    
    }
public void showSelectedHoadonInfo(HoaDon hoaDon) {
    managementAppRemote.populateInputFields(hoaDon);
}
    public void populateInputFields(HoaDon hoaDon) {
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

        if (hoaDon instanceof HoaDonNuocNgoai) {
            quotaField.setText(String.valueOf(((HoaDonNuocNgoai) hoaDon).getQuocTich()));
            nationalityField.setText(((HoaDonNuocNgoai) hoaDon).getQuocTich());
            customerTypeComboBox.setSelectedItem("Khách hàng nước ngoài");
        } else if (hoaDon instanceof HoaDonVietNam) {
            quotaField.setText(String.valueOf(((HoaDonVietNam) hoaDon).getDinhMuc()));
            customerObjectComboBox.setSelectedItem(((HoaDonVietNam) hoaDon).getDoiTuongHK());
            customerTypeComboBox.setSelectedItem("Khách hàng Việt Nam");
        }
    }
}
