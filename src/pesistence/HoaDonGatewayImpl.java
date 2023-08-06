package pesistence;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;



import domain.model.DoiTuongKH;
import domain.model.HoaDon;
import domain.model.HoaDonNuocNgoai;
import domain.model.HoaDonVietNam;

public class HoaDonGatewayImpl implements HoaDonGateway {
    private Connection connection;
    public static Connection HoaDonGatewayImpl() {
        String url = "jdbc:mysql://localhost:3306/csdl";
        String username = "root";
        String password = "";
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(url, username, password);
            System.out.println("Connected to MySQL database!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
        
    }

    @Override
    public void themHoaDonVN(HoaDon hoaDon) {
        
       if(!(hoaDon instanceof HoaDonVietNam)){
            String sql = "INSERT INTO HoaDonVietNam (maKH, hotenKH, ngayraHD, soLuong, donGia, doiTuongHK, dinhMuc) VALUES (?,?,?,?,?,?,?)";
            try (PreparedStatement statement = connection.prepareStatement(sql)) {
                statement.setString(1, hoaDon.getHotenKH());
                statement.setDate(2, (Date) hoaDon.getNgayraHD());
                statement.setDouble(3, hoaDon.getSoLuong());
                statement.setDouble(4, hoaDon.getDonGia());
                statement.setObject(5, ((HoaDonVietNam) hoaDon).getDoiTuongHK());
                statement.setDouble(6, ((HoaDonVietNam) hoaDon).getDinhMuc());

                statement.executeUpdate();
                statement.close();
            }catch (SQLException e){
                e.printStackTrace();
            }}
           
        }


    @Override
    public void xoaHoaDon(int maKH,HoaDon hoaDon) {
        if(hoaDon instanceof HoaDonVietNam){
            String sql = "DELETE FROM HoaDonVietNam WHERE maKH=? ";
            try (PreparedStatement statement = connection.prepareStatement(sql)) {
                statement.setInt(1, maKH);
                
                statement.executeUpdate();
                statement.close();
            }catch (SQLException e){
                e.printStackTrace();
            }}
            else if(hoaDon instanceof HoaDonNuocNgoai){
                String sql = "DELETE FROM HoaDonNuocNgoai WHERE maKH=? ";
                try (PreparedStatement statement = connection.prepareStatement(sql)) {
                    statement.setInt(1, maKH);
                    
                    statement.executeUpdate();
                    statement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        
    }

    @Override
    public void suaHoaDon(HoaDon hoaDon) {
        if(hoaDon instanceof HoaDonVietNam){
            String sql = "UPDATE HoaDonVietNam SET hotenKH=?, ngayraHD=?, soLuong=?, donGia=?, doiTuongHK=?, dinhMuc=? WHERE maKH=?";
            try (PreparedStatement statement = connection.prepareStatement(sql)) {
                statement.setString(1, hoaDon.getHotenKH());
                statement.setDate(2, (Date) hoaDon.getNgayraHD());
                statement.setDouble(3, hoaDon.getSoLuong());
                statement.setDouble(4, hoaDon.getDonGia());
                
                statement.setObject(5, ((HoaDonVietNam) hoaDon).getDoiTuongHK());
                statement.setDouble(6, ((HoaDonVietNam) hoaDon).getDinhMuc());
                statement.setInt(7, hoaDon.getMaKH());
                
                statement.executeUpdate();
                statement.close();
            }catch (SQLException e){
                e.printStackTrace();
            }}
            else if(hoaDon instanceof HoaDonNuocNgoai){
                String sql = "UPDATE HoaDonNuocNgoai SET hotenKH=?, ngayraHD=?, soLuong=?, donGia=?, doiTuongHK=?, dinhMuc=? WHERE maKH=?";
                try (PreparedStatement statement = connection.prepareStatement(sql)) {
                    statement.setString(1, hoaDon.getHotenKH());
                    statement.setDate(2, (Date) hoaDon.getNgayraHD());
                    statement.setDouble(3, hoaDon.getSoLuong());
                    statement.setDouble(4, hoaDon.getDonGia());
                    
                    statement.setString(5, ((HoaDonNuocNgoai) hoaDon).getQuocTich());
                    
                    
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
            String doiTuongKHString = resultSet.getString("doiTuongHK");
            DoiTuongKH doiTuongKH = DoiTuongKH.valueOf(doiTuongKHString);
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
    public HoaDon timKiemID(int maKH,HoaDon hoaDon) {
       if(hoaDon instanceof HoaDonVietNam){
           String sql = "SELECT * FROM HoaDonVietNam WHERE maKH=?";
           try(PreparedStatement statement = connection.prepareStatement(sql)){
               statement.setInt(1, hoaDon.getMaKH());
               ResultSet resultSet = statement.executeQuery();
               if(resultSet.next()){
                   int maHD = resultSet.getInt("maKH");
                   String hotenKH = resultSet.getString("hotenKH");
                   double soLuong = resultSet.getInt("soLuong");
                   double donGia = resultSet.getDouble("donGia");
                   String doiTuongKH= resultSet.getString("doiTuongHK");
                   DoiTuongKH KH= DoiTuongKH.valueOf(doiTuongKH);
                   double dinhMuc = resultSet.getDouble("dinhMuc");
                   Date ngayraHD = resultSet.getDate("ngayraHD");
                   Double thanhTien = resultSet.getDouble("thanhTien");
                   return new HoaDonVietNam(maHD, hotenKH, ngayraHD, soLuong, donGia, KH, dinhMuc, thanhTien);
               }
               
           }catch (SQLException e){
               e.printStackTrace();
           }}else if(hoaDon instanceof HoaDonNuocNgoai){
               String sql = "SELECT * FROM HoaDonNuocNgoai WHERE maKH=?";
               try(PreparedStatement statement = connection.prepareStatement(sql)){
                   statement.setInt(1, hoaDon.getMaKH());
                   ResultSet resultSet = statement.executeQuery();
                   if(resultSet.next()){
                       int maHD = resultSet.getInt("maKH");
                       String hotenKH = resultSet.getString("hotenKH");
                       double soLuong = resultSet.getInt("soLuong");
                       double donGia = resultSet.getDouble("donGia");
                       String quocTich= resultSet.getString("quocTich");
                       Date ngayraHD = resultSet.getDate("ngayraHD");
                       Double thanhTien = resultSet.getDouble("thanhTien");
                       return new HoaDonNuocNgoai(maHD, hotenKH, ngayraHD, soLuong, donGia, quocTich, thanhTien);}
                   
               }catch (SQLException e){
                   e.printStackTrace();
           }
       }
       return null;
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
    public List<HoaDon> getAllHoaDons(int maKH) {
        List<HoaDon> hoaDon = new ArrayList<>();
        
        String sql = "SELECT * FROM HoaDonVietNam\r\n" + //
                "UNION ALL\r\n" + //
                "SELECT * FROM HoaDonNuocNgoai";
        try(Statement statement = connection.createStatement()){
            try(PreparedStatement statement1 = connection.prepareStatement(sql)){
                statement1.setInt(1, maKH);
                
                 
                        ResultSet resultSet = statement1.executeQuery();
                            while(resultSet.next()){
                            maKH = resultSet.getInt("maKH");
                            String hotenKH = resultSet.getString("hotenKH");
                            double soLuong = resultSet.getInt("soLuong");
                            double donGia = resultSet.getDouble("donGia");
                            Date ngayraHD = resultSet.getDate("ngayraHD");
                            double DinhMuc = resultSet.getInt("dinhMuc");
                            String doiTuongKHString = resultSet.getString("doiTuongKH");
                            DoiTuongKH doiTuongKH = DoiTuongKH.valueOf(doiTuongKHString);
                            String QuocTich = resultSet.getString("quocTich");
                            Double thanhTien = resultSet.getDouble("thanhTien");
                            hoaDon.add(new HoaDonVietNam(maKH, hotenKH, ngayraHD, soLuong, donGia, doiTuongKH, DinhMuc, thanhTien));
                            hoaDon.add(new HoaDonNuocNgoai(maKH, hotenKH, ngayraHD, soLuong, donGia,  QuocTich, thanhTien));
                    }
                }
                catch(SQLException e) {
                 e.printStackTrace();
                }
              
            }catch (SQLException e) {
            e.printStackTrace();
        }
        return hoaDon;
            
        }

    @Override
    public void themHoaDonNuocNgoai(HoaDon hoaDon) {
       
       String sql = "INSERT INTO HoaDonNuocNgoai (maKH, hotenKH, ngayraHD, soLuong, donGia, quocTich) VALUES (?, ?, ?, ?, ?, ?)";
       try(PreparedStatement statement = connection.prepareStatement(sql)){
           statement.setInt(1, hoaDon.getMaKH());
           statement.setString(2, hoaDon.getHotenKH());
           statement.setDate(3, (Date) hoaDon.getNgayraHD());
           statement.setDouble(4, hoaDon.getSoLuong());
           statement.setDouble(5, hoaDon.getDonGia());
           statement.setString(6, ((HoaDonNuocNgoai) hoaDon).getQuocTich());
           statement.executeUpdate();
           statement.close();
       }catch(SQLException e) {
           e.printStackTrace();
       }
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
               String doiTuongKHString = resultSet.getString("doiTuongKH");
               DoiTuongKH doiTuongKH = DoiTuongKH.valueOf(doiTuongKHString);
               Double thanhTien = resultSet.getDouble("thanhTien");
               
               return new HoaDonVietNam(maKH, hotenKH1, ngayraHD, soLuong, donGia, doiTuongKH, DinhMuc, thanhTien);
           }
           return null;
       }catch(SQLException e) {
           e.printStackTrace();
       }
       return null;
    }}
   

