


package Rent_a_Car;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author bugra
 */

public class Baglanti {
    
    public static final String kullanici_adi = "root";
    public static final String parola = "";
    public static final String db_ismi = "rent_a_car";
    public static final String host = "localhost";
    public static final int port = 3306;
    private Connection connect = null ;
    
    public Baglanti() {
        
        String url = "jdbc:mysql://" + host + ":" + port + "/" + db_ismi ;
        
        try { 
            Class.forName("com.mysql.jdbc.Driver");
    }   catch (ClassNotFoundException ex) {
        System.out.println("Driver not Found !");
        }
        
        try {
            connect = DriverManager.getConnection(url,kullanici_adi,parola);
        } catch (SQLException ex) {
            System.out.println("Connection Unsuccessful");
        }      
    }
      
}
