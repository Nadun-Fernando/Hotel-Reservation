/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.hotelme.bo.custom.impl;

import lk.hotelme.bo.custom.RoomsBO;
import lk.hotelme.dao.DAOFactory;
import lk.hotelme.dao.custom.RoomsDAO;
import lk.hotelme.dto.RoomDTO;
import lk.hotelme.entity.Room;
import java.util.ArrayList;

/**
 *
 * @author Nadun N. T. Fernando
 */
public class RoomsBOImpl implements RoomsBO{
    public static RoomsDAO roomdao=(RoomsDAO) DAOFactory.getInstance().getDAAO(DAOFactory.dAOTypes.ROOMS);
    
    @Override
    public ArrayList<RoomDTO> loadallRooms() throws Exception {
        ArrayList<RoomDTO> rooms=new ArrayList<>();
        ArrayList<Room> loadAll = roomdao.loadAll();
        for (Room room : loadAll) {
            rooms.add(new RoomDTO(room.getRoom_ID(), room.getType_ID(), room.getRoom_No(), room.getPackage_ID(), room.getRoom_Floor()));
        }
        
        return rooms;
    }

    @Override
    public boolean addRoom(RoomDTO t) throws Exception {
        return roomdao.add(new Room(t.getRoom_ID(), t.getType_ID(), t.getRoom_No(), t.getPackage_ID(), t.getRoom_Floor()));
    }

    @Override
    public boolean updateRoom(RoomDTO t) throws Exception {
        return roomdao.update(new Room(t.getRoom_ID(), t.getType_ID(), t.getRoom_No(), t.getPackage_ID(), t.getRoom_Floor()));
    }

    @Override
    public boolean deleteRoom(String ID) throws Exception {
        return roomdao.delete(ID);
    }

    @Override
    public RoomDTO search(String ID) throws Exception {
        Room search = roomdao.search(ID);
        return new RoomDTO(search.getRoom_ID(), search.getType_ID(), search.getRoom_No(), search.getPackage_ID(), search.getRoom_Floor());
    }
    
    
    
}
