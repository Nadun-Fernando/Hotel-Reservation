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
public class Reservation {

    private String Reservation__ID;
    private String Customer_ID;
    private int No_of_Guests;
    private String Arrival_Date;
    private String Departure_Date;
    private String Package_ID;
    private String Meal_ID;
    private String Room_ID;
    private String Receptionist_ID;
    private String Payment_ID;

    public Reservation() {
    }

    public Reservation(String Reservation__ID, String Arrival_Date, String Departure_Date) {
        this.Reservation__ID = Reservation__ID;
        this.Arrival_Date = Arrival_Date;
        this.Departure_Date = Departure_Date;
    }
    

    public Reservation(String Reservation__ID, String Customer_ID, int No_of_Guests, String Arrival_Date, String Departure_Date, String Package_ID, String Meal_ID, String Room_ID, String Receptionist_ID, String Payment_ID) {
        this.Reservation__ID = Reservation__ID;
        this.Customer_ID = Customer_ID;
        this.No_of_Guests = No_of_Guests;
        this.Arrival_Date = Arrival_Date;
        this.Departure_Date = Departure_Date;
        this.Package_ID = Package_ID;
        this.Meal_ID = Meal_ID;
        this.Room_ID = Room_ID;
        this.Receptionist_ID = Receptionist_ID;
        this.Payment_ID = Payment_ID;
    }

    public String getReservation__ID() {
        return Reservation__ID;
    }

    public void setReservation__ID(String Reservation__ID) {
        this.Reservation__ID = Reservation__ID;
    }

    public String getCustomer_ID() {
        return Customer_ID;
    }

    public void setCustomer_ID(String Customer_ID) {
        this.Customer_ID = Customer_ID;
    }

    public int getNo_of_Guests() {
        return No_of_Guests;
    }

    public void setNo_of_Guests(int No_of_Guests) {
        this.No_of_Guests = No_of_Guests;
    }

    public String getArrival_Date() {
        return Arrival_Date;
    }

    public void setArrival_Date(String Arrival_Date) {
        this.Arrival_Date = Arrival_Date;
    }

    public String getDeparture_Date() {
        return Departure_Date;
    }

    public void setDeparture_Date(String Departure_Date) {
        this.Departure_Date = Departure_Date;
    }

    public String getPackage_ID() {
        return Package_ID;
    }

    public void setPackage_ID(String Package_ID) {
        this.Package_ID = Package_ID;
    }

    public String getMeal_ID() {
        return Meal_ID;
    }

    public void setMeal_ID(String Meal_ID) {
        this.Meal_ID = Meal_ID;
    }

    public String getRoom_ID() {
        return Room_ID;
    }

    public void setRoom_ID(String Room_ID) {
        this.Room_ID = Room_ID;
    }

    public String getReceptionist_ID() {
        return Receptionist_ID;
    }

    public void setReceptionist_ID(String Receptionist_ID) {
        this.Receptionist_ID = Receptionist_ID;
    }

    public String getPayment_ID() {
        return Payment_ID;
    }

    public void setPayment_ID(String Payment_ID) {
        this.Payment_ID = Payment_ID;
    }

    
    
    
}
