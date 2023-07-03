package controller;

import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import model.KhachHang;
import service.KhachHangService;
import service.KhachHangServiceImpl;

public class KhachHangController {

    private JButton btnSubmit;
    private JTextField jtfTenKhachHang;
    private JTextField jtfSoDienThoai;
    private JTextField jtfGioDen;
    private JTextField jtfNgayDen;
    private JTextField jtfThoiLuong;
    private JTextField jtfSoKhach;
    private JTextField jtfNVDatBan;
    private JTextField jtfBan;
    private JTextArea jtfGhiChu;
    private JLabel jlbMsg;
    private JLabel jtfMaKhachHang;

    private KhachHang khachHang = null;
    private KhachHangService khachHangService = null;

    public KhachHangController(JButton btnSubmit, JTextField jtfTenKhachHang, JTextField jtfSoDienThoai, JTextField jtfGioDen, JTextField jtfNgayDen, JTextField jtfThoiLuong, JTextField jtfSoKhach, JTextField jtfNVDatBan, JTextField jtfBan, JTextArea jtfGhiChu, JLabel jlbMsg, JLabel jtfMaKhachHang) {
        this.btnSubmit = btnSubmit;
        this.jtfTenKhachHang = jtfTenKhachHang;
        this.jtfSoDienThoai = jtfSoDienThoai;
        this.jtfGioDen = jtfGioDen;
        this.jtfNgayDen = jtfNgayDen;
        this.jtfThoiLuong = jtfThoiLuong;
        this.jtfSoKhach = jtfSoKhach;
        this.jtfNVDatBan = jtfNVDatBan;
        this.jtfBan = jtfBan;
        this.jtfGhiChu = jtfGhiChu;
        this.jlbMsg = jlbMsg;
        this.jtfMaKhachHang = jtfMaKhachHang;
        this.khachHangService = new KhachHangServiceImpl();
    }

    public void setView(KhachHang khachHang) {
        this.khachHang = khachHang;
        jtfMaKhachHang.setText("#" + khachHang.getMaDatBan());
        jtfTenKhachHang.setText(khachHang.getTenKhachHang());
        jtfSoDienThoai.setText(khachHang.getSdt());
        jtfGioDen.setText(khachHang.getGioDen());
        jtfNgayDen.setText(khachHang.getNgayDen());
        jtfThoiLuong.setText(khachHang.getThoiLuong());
        jtfSoKhach.setText(khachHang.getSoKhach());
        jtfNVDatBan.setText(khachHang.getNvDatBan());
        jtfBan.setText(khachHang.getBan());
        jtfGhiChu.setText(khachHang.getGhiChu());
    }

    public void setEvent() {
        btnSubmit.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                try {
                    if (jtfTenKhachHang.getText().length() == 0 || jtfGioDen.getText().length() == 0 || jtfNgayDen.getText().length() == 0||
                            jtfSoDienThoai.getText().length() ==0  || jtfNVDatBan.getText().length()==0|| jtfSoKhach.getText().length()==0||
                            jtfThoiLuong.getText().length() ==0|| jtfBan.getText().length()==0) {
                        jlbMsg.setText("Vui lòng nhập đầy đủ thông tin!");
                    } else {
                        khachHang.setTenKhachHang(jtfTenKhachHang.getText());
                        if (!jtfSoDienThoai.getText().matches("^[0-9]{10,12}$")) {
                            jlbMsg.setText("Số điện thoại không đúng định dạng");
                            return;
                        }
                        khachHang.setSdt(jtfSoDienThoai.getText());
                        if (!jtfGioDen.getText().matches("^([01][0-9]|2[0-3]):[0-5][0-9]$")) {
                            jlbMsg.setText("Giờ đến phải ở dạng giờ:phút");
                            return;
                        }
                        khachHang.setGioDen(jtfGioDen.getText());
                        if (!jtfNgayDen.getText().matches("^(0[1-9]|1[0-9]|2[0-9]|3[01])/(0[1-9]|1[0-2])/([0-9]{2})$")) {
                            jlbMsg.setText("Ngày đến phải ở dạng ngày/tháng/năm");
                            return;
                        }
                        khachHang.setNgayDen(jtfNgayDen.getText());
                        khachHang.setThoiLuong(jtfThoiLuong.getText());
                        if (!jtfThoiLuong.getText().matches("^[0-9]+$")) {
                            jlbMsg.setText("Thời lượng phải là số tự nhiên");
                            return;
                        }
                        khachHang.setThoiLuong(jtfThoiLuong.getText());
                        if (!jtfSoKhach.getText().matches("^[0-9]+$")) {
                            jlbMsg.setText("Số khách phải là số tự nhiên");
                            return;
                        }
                        khachHang.setSoKhach(jtfSoKhach.getText());
                        if (!jtfNVDatBan.getText().matches("NV\\d{2}")) {
                            jlbMsg.setText("Không đúng mã nhân viên");
                            return;
                        }
                        khachHang.setNvDatBan(jtfNVDatBan.getText());
                        if (!jtfBan.getText().matches("^[0-9]+$")) {
                            jlbMsg.setText("Số bàn phải là số tự nhiên");
                            return;
                        }
                        khachHang.setBan(jtfBan.getText());
                        String gio = jtfGioDen.getText();
                        String ngay = jtfNgayDen.getText();
                        khachHang.setGhiChu(jtfGhiChu.getText());
                        String gioNgay = gio + " " + ngay;
                        DateFormat df = new SimpleDateFormat("HH:mm dd/MM/yy");
                        Date gioNgayDate = df.parse(gioNgay);
                        Date hienTai = new Date();
                        int compareResult = gioNgayDate.compareTo(hienTai);
                        if (compareResult < 0) {
                            JOptionPane.showMessageDialog(null, "Thời gian đặt bàn không được ở trong quá khứ");
                        } else {
                            if (showDialog()) {
                                int lastID = khachHangService.createOrUpdate(khachHang);
                                if (lastID != 0) {
                                    khachHang.setMaDatBan(lastID);
                                    jtfMaKhachHang.setText("#" + khachHang.getMaDatBan());
                                    jlbMsg.setText("Cập nhật dữ liệu thất bại");
                                } else {
                                    jlbMsg.setText("Cập nhật dữ liệu thành công");
                                }
                            }
                        }

                    }
                } catch (Exception ex) {
                    jlbMsg.setText(ex.toString());
                }

            }

            @Override
            public void mouseEntered(MouseEvent e) {
                btnSubmit.setBackground(new Color(0, 200, 83));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                btnSubmit.setBackground(new Color(100, 221, 23));
            }
        });

    }

    private boolean showDialog() {
        int dialogResult = JOptionPane.showConfirmDialog(null,
                "Bạn muốn lưu dữ liệu không?", "Thông báo", JOptionPane.YES_NO_OPTION);
        return dialogResult == JOptionPane.YES_OPTION;
    }
}
