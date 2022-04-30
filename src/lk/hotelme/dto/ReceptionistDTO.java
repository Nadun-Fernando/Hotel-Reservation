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
public class ReceptionistDTO {

    private String Receptionist_ID;
    private String Receptionist_Name;
    private String Username;
    private String Password;

    public ReceptionistDTO() {
    }

    public ReceptionistDTO(String Receptionist_ID, String Receptionist_Name, String Username, String Password) {
        this.Receptionist_ID = Receptionist_ID;
        this.Receptionist_Name = Receptionist_Name;
        this.Username = Username;
        this.Password = Password;
    }

    public String getReceptionist_ID() {
        return Receptionist_ID;
    }

    public void setReceptionist_ID(String Receptionist_ID) {
        this.Receptionist_ID = Receptionist_ID;
    }

    public String getReceptionist_Name() {
        return Receptionist_Name;
    }

    public void setReceptionist_Name(String Receptionist_Name) {
        this.Receptionist_Name = Receptionist_Name;
    }

    public String getUsername() {
        return Username;
    }

    public void setUsername(String Username) {
        this.Username = Username;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String Password) {
        this.Password = Password;
    }
    
}
