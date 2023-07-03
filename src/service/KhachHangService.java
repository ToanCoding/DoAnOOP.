
package service;

import java.util.List;
import model.KhachHang;

/**
 *
 * @author truon
 */
public interface KhachHangService {
 public List<KhachHang> getList();  
 public int createOrUpdate(KhachHang khachHang);
}
