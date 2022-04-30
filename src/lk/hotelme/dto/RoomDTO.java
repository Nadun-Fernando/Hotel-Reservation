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
public class RoomDTO {

    private String Room_ID;
    private String Type_ID;
    private String Room_No;
    private String Package_ID;
    private String Room_Floor;

    public RoomDTO() {
    }

    public RoomDTO(String Room_ID, String Type_ID, String Room_No, String Package_ID, String Room_Floor) {
        this.Room_ID = Room_ID;
        this.Type_ID = Type_ID;
        this.Room_No = Room_No;
        this.Package_ID = Package_ID;
        this.Room_Floor = Room_Floor;
    }

    public String getRoom_ID() {
        return Room_ID;
    }

    public void setRoom_ID(String Room_ID) {
        this.Room_ID = Room_ID;
    }

    public String getType_ID() {
        return Type_ID;
    }

    public void setType_ID(String Type_ID) {
        this.Type_ID = Type_ID;
    }

    public String getRoom_No() {
        return Room_No;
    }

    public void setRoom_No(String Room_No) {
        this.Room_No = Room_No;
    }

    public String getPackage_ID() {
        return Package_ID;
    }

    public void setPackage_ID(String Package_ID) {
        this.Package_ID = Package_ID;
    }

    public String getRoom_Floor() {
        return Room_Floor;
    }

    public void setRoom_Floor(String Room_Floor) {
        this.Room_Floor = Room_Floor;
    }

}
