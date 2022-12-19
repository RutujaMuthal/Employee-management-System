 
package employee.manegment.system;

import java.sql.*;
import java.sql.DriverManager;
public class Conn {
    
    Connection c;
    Statement s;

    public Conn () {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
           c = DriverManager.getConnection("jdbc:mysql:///employeemanagementsystem", "root", "MRutuja185@");
            s = c.createStatement();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
