/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.hotelme.entity;

/**
 *
 * @author Nadun N. T. Fernando
 */
public class Administrator {

    private String Admin_ID;
    private String Username;
    private String Password;
    private String Email;
    private String User_Level;

    public Administrator() {
    }

    public Administrator(String Admin_ID, String Username, String Password, String Email, String User_Level) {
        this.Admin_ID = Admin_ID;
        this.Username = Username;
        this.Password = Password;
        this.Email = Email;
        this.User_Level = User_Level;
    }

    public Administrator(String Username, String Password) {
        this.Username = Username;
        this.Password = Password;
    }

    public String getAdmin_ID() {
        return Admin_ID;
    }

    public void setAdmin_ID(String Admin_ID) {
        this.Admin_ID = Admin_ID;
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

    public String getEmail() {
        return Email;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

    public String getUser_Level() {
        return User_Level;
    }

    public void setUser_Level(String User_Level) {
        this.User_Level = User_Level;
    }
    
}
