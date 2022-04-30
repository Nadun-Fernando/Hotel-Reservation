/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.hotelme.controller;


import lk.hotelme.bo.BOFactory;
import lk.hotelme.bo.custom.ReservationBO;
import lk.hotelme.dao.DAOFactory;
import lk.hotelme.dao.custom.QueryDAO;
import lk.hotelme.dto.ReservationDTO;
import lk.hotelme.entity.CustomEntity;
import java.util.ArrayList;
import javafx.collections.ObservableList;

/**
 *
 * @author Nadun N. T. Fernando
 */
public class ReservationMethodController {
    public static QueryDAO Querydao = (QueryDAO) DAOFactory.getInstance().getDAAO(DAOFactory.dAOTypes.QUERY);
    public static ReservationBO resbo=(ReservationBO) BOFactory.getInstance().getBO(BOFactory.bOTYPES.RESERVATION);
    
    public static ObservableList<String> getPackage() throws Exception{
        return Querydao.getPackageName();
    }
    
    public static ObservableList<String> getRoomType() throws Exception{
        return Querydao.getRoomType();
    }
    
    public static ArrayList<CustomEntity> getAvailableReservations(String packagename,int guests,String floor,String type,String arrival_Date) throws Exception{
        return Querydao.getAvailableReservation(packagename, guests, floor, type, arrival_Date);
    }
    
    public static boolean updateReservation(ReservationDTO t) throws Exception{
        return resbo.updateReservation(t);
    }
    public static boolean deleteReservation(String ID) throws Exception{
        return resbo.deleteReservation(ID);
    }
    public static ArrayList<ReservationDTO> loadallReservation() throws Exception{
        return resbo.loadAllReservation();
    }
    public static ReservationDTO searchReservation(String ID) throws Exception{
        return resbo.searchReservation(ID);
    }
   
}
