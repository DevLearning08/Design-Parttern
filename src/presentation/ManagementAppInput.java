package presentation;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class ManagementAppInput extends JPanel {
    private JTextField fullNameField;
    private JTextField customerIdField;
    private JComboBox<String> customerTypeComboBox;
    private JComboBox<String> customerObjectComboBox;
    private JTextField invoiceDateField;
    private JTextField quantityField;
    private JTextField unitPriceField;
    private JTextField quotaField;
    private JTextField nationalityField;

    private ManagementApp electricityBillGUI;
    private ManagementApp managementApp;

    public ManagementAppInput(ManagementApp managementApp) {
        this.managementApp = managementApp;
        initialize();
    }

    private void initialize() {
        setLayout(new GridLayout(0, 2, 5, 5));
        fullNameField = new JTextField();
        customerIdField = new JTextField();
        customerTypeComboBox = new JComboBox<>(new String[]{"", "Khách hàng Việt Nam", "Khách hàng nước ngoài"});
        customerObjectComboBox = new JComboBox<>(new String[]{"", "Kinh doanh", "Định mức", "Sản xuất"});
        invoiceDateField = new JTextField();
        quantityField = new JTextField();
        unitPriceField = new JTextField();
        quotaField = new JTextField();
        nationalityField = new JTextField();

        // Thêm các thành phần vào InputPanel
        add(new JLabel("Loại khách hàng:"));
        add(customerTypeComboBox);
        add(new JLabel("Họ và tên:"));
        add(fullNameField);
        add(new JLabel("Mã khách hàng:"));
        add(customerIdField);
        add(new JLabel("Đối tượng khách hàng:"));
        add(customerObjectComboBox);
        add(new JLabel("Ngày xuất hoá đơn:"));
        add(invoiceDateField);
        add(new JLabel("Số lượng:"));
        add(quantityField);
        add(new JLabel("Đơn giá:"));
        add(unitPriceField);
        add(new JLabel("Định mức:"));
        add(quotaField);
        add(new JLabel("Quốc tịch:"));
        add(nationalityField);
        add(new JLabel());
        add(createButtonPanel());
    }

    // Tạo JPanel chứa các nút bấm để thêm, xoá, sửa, tính toán và xuất hoá đơn
    private JPanel createButtonPanel() {
        JPanel panel = new JPanel();
        JButton addButton = new JButton("Thêm");
        // ...

        // Xử lý sự kiện khi nhấn các nút bấm
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addBill();
            }
        });

        // ...

        // Thêm các nút bấm vào panel
        panel.add(addButton);
        // ...

        return panel;
    }

    private void addBill() {
        // Lấy thông tin từ các trường nhập liệu
        String customerType = (String) customerTypeComboBox.getSelectedItem();
        String fullName = fullNameField.getText();
        String customerId = customerIdField.getText();
        String customerObject = (String) customerObjectComboBox.getSelectedItem();
        String invoiceDate = invoiceDateField.getText();
        String quantity = quantityField.getText();
        String unitPrice = unitPriceField.getText();
        String quota = quotaField.getText();
        String nationality = nationalityField.getText();

        // Kiểm tra xem có trường nào bị bỏ trống không
        if (!customerType.isEmpty() && !fullName.isEmpty() && !customerId.isEmpty() && !customerObject.isEmpty()
                && !invoiceDate.isEmpty() && !quantity.isEmpty() && !unitPrice.isEmpty() && !quota.isEmpty()
                && (!customerType.equals("Khách hàng nước ngoài") || !nationality.isEmpty())) {
            // Thêm thông tin vào bảng
            DefaultTableModel tableModel = managementApp.getTableModel();
            tableModel.addRow(new String[]{customerType, fullName, customerId, customerObject,
                    invoiceDate, quantity, unitPrice, quota, nationality});

            // Thêm thông tin vào danh sách hoá đơn
            ArrayList<ManagementAppInfor> billList = ManagementAppInfor.getBillList();
            ManagementAppInfor bill = new ManagementAppInfor(fullName, customerId, customerType, customerObject,
                    invoiceDate, quantity, unitPrice, quota, nationality);
            billList.add(bill);
        } else {
            JOptionPane.showMessageDialog(this, "Vui lòng điền đầy đủ thông tin.");
        }
    }
}
