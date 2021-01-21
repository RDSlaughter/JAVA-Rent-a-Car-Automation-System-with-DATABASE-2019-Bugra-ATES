

package Rent_a_Car;

/**
 *
 * @author bugra
 */
public class Musteri {
    
    private String name ;
    private String surname ;
    private String gender ;
    private String phone_number ;
    private String id_number ;
    private String brand ;
    private String model ;
    private int model_year ;
    private int daily_price ;
    private int day ;
    private String fuel_type ;

    public Musteri(String name, String surname, String gender ,String phone_number, String id_number, String brand, String model, int model_year, int daily_price, int day,String fuel_type) {
        this.name = name;
        this.surname = surname;
        this.gender = gender ;
        this.phone_number = phone_number;
        this.id_number = id_number;
        this.brand = brand;
        this.model = model;
        this.model_year = model_year;
        this.daily_price = daily_price;
        this.day = day;
        this.fuel_type = fuel_type ;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }
    public String getGender(){
        return gender ;
    }
    public void setGender(String gender){
        this.gender = gender ;
    }

    public String getPhone_number() {
        return phone_number;
    }

    public void setPhone_number(String phone_number) {
        this.phone_number = phone_number;
    }

    public String getId_number() {
        return id_number;
    }

    public void setId_number(String id_number) {
        this.id_number = id_number;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getModel_year() {
        return model_year;
    }

    public void setModel_year(int model_year) {
        this.model_year = model_year;
    }

    public int getDaily_price() {
        return daily_price;
    }

    public void setDaily_price(int daily_price) {
        this.daily_price = daily_price;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }
    public String getFuel_type () {
        return fuel_type ;
    }
    public void setFuel_type (String fuel_type){
        this.fuel_type = fuel_type;
    }
}
