package presentation;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.ArrayList;

public class ManagementApp extends JFrame {
    private JTable table;
    private DefaultTableModel tableModel;
    private JScrollPane scrollPane;

    private ArrayList<ManagementApp> billList = new ArrayList<>();

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            try {
                new ManagementApp().initialize();
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    public void initialize() {
        // Tạo JFrame và cấu hình giao diện chính
        setTitle("Quản lý danh sách hoá đơn tiền điện");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        getContentPane().setLayout(new BorderLayout());
        setExtendedState(JFrame.MAXIMIZED_BOTH);

        // Tạo DefaultTableModel và JTable để hiển thị danh sách hoá đơn
        tableModel = new DefaultTableModel(new String[]{"Loại khách hàng", "Họ và tên", "Mã khách hàng",
                "Đối tượng", "Ngày xuất hoá đơn", "Số lượng", "Đơn giá", "Định mức", "Quốc tịch", "Thành tiền"}, 0);
        table = new JTable(tableModel);
        scrollPane = new JScrollPane(table);

        // Đưa JTable vào JScrollPane để có khả năng cuộn ngang và cuộn dọc
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);

        // Thêm JScrollPane vào JFrame
        getContentPane().add(scrollPane, BorderLayout.CENTER);

        // Thêm JPanel để nhập thông tin hoá đơn vào JFrame
        ManagementAppInput managementAppInput = new ManagementAppInput(this);
        getContentPane().add(managementAppInput, BorderLayout.NORTH);

        // Set kích thước và hiển thị JFrame
        setSize(800, 500);
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setLocationRelativeTo(null); // Đưa JFrame vào giữa màn hình
        setVisible(true);
    }

    public ArrayList<ManagementApp> getBillList() {
        return billList;
    }

    public DefaultTableModel getTableModel() {
        return tableModel;
    }
}
