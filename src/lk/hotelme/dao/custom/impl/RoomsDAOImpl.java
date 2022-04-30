/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.hotelme.dao.custom.impl;

import lk.hotelme.dao.CrudUtil;
import lk.hotelme.dao.custom.RoomsDAO;
import lk.hotelme.entity.Room;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author Nadun N. T. Fernando
 */
public class RoomsDAOImpl implements RoomsDAO{
    
    @Override
    public boolean add(Room t) throws Exception {
        String sql="insert into Room values(?,?,?,?,?)";
        return CrudUtil.executeUpdate(sql, t.getRoom_ID(),t.getType_ID(),t.getRoom_No(),t.getPackage_ID(),t.getRoom_Floor());
    }

    @Override
    public boolean update(Room t) throws Exception {
        String sql="update Room set Type_ID=?,Room_No=?,Package_ID=?,Room_Floor=? where Room_ID=?";
        return CrudUtil.executeUpdate(sql, t.getRoom_ID(),t.getType_ID(),t.getRoom_No(),t.getPackage_ID(),t.getRoom_Floor());
    }

    @Override
    public boolean delete(String id) throws Exception {
        String sql="delete from Room where Room_ID=?";
        return CrudUtil.executeUpdate(sql, id);
    }

    @Override
    public Room search(String id) throws Exception {
        String sql ="select Room.Room_ID,Room_Type.Room_Type,Room.Room_No,Package.Package_Name,Room.Room_Floor from Room,Package,Room_Type where"
                + " Room_ID=? and Room.Type_ID=Room_Type.Type_ID and Package.Package_ID=Room.Package_ID";
        ResultSet rst = CrudUtil.executeQuery(sql, id);
        Room room=null;
        while(rst.next()){
            room=new Room(rst.getString(1), rst.getString(2), rst.getString(3), rst.getString(4), rst.getString(5));
        }
        return room;
    }

    @Override
    public ArrayList<Room> loadAll() throws Exception {
        String sql="select Room.Room_ID,Room.Room_No,Room_Type.Room_Type,Package.Package_Name,Room.Room_Floor from Room,Room_Type,Package "
                + "where Room_Type.Type_ID=Room.Type_ID and Package.Package_ID=Room.Package_ID";
        ResultSet rst = CrudUtil.executeQuery(sql);
        ArrayList<Room> allrooms=new ArrayList<>();
        while(rst.next()){
            Room rooms = new Room(rst.getString(1), rst.getString(3), rst.getString(2), rst.getString(4), rst.getString(5));
            allrooms.add(rooms);
        }
        return allrooms;
    }
    
}
