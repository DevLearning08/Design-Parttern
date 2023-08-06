package presentation.view;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import domain.HoaDon_GetAll;
import domain.HoadonService;
import domain.model.HoaDon;
import domain.model.HoaDonNuocNgoai;
import domain.model.HoaDonVietNam;
import presentation.controller.InvoiceManagementController;

import java.awt.*;

import java.sql.Date;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;


public class ManagementApp {
    private HoaDon  hoaDon;
    private InvoiceManagementController controlRemotel;
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

    private JButton addButton = new JButton("Thêm");
    private JButton deleteButton = new JButton("Xoá");
    private JButton editButton = new JButton("Sửa");
    private JButton findButton = new JButton("Tìm kiếm");
    private JButton calculateButton = new JButton("Thành tiền");
    private JButton exportButton = new JButton("Xuất hoá đơn");


    private JButton TBHDNNButton = new JButton("Tính TB hóa đơn nước ngoài");


    public ManagementApp() {
        controlRemotel = new InvoiceManagementController(this);
        // Tạo JFrame và cấu hình giao diện chính
        frame = new JFrame("Quản lý danh sách hoá đơn tiền điện");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(new BorderLayout());
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
    
        // Tạo DefaultTableModel và JTable để hiển thị danh sách hoá đơn

        tableModel = new DefaultTableModel();
        tableModel.addColumn( "mã khách hàng");
        tableModel.addColumn( "Họ và tên");
        tableModel.addColumn( "số lượng");
        tableModel.addColumn("định mức");
        tableModel.addColumn("đối tượng");
        tableModel.addColumn("ngày ra hóa đơn");
        tableModel.addColumn("quốc gia");
        tableModel.addColumn("đơn giá ");
        table = new JTable();
        table.setModel(tableModel);
        scrollPane = new JScrollPane(table);
    
        // Đưa JTable vào JScrollPane để có khả năng cuộn ngang và cuộn dọc
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
    
        // Thêm JScrollPane vào JFrame
        frame.getContentPane().add(scrollPane, BorderLayout.CENTER);

    
        // Tạo JPanel để nhập thông tin hoá đơn
        JPanel inputPanel = new JPanel(new GridLayout(0, 2, 5, 5));
        fullNameField = new JTextField();
        customerIdField = new JTextField();
        customerTypeComboBox = new JComboBox<>(new String[]{"", "Khách hàng Việt Nam", "Khách hàng nước ngoài"});
        customerObjectComboBox = new JComboBox<>(new String[]{"", "Kinh doanh", "Định mức", "Sản xuất"});
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


        // Khởi tạo controller để lắng nghe sự kiện
        addButton.addActionListener(controlRemotel);
        findButton.addActionListener(controlRemotel);
        editButton.addActionListener(controlRemotel);
        deleteButton.addActionListener(controlRemotel);
        calculateButton.addActionListener(controlRemotel);
        exportButton.addActionListener(controlRemotel);
        showAll();
    }
    
    
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
   public void showAll(){
    if(hoaDon instanceof HoaDonNuocNgoai){
        hoaDon = new HoaDonNuocNgoai();
        HoadonService service = new HoaDon_GetAll();
        service.action(hoaDon);
        tableModel.setRowCount(0);
        Object [] row = new Object[]{hoaDon.getMaHD(),hoaDon.getHoVaTen(),hoaDon.getSoLuong(),hoaDon.getDonGia(),hoaDon.thanhTien(),hoaDon.getNgayraHD(),((HoaDonNuocNgoai) hoaDon).getQuocTich()};
        tableModel.addRow(row) ;
    }else if(hoaDon instanceof HoaDonVietNam)
    {
    HoadonService service = new HoaDon_GetAll();
    service.action(hoaDon);
    tableModel.setRowCount(0);
    tableModel.addRow(new Object[]{tableModel.getRowCount() +1, hoaDon.getMaHD(),hoaDon.getHoVaTen(),hoaDon.getSoLuong(),hoaDon.getDonGia(),hoaDon.thanhTien()});
   }
}


    // Thêm thông tin hoá đơn vào bảng
 

    public boolean findInvoice(String findQuery) {
        return false;
    }

    public void avergForeignInvoice() {
        
    }

    public DefaultTableModel getTableModel() {
        return tableModel;
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

    public void setTableModel(DefaultTableModel tableModel) {
        this.tableModel = tableModel;
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

}

