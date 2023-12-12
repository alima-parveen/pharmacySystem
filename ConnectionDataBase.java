
package pharmacysystem;
import java.sql.*;

public class ConnectionDataBase {
    
    
    Connection c;
    Statement s;

    ConnectionDataBase () {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            c = DriverManager.getConnection("jdbc:mysql:///poject01", "root", "Test@123");
            s = c.createStatement();
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    
}
