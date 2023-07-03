package utility;

import java.util.List;
import javax.swing.table.DefaultTableModel;
import model.KhachHang;

/**
 *
 * @author truon
 */
public class ClassTableModel {

    public DefaultTableModel setTableKhachHang(List<KhachHang> listItem, String[] listColumn) {
        DefaultTableModel dtm = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }

        };
        dtm.setColumnIdentifiers(listColumn);
        int columns = listColumn.length;
        Object[] obj = null;
        int rows = listItem.size();
        if (rows > 0) {
            for (int i = 0; i < rows; i++) {
                KhachHang khachHang = listItem.get(i);
                obj = new Object[columns];
                obj[0] = (i+1);
                obj[1] = i;
                obj[2] = khachHang.getTenKhachHang();
                obj[3] = khachHang.getSdt();
                obj[4] = khachHang.getGioDen();
                obj[5] = khachHang.getNgayDen();
                obj[6] = khachHang.getThoiLuong();
                obj[7] = khachHang.getSoKhach();
                obj[8] = khachHang.getNvDatBan();
                obj[9] = khachHang.getBan();
                obj[10] = khachHang.getGhiChu();
                dtm.addRow(obj);
            }
        }
        return dtm;
    }
}
