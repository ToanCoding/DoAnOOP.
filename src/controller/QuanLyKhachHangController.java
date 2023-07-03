package controller;

import dao.DAO;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.RowFilter;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableModel;
import model.KhachHang;
import service.KhachHangService;
import service.KhachHangServiceImpl;
import utility.ClassTableModel;
import view.KhachHangJFrame;

/**
 *
 * @author truon
 */
public class QuanLyKhachHangController {

    private JPanel jpnView;
    private JButton btnAdd;
    private JTextField jtfSearch;
    private ClassTableModel classTableModel = null;
    private KhachHangService khachHangService = null;
    private final String[] COLUMNS = {"Mã Khách Hàng", "STT", "Tên KH", "SĐT", "Giờ Đến", "Ngày Đến", "Thời Lượng", "Số Khách", "NV Đặt Bàn", "Bàn", "Ghi Chú"};
    private TableRowSorter<TableModel> rowSorter = null;
    JTable table = new JTable();


    public QuanLyKhachHangController(JPanel jpnView, JButton btnAdd, JTextField jtfSearch) {
        this.jpnView = jpnView;
        this.btnAdd = btnAdd;
        this.jtfSearch = jtfSearch;
        this.classTableModel = new ClassTableModel();
        this.khachHangService = new KhachHangServiceImpl();
    }

    public void setDateToTable() {
        List<KhachHang> listItem = khachHangService.getList();
        DefaultTableModel model = new ClassTableModel().setTableKhachHang(listItem, COLUMNS);
        table = new JTable(model);
        rowSorter = new TableRowSorter<>(table.getModel());
        table.setRowSorter(rowSorter);
        jtfSearch.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                String text = jtfSearch.getText();
                if (text.trim().length() == 0) {
                    rowSorter.setRowFilter(null);

                } else {
                    rowSorter.setRowFilter(RowFilter.regexFilter("(?i)" + text));
                }
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                String text = jtfSearch.getText();
                if (text.trim().length() == 0) {
                    rowSorter.setRowFilter(null);

                } else {
                    rowSorter.setRowFilter(RowFilter.regexFilter("(?i)" + text));
                }
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
            }
        });
        table.getColumnModel().getColumn(0).setPreferredWidth(0);
        table.getColumnModel().getColumn(0).setMinWidth(0);
        table.getColumnModel().getColumn(0).setMaxWidth(0);

        table.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (e.getClickCount() == 2 && table.getSelectedRow() != -1) {
                    DefaultTableModel model = (DefaultTableModel) table.getModel();
                    int selectedRowIndex = table.getSelectedRow();
                    selectedRowIndex = table.convertRowIndexToModel(selectedRowIndex);
                    KhachHang khachHang = new KhachHang();
                    khachHang.setMaDatBan((int) model.getValueAt(selectedRowIndex, 0));
                    khachHang.setTenKhachHang(model.getValueAt(selectedRowIndex, 2).toString());
                    khachHang.setSdt(model.getValueAt(selectedRowIndex, 3).toString());
                    khachHang.setNgayDen(model.getValueAt(selectedRowIndex, 4).toString());
                    khachHang.setGioDen(model.getValueAt(selectedRowIndex, 5).toString());
                    khachHang.setThoiLuong(model.getValueAt(selectedRowIndex, 6).toString());
                    khachHang.setSoKhach(model.getValueAt(selectedRowIndex, 7).toString());
                    khachHang.setNvDatBan(model.getValueAt(selectedRowIndex, 8).toString());
                    khachHang.setBan(model.getValueAt(selectedRowIndex, 9).toString());
                    khachHang.setGhiChu((String) model.getValueAt(selectedRowIndex, 10));
                    KhachHangJFrame frame = new KhachHangJFrame(khachHang);
                    frame.setTitle("Thông tin khách hàng");
                    frame.setResizable(false);
                    frame.setLocationRelativeTo(null);
                    frame.setVisible(true);
                }
            }

        });

        table.getTableHeader().setFont(new Font("Segoe UI", Font.PLAIN, 14));
        table.getTableHeader().setPreferredSize(new Dimension(100, 50));
        table.setRowHeight(70);
        table.validate();
        table.repaint();
        JScrollPane scrollpane = new JScrollPane();
        scrollpane.getViewport().add(table);
        scrollpane.setPreferredSize(new Dimension(1300, 400));
        jpnView.removeAll();
        jpnView.setLayout(new BorderLayout());
        jpnView.add(scrollpane);
        jpnView.validate();
        jpnView.repaint();

    }

    public void deleteSelectedRow() {
         int selectedRow = table.getSelectedRow();
        if (selectedRow != -1) {
            String maDatBanString = (String) table.getValueAt(selectedRow, 5).toString().trim();
            String maDatBan = maDatBanString;
            try {
                DAO dao = new DAO();
                dao.deleteRow(maDatBan);
                DefaultTableModel model = (DefaultTableModel) table.getModel();
                model.removeRow(selectedRow);

                JOptionPane.showMessageDialog(null, "Đã xoá thông tin đặt bàn \"" + maDatBan + "\"");
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "Lỗi khi xoá bàn đặt bàn");
                ex.printStackTrace();
            }
        } else {
            JOptionPane.showMessageDialog(null, "Đã xoá thông tin đặt bàn");
        }
    }

    public void setEvent() {
        btnAdd.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                KhachHangJFrame frame = new KhachHangJFrame(new KhachHang());
                frame.setTitle("Thông tin khách hàng");
                frame.setLocationRelativeTo(null);
                frame.setResizable(false);
                frame.setVisible(true);
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                btnAdd.setBackground(new Color(0, 200, 83));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                btnAdd.setBackground(new Color(100, 221, 23));
            }
        });
    }
}
