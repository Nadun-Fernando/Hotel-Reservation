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
public class CustomEntity {

    private String Admin_ID;
    private String Username;
    private String Password;
    private String Email;
    private String User_Level;
    private String Customer_ID;
    private String Customer_Name;
    private String Address;
    private String Contact_No;
    private String Meal_ID;
    private String Meal_Name;
    private String Meal_Description;
    private double Meal_Price;
    private String Package_ID;
    private String Package_Name;
    private String Package_Details;
    private double Package_Price;
    private String Package_Expiry_Date;
    private String Payment_ID;
    private double Total_Amount;
    private String Payment_Type_ID;
    private String Payment_Type_Name;
    private String Payment_Date;
    private double Amount_Paid;
    private double Remaining_Amount;
    private String Receptionist_ID;
    private String Receptionist_Name;
    private String Reservation__ID;
    private int No_of_Guests;
    private String Arrival_Date;
    private String Departure_Date;
    private String Room_ID;
    private String Item_ID;
    private String Reservation_Status;
    private String Type_ID;
    private String Room_No;
    private String Room_Floor;
    private String Room_Type;
    private int Room_Quantity;
    private int Available_Quantity;
    private double Room_Price;
    private int Max_Guests;

    public CustomEntity() {
    }

    public CustomEntity(String Customer_ID, String Payment_ID, double Total_Amount, double Amount_Paid, double Remaining_Amount) {
        this.Customer_ID = Customer_ID;
        this.Payment_ID = Payment_ID;
        this.Total_Amount = Total_Amount;
        this.Amount_Paid = Amount_Paid;
        this.Remaining_Amount = Remaining_Amount;
    }
    
    

    public CustomEntity(int No_of_Guests, String Arrival_Date, String Departure_Date) {
        this.No_of_Guests = No_of_Guests;
        this.Arrival_Date = Arrival_Date;
        this.Departure_Date = Departure_Date;
    }

  
    
    public CustomEntity(String Receptionist_Name) {
        this.Receptionist_Name = Receptionist_Name;
    }

    public CustomEntity(String Meal_Name, double Meal_Price) {
        this.Meal_Name = Meal_Name;
        this.Meal_Price = Meal_Price;
    }
    
    
    

    public CustomEntity(String Package_Name, String Room_No, String Room_Floor, String Room_Type, double Room_Price) {
        this.Package_Name = Package_Name;
        this.Room_No = Room_No;
        this.Room_Floor = Room_Floor;
        this.Room_Type = Room_Type;
        this.Room_Price = Room_Price;
    }

    public CustomEntity(String Package_Name, String Arrival_Date, String Room_Floor, String Room_Type, int Max_Guests) {
        this.Package_Name = Package_Name;
        this.Arrival_Date = Arrival_Date;
        this.Room_Floor = Room_Floor;
        this.Room_Type = Room_Type;
        this.Max_Guests = Max_Guests;
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

    public String getCustomer_ID() {
        return Customer_ID;
    }

    public void setCustomer_ID(String Customer_ID) {
        this.Customer_ID = Customer_ID;
    }

    public String getCustomer_Name() {
        return Customer_Name;
    }

    public void setCustomer_Name(String Customer_Name) {
        this.Customer_Name = Customer_Name;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String Address) {
        this.Address = Address;
    }

    public String getContact_No() {
        return Contact_No;
    }

    public void setContact_No(String Contact_No) {
        this.Contact_No = Contact_No;
    }

    public String getMeal_ID() {
        return Meal_ID;
    }

    public void setMeal_ID(String Meal_ID) {
        this.Meal_ID = Meal_ID;
    }

    public String getMeal_Name() {
        return Meal_Name;
    }

    public void setMeal_Name(String Meal_Name) {
        this.Meal_Name = Meal_Name;
    }

    public String getMeal_Description() {
        return Meal_Description;
    }

    public void setMeal_Description(String Meal_Description) {
        this.Meal_Description = Meal_Description;
    }

    public double getMeal_Price() {
        return Meal_Price;
    }

    public void setMeal_Price(double Meal_Price) {
        this.Meal_Price = Meal_Price;
    }

    public String getPackage_ID() {
        return Package_ID;
    }

    public void setPackage_ID(String Package_ID) {
        this.Package_ID = Package_ID;
    }

    public String getPackage_Name() {
        return Package_Name;
    }

    public void setPackage_Name(String Package_Name) {
        this.Package_Name = Package_Name;
    }

    public String getPackage_Details() {
        return Package_Details;
    }

    public void setPackage_Details(String Package_Details) {
        this.Package_Details = Package_Details;
    }

    public double getPackage_Price() {
        return Package_Price;
    }

    public void setPackage_Price(double Package_Price) {
        this.Package_Price = Package_Price;
    }

    public String getPackage_Expiry_Date() {
        return Package_Expiry_Date;
    }

    public void setPackage_Expiry_Date(String Package_Expiry_Date) {
        this.Package_Expiry_Date = Package_Expiry_Date;
    }

    public String getPayment_ID() {
        return Payment_ID;
    }

    public void setPayment_ID(String Payment_ID) {
        this.Payment_ID = Payment_ID;
    }

    public double getTotal_Amount() {
        return Total_Amount;
    }

    public void setTotal_Amount(double Total_Amount) {
        this.Total_Amount = Total_Amount;
    }

    public String getPayment_Type_ID() {
        return Payment_Type_ID;
    }

    public void setPayment_Type_ID(String Payment_Type_ID) {
        this.Payment_Type_ID = Payment_Type_ID;
    }

    public String getPayment_Type_Name() {
        return Payment_Type_Name;
    }

    public void setPayment_Type_Name(String Payment_Type_Name) {
        this.Payment_Type_Name = Payment_Type_Name;
    }

    public String getPayment_Date() {
        return Payment_Date;
    }

    public void setPayment_Date(String Payment_Date) {
        this.Payment_Date = Payment_Date;
    }

    public double getAmount_Paid() {
        return Amount_Paid;
    }

    public void setAmount_Paid(double Amount_Paid) {
        this.Amount_Paid = Amount_Paid;
    }

    public double getRemaining_Amount() {
        return Remaining_Amount;
    }

    public void setRemaining_Amount(double Remaining_Amount) {
        this.Remaining_Amount = Remaining_Amount;
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

    public String getReservation__ID() {
        return Reservation__ID;
    }

    public void setReservation__ID(String Reservation__ID) {
        this.Reservation__ID = Reservation__ID;
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

    public String getRoom_ID() {
        return Room_ID;
    }

    public void setRoom_ID(String Room_ID) {
        this.Room_ID = Room_ID;
    }

    public String getItem_ID() {
        return Item_ID;
    }

    public void setItem_ID(String Item_ID) {
        this.Item_ID = Item_ID;
    }

    public String getReservation_Status() {
        return Reservation_Status;
    }

    public void setReservation_Status(String Reservation_Status) {
        this.Reservation_Status = Reservation_Status;
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

    public String getRoom_Floor() {
        return Room_Floor;
    }

    public void setRoom_Floor(String Room_Floor) {
        this.Room_Floor = Room_Floor;
    }

    public String getRoom_Type() {
        return Room_Type;
    }

    public void setRoom_Type(String Room_Type) {
        this.Room_Type = Room_Type;
    }

    public int getRoom_Quantity() {
        return Room_Quantity;
    }

    public void setRoom_Quantity(int Room_Quantity) {
        this.Room_Quantity = Room_Quantity;
    }

    public int getAvailable_Quantity() {
        return Available_Quantity;
    }

    public void setAvailable_Quantity(int Available_Quantity) {
        this.Available_Quantity = Available_Quantity;
    }

    public double getRoom_Price() {
        return Room_Price;
    }

    public void setRoom_Price(double Room_Price) {
        this.Room_Price = Room_Price;
    }

    public int getMax_Guests() {
        return Max_Guests;
    }

    public void setMax_Guests(int Max_Guests) {
        this.Max_Guests = Max_Guests;
    }
    
    

}
