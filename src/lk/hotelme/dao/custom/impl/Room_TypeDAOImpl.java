/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.hotelme.dao.custom.impl;

import lk.hotelme.dao.CrudUtil;
import lk.hotelme.entity.Room_Type;
import java.util.ArrayList;
import lk.hotelme.dao.custom.Room_TypeDAO;
import java.sql.ResultSet;

/**
 *
 * @author Nadun N. T. Fernando
 */
public class Room_TypeDAOImpl implements Room_TypeDAO{

    @Override
    public boolean add(Room_Type t) throws Exception {
       String sql="insert into Room_Type values(?,?,?)";
       return CrudUtil.executeUpdate(sql, t.getType_ID(),t.getRoom_Type(),t.getMax_Guests());
    }

    @Override
    public boolean update(Room_Type t) throws Exception {
        String sql="update Room_Type set Room_Type=?,Max_Guests=? where Type_ID=?";
        return CrudUtil.executeUpdate(sql, t.getType_ID(),t.getRoom_Type(),t.getMax_Guests());
    }

    @Override
    public boolean delete(String id) throws Exception {
        String sql="delete from Room_Type where Type_ID=?";
        return CrudUtil.executeUpdate(sql, id);
    }

    @Override
    public Room_Type search(String id) throws Exception {
        String sql ="SELECT * FROM Room_Type WHERE Type_ID=?";
        ResultSet rst = CrudUtil.executeQuery(sql, id);
        Room_Type room_Type=null;
        while(rst.next()){
            room_Type=new Room_Type(rst.getString("Type_ID"), rst.getString("Room_Type"), rst.getInt("Max_Guests"));
        }
        return room_Type;
        
    }

    @Override
    public ArrayList<Room_Type> loadAll() throws Exception {
         String sql="SELECT * FROM Room_Type";
        ResultSet rst = CrudUtil.executeQuery(sql);
        ArrayList<Room_Type> all=new ArrayList<>();
        while(rst.next()){
            Room_Type room_Type=new Room_Type(rst.getString(1), rst.getString(2), rst.getInt(3));
            all.add(room_Type);
        }
        return all;
    }
    
}
