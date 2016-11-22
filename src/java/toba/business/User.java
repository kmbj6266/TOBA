package toba.business;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
   
@Entity
public class User implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long userId;
    private String firstName;
    private String lastName;
    private String phone;
    private String address;
    private String city;
    private String state;
    private String zipcode;
    private String email;
    private String username;
    private String password;


    //commented out on 11/21/16 ********this is the Constructor i don't need to pass in username or password because I'm hard coding it in below
    public User (String firstName, String lastName, String phone, String address, String city, String state, String zipcode, String email, String username, String password){
        this.firstName = firstName;
        this.lastName = lastName;
        this.phone = phone;
        this.address = address;
        this.city = city;
        this.state = state;
        this.zipcode = zipcode;
        this.email = email;
        this.username = username;
        this.password = password;
        //11/21/16 NO LONGER HARD CODING username and password!!!... MUST GO INTO DATABASE AND GET FROM DATABASE NOW
        
    //commented this out 11/21/16
        //username is HARD CODED HERE, THE USERNAME IS the Last Name and Zipcode of the user
        //this.username = lastName + zipcode;
        //HARD CODED HERE password here!!!
        //this.password = "welcome1";
        
    }

    User() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    User(String firstName, String lastName, String phone, String address, String city, String state, String zipcode, String email) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public Long getUserId() {
        return userId;
    }
    public void setUserId(Long userId) {
        this.userId = userId;
    }
    
    public String getFirstName() {
        return firstName;
    }
    public void setFirstName(String firstName){
        this.firstName = firstName;
    }
    
    public String getLastName() {
        return lastName;
    }
    public void setLastName(String lastName){
        this.lastName = lastName;
    }
      
    public String getPhone() {
        return phone;
    }
    public void setPhone(String phone){
        this.phone = phone;
    }
        
    public String getAddress() {
        return address;
    }
    public void setAddress(String address){
        this.address = address;
    }
    
    public String getCity() {
        return city;
    }
    public void setCity(String city){
        this.city = city;
    }

    public String getState() {
        return state;
    }
    public void setState(String state){
        this.state = state;
    }
    
    public String getZipcode() {
        return zipcode;
    }
    public void setZipcode(String zipcode){
        this.city = zipcode;
    }
    
    public String getEmail() {
        return email;
    }
    public void setEmail(String email){
        this.email = email;
    }
    
    public String getUsername() {
        return username;
    }
    public void setUsername(String username){
        this.username = username;
    }
    
    public String getPassword() {
        return password;
    }
    public void setPassword(String password){
        this.password = password;
    }
    
    
}

