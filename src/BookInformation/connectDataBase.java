package BookInformation;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class connectDataBase {

    public static Connection getJDBCConnection() {
        String url = "jdbc:jtds:sqlserver://DESKTOP-ICL7331:1433/Book";
        try {
            Class.forName("net.sourceforge.jtds.jdbc.Driver");
            return DriverManager.getConnection(url);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(connectDataBase.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(connectDataBase.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }


}
