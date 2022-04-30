/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.hotelme.controller;

import lk.hotelme.bo.BOFactory;
import lk.hotelme.bo.custom.RoomsBO;
import lk.hotelme.dao.DAOFactory;
import lk.hotelme.dao.custom.QueryDAO;
import lk.hotelme.dto.RoomDTO;
import java.util.ArrayList;
import javafx.collections.ObservableList;

/**
 *
 * @author Nadun N. T. Fernando
 */
public class RoomsMethodController {
    public static QueryDAO qdao=(QueryDAO) DAOFactory.getInstance().getDAAO(DAOFactory.dAOTypes.QUERY);
    public static RoomsBO rbo=(RoomsBO) BOFactory.getInstance().getBO(BOFactory.bOTYPES.ROOMS);
    
    public static ObservableList<String> getPackageName() throws Exception{
        return qdao.getPackageName();
    }
    
    public static ObservableList<String> getRoomType() throws Exception{
        return qdao.getRoomType();
    }
    
    public static ArrayList<RoomDTO> loadallRooms() throws Exception{
        return rbo.loadallRooms();
    }
    public static boolean addRoom(RoomDTO t) throws Exception{
        return rbo.addRoom(t);
    }
    
    public static boolean updateRoom(RoomDTO t) throws Exception{
        return rbo.updateRoom(t);
    }
    
    public static boolean deleteRoom(String ID) throws Exception{
        return rbo.deleteRoom(ID);
    }
    
    public static RoomDTO searchRoom(String ID) throws Exception{
        return rbo.search(ID);
    }
    
    public static String getPackageID(String name) throws Exception{
        return qdao.getPackageID(name);
    }
    
     public static String gettypeID(String type) throws Exception{
        return qdao.getRoomTypeID(type);
    }
}
