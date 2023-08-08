package pesistence;

import java.sql.Connection;
import java.util.Date;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.swing.table.DefaultTableModel;


import domain.model.HoaDon;
import domain.model.HoaDonNuocNgoai;
import domain.model.HoaDonVietNam;

public class HoaDonGatewayImpl implements HoaDonGateway {
    private Connection connection = null;
    private DefaultTableModel tableModel;
    
    public HoaDonGatewayImpl() {
        String url = "jdbc:mysql://localhost:3306/csdl";
        String username = "root";
        String password = "";
        
        try {
            connection = DriverManager.getConnection(url, username, password);
            System.out.println("Connected to MySQL database!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    @Override
    public void themHoaDon(HoaDon hoaDon) {
        try {
            if (hoaDon instanceof HoaDonVietNam) {
                String insertVN = "INSERT INTO hoadonvietnam (maKH, hotenKH, ngayraHD, soLuong, donGia, doiTuongKH, dinhMuc, thanhTien) VALUES (?,?,?,?,?,?,?,?)";
                PreparedStatement statement = connection.prepareStatement(insertVN);
                statement.setInt(1, hoaDon.getMaHD());
                statement.setString(2, hoaDon.getHotenKH());
                statement.setDate(3, new java.sql.Date(hoaDon.getNgayraHD().getTime()));
                statement.setDouble(4, hoaDon.getSoLuong());
                statement.setDouble(5, hoaDon.getDonGia());
                statement.setString(6, ((HoaDonVietNam) hoaDon).getDoiTuongHK().toString());
                statement.setDouble(7, ((HoaDonVietNam) hoaDon).getDinhMuc());
                statement.setDouble(8, ((HoaDonVietNam) hoaDon).thanhTien());
    
                statement.executeUpdate();
                statement.close();
            } else if (hoaDon instanceof HoaDonNuocNgoai) {
                String insertNN = "INSERT INTO hoadonnuocngoai (maKH, hotenKH, ngayraHD, soLuong, donGia, quoctich, thanhTien) VALUES (?,?,?,?,?,?,?)";
                PreparedStatement statement2 = connection.prepareStatement(insertNN);
                statement2.setInt(1, hoaDon.getMaHD());
                statement2.setString(2, hoaDon.getHotenKH());
                statement2.setDate(3, new java.sql.Date(hoaDon.getNgayraHD().getTime()));
                statement2.setDouble(4, hoaDon.getSoLuong());
                statement2.setDouble(5, hoaDon.getDonGia());
                statement2.setString(6, ((HoaDonNuocNgoai) hoaDon).getQuocTich());
                statement2.setDouble(7, ((HoaDonNuocNgoai) hoaDon).thanhTien());
                statement2.executeUpdate();
                statement2.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    

    @Override
    public void xoaHoaDon(int maHD) {
        String sql = "DELETE FROM HoaDonVietNam WHERE maKH=? ";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, maHD);
            statement.executeUpdate();
            connection.setAutoCommit(false);
            connection.commit();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        sql = "DELETE FROM HoaDonNuocNgoai WHERE maKH=? ";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, maHD);
            statement.executeUpdate();
            connection.setAutoCommit(false);
            connection.commit();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void suaHoaDon(HoaDon hoaDon) {
        if(hoaDon instanceof HoaDonVietNam){
            String sql = "UPDATE HoaDonVietNam SET hotenKH=?, ngayraHD=?, soLuong=?, donGia=?, doiTuongKH=?, dinhMuc=?, thanhTien=? WHERE maKH=?";
            try (PreparedStatement statement = connection.prepareStatement(sql)) {
                statement.setString(1, hoaDon.getHotenKH());
                statement.setDate(2, (java.sql.Date) hoaDon.getNgayraHD());
                statement.setDouble(3, hoaDon.getSoLuong());
                statement.setDouble(4, hoaDon.getDonGia());
                
                statement.setObject(5, ((HoaDonVietNam) hoaDon).getDoiTuongHK());
                statement.setDouble(6, ((HoaDonVietNam) hoaDon).getDinhMuc());
                statement.setDouble(7, ((HoaDonVietNam) hoaDon).thanhTien());
                statement.setInt(8, hoaDon.getMaHD());
                
                statement.executeUpdate();
                statement.close();
            }catch (SQLException e){
                e.printStackTrace();
            }}
            else if(hoaDon instanceof HoaDonNuocNgoai){
                String sql = "UPDATE HoaDonNuocNgoai SET hotenKH=?, ngayraHD=?, soLuong=?, donGia=?, quocTich=?, thanhTien=? WHERE maKH=?";
                try (PreparedStatement statement = connection.prepareStatement(sql)) {
                    statement.setString(1, hoaDon.getHotenKH());
                    statement.setDate(2, (java.sql.Date) hoaDon.getNgayraHD());
                    statement.setDouble(3, hoaDon.getSoLuong());
                    statement.setDouble(4, hoaDon.getDonGia());
                    statement.setString(5, ((HoaDonNuocNgoai) hoaDon).getQuocTich());
                    statement.setDouble(6, ((HoaDonNuocNgoai) hoaDon).thanhTien());
                    statement.setInt(7, hoaDon.getMaHD());
                    
                    statement.executeUpdate();
                    statement.close();
                }catch (SQLException e){
                    e.printStackTrace();
                }
        }
    }

    @Override
    public void tinhSoLuongTungLoai(int maKH) {
        int soLuongVietNam = 0;
        int soLuongNuocNgoai = 0;

        String sqlVietNam = "SELECT COUNT(*) AS count FROM HoaDonVietNam WHERE maKH=?";
        String sqlNuocNgoai = "SELECT COUNT(*) AS count FROM HoaDonNuocNgoai WHERE maKH=?";

        try (PreparedStatement statementVietNam = connection.prepareStatement(sqlVietNam);
             PreparedStatement statementNuocNgoai = connection.prepareStatement(sqlNuocNgoai)) {

            statementVietNam.setInt(1, maKH);
            ResultSet resultSetVietNam = statementVietNam.executeQuery();
            if (resultSetVietNam.next()) {
                soLuongVietNam = resultSetVietNam.getInt("count");
            }

            statementNuocNgoai.setInt(1, maKH);
            ResultSet resultSetNuocNgoai = statementNuocNgoai.executeQuery();
            if (resultSetNuocNgoai.next()) {
                soLuongNuocNgoai = resultSetNuocNgoai.getInt("count");
            }

            System.out.println("Số lượng khách hàng Việt Nam: " + soLuongVietNam);
            System.out.println("Số lượng khách hàng nước ngoài: " + soLuongNuocNgoai);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void tbHoaDonNN() {
        double trungBinhThanhTien = 0.0;

        String sql = "SELECT AVG(ThanhTien) AS trungBinhThanhTien FROM HoaDonNuocNgoai";

        try (Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery(sql);
            if (resultSet.next()) {
                trungBinhThanhTien = resultSet.getDouble("trungBinhThanhTien");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        System.out.println("Trung binh thanh tien: " + trungBinhThanhTien);
    }
    

    @Override
    public List<HoaDon> xuatHoaDonTrongThang(HoaDon hoaDon) {
         List<HoaDon> hoaDonList = new ArrayList<>();
    String sql = "SELECT * FROM HoaDonVietNam WHERE MONTH(ngayraHD) = ? AND YEAR(ngayraHD) = ? " +
                 "UNION " +
                 "SELECT * FROM HoaDonNuocNgoai WHERE MONTH(ngayraHD) = ? AND YEAR(ngayraHD) = ?";
    try (PreparedStatement statement = connection.prepareStatement(sql)) {
        statement.setInt(1, hoaDon.getNgayraHD().getMonth());
        statement.setInt(2, hoaDon.getNgayraHD().getYear());
        statement.setInt(3, hoaDon.getNgayraHD().getMonth());
        statement.setInt(4, hoaDon.getNgayraHD().getYear());

        ResultSet resultSet = statement.executeQuery();
        while (resultSet.next()) {
            int maKH = resultSet.getInt("maKH");
            String hotenKH = resultSet.getString("hotenKH");
            double soLuong = resultSet.getDouble("soLuong");
            double donGia = resultSet.getDouble("donGia");
            Date ngayraHD = resultSet.getDate("ngayraHD");
        if(hoaDon instanceof HoaDonVietNam){  
            
            String doiTuongKH = resultSet.getString("doiTuongKH");
            double dinhMuc = resultSet.getDouble("dinhMuc");
            Double thanhTien = resultSet.getDouble("thanhTien");
            hoaDonList.add(new HoaDonVietNam(maKH, hotenKH, ngayraHD, soLuong, donGia, doiTuongKH, dinhMuc, thanhTien));
            } else if(hoaDon instanceof HoaDonNuocNgoai){
                String quocTich = resultSet.getString("quocTich");
                Double thanhTien = resultSet.getDouble("thanhTien");
                hoaDonList.add(new HoaDonNuocNgoai(maKH, hotenKH, ngayraHD, soLuong, donGia, quocTich, thanhTien));
            }
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }
    return hoaDonList;
    }

    @Override
    public HoaDon timKiemID(HoaDon hoaDon) {
        List <HoaDon> hoaDonList = new ArrayList<>();
       if(hoaDon instanceof HoaDonVietNam){
          hoaDonList = getHoaDonVN();
          for (HoaDon hoaDon2 : hoaDonList) {
                if(hoaDon2.getMaHD() == hoaDon.getMaHD()){
                    return hoaDon2;
          }
                return null;
               }
               
           }
           else if(hoaDon instanceof HoaDonNuocNgoai){
             hoaDonList = getHoaDonVN();
          for (HoaDon hoaDon2 : hoaDonList) {
                if(hoaDon2.getMaHD() == hoaDon.getMaHD()){
                    return hoaDon2;
           }
               
                   
           else{
               return null;
           }
       }

       }
       return hoaDon;
    }

    @Override
    public HoaDon timKiemTenNN(String hoten) {
        String sql = "SELECT * FROM HoaDonNuocNgoai WHERE hotenKH=?";
        try(PreparedStatement statement = connection.prepareStatement(sql)){
            statement.setString(1, hoten);
            ResultSet resultSet = statement.executeQuery();
            if(resultSet.next()){
                int maKH = resultSet.getInt("maKH");
                String hotenKH = resultSet.getString("hotenKH");
                double soLuong = resultSet.getInt("soLuong");
                double donGia = resultSet.getDouble("donGia");
                Date ngayraHD = resultSet.getDate("ngayraHD");
                String QuocTich = resultSet.getString("quocTich");
                Double thanhTien = resultSet.getDouble("thanhTien");
                
                return new HoaDonNuocNgoai(maKH, hotenKH, ngayraHD, soLuong, donGia, QuocTich, thanhTien);
            }
            return null;
        }catch(SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
public List<HoaDon> getHoaDonVN() {
    List<HoaDon> hoaDonList = new ArrayList<>();
    String sql = "SELECT * FROM HoaDonVietNam ";

    try (Statement statement = connection.createStatement()) {
        ResultSet resultSet = statement.executeQuery(sql);
        while (resultSet.next()) {
            int maKH = resultSet.getInt("maKH");
            String hotenKH = resultSet.getString("hotenKH");
            double soLuong = resultSet.getInt("soLuong");
            double donGia = resultSet.getDouble("donGia");
            Date ngayraHD = resultSet.getDate("ngayraHD");
            
            String doiTuongKH = resultSet.getString("doiTuongKH");
            double dinhMuc = resultSet.getDouble("dinhMuc");
            double thanhTien = resultSet.getDouble("thanhTien");
            HoaDonVietNam hoaDon = new HoaDonVietNam(maKH, hotenKH, ngayraHD, soLuong, donGia, doiTuongKH, dinhMuc, thanhTien);
            hoaDonList.add(hoaDon);
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }
    return hoaDonList;
}
        public DefaultTableModel getTableModel() {
               return tableModel;
           }  
    @Override
    public HoaDon timKiemTenVN(String hotenKH) {
       String sql = "SELECT * FROM HoaDonVietNam WHERE hotenKH=?";
       try(PreparedStatement statement = connection.prepareStatement(sql)){
           statement.setString(1, hotenKH);
           ResultSet resultSet = statement.executeQuery();
           if(resultSet.next()){
               int maKH = resultSet.getInt("maKH");
               String hotenKH1 = resultSet.getString("hotenKH");
               double soLuong = resultSet.getInt("soLuong");
               double donGia = resultSet.getDouble("donGia");
               Date ngayraHD = resultSet.getDate("ngayraHD");
               double DinhMuc = resultSet.getInt("dinhMuc");
               
               String doiTuongKH = resultSet.getString("doiTuongHK");
               Double thanhTien = resultSet.getDouble("thanhTien");
               
               return new HoaDonVietNam(maKH, hotenKH1, ngayraHD, soLuong, donGia, doiTuongKH, DinhMuc, thanhTien);
           }
           return null;
       }catch(SQLException e) {
           e.printStackTrace();
       }
       return null;
    }

    @Override
public List<HoaDon> getHoaDonNN() {
    List<HoaDon> hoaDonList = new ArrayList<>();
    String sql = "SELECT * FROM HoaDonNuocNgoai ";

    try (Statement statement = connection.createStatement()) {
        ResultSet resultSet = statement.executeQuery(sql);
        while (resultSet.next()) {
            int maKH = resultSet.getInt("maKH");
            String hotenKH = resultSet.getString("hotenKH");
            double soLuong = resultSet.getInt("soLuong");
            double donGia = resultSet.getDouble("donGia");
            Date ngayraHD = resultSet.getDate("ngayraHD");
            String quocTich = resultSet.getString("quocTich");
            double thanhTien = resultSet.getDouble("thanhTien");
            HoaDonNuocNgoai hoaDon = new HoaDonNuocNgoai(maKH, hotenKH, ngayraHD, soLuong, donGia, quocTich, thanhTien);
            hoaDonList.add(hoaDon);
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }
    return hoaDonList;
}
}
   

