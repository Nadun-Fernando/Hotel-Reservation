/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.hotelme.bo.custom;

import lk.hotelme.bo.SuperBO;
import lk.hotelme.dto.Room_TypeDTO;
import java.util.ArrayList;

/**
 *
 * @author Nadun N. T. Fernando
 */
public interface Room_TypeBO extends SuperBO{
    public boolean addRoomType(Room_TypeDTO type) throws Exception;

    public boolean updateRoomType(Room_TypeDTO type) throws Exception;

    public boolean deleteRoomType(String ID) throws Exception;

    public Room_TypeDTO searchType(String ID) throws Exception;

    public ArrayList<Room_TypeDTO> loadAllRoomType() throws Exception;
}
