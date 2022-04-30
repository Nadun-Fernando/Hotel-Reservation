/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.hotelme.controller;

import lk.hotelme.bo.BOFactory;
import lk.hotelme.bo.custom.Room_TypeBO;
import lk.hotelme.dto.Room_TypeDTO;
import java.util.ArrayList;

/**
 *
 * @author Nadun N. T. Fernando
 */
public class RoomTypeMethodController {
    public static Room_TypeBO room_TypeBO=(Room_TypeBO) BOFactory.getInstance().getBO(BOFactory.bOTYPES.ROOMTYPE);
    
    public static boolean addtype(Room_TypeDTO t) throws Exception{
        return room_TypeBO.addRoomType(t);
    }
    
    public static boolean updatetype(Room_TypeDTO t) throws Exception{
        return room_TypeBO.updateRoomType(t);
    }
    
    public static boolean deletetype(String ID) throws Exception{
        return room_TypeBO.deleteRoomType(ID);
    }
    
    public static Room_TypeDTO searchtype(String ID) throws Exception{
        return room_TypeBO.searchType(ID);
    }
    
    public static ArrayList<Room_TypeDTO> loadtypes() throws Exception{
        return room_TypeBO.loadAllRoomType();
    }
}
