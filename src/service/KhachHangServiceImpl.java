 
package service;

import dao.KhachHangDAO;
import dao.KhachHangDAOImpl;
import java.util.List;
import model.KhachHang;

/**
 *
 * @author truon
 */
public class KhachHangServiceImpl implements KhachHangService{
    private KhachHangDAO khachHangDAO = null;

    public KhachHangServiceImpl() { 
            khachHangDAO = new KhachHangDAOImpl();
    }
    
    
    @Override
    public List<KhachHang> getList() {
        return khachHangDAO.getList();
    }

    @Override
    public int createOrUpdate(KhachHang khachHang) {
        return khachHangDAO.createOrUpdate(khachHang);
    }
    
}
