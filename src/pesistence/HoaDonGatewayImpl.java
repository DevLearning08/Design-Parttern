package pesistence;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import domain.model.HoaDon;

public class HoaDonGatewayImpl implements HoaDonGateway {
    private Connection connection;

    public HoaDonGatewayImpl() {
        String url = "jdbc:mysql://localhost:3306/ngu";
        String username = "root";
        String password = "";
        try {
            connection = DriverManager.getConnection(url, username, password);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
    }

    @Override
    public void themHoaDon(HoaDon hoaDon) {
        String sql = "INSERT INTO Students (maKH, hotenKH, soLuong, donGia) VALUES (?, ?, ?, ?)";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, hoaDon.getMaKH());
            statement.setString(2, hoaDon.getHotenKH());
            statement.setDouble(3, hoaDon.getSoLuong());
            statement.setDouble(4, hoaDon.getDonGia());
            // statement.setInt(5, hoaDon.getDinhMuc());
            // statement.setInt(6, hoaDon.getQuocTich());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void xoaHoaDon(int maKH) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'xoaHoaDon'");
    }

    @Override
    public void suaHoaDon(HoaDon hoaDon) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'suaHoaDon'");
    }

    @Override
    public void tinhSoLuongTungLoai(int maKH) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'tinhSoLuongTungLoai'");
    }

    @Override
    public void tbHoaDonNN(int maKH) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'tbHoaDonNN'");
    }

    @Override
    public List<HoaDon> xuatHoaDonTrongThang() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'xuatHoaDonTrongThang'");
    }

    @Override
    public HoaDon timKiemID(int maKH) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'timKiemID'");
    }

    @Override
    public HoaDon timKiemTen(String hotenKH) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'timKiemTen'");
    }
   
}
