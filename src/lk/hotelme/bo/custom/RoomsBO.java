/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.hotelme.bo.custom;

import lk.hotelme.bo.SuperBO;
import lk.hotelme.dto.RoomDTO;
import java.util.ArrayList;

/**
 *
 * @author Nadun N. T. Fernando
 */
public interface RoomsBO extends SuperBO {

    public ArrayList<RoomDTO> loadallRooms() throws Exception;

    public boolean addRoom(RoomDTO t) throws Exception;

    public boolean updateRoom(RoomDTO t) throws Exception;

    public boolean deleteRoom(String ID) throws Exception;

    public RoomDTO search(String ID) throws Exception;

}
