/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.hotelme.bo.custom;

import lk.hotelme.bo.SuperBO;
import lk.hotelme.dao.DAOFactory;
import lk.hotelme.dao.custom.LoginDAO;

/**
 *
 * @author Nadun N. T. Fernando
 */
public interface LoginBO extends SuperBO{
    
    
    public String getpassword(String username) throws Exception;
    
    public String getAdminPass(String Username) throws Exception;
    
}
