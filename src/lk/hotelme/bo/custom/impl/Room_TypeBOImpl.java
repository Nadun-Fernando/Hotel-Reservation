/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.hotelme.bo.custom.impl;

import lk.hotelme.bo.custom.Room_TypeBO;
import lk.hotelme.dao.DAOFactory;
import lk.hotelme.dto.Room_TypeDTO;
import java.util.ArrayList;
import lk.hotelme.dao.custom.Room_TypeDAO;
import lk.hotelme.entity.Room_Type;

/**
 *
 * @author Nadun N. T. Fernando
 */
public class Room_TypeBOImpl implements Room_TypeBO{
    public static Room_TypeDAO room_typeDAO=(Room_TypeDAO) DAOFactory.getInstance().getDAAO(DAOFactory.dAOTypes.ROOMTYPE);

    @Override
    public boolean addRoomType(Room_TypeDTO type) throws Exception {
        return room_typeDAO.add(new Room_Type(type.getRoom_Type_ID(),type.getRoom_Type_Name(),type.getMax_Guests()));
    }

    @Override
    public boolean updateRoomType(Room_TypeDTO type) throws Exception {
    return room_typeDAO.update(new Room_Type(type.getRoom_Type_ID(),type.getRoom_Type_Name(),type.getMax_Guests()));
    }

    @Override
    public boolean deleteRoomType(String ID) throws Exception {
    return room_typeDAO.delete(ID);
    }

    @Override
    public Room_TypeDTO searchType(String ID) throws Exception {
        Room_Type search = room_typeDAO.search(ID);
        return new Room_TypeDTO(search.getType_ID(), search.getRoom_Type(), search.getMax_Guests());
    }

    @Override
    public ArrayList<Room_TypeDTO> loadAllRoomType() throws Exception {
        ArrayList<Room_TypeDTO> type = new ArrayList<>();
        ArrayList<Room_Type> room_tpye=room_typeDAO.loadAll();
        for (Room_Type room_types : room_tpye) {
            type.add(new Room_TypeDTO(room_types.getType_ID(), room_types.getRoom_Type(), room_types.getMax_Guests()));
        }
        return type;
        
    }
    
}
