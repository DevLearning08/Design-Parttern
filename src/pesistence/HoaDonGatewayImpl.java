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

import javax.xml.crypto.Data;

import domain.model.DoiTuongKH;
import domain.model.HoaDon;
import domain.model.HoaDonNuocNgoai;
import domain.model.HoaDonVietNam;

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
    public void themHoaDonVN(HoaDon hoaDon) {
        String sql = "INSERT INTO HoaDonVietNam (maKH, hotenKH, ngayraHD, soLuong, donGia, doiTuongHK, dinhMuc) VALUES (?,?,?,?,?,?,?)";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, hoaDon.getMaKH());
            statement.setString(2, hoaDon.getHotenKH());
            statement.setDate(3, (Date) hoaDon.getNgayraHD());
            statement.setDouble(4, hoaDon.getSoLuong());
            statement.setDouble(5, hoaDon.getDonGia());
            
            statement.setObject(6, ((HoaDonVietNam) hoaDon).getDoiTuongHK());
            statement.setDouble(7, ((HoaDonVietNam) hoaDon).getDinhMuc());
            statement.executeUpdate();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
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
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'tinhSoLuongTungLoai'");
    }

    @Override
    public void tbHoaDonNN(int maKH) {
        String sql = "select AVG(ThanhTien) from HoaDonNuocNgoai WHERE maKH=?";
        try(PreparedStatement statement = connection.prepareStatement(sql)){
            statement .setInt(1, maKH);
            ResultSet resultSet = statement.executeQuery();
            if(resultSet.next()){
                double avg = resultSet.getDouble("AVG(ThanhTien)");
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    @Override
    public List<HoaDon> xuatHoaDonTrongThang() {
        String sql = 
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
                   return new HoaDonVietNam(maHD, hotenKH, ngayraHD, soLuong, donGia, KH, dinhMuc);
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
                       return new HoaDonNuocNgoai(maHD, hotenKH, ngayraHD, soLuong, donGia, quocTich);}
                   
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
                
                return new HoaDonNuocNgoai(maKH, hotenKH, ngayraHD, soLuong, donGia, QuocTich);
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
                            
                            hoaDon.add(new HoaDonVietNam(maKH, hotenKH, ngayraHD, soLuong, donGia, doiTuongKH, DinhMuc));
                            hoaDon.add(new HoaDonNuocNgoai(maKH, hotenKH, ngayraHD, soLuong, donGia,  QuocTich));
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
               
               
               return new HoaDonVietNam(maKH, hotenKH1, ngayraHD, soLuong, donGia, doiTuongKH, DinhMuc);
           }
           return null;
       }catch(SQLException e) {
           e.printStackTrace();
       }
       return null;
    }}
   

