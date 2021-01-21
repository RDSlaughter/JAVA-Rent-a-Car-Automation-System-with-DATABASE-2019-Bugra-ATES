
package Rent_a_Car;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author bugra
 */
public class MyConnection {
    
    public static Connection getConnection() {
        
      Connection connect = null ;
      String url = "jdbc:mysql://" + Baglanti.host +":"+Baglanti.port+"/"+Baglanti.db_ismi+"?useUnicode=true&characterEncoding=utf-8";
        
        try { 
            Class.forName("com.mysql.jdbc.Driver");
    }   catch (ClassNotFoundException ex) {
        System.out.println("Driver not Found !");
        }
        
        try {
            connect = DriverManager.getConnection(url,Baglanti.kullanici_adi,Baglanti.parola);
            System.out.println("Connection Successful");
        } catch (SQLException ex) {
            System.out.println("Connection Unsuccessful");
        } 
        return connect ;
    }
    
}

