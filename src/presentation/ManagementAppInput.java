// package presentation;

// import javax.swing.*;
// import javax.swing.table.DefaultTableModel;


// import java.awt.*;
// import java.awt.event.ActionEvent;
// import java.awt.event.ActionListener;
// import java.util.ArrayList;

import presentation.controller.InvoiceManagementController;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;


// public class ManagementAppInput extends JPanel {
//     private JTextField fullNameFieldRemote;
//     private JTextField customerIdFieldRemote;
//     private JComboBox<String> customerTypeComboBoxRemote;
//     private JComboBox<String> customerObjectComboBoxRemote;
//     private JTextField invoiceDateFieldRemote;
//     private JTextField quantityFieldRemote;
//     private JTextField unitPriceFieldRemote;
//     private JTextField quotaFieldRemote;
//     private JTextField nationalityFieldRemote;


//     private ManagementApp managementApp;

//     public ManagementAppInput(ManagementApp managementApp) {
//         this.managementApp = managementApp;
//         initialize();
//     }

//     private void initialize() {
//         setLayout(new GridLayout(0, 2, 5, 5));
//         fullNameFieldRemote = new JTextField();
//         customerIdFieldRemote = new JTextField();
//         customerTypeComboBoxRemote = new JComboBox<>(new String[]{"", "Khách hàng Việt Nam", "Khách hàng nước ngoài"});
//         customerObjectComboBoxRemote = new JComboBox<>(new String[]{"", "Kinh doanh", "Sinh hoạt", "Sản xuất"});
//         invoiceDateFieldRemote = new JTextField();
//         quantityFieldRemote = new JTextField();
//         unitPriceFieldRemote = new JTextField();
//         quotaFieldRemote = new JTextField();
//         nationalityFieldRemote = new JTextField();

    private ManagementApp managementApp;
    //  remote controller 

    private ManagementAppInfor managementAppInforRemote;
    private InvoiceManagementController invoiceManagementController;
    // buttons
    private JButton searchButtonRemote = new JButton("Tìm kiếm");
    private JButton addButtonRemote = new JButton("Thêm");
    private JButton deleteButtonRemote = new JButton("Xóa");
    private JButton updateButtonRemote = new JButton("Sửa");
    private JButton calculateButtonRemote = new JButton("Thành tiền");
    private JButton invoiceButtonRemote = new JButton("Xuất hoá đơn");
        // ...
    public ManagementAppInput(ManagementApp managementApp) {
        this.managementApp = managementApp;
        initialize();
    }


    
    private void initialize() {
        setLayout(new GridLayout(0, 2, 5, 5));
        customerTypeComboBoxRemote = new JComboBox<>(new String[]{"Khách hàng Việt Nam", "Khách hàng nước ngoài"});
        fullNameFieldRemote = new JTextField();
        customerIdFieldRemote = new JTextField();
        customerObjectComboBoxRemote = new JComboBox<>(new String[]{"Kinh doanh", "Sinh hoạt", "Sản xuất"});
        invoiceDateFieldRemote = new JTextField();
        quantityFieldRemote = new JTextField();
        unitPriceFieldRemote = new JTextField();
        quotaFieldRemote = new JTextField();
        nationalityFieldRemote = new JTextField();


//         // Thêm các thành phần vào InputPanel
//         add(new JLabel("Loại khách hàng:"));
//         add(customerTypeComboBoxRemote);
//         add(new JLabel("Họ và tên:"));
//         add(fullNameFieldRemote);
//         add(new JLabel("Mã khách hàng:"));
//         add(customerIdFieldRemote);
//         add(new JLabel("Đối tượng khách hàng:"));
//         add(customerObjectComboBoxRemote);
//         add(new JLabel("Ngày xuất hoá đơn:"));
//         add(invoiceDateFieldRemote);
//         add(new JLabel("Số lượng:"));
//         add(quantityFieldRemote);
//         add(new JLabel("Đơn giá:"));
//         add(unitPriceFieldRemote);
//         add(new JLabel("Định mức:"));
//         add(quotaFieldRemote);
//         add(new JLabel("Quốc tịch:"));
//         add(nationalityFieldRemote);
//         add(new JLabel());
//         add(createButtonPanel());

//     }


//     // Tạo JPanel chứa các nút bấm để thêm, xoá, sửa, tính toán và xuất hoá đơn
//     private JPanel createButtonPanel() {
//         JPanel panel = new JPanel();
//         JButton searchButton = new JButton("Tìm kiếm");
//         JButton addButton = new JButton("Thêm");
//         JButton deleteButton = new JButton("Xóa");
//         JButton updateButton = new JButton("Sửa");
//         JButton calculateButton = new JButton("Thành tiền");
//         JButton invoiceButton = new JButton("Xuất hoá đơn");
//         // ...

//         // Xử lý sự kiện khi nhấn các nút bấm
//         addButton.addActionListener(new ActionListener() {
//             @Override
//             public void actionPerformed(ActionEvent e) {
//                 addBill();
//             }
//         });

//         // ...

//         // Thêm các nút bấm vào panel
//         panel.add(addButton);
//         panel.add(deleteButton);
//         panel.add(updateButton);
//         panel.add(calculateButton);
//         panel.add(searchButton);
//         panel.add(invoiceButton);
//         // ...

    // Tạo JPanel chứa các nút bấm để thêm, xoá, sửa, tính toán và xuất hoá đơn
    private JPanel createButtonPanel() {
        JPanel panel = new JPanel();
        

        // Xử lý sự kiện khi nhấn các nút bấm
        addButtonRemote.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addBill();
            }
        });
        



        // Thêm các nút bấm vào panel
        panel.add(addButtonRemote);
        panel.add(deleteButtonRemote);
        panel.add(updateButtonRemote);
        panel.add(calculateButtonRemote);
        panel.add(searchButtonRemote);
        panel.add(invoiceButtonRemote);
        // ...


//         return panel;
//     }


//     private void addBill() {
//         // Lấy thông tin từ các trường nhập liệu
//         String customerType = (String) customerTypeComboBoxRemote.getSelectedItem();
//         String fullName = fullNameFieldRemote.getText();
//         String customerId = customerIdFieldRemote.getText();
//         String customerObject = (String) customerObjectComboBoxRemote.getSelectedItem();
//         String invoiceDate = invoiceDateFieldRemote.getText();
//         String quantity = quantityFieldRemote.getText();
//         String unitPrice = unitPriceFieldRemote.getText();
//         String quota = quotaFieldRemote.getText();
//         String nationality = nationalityFieldRemote.getText();

    public void addBill() {
        // Lấy thông tin từ các trường nhập liệu
        String customerType = (String) customerTypeComboBoxRemote.getSelectedItem();
        String fullName = fullNameFieldRemote.getText();
        String customerId = customerIdFieldRemote.getText();
        String customerObject = (String) customerObjectComboBoxRemote.getSelectedItem();
        String invoiceDate = invoiceDateFieldRemote.getText();
        String quantity = quantityFieldRemote.getText();
        String unitPrice = unitPriceFieldRemote.getText();
        String quota = quotaFieldRemote.getText();
        String nationality = nationalityFieldRemote.getText();


//         // Kiểm tra xem có trường nào bị bỏ trống không
//         if (!customerType.isEmpty() && !fullName.isEmpty() && !customerId.isEmpty() && !customerObject.isEmpty()
//                 && !invoiceDate.isEmpty() && !quantity.isEmpty() && !unitPrice.isEmpty() && !quota.isEmpty()
//                 && (!customerType.equals("Khách hàng nước ngoài") || !nationality.isEmpty())) {
//             // Thêm thông tin vào bảng
//             DefaultTableModel tableModel = managementApp.getTableModel();
//             tableModel.addRow(new String[]{customerType, fullName, customerId, customerObject,
//                     invoiceDate, quantity, unitPrice, quota, nationality});


//             // Thêm thông tin vào danh sách hoá đơn
//             ArrayList<ManagementAppInfor> billList = ManagementAppInfor.getBillList();
//             ManagementAppInfor bill = new ManagementAppInfor(fullName, customerId, customerType, customerObject,
//                     invoiceDate, quantity, unitPrice, quota, nationality);
//             billList.add(bill);
//         } else {
//             JOptionPane.showMessageDialog(this, "Vui lòng điền đầy đủ thông tin.");
//         }
//     }

            // Thêm thông tin vào danh sách hoá đơn
            ArrayList<ManagementAppInfor> billList = ManagementAppInfor.getBillList();
            ManagementAppInfor bill = new ManagementAppInfor(fullName, customerId, customerType, customerObject,
                    invoiceDate, quantity, unitPrice, quota, nationality);
            billList.add(bill);
        } else {
            JOptionPane.showMessageDialog(this, "Vui lòng điền đầy đủ thông tin.");
        }
    }

    public JTextField getFullNameFieldRemote() {
        return fullNameFieldRemote;
    }

    public void setFullNameFieldRemote(JTextField fullNameFieldRemote) {
        this.fullNameFieldRemote = fullNameFieldRemote;
    }

    public JTextField getCustomerIdFieldRemote() {
        return customerIdFieldRemote;
    }

    public void setCustomerIdFieldRemote(JTextField customerIdFieldRemote) {
        this.customerIdFieldRemote = customerIdFieldRemote;
    }

    public JComboBox<String> getCustomerTypeComboBoxRemote() {
        return customerTypeComboBoxRemote;
    }

    public void setCustomerTypeComboBoxRemote(JComboBox<String> customerTypeComboBoxRemote) {
        this.customerTypeComboBoxRemote = customerTypeComboBoxRemote;
    }

    public JComboBox<String> getCustomerObjectComboBoxRemote() {
        return customerObjectComboBoxRemote;
    }

    public void setCustomerObjectComboBoxRemote(JComboBox<String> customerObjectComboBoxRemote) {
        this.customerObjectComboBoxRemote = customerObjectComboBoxRemote;
    }

    public JTextField getInvoiceDateFieldRemote() {
        return invoiceDateFieldRemote;
    }

    public void setInvoiceDateFieldRemote(JTextField invoiceDateFieldRemote) {
        this.invoiceDateFieldRemote = invoiceDateFieldRemote;
    }

    public JTextField getQuantityFieldRemote() {
        return quantityFieldRemote;
    }

    public void setQuantityFieldRemote(JTextField quantityFieldRemote) {
        this.quantityFieldRemote = quantityFieldRemote;
    }

    public JTextField getUnitPriceFieldRemote() {
        return unitPriceFieldRemote;
    }

    public void setUnitPriceFieldRemote(JTextField unitPriceFieldRemote) {
        this.unitPriceFieldRemote = unitPriceFieldRemote;
    }

    public JTextField getQuotaFieldRemote() {
        return quotaFieldRemote;
    }

    public void setQuotaFieldRemote(JTextField quotaFieldRemote) {
        this.quotaFieldRemote = quotaFieldRemote;
    }

    public JTextField getNationalityFieldRemote() {
        return nationalityFieldRemote;
    }

    public void setNationalityFieldRemote(JTextField nationalityFieldRemote) {
        this.nationalityFieldRemote = nationalityFieldRemote;
    }

    public ManagementApp getManagementApp() {
        return managementApp;
    }

    public void setManagementApp(ManagementApp managementApp) {
        this.managementApp = managementApp;
    }

    public JButton getSearchButtonRemote() {
        return searchButtonRemote;
    }

    public void setSearchButtonRemote(JButton searchButtonRemote) {
        this.searchButtonRemote = searchButtonRemote;
    }

    public JButton getAddButtonRemote() {
        return addButtonRemote;
    }

    public void setAddButtonRemote(JButton addButtonRemote) {
        this.addButtonRemote = addButtonRemote;
    }

    public JButton getDeleteButtonRemote() {
        return deleteButtonRemote;
    }

    public void setDeleteButtonRemote(JButton deleteButtonRemote) {
        this.deleteButtonRemote = deleteButtonRemote;
    }

    public JButton getUpdateButtonRemote() {
        return updateButtonRemote;
    }

    public void setUpdateButtonRemote(JButton updateButtonRemote) {
        this.updateButtonRemote = updateButtonRemote;
    }

    public JButton getCalculateButtonRemote() {
        return calculateButtonRemote;
    }

    public void setCalculateButtonRemote(JButton calculateButtonRemote) {
        this.calculateButtonRemote = calculateButtonRemote;
    }

    public JButton getInvoiceButtonRemote() {
        return invoiceButtonRemote;
    }

    public void setInvoiceButtonRemote(JButton invoiceButtonRemote) {
        this.invoiceButtonRemote = invoiceButtonRemote;
    }
    

    
// }
