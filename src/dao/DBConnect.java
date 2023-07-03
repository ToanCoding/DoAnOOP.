
package dao;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author truon
 */
public class DBConnect {
    public static Connection getConnection(){
        try {
            Connection cons = null;
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            cons = DriverManager.getConnection("jdbc:sqlserver://LAPTOP-PLDIM1QL:1433;DatabaseName=DoAnOOP;encrypt=true;trustServerCertificate=true;"
                    + "username=sa; password=123456789");
            return cons;
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return null;
    }
    public static void main(String[] args) throws SQLException{
        Connection c = getConnection();
        System.out.println(c.toString());
        c.close();
    }
}

