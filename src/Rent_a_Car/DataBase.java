
package Rent_a_Car;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author bugra
 */

public class DataBase {
    
    private Connection connect = null ;
    private Statement statement = null ;
    private PreparedStatement preparedStatement = null ;
    
    public ArrayList<Musteri> MusterileriGetir() {
        
        ArrayList<Musteri> cikti = new ArrayList<Musteri>();
        
        try {
            statement = connect.createStatement();
             String sorgu = "Select * From tablo_bilgileri";
             
             ResultSet rs = statement.executeQuery(sorgu);
             
             while (rs.next()) {
                 
                 String name = rs.getString("name");
                 String surname = rs.getString("surname");
                 String gender = rs.getString("gender");
                 String phone_number = rs.getString("phone_number");
                 String id_number = rs.getString("id_number");
                 String brand = rs.getString("brand");
                 String model = rs.getString("model");
                 int model_year = rs.getInt("model_year");
                 int daily_price = rs.getInt("daily_price");
                 int day = rs.getInt("day");
                 String fuel_type = rs.getString("fuel_type");
                 
                 cikti.add(new Musteri(name,surname,gender,phone_number,id_number,brand,model,model_year,daily_price,day,fuel_type));
             }
             
             return cikti ;
             
        } catch (SQLException ex) {
            Logger.getLogger(DataBase.class.getName()).log(Level.SEVERE, null, ex);
            return null ;
        }
    
        
    }
    public void MusteriEkle (String name,String surname,String gender ,String phone_number ,String id_number,String brand,String model ,String model_year,String daily_price ,String day,String fuel_type ) {
        
        
        String sorgu = "Insert into tablo_bilgileri (name,surname,gender,phone_number,id_number,brand,model,model_year,daily_price,day,fuel_type) VALUES (?,?,?,?,?,?,?,?,?,?,?)";
        try {
            preparedStatement = connect.prepareStatement(sorgu);
            
            preparedStatement.setString(1, name);
            preparedStatement.setString(2, surname);
            preparedStatement.setString(3, gender);
            preparedStatement.setString(4, phone_number);
            preparedStatement.setString(5, id_number);
            preparedStatement.setString(6, brand);
            preparedStatement.setString(7, model);
            preparedStatement.setString(8, model_year);
            preparedStatement.setString(9, daily_price);
            preparedStatement.setString(10, day);
            preparedStatement.setString(11, fuel_type);
            
            preparedStatement.executeUpdate();
            
                    
        } catch (SQLException ex) {
            Logger.getLogger(DataBase.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        
        
    }
    
    public boolean girisYap(String kullanici_adi,String parola){
        
    String sorgu = " Select * From uyelik_bilgileri where username = ? and password = ?";
        try {
            preparedStatement = connect.prepareStatement(sorgu);
            preparedStatement.setString(1, kullanici_adi);
            preparedStatement.setString(2, parola);
            
            ResultSet rs = preparedStatement.executeQuery();
            return rs.next();
       
      
        } catch (SQLException ex) {
            Logger.getLogger(DataBase.class.getName()).log(Level.SEVERE, null, ex);
             return false ;
        }
}
    public DataBase () {
        
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
    }
    
}
