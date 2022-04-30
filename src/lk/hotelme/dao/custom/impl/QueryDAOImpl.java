/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.hotelme.dao.custom.impl;

import lk.hotelme.controller.ReservationController;
import lk.hotelme.dao.CrudUtil;
import lk.hotelme.dao.custom.QueryDAO;
import lk.hotelme.entity.CustomEntity;
import java.sql.ResultSet;
import java.util.ArrayList;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author Nadun N. T. Fernando
 */
public class QueryDAOImpl implements QueryDAO{

    @Override
    public ArrayList<CustomEntity> getAvailableReservation(String packagename,int guests,String floor,String type,String arrival_Date) throws Exception {
        ArrayList<CustomEntity> availableReservations=new ArrayList<>();
        if(floor==null){
            String sql="select Room.Room_No,Package.Package_Name,Room.Room_Floor,Room_Type.Room_Type,Package.Package_Price as Room_Price from Room,Room_Type,Package"
                    + " where Room_Type.Type_ID=Room.Type_ID and Package.Package_ID=Room.Package_ID and Package.Package_Name=?  and Room_Type.Max_Guests>=?"
                    + " and Room_Type.Room_Type=? and Room.Room_ID not in(select Room_ID from Reservation where Room.Room_ID=Reservation.Room_ID "
                    + "and Departure_Date>=?)";
            ResultSet rst = CrudUtil.executeQuery(sql, packagename,guests,type,arrival_Date);
            while(rst.next()){
                availableReservations.add(new CustomEntity(rst.getString("Package_Name"), rst.getString("Room_No"), rst.getString("Room_Floor"), rst.getString("Room_Type"), rst.getDouble("Room_Price")));
                }
            return availableReservations;
        }else{
        String sql="select Room.Room_No,Package.Package_Name,Room.Room_Floor,Room_Type.Room_Type,Package.Package_Price as Room_Price from Room,Room_Type,Package"
                + " where Room_Type.Type_ID=Room.Type_ID and Package.Package_ID=Room.Package_ID and Package.Package_Name=?  and Room_Type.Max_Guests>=? "
                + "and Room.Room_Floor=? and Room_Type.Room_Type=? and Room.Room_ID not in(select Room_ID from Reservation where Room.Room_ID=Reservation.Room_ID and Departure_Date>=?)";
       
        ResultSet rst = CrudUtil.executeQuery(sql, packagename,guests,floor,type,arrival_Date);
        while(rst.next()){
            availableReservations.add(new CustomEntity(rst.getString("Package_Name"), rst.getString("Room_No"), rst.getString("Room_Floor"), rst.getString("Room_Type"), rst.getDouble("Room_Price")));
        }
        return availableReservations;
        }
    }

    @Override
    public ObservableList<String> getPackageName() throws Exception {
        String sql="Select Package_Name from Package";
        ResultSet rst = CrudUtil.executeQuery(sql);
        ObservableList<String> packageName=FXCollections.observableArrayList();
        while(rst.next()){
            packageName.add(rst.getString("Package_Name"));
        }
       return packageName;
    }

    @Override
    public ObservableList<String> getRoomType() throws Exception {
         String sql="Select Room_Type from Room_Type";
        ResultSet rst = CrudUtil.executeQuery(sql);
        ObservableList<String> roomType=FXCollections.observableArrayList();
        while(rst.next()){
            roomType.add(rst.getString("Room_Type"));
        }
       return roomType;
    }

    @Override
    public ObservableList<String> getReceptionistID() throws Exception {
        String sql="select Receptionist_ID from Receptionist";
        ResultSet rst = CrudUtil.executeQuery(sql);
        ObservableList<String> recptionistID=FXCollections.observableArrayList();
        while(rst.next()){
            recptionistID.add(rst.getString("Receptionist_ID"));
            
        }
        return recptionistID;
    }

    @Override
    public String getReceptionisName(String ID) throws Exception {
        String sql="Select Receptionist_Name from Receptionist where Receptionist_ID=?";
        ResultSet rst = CrudUtil.executeQuery(sql, ID);
        String name = null;
        while(rst.next()){
            name=rst.getString("Receptionist_Name");
        }
        return name;
    }

    @Override
    public String getnextReservationID() throws Exception {
        String sql="select Reservation__ID from Reservation order by Reservation__ID DESC limit 1;";
        ResultSet rst  = CrudUtil.executeQuery(sql);
        String reservationID=null;
        while(rst.next()){
            reservationID=rst.getString("Reservation__ID");
        }
        return reservationID;
    }

    @Override
    public String getRoomID(String roomNo) throws Exception {
        String sql="select Room_ID from Room where Room_No=?";
        ResultSet rst = CrudUtil.executeQuery(sql, roomNo);
        String room = null;
        while(rst.next()){
            room = rst.getString("Room_ID");
        }
        return room;
    }

    @Override
    public String getPaymentID() throws Exception {
        String sql="select Payment_ID from Payment order by Payment_ID DESC limit 1;";
        ResultSet rst = CrudUtil.executeQuery(sql);
        String paymentID = null;
        while(rst.next()){
            paymentID=rst.getString("Payment_ID");
        }
        return paymentID;
    }

    @Override
    public ObservableList<String> getMealType() throws Exception {
        String sql="select Meal_ID from Meal_Type";
        ResultSet rst = CrudUtil.executeQuery(sql);
        ObservableList<String> mealID=FXCollections.observableArrayList();
        while(rst.next()){
            mealID.add(rst.getString("Meal_ID"));
        }
        return mealID;
    }

    @Override
    public CustomEntity getMealNamePrice(String ID) throws Exception {
        String sql="select Meal_Name,Meal_Price from Meal_Type where Meal_ID=?";
        ResultSet rst = CrudUtil.executeQuery(sql, ID);
        CustomEntity mealnameprice=null;
        while(rst.next()){
            mealnameprice=new CustomEntity(rst.getString("Meal_Name"), rst.getDouble("Meal_Price"));
        }
        return mealnameprice;
    }

    @Override
    public String getPackageID(String name) throws Exception {
        String sql ="select Package_ID from Package where Package_Name=?";
        ResultSet rst = CrudUtil.executeQuery(sql,name);
        String packageid=null;
        while(rst.next()){
            packageid=rst.getString("Package_ID");
        }
        return packageid;
    }

    @Override
    public String getRoomTypeID(String type) throws Exception {
        String sql="select Type_ID from Room_Type where Room_Type=?";
        ResultSet rst = CrudUtil.executeQuery(sql, type);
        String roomTypeID=null;
        while(rst.next()){
            roomTypeID=rst.getString("Type_ID");
        }
        return roomTypeID;
    }

    @Override
    public ArrayList<CustomEntity> getAllPaymentDetails(String currentDate) throws Exception {
        ArrayList<CustomEntity> allPayments=new ArrayList<>();
        String sql="select Reservation.Customer_ID,Reservation.Payment_ID,Payment.Total_Amount,Payment_Detail.Amount_Paid,Payment_Detail.Remaining_Amount"
                + " from Reservation,Payment,Payment_Detail where Reservation.Payment_ID=Payment.Payment_ID and Payment.Payment_ID=Payment_Detail.Payment_ID "
                + "and Reservation.Departure_Date>=? group by Reservation.Payment_ID";
        ResultSet rst = CrudUtil.executeQuery(sql, currentDate);
        while(rst.next()){
            allPayments.add(new CustomEntity(rst.getString("Customer_ID"), rst.getString("Payment_ID"), rst.getDouble("Total_Amount"), rst.getDouble("Amount_Paid"), rst.getDouble("Remaining_Amount")));
        }
        return allPayments;
    }

    @Override
    public ArrayList<CustomEntity> getPaymentDetailsbyCustomerID(String customerID,String currentDate) throws Exception {
        ArrayList<CustomEntity> paymentbyCustomerID=new ArrayList<>();
        String sql="select Reservation.Customer_ID,Reservation.Payment_ID,Payment.Total_Amount,Payment_Detail.Amount_Paid,Payment_Detail.Remaining_Amount "
                + "from Reservation,Payment,Payment_Detail where Reservation.Payment_ID=Payment.Payment_ID and Payment.Payment_ID=Payment_Detail.Payment_ID "
                + "and Reservation.Departure_Date>=? and Reservation.Customer_ID=? group by Reservation.Payment_ID;";
        ResultSet rst = CrudUtil.executeQuery(sql, currentDate,customerID);
        while(rst.next()){
            paymentbyCustomerID.add(new CustomEntity(rst.getString("Customer_ID"), rst.getString("Payment_ID"), rst.getDouble("Total_Amount"), rst.getDouble("Amount_Paid"), rst.getDouble("Remaining_Amount")));
        }
        return paymentbyCustomerID;
    }

    @Override
    public ArrayList<CustomEntity> getPaymentDetailsbyPaymentID(String paymentID,String currentDate) throws Exception {
        ArrayList<CustomEntity> paymentbyPaymentID=new ArrayList<>();
        String sql="select Reservation.Customer_ID,Reservation.Payment_ID,Payment.Total_Amount,Payment_Detail.Amount_Paid,Payment_Detail.Remaining_Amount "
                + "from Reservation,Payment,Payment_Detail where Reservation.Payment_ID=Payment.Payment_ID and Payment.Payment_ID=Payment_Detail.Payment_ID "
                + "and Reservation.Departure_Date>=? and Reservation.Payment_ID=? group by Reservation.Payment_ID;";
        ResultSet rst = CrudUtil.executeQuery(sql, currentDate,paymentID);
        while(rst.next()){
            paymentbyPaymentID.add(new CustomEntity(rst.getString("Customer_ID"), rst.getString("Payment_ID"), rst.getDouble("Total_Amount"), rst.getDouble("Amount_Paid"), rst.getDouble("Remaining_Amount")));
        }
        return paymentbyPaymentID;
    }

    
}
