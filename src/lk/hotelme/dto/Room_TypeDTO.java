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
public class Room_TypeDTO {
    private String Room_Type_ID;
    private String Room_Type_Name;
    private int Max_Guests;

    public Room_TypeDTO() {
    }

    public Room_TypeDTO(String Room_Type_ID, String Room_Type_Name, int Max_Guests) {
        this.Room_Type_ID = Room_Type_ID;
        this.Room_Type_Name = Room_Type_Name;
        this.Max_Guests = Max_Guests;
    }

    public String getRoom_Type_ID() {
        return Room_Type_ID;
    }

    public void setRoom_Type_ID(String Room_Type_ID) {
        this.Room_Type_ID = Room_Type_ID;
    }

    public String getRoom_Type_Name() {
        return Room_Type_Name;
    }

    public void setRoom_Type_Name(String Room_Type_Name) {
        this.Room_Type_Name = Room_Type_Name;
    }

    public int getMax_Guests() {
        return Max_Guests;
    }

    public void setMax_Guests(int Max_Guests) {
        this.Max_Guests = Max_Guests;
    }

   
    
    
}
