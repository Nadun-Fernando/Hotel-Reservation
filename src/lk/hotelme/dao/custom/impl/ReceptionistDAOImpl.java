/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.hotelme.dao.custom.impl;

import lk.hotelme.dao.CrudUtil;
import lk.hotelme.dao.custom.ReceptionistDAO;
import lk.hotelme.entity.Receptionist;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author Nadun N. T. Fernando
 */
public class ReceptionistDAOImpl implements ReceptionistDAO{
    
    @Override
    public boolean add(Receptionist t) throws Exception {
        String sql="insert into Receptionist values(?,?,?,COMPRESS(?))";
        return CrudUtil.executeUpdate(sql, t.getReceptionist_ID(),t.getReceptionist_Name(),t.getUsername(),t.getPassword());
    }

    @Override
    public boolean update(Receptionist t) throws Exception {
        String sql="update Receptionist set Receptionist_Name=?,Username=?,Password=COMPRESS(?) where Receptionist_ID=?";
        return CrudUtil.executeUpdate(sql, t.getReceptionist_Name(),t.getUsername(),t.getPassword(),t.getReceptionist_ID());
    }

    @Override
    public boolean delete(String id) throws Exception {
        String sql="delete from Receptionist where Receptionist_ID=?";
        return CrudUtil.executeUpdate(sql, id);
    }

    @Override
    public Receptionist search(String id) throws Exception {
        String sql="select Receptionist_ID,Receptionist_Name,Username,UNCOMPRESS(Password) from Receptionist where Receptionist_ID=?";
        ResultSet rst = CrudUtil.executeQuery(sql, id);
        Receptionist users=null;
        while(rst.next()){
            users=new Receptionist(rst.getString(1), rst.getString(2), rst.getString(3), rst.getString(4));
        }
        return users;
    }

    @Override
    public ArrayList<Receptionist> loadAll() throws Exception {
        String sql="select Receptionist_ID,Receptionist_Name,Username,UNCOMPRESS(Password) from Receptionist;";
        ResultSet rst = CrudUtil.executeQuery(sql);
        ArrayList<Receptionist> allusers=new ArrayList<>();
        while(rst.next()){
            Receptionist user=new Receptionist(rst.getString(1), rst.getString(2), rst.getString(3), rst.getString(4));
            allusers.add(user);
        }
        return allusers;
    }
    
}
