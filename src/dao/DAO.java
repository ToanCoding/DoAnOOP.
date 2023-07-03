/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import model.DoanhThu;
import model.ThucDon;

/**
 *
 * @author truon
 */
public class DAO {

    private Connection conn;

    public DAO() {
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            conn = DriverManager.getConnection("jdbc:sqlserver://LAPTOP-PLDIM1QL:1433;DatabaseName=DoAnOOp;encrypt=true;trustServerCertificate=true;"
                    + "username=sa; password=123456789");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
     public boolean login(String username, String password) throws SQLException {
        boolean result = false;
        String sql = "SELECT * FROM ThongTinDangNhap WHERE username=? AND password=?";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setString(1, username);
        ps.setString(2, password);
        ResultSet rs = ps.executeQuery();
        if (rs.next()) {
            result = true;
        }
        return result;
    }
    public void deleteFood(String tenMon) throws Exception {
        String query = "DELETE FROM ThongTinDatMon WHERE TenMon = ?";
        PreparedStatement ps = conn.prepareStatement(query);
        ps.setString(1, tenMon);
        ps.executeUpdate();
    }

    //Kiểm tra mã đặt bàn
    public boolean checkMaDatBan(String maDatBan) {
        try {
            String query = "SELECT * FROM ThongTinDatBan WHERE MaKhachHang = ?";
            PreparedStatement statement = conn.prepareStatement(query);
            statement.setString(1, maDatBan);

            ResultSet resultSet = statement.executeQuery();
            return resultSet.next(); // return true nếu có kết quả trả về
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public void deleteRow(String maDatBan) throws Exception {
        String query = "DELETE FROM ThongTinDatMon WHERE MaKhachHang = ?";
        PreparedStatement statement = conn.prepareStatement(query);
        statement.setString(1, maDatBan);
        statement.executeUpdate();
    }

    //Thêm dữ liệu vào tblThongTinThucDon
    public boolean addThucDon(ThucDon s) {
        String sql = "INSERT INTO ThongTinDatMon(MaKhachHang,TenMon,GiaMon,SoLuong,ThanhTien)"
                + "VALUES(?, ?, ?, ?,?)";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            int rowsAffected = 0;
            if (s.getSoLuong1() != 0) {
                ps.setString(1, s.getMaDatBan());
                ps.setString(2, s.getTenMon1());
                ps.setInt(3, s.getGiaMon1());
                ps.setInt(4, s.getSoLuong1());
                ps.setInt(5, s.getThanhTien1(s.getGiaMon1(), s.getSoLuong1()));
                rowsAffected = ps.executeUpdate();
            }
            if (s.getSoLuong2() != 0) {
                ps.setString(1, s.getMaDatBan());
                ps.setString(2, s.getTenMon2());
                ps.setInt(3, s.getGiaMon2());
                ps.setInt(4, s.getSoLuong2());
                ps.setInt(5, s.getThanhTien2(s.getGiaMon2(), s.getSoLuong2()));
                rowsAffected = ps.executeUpdate();
            }
            if (s.getSoLuong3() != 0) {
                ps.setString(1, s.getMaDatBan());
                ps.setString(2, s.getTenMon3());
                ps.setInt(3, s.getGiaMon3());
                ps.setInt(4, s.getSoLuong3());
                ps.setInt(5, s.getThanhTien3(s.getGiaMon3(), s.getSoLuong3()));
                rowsAffected = ps.executeUpdate();
            }

            if (s.getSoLuong4() != 0) {
                ps.setString(1, s.getMaDatBan());
                ps.setString(2, s.getTenMon4());
                ps.setInt(3, s.getGiaMon4());
                ps.setInt(4, s.getSoLuong4());
                ps.setInt(5, s.getThanhTien4(s.getGiaMon4(), s.getSoLuong4()));
                rowsAffected = ps.executeUpdate();
            }

            if (s.getSoLuong5() != 0) {
                ps.setString(1, s.getMaDatBan());
                ps.setString(2, s.getTenMon5());
                ps.setInt(3, s.getGiaMon5());
                ps.setInt(4, s.getSoLuong5());
                ps.setInt(5, s.getThanhTien5(s.getGiaMon5(), s.getSoLuong5()));
                rowsAffected = ps.executeUpdate();
            }

            if (s.getSoLuong6() != 0) {
                ps.setString(1, s.getMaDatBan());
                ps.setString(2, s.getTenMon6());
                ps.setInt(3, s.getGiaMon6());
                ps.setInt(4, s.getSoLuong6());
                ps.setInt(5, s.getThanhTien6(s.getGiaMon6(), s.getSoLuong6()));
                rowsAffected = ps.executeUpdate();
            }

            if (s.getSoLuong7() != 0) {
                ps.setString(1, s.getMaDatBan());
                ps.setString(2, s.getTenMon7());
                ps.setInt(3, s.getGiaMon7());
                ps.setInt(4, s.getSoLuong7());
                ps.setInt(5, s.getThanhTien7(s.getGiaMon7(), s.getSoLuong7()));
                rowsAffected = ps.executeUpdate();
            }

            if (s.getSoLuong8() != 0) {
                ps.setString(1, s.getMaDatBan());
                ps.setString(2, s.getTenMon8());
                ps.setInt(3, s.getGiaMon8());
                ps.setInt(4, s.getSoLuong8());
                ps.setInt(5, s.getThanhTien8(s.getGiaMon8(), s.getSoLuong8()));
                rowsAffected = ps.executeUpdate();
            }

            if (s.getSoLuong9() != 0) {
                ps.setString(1, s.getMaDatBan());
                ps.setString(2, s.getTenMon9());
                ps.setInt(3, s.getGiaMon9());
                ps.setInt(4, s.getSoLuong9());
                ps.setInt(5, s.getThanhTien9(s.getGiaMon9(), s.getSoLuong9()));
                rowsAffected = ps.executeUpdate();
            }

            if (s.getSoLuong10() != 0) {
                ps.setString(1, s.getMaDatBan());
                ps.setString(2, s.getTenMon10());
                ps.setInt(3, s.getGiaMon10());
                ps.setInt(4, s.getSoLuong10());
                ps.setInt(5, s.getThanhTien10(s.getGiaMon10(), s.getSoLuong10()));
                rowsAffected = ps.executeUpdate();
            }

            if (s.getSoLuong11() != 0) {
                ps.setString(1, s.getMaDatBan());
                ps.setString(2, s.getTenMon11());
                ps.setInt(3, s.getGiaMon11());
                ps.setInt(4, s.getSoLuong11());
                ps.setInt(5, s.getThanhTien11(s.getGiaMon11(), s.getSoLuong11()));
                rowsAffected = ps.executeUpdate();
            }

            if (s.getSoLuong12() != 0) {
                ps.setString(1, s.getMaDatBan());
                ps.setString(2, s.getTenMon12());
                ps.setInt(3, s.getGiaMon12());
                ps.setInt(4, s.getSoLuong12());
                ps.setInt(5, s.getThanhTien12(s.getGiaMon12(), s.getSoLuong12()));
                rowsAffected = ps.executeUpdate();
            }
            return rowsAffected > 0;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
//Lấy dữ liệu từ tblThongTinThucDon

    public ArrayList<ThucDon> getListThucDon() {
        ArrayList<ThucDon> list = new ArrayList<>();
        String sql = "SELECT * FROM ThongTinDatMon";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                ThucDon s = new ThucDon();
                s.setMaDatBan(rs.getString("MaKhachHang"));
                s.setTenMon1(rs.getString("TenMon"));
                s.setGiaMon1(rs.getInt("GiaMon"));
                s.setThanhTien1(rs.getInt("ThanhTien"));

                list.add(s);

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
//Lấy thực đơn bằng mã đặt bàn

    public ArrayList<ThucDon> getListHoaDon(String maDatBan) {
        ArrayList<ThucDon> list = new ArrayList<>();
        String sql = "SELECT * FROM ThongTinDatMon WHERE MaKhachHang='" + maDatBan + "'";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                ThucDon s = new ThucDon();
                s.setTenMon(rs.getString("TenMon"));
                s.setGiaMon(rs.getInt("GiaMon"));
                s.setSoLuong(rs.getInt("SoLuong"));
                s.setThanhTien(rs.getInt("ThanhTien"));
                list.add(s);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
//Lấy tồng tiền từ mã đặt bàn

    public ArrayList<ThucDon> getListTongTien(String maDatBan) {
        ArrayList<ThucDon> list = new ArrayList<>();
        String sql = "SELECT maDatBan, SUM(thanhTien) AS tongTien FROM ThongTinDatMon GROUP BY MaKhachHang='" + maDatBan + "'";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                ThucDon s = new ThucDon();
                s.setTongTien(rs.getInt("TongTien"));
                list.add(s);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public ArrayList<DoanhThu> getListDoanhThuTong() throws SQLException {
        ArrayList<DoanhThu> list = new ArrayList<>();
        String sql1 = "DELETE FROM ThongTinDoanhThu";
        String sql2 = "INSERT INTO ThongTinDoanhThu(MaKhachHang, NgayDen, NVDatBan, Ban, HoaDon)\n"
            + "SELECT ThongTinDatBan.MaKhachHang, ThongTinDatBan.NgayDen, ThongTinDatBan.NVDatBan, ThongTinDatBan.Ban, SUM(ThongTinDatMon.ThanhTien) AS TongThanhTien\n"
            + "FROM ThongTinDatBan\n"
            + "INNER JOIN ThongTinDatMon\n"
            + "ON ThongTinDatBan.MaKhachHang = ThongTinDatMon.MaKhachHang\n"
            + "GROUP BY ThongTinDatBan.MaKhachHang, ThongTinDatBan.NgayDen, ThongTinDatBan.NVDatBan, ThongTinDatBan.Ban";
        String sql = "SELECT * FROM ThongTinDoanhThu";
        try {
            PreparedStatement ps1 = conn.prepareStatement(sql1);
            ps1.executeUpdate();

            PreparedStatement ps2 = conn.prepareStatement(sql2);
            ps2.executeUpdate();

            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                DoanhThu s = new DoanhThu();
                s.setMaKhachHang(rs.getInt("MaKhachHang"));
                s.setNgayDen(rs.getString("NgayDen"));
                s.setNvDatBan(rs.getString("NVDatBan"));
                s.setBan(rs.getString("Ban"));
                s.setHoaDon(rs.getString("HoaDon"));
                list.add(s);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public ArrayList<DoanhThu> timKiemKhachHang(String field, String keyword) {
    ArrayList<DoanhThu> list = new ArrayList<>();
    String sql1 = "DELETE FROM ThongTinDoanhThu";
    String sql2 = "INSERT INTO ThongTinDoanhThu(MaKhachHang, NgayDen, NVDatBan, Ban, HoaDon)\n"
            + "SELECT ThongTinDatBan.MaKhachHang, ThongTinDatBan.NgayDen, ThongTinDatBan.NVDatBan, ThongTinDatBan.Ban, SUM(ThongTinDatMon.ThanhTien) AS TongThanhTien\n"
            + "FROM ThongTinDatBan\n"
            + "INNER JOIN ThongTinDatMon\n"
            + "ON ThongTinDatBan.MaKhachHang = ThongTinDatMon.MaKhachHang\n"
            + "GROUP BY ThongTinDatBan.MaKhachHang, ThongTinDatBan.NgayDen, ThongTinDatBan.NVDatBan, ThongTinDatBan.Ban";
    String sql = "SELECT * FROM ThongTinDoanhThu WHERE " + field + " LIKE '%" + keyword + "%'";

    try {
        // Thực hiện câu lệnh DELETE
        PreparedStatement psDelete = conn.prepareStatement(sql1);
        psDelete.executeUpdate();
        
        // Thực hiện câu lệnh INSERT INTO
        PreparedStatement psInsert = conn.prepareStatement(sql2);
        psInsert.executeUpdate();

        // Thực hiện câu lệnh SELECT
        PreparedStatement psSelect = conn.prepareStatement(sql);
        ResultSet rs = psSelect.executeQuery();
        while (rs.next()) {
            DoanhThu s = new DoanhThu();
            s.setMaKhachHang(rs.getInt("MaKhachHang"));//Lấy dữ liệu từ cột tenKhachHang trong SQL
            s.setNgayDen(rs.getString("NgayDen"));
            s.setNvDatBan(rs.getString("NVDatBan"));
            s.setBan(rs.getString("Ban"));
            s.setHoaDon(rs.getString("HoaDon"));
            list.add(s);
        }
    } catch (Exception e) {
        e.printStackTrace();
    }
    return list;
}


}
