package presentation.view;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import domain.Subcriber;

// import domain.HoadonService;

import domain.model.HoaDon;

import presentation.controller.InvoiceManagementController;

import java.awt.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;



public class ManagementApp extends JFrame implements Subcriber {
    private HoaDon  hoaDon;
    private InvoiceManagementController controlRemotel;
    private JFrame frame;
    private JTable table;
    private JTable tableNN;
    private DefaultTableModel tableModelVN;
    private DefaultTableModel tableModelNN;
    public DefaultTableModel getTableModelNN() {
        return tableModelNN;
    }
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
    private JScrollPane scrollPaneNN;
    private JButton addButton = new JButton("Thêm");
    private JButton deleteButton = new JButton("Xoá");
    private JButton editButton = new JButton("Sửa");
    private JButton findButton = new JButton("Tìm kiếm");
    private JButton calculateButton = new JButton("Thành tiền");
    private JButton exportButton = new JButton("Xuất hóa đơn");

    private JButton TBHDNNButton = new JButton("Tính TB hóa đơn nước ngoài");
    private JLabel fullNameFieldJLabel;
    private JLabel customerIdFieldJLabel;
    private JLabel quantityFieldJLabel;
    private JLabel unitPriceFieldJLabel;
    private JLabel quotaFieldJLabel;
    private JLabel nationalityFieldJLabel;
    private JLabel customerTypeFieldJLabel ;
    private JLabel customerOjectFieldJLabel ;
    private JLabel invoiceDateJLabel ;
    private boolean isVietNamSelected;

    public ManagementApp() {
        controlRemotel = new InvoiceManagementController(this);
        // Tạo JFrame và cấu hình giao diện chính
        frame = new JFrame("Quản lý danh sách hoá đơn tiền điện");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(new BorderLayout());
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
    
        // Tạo DefaultTableModel và JTable để hiển thị danh sách hoá đơn

        tableModelVN = new DefaultTableModel();
        tableModelVN.addColumn( "Mã khách hàng");
        tableModelVN.addColumn( "Họ và tên");
        tableModelVN.addColumn( "Số lượng");
        tableModelVN.addColumn("Định mức");
        tableModelVN.addColumn("Đối tượng");
        tableModelVN.addColumn("Ngày ra hóa đơn");
        tableModelVN.addColumn("Đơn giá");
        tableModelVN.addColumn("Thành tiền");
        table = new JTable();
        table.setModel(tableModelVN);
       
        //tạo tabelmodelNN
        tableModelNN = new DefaultTableModel();
        tableModelNN.addColumn( "Mã khách hàng");
        tableModelNN.addColumn( "Họ và tên");
        tableModelNN.addColumn( "Số lượng");
        tableModelNN.addColumn("Ngày ra hóa đơn");
        tableModelNN.addColumn("Quốc tịch");
        tableModelNN.addColumn("Đơn giá");
        tableModelNN.addColumn("Thành tiền");
        tableNN = new JTable();
        tableNN.setModel(tableModelNN);
       


    
        // Tạo JPanel để nhập thông tin hoá đơn
        JPanel inputPanel = new JPanel(new GridLayout(0, 2, 5, 5));
        fullNameField = new JTextField();
        customerIdField = new JTextField();
        customerTypeComboBox = new JComboBox<>(new String[]{"Khách hàng Việt Nam","Khách hàng nước ngoài"});
        customerObjectComboBox = new JComboBox<>(new String[]{  "sinh hoạt", "kinh doanh ","sản xuất"}); 
        // ---------------------------------------------------------
        // tạo Ô nhập chon ngày tháng 
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        String today = LocalDate.now().format(formatter);
        invoiceDateField = new JTextField();
        invoiceDateField.setText(today);
        
       
        // ---------------------------------------------------------
        quantityField = new JTextField();
        unitPriceField = new JTextField();
        quotaField = new JTextField();
        nationalityField = new JTextField();
    
        fullNameFieldJLabel= new JLabel("Họ và tên:");
        customerIdFieldJLabel= new JLabel("Mã khách hàng:");
        quantityFieldJLabel= new JLabel("Số lượng:");
        unitPriceFieldJLabel= new JLabel("Đơn giá:");
        quotaFieldJLabel= new JLabel("Định mức:");
        nationalityFieldJLabel= new JLabel("Quốc tịch");
        customerTypeFieldJLabel = new JLabel("Loại khách hàng:");
        customerOjectFieldJLabel = new JLabel("Đối tượng khách hàng:");
        invoiceDateJLabel = new JLabel("Ngày xuất hoá đơn:");
        // Thêm các thành phần vào inputPanel;
        inputPanel.add(customerTypeFieldJLabel);
        inputPanel.add(customerTypeComboBox);
        inputPanel.add(fullNameFieldJLabel);
        inputPanel.add(fullNameField);
        inputPanel.add(customerIdFieldJLabel);
        inputPanel.add(customerIdField);
        inputPanel.add(customerOjectFieldJLabel);
        inputPanel.add(customerObjectComboBox);
        inputPanel.add(invoiceDateJLabel);
        inputPanel.add(invoiceDateField);
        inputPanel.add(quantityFieldJLabel);
        inputPanel.add(quantityField);
        inputPanel.add(unitPriceFieldJLabel);
        inputPanel.add(unitPriceField);
        inputPanel.add(quotaFieldJLabel);
        inputPanel.add(quotaField);
        inputPanel.add(nationalityFieldJLabel);
        inputPanel.add(nationalityField);
        inputPanel.add(new JLabel());
        inputPanel.add(createButtonPanel());
        
        // Đưa inputPanel vào JFrame
        frame.getContentPane().add(inputPanel, BorderLayout.NORTH);
        // Set kích thước và hiển thị JFrame
        frame.setSize(800, 500);
        frame.setLocationRelativeTo(null); // Đưa JFrame vào giữa màn hình
        frame.setVisible(true);
        // Khởi tạo controller để lắng nghe sự kiện
        addButton.addActionListener(controlRemotel);
        findButton.addActionListener(controlRemotel);
        editButton.addActionListener(controlRemotel);
        deleteButton.addActionListener(controlRemotel);
        calculateButton.addActionListener(controlRemotel);
        exportButton.addActionListener(controlRemotel);
        customerTypeComboBox.addMouseListener(controlRemotel);
        
        
        
        
         
        // Thêm JScrollPane vào JFrame
        
        
        // Đưa JTable vào JScrollPane để có khả năng cuộn ngang và cuộn dọc
        String customerType = (String) customerTypeComboBox.getSelectedItem();
        if(customerType == "Khách hàng Việt Nam") {
            scrollPane = new JScrollPane(table);
            System.out.println(customerType);
            frame.getContentPane().add(scrollPane, BorderLayout.CENTER);
            scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
            scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        }else if (customerType == "Khách hàng nước ngoài") {
            scrollPane = new JScrollPane(tableNN);
            frame.getContentPane().add(scrollPane, BorderLayout.CENTER);
            scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
            scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        }
    
    }
   
        // Xử lý khi chuột được nhấn
        
      
    
        
            
        
    
    // Tạo JPanel chứa các nút bấm để thêm, xoá, sửa, tính toán, xuất hoá đơn, tìm kiếm, TB hóa đơn nước ngoài
    private JPanel createButtonPanel() {
        JPanel panel = new JPanel();
        // Thêm các nút bấm vào panel
        panel.add(addButton);
        panel.add(deleteButton);
        panel.add(editButton);
        panel.add(calculateButton);
        panel.add(exportButton);
        panel.add(findButton);
        panel.add(TBHDNNButton);
       
            
        return panel;
    }
    public JScrollPane getScrollPaneNN() {
        
        return scrollPane;
    }

    // Thêm thông tin hoá đơn vào bảng
    public boolean findInvoice(String findQuery) {
        return false;
    }
    public void avergForeignInvoice() {
        
    }

    public DefaultTableModel getTableModelVN() {
        return tableModelVN;
    }

    public JFrame getFrame() {
        return frame;
    }

    public void setFrame(JFrame frame) {
        this.frame = frame;
    }

    public JTable getTable() {
        return table;
    }

    public void setTable(JTable table) {
        this.table = table;
    }

    public void setTableModelVN(DefaultTableModel tableModelVN) {
        this.tableModelVN = tableModelVN;
    }

    public JTextField getFullNameField() {
        return fullNameField;
    }

    public void setFullNameField(JTextField fullNameField) {
        this.fullNameField = fullNameField;
    }

    public JTextField getCustomerIdField() {
        return customerIdField;
    }

    public void setCustomerIdField(JTextField customerIdField) {
        this.customerIdField = customerIdField;
    }

    public JComboBox<String> getCustomerTypeComboBox() {
        return customerTypeComboBox;
    }
    public void setCustomerTypeComboBox(JComboBox<String> customerTypeComboBox) {
        this.customerTypeComboBox = customerTypeComboBox;
    }

    public JComboBox<String> getCustomerObjectComboBox() {
        return customerObjectComboBox;
    }

    public void setCustomerObjectComboBox(JComboBox<String> customerObjectComboBox) {
        this.customerObjectComboBox = customerObjectComboBox;
    }



    public JTextField getInvoiceDateField() {
        return invoiceDateField;
    }


    public void setInvoiceDateField(JTextField invoiceDateField) {
        this.invoiceDateField = invoiceDateField;
    }


    public JTextField getQuantityField() {
        return quantityField;
    }

    public void setQuantityField(JTextField quantityField) {
        this.quantityField = quantityField;
    }

    public JTextField getUnitPriceField() {
        return unitPriceField;
    }

    public void setUnitPriceField(JTextField unitPriceField) {
        this.unitPriceField = unitPriceField;
    }

    public JTextField getQuotaField() {
        return quotaField;
    }

    public void setQuotaField(JTextField quotaField) {
        this.quotaField = quotaField;
    }

    public JTextField getNationalityField() {
        return nationalityField;
    }

    public void setNationalityField(JTextField nationalityField) {
        this.nationalityField = nationalityField;
    }

    public JScrollPane getScrollPane() {
        return scrollPane;
    }

    public void setScrollPane(JScrollPane scrollPane) {
        this.scrollPane = scrollPane;
    }

    public JButton getAddButton() {
        return addButton;
    }

    public JButton getDeleteButton() {
        return deleteButton;
    }

    public JButton getEditButton() {
        return editButton;
    }

    public JButton getCalculateButton() {
        return calculateButton;
    }

    public JButton getExportButton() {
        return exportButton;
    }

    public JButton getFindButton() {
        return findButton;
    }


    public JButton getTBHDNNButton() {
        return TBHDNNButton;
    }
    public HoaDon getHoaDonRemote(){
        return hoaDon;
    }
    public void setHoaDonRemote(HoaDon hoaDon){
        this.hoaDon = hoaDon;
    }

    public void populateInputFields(HoaDon hoaDon2) {
        
    }

    public boolean isVietNamSelected() {
        return isVietNamSelected;
    }

    public void setVietNamSelected(boolean vietNamSelected) {
        isVietNamSelected = vietNamSelected;
    }

    @Override
    public void thongBao() {
       controlRemotel.ShowNN();
       controlRemotel.ShowVN();
    }
    
   


    
    
    

   
}


