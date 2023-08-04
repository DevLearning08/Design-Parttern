package presentation;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import presentation.controller.InvoiceManagementController;

import java.awt.*;

import java.util.ArrayList;
import domain.HoadonService;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class ManagementApp {
    private JFrame frame;
    private JTable table;
    private DefaultTableModel tableModel;
    private JTextField fullNameField;
    private JTextField customerIdField;
    private JComboBox<String> customerTypeComboBox;
    private JComboBox<String> customerObjectComboBox;
    private JTextField invoiceDateField;
    private JTextField quantityField;
    private JTextField unitPriceField;
    private JTextField quotaField;
    private JTextField nationalityField;
    private JScrollPane scrollPane;


    // public static void main(String[] args) {
    //     SwingUtilities.invokeLater(() -> {
    //         try {
    //             new ManagementApp().initialize();
    //         } catch (Exception e) {
    //             e.printStackTrace();
    //         }
    //     });
    // }

    private ArrayList<ManagementApp> billList = new ArrayList<>();
    private HoadonService hoadonServiceRemote;
    // public void initialize() {

        

        
    //     // Tạo JFrame và cấu hình giao diện chính
    //     setTitle("Quản lý danh sách hoá đơn tiền điện");
    //     setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    //     getContentPane().setLayout(new BorderLayout());
    //     setExtendedState(JFrame.MAXIMIZED_BOTH);
        
    //     // Tạo DefaultTableModel và JTable để hiển thị danh sách hoá đơn
    //     tableModel = new DefaultTableModel(new String[]{"Loại khách hàng", "Họ và tên", "Mã khách hàng",
    //     "Đối tượng", "Ngày xuất hoá đơn", "Số lượng", "Đơn giá", "Định mức", "Quốc tịch", "Thành tiền"}, 0);

    //  public static void main(String[] args) {
    //      SwingUtilities.invokeLater(() -> {
    //          try {
    //             new ManagementApp().initialize();
    //         } catch (Exception e) {
    //             e.printStackTrace();
    //         }
    //     });
    // }


    public void initialize() {
        // Tạo JFrame và cấu hình giao diện chính
        frame = new JFrame("Quản lý danh sách hoá đơn tiền điện");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(new BorderLayout());
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);

        // Tạo DefaultTableModel và JTable để hiển thị danh sách hoá đơn
        tableModel = new DefaultTableModel(new String[]{"Mục", "Loại khách hàng", "Họ và tên", "Mã khách hàng",
                "Đối tượng", "Ngày xuất hoá đơn", "Số lượng", "Đơn giá", "Định mức", "Quốc tịch"}, 0);

        table = new JTable(tableModel);
        scrollPane = new JScrollPane(table);
        
        // Đưa JTable vào JScrollPane để có khả năng cuộn ngang và cuộn dọc
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);

        // Thêm JScrollPane vào JFrame
        frame.getContentPane().add(scrollPane, BorderLayout.CENTER);


        // Thêm JPanel để nhập thông tin hoá đơn vào JFrame
      
        
        

        // Tạo JPanel để nhập thông tin hoá đơn
        JPanel inputPanel = new JPanel(new GridLayout(0, 2, 5, 5));
        fullNameField = new JTextField();
        customerIdField = new JTextField();
        customerTypeComboBox = new JComboBox<>(new String[]{"", "Khách hàng Việt Nam", "Khách hàng nước ngoài"});
        customerObjectComboBox = new JComboBox<>(new String[]{"", "Kinh doanh", "Định mức", "Sản xuất"});
        invoiceDateField = new JTextField();
        quantityField = new JTextField();
        unitPriceField = new JTextField();
        quotaField = new JTextField();
        nationalityField = new JTextField();

        // Thêm các thành phần vào inputPanel
        inputPanel.add(new JLabel("Loại khách hàng:"));
        inputPanel.add(customerTypeComboBox);
        inputPanel.add(new JLabel("Họ và tên:"));
        inputPanel.add(fullNameField);
        inputPanel.add(new JLabel("Mã khách hàng:"));
        inputPanel.add(customerIdField);
        inputPanel.add(new JLabel("Đối tượng khách hàng:"));
        inputPanel.add(customerObjectComboBox);
        inputPanel.add(new JLabel("Ngày xuất hoá đơn:"));
        inputPanel.add(invoiceDateField);
        inputPanel.add(new JLabel("Số lượng:"));
        inputPanel.add(quantityField);
        inputPanel.add(new JLabel("Đơn giá:"));
        inputPanel.add(unitPriceField);
        inputPanel.add(new JLabel("Định mức:"));
        inputPanel.add(quotaField);
        inputPanel.add(new JLabel("Quốc tịch:"));
        inputPanel.add(nationalityField);
        inputPanel.add(new JLabel());
        inputPanel.add(createButtonPanel());

        // Đưa inputPanel vào JFrame
        frame.getContentPane().add(inputPanel, BorderLayout.NORTH);


        // Set kích thước và hiển thị JFrame
        frame.setSize(800, 500);
        frame.setLocationRelativeTo(null); // Đưa JFrame vào giữa màn hình
        frame.setVisible(true);
    }
    


    // Tạo JPanel chứa các nút bấm để thêm, xoá, sửa, tính toán và xuất hoá đơn
    private JPanel createButtonPanel() {
        JPanel panel = new JPanel();
        JButton addButton = new JButton("Thêm");
        JButton deleteButton = new JButton("Xoá");
        JButton editButton = new JButton("Sửa");
        JButton calculateButton = new JButton("Thành tiền");
        JButton exportButton = new JButton("Xuất hoá đơn");

        // Xử lý sự kiện khi nhấn các nút bấm
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addRowToTable();
            }
        });

        deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                deleteSelectedRowFromTable();
            }
        });

        editButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                editSelectedRowInTable();
            }
        });

        calculateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                calculateTotalAmount();
            }
        });

        exportButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                exportInvoice();
            }
        });

        // Thêm các nút bấm vào panel
        panel.add(addButton);
        panel.add(deleteButton);
        panel.add(editButton);
        panel.add(calculateButton);
        panel.add(exportButton);

        return panel;
    }

    // Thêm thông tin hoá đơn vào bảng
    private void addRowToTable() {
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
            tableModel.addRow(new String[]{customerType, fullName, customerId, customerObject,
                    invoiceDate, quantity, unitPrice, quota, nationality});
        } else {
            JOptionPane.showMessageDialog(frame, "Vui lòng điền đầy đủ thông tin.");
        }
    }

    // Xoá hàng được chọn từ bảng
    private void deleteSelectedRowFromTable() {
        int selectedRow = table.getSelectedRow();
        if (selectedRow >= 0) {
            tableModel.removeRow(selectedRow);
        } else {
            JOptionPane.showMessageDialog(frame, "Vui lòng chọn hàng cần xoá.");
        }
    }

    // Sửa thông tin trong hàng được chọn từ bảng
    private void editSelectedRowInTable() {
        int selectedRow = table.getSelectedRow();
        if (selectedRow >= 0) {
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
                // Cập nhật thông tin vào hàng đã chọn
                tableModel.setValueAt(customerType, selectedRow, 0);
                tableModel.setValueAt(fullName, selectedRow, 1);
                tableModel.setValueAt(customerId, selectedRow, 2);
                tableModel.setValueAt(customerObject, selectedRow, 3);
                tableModel.setValueAt(invoiceDate, selectedRow, 4);
                tableModel.setValueAt(quantity, selectedRow, 5);
                tableModel.setValueAt(unitPrice, selectedRow, 6);
                tableModel.setValueAt(quota, selectedRow, 7);
                tableModel.setValueAt(nationality, selectedRow, 8);
            } else {
                JOptionPane.showMessageDialog(frame, "Vui lòng điền đầy đủ thông tin.");
            }
        } else {
            JOptionPane.showMessageDialog(frame, "Vui lòng chọn hàng cần sửa.");
        }
    }

    // Tính tổng thành tiền
    private void calculateTotalAmount() {
        // Implement your calculation logic here
    }

    // Xuất hoá đơn
    private void exportInvoice() {
        // Implement your export logic here
    }


    public DefaultTableModel getTableModel() {
        return null;
    }



    public HoadonService getHoadonServiceRemote() {
        return hoadonServiceRemote;
    }
    

}

