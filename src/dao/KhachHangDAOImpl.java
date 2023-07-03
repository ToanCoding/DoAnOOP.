package dao;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import model.KhachHang;

/**
 *
 * @author truon
 */
public class KhachHangDAOImpl implements KhachHangDAO {

    @Override
    public List<KhachHang> getList() {
        Connection cons = DBConnect.getConnection();
        String sql = "Select * from ThongTinDatBan";
        List<KhachHang> list = new ArrayList<>();
        try {
            PreparedStatement ps = (PreparedStatement) cons.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                KhachHang khachHang = new KhachHang();
                khachHang.setMaDatBan(rs.getInt("MaKhachHang"));
                khachHang.setTenKhachHang(rs.getString("TenKhachHang"));
                khachHang.setSdt(rs.getString("SDT"));
                khachHang.setGioDen(rs.getString("GioDen"));
                khachHang.setNgayDen(rs.getString("NgayDen"));
                khachHang.setThoiLuong(rs.getString("ThoiLuong"));
                khachHang.setSoKhach(rs.getString("SoKhach"));
                khachHang.setNvDatBan(rs.getString("NVDatBan"));
                khachHang.setBan(rs.getString("Ban"));
                khachHang.setGhiChu(rs.getString("GhiChu"));
                list.add(khachHang);
            }
            ps.close();
            rs.close();
            cons.close();
            return list;
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return list;
    }

     @Override
    public int createOrUpdate(KhachHang khachHang) {
        try {
            Connection cons = DBConnect.getConnection();
            String sql = "INSERT INTO ThongTinDatBan(MaKhachHang,TenKhachHang,SDT,"
                    + "GioDen,NgayDen,ThoiLuong,SoKhach,NVDatBan,Ban,GhiChu) VALUES(?, ?, ?, ?,?, ?, ?, ?,?,?)";
            PreparedStatement ps = cons.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
            ps.setInt(1, khachHang.getMaDatBan());
            ps.setString(2, khachHang.getTenKhachHang());
            ps.setString(3, khachHang.getSdt());
            ps.setString(4, khachHang.getGioDen());
            ps.setString(5,khachHang.getNgayDen());
            ps.setString(6, khachHang.getThoiLuong());
            ps.setString(7, khachHang.getSoKhach());
            ps.setString(8, khachHang.getNvDatBan());
            ps.setString(9, khachHang.getBan());
            ps.setString(10, khachHang.getGhiChu());
            ps.execute();
            ResultSet rs = ps.getGeneratedKeys();
            int generatedKey = 0;
            if (rs.next()) {
                generatedKey = rs.getInt(1);
            }
            ps.close();
            cons.close();
            return generatedKey;
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return 0;
    }

}
