/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.hotelme.dto;

/**
 *
 * @author Nadun N. T. Fernando
 */
public class CustomerDTO {
    private String ID;
    private String Name;
    private String Address;
    private String TelephoneNumber;
    private String email;

    public CustomerDTO() {
    }

    public CustomerDTO(String ID, String Name, String Address, String TelephoneNumber, String email) {
        this.ID = ID;
        this.Name = Name;
        this.Address = Address;
        this.TelephoneNumber = TelephoneNumber;
        this.email = email;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String Address) {
        this.Address = Address;
    }

    public String getTelephoneNumber() {
        return TelephoneNumber;
    }

    public void setTelephoneNumber(String TelephoneNumber) {
        this.TelephoneNumber = TelephoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
}
