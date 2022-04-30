/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.hotelme.dao.custom;

import lk.hotelme.dao.SuperDAO;
import lk.hotelme.entity.CustomEntity;
import java.util.ArrayList;
import javafx.collections.ObservableList;

/**
 *
 * @author Nadun N. T. Fernando
 */
public interface QueryDAO extends SuperDAO{
    public ArrayList<CustomEntity> getAvailableReservation(String packagename,int guests,String floor,String type,String arrival_Date) throws Exception;
    public ObservableList<String> getPackageName() throws Exception;
    public ObservableList<String> getRoomType() throws Exception;
    public ObservableList<String> getReceptionistID() throws Exception;
    public String getReceptionisName(String ID) throws Exception;
    public String getnextReservationID() throws Exception;
    public String getRoomID(String roomNo) throws Exception;
    public String getPaymentID() throws Exception;
    public ObservableList<String> getMealType() throws Exception;
    public CustomEntity getMealNamePrice(String ID) throws Exception;
    public String getPackageID(String name) throws Exception;
    public String getRoomTypeID(String type) throws Exception;
    public ArrayList<CustomEntity> getAllPaymentDetails(String currentDate)throws Exception;
    public ArrayList<CustomEntity> getPaymentDetailsbyCustomerID(String customerID,String currentDate) throws Exception;
    public ArrayList<CustomEntity> getPaymentDetailsbyPaymentID(String paymentID,String currentDate) throws Exception;
    
}
