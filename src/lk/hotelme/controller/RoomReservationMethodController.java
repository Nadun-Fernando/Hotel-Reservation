/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.hotelme.controller;

import lk.hotelme.bo.BOFactory;
import lk.hotelme.bo.custom.RoomReservationBO;
import lk.hotelme.dao.DAOFactory;
import lk.hotelme.dao.custom.QueryDAO;
import lk.hotelme.dto.PaymentDTO;
import lk.hotelme.dto.Payment_DetailsTO;
import lk.hotelme.dto.ReservationDTO;
import lk.hotelme.entity.CustomEntity;
import javafx.collections.ObservableList;
import lk.hotelme.bo.custom.CustomerBO;
import lk.hotelme.dto.CustomerDTO;

/**
 *
 * @author Nadun N. T. Fernando
 */
public class RoomReservationMethodController {
    public static QueryDAO Querydao = (QueryDAO) DAOFactory.getInstance().getDAAO(DAOFactory.dAOTypes.QUERY);
    public static RoomReservationBO rrbo=(RoomReservationBO) BOFactory.getInstance().getBO(BOFactory.bOTYPES.ROOMRESERVATION);
    public static CustomerBO custbo=(CustomerBO) BOFactory.getInstance().getBO(BOFactory.bOTYPES.CUSTOMER);
    
    public static ObservableList<String> getReceptionistID() throws Exception{
        return Querydao.getReceptionistID();
    }
    
    public static String getReceptionistName(String ID) throws Exception{
        return Querydao.getReceptionisName(ID);
    }
    public static String getnextReservationID() throws Exception{
        return Querydao.getnextReservationID();
    }
    public static String getRoomID(String roomNO) throws Exception{
        return Querydao.getRoomID(roomNO);
    }
    public static String getPaymentID() throws Exception{
        return Querydao.getPaymentID();
    }
    public static ObservableList<String> getMealID() throws Exception {
        return Querydao.getMealType();
    }
    public static CustomEntity getMealName(String ID) throws Exception{
        return Querydao.getMealNamePrice(ID);
    }
    public static boolean confirmbooking(PaymentDTO p,Payment_DetailsTO pd,ReservationDTO res) throws Exception{
        return rrbo.confirmBooking(p, pd, res);
    }
    
    public static String getPackageID(String name) throws Exception{
        return Querydao.getPackageID(name);
    }
    
   public static CustomerDTO seacrhcutomerbyContactNo(String contactNo) throws Exception{
       return custbo.searchbyContacNumber(contactNo);
   }
}
