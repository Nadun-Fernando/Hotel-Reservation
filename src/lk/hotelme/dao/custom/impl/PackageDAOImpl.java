/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.hotelme.dao.custom.impl;

import lk.hotelme.dao.CrudUtil;
import lk.hotelme.dao.custom.PackageDAO;
import lk.hotelme.entity.Packages;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author Nadun N. T. Fernando
 */
public class PackageDAOImpl implements PackageDAO {

    @Override
    public boolean add(Packages t) throws Exception {
        String sql = "insert into Package values(?,?,?,?)";
        return CrudUtil.executeUpdate(sql, t.getPackage_ID(), t.getPackage_Name(), t.getPackage_Details(), t.getPackage_Price());
    }

    @Override
    public boolean update(Packages t) throws Exception {
        String sql="Update Package set Package_Name=?,Package_Details=?,Package_Price=? where Package_ID=?";
       return CrudUtil.executeUpdate(sql, t.getPackage_Name(),t.getPackage_Details(),t.getPackage_Price(),t.getPackage_ID());
    }

    @Override
    public boolean delete(String id) throws Exception {
         String sql="DELETE FROM Package WHERE Package_ID=?";
        return CrudUtil.executeUpdate(sql, id);
    }

    @Override
    public Packages search(String id) throws Exception {
     String sql="select * from Package where Package_ID=?";
        ResultSet rst = CrudUtil.executeQuery(sql, id);
        Packages pack=null;
        while(rst.next()){
            pack=new Packages(rst.getString(1), rst.getString(2), rst.getString(3), rst.getDouble(4));
        }
        return pack;
    }

    @Override
    public ArrayList<Packages> loadAll() throws Exception {
        String sql="SELECT * FROM Package";
        ResultSet rst = CrudUtil.executeQuery(sql);
        ArrayList<Packages> all=new ArrayList<>();
        while(rst.next()){
            Packages pack = new Packages(rst.getString(1), rst.getString(2), rst.getString(3), rst.getDouble(4));
            all.add(pack);
        }
        return all;
    
    }

}
