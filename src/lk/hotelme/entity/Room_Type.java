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
public class Room_Type {

    private String Type_ID;
    private String Room_Type;
    private int Max_Guests;

    public Room_Type() {
    }

    public Room_Type(String Type_ID, String Room_Type, int Max_Guests) {
        this.Type_ID = Type_ID;
        this.Room_Type = Room_Type;
        this.Max_Guests = Max_Guests;
    }

    public String getType_ID() {
        return Type_ID;
    }

    public void setType_ID(String Type_ID) {
        this.Type_ID = Type_ID;
    }

    public String getRoom_Type() {
        return Room_Type;
    }

    public void setRoom_Type(String Room_Type) {
        this.Room_Type = Room_Type;
    }

    public int getMax_Guests() {
        return Max_Guests;
    }

    public void setMax_Guests(int Max_Guests) {
        this.Max_Guests = Max_Guests;
    }

  
}
