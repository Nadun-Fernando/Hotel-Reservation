/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.hotelme.dao.custom.impl;

import lk.hotelme.dao.CrudUtil;
import lk.hotelme.dao.custom.LoginDAO;
import java.sql.ResultSet;

/**
 *
 * @author Nadun N. T. Fernando
 */
public class LoginDAOImpl implements LoginDAO{
    
    @Override
    public String getPassword(String username) throws Exception {
        String sql="select UNCOMPRESS(Password) as Password from Receptionist where Username=?";
        ResultSet rst = CrudUtil.executeQuery(sql, username);
        String pass=null;
        while(rst.next()){
            pass=rst.getString("Password");
        }
        return pass;
    }

    @Override
    public String getAdminPass(String Username) throws Exception {
        String sql="select UNCOMPRESS(Password) as Password from Administrator where Username=?";
         ResultSet rst = CrudUtil.executeQuery(sql, Username);
        String pass=null;
        while(rst.next()){
            pass=rst.getString("Password");
        }
        return pass;
    }
    
}
