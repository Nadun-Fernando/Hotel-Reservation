/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.hotelme.dao.custom;

import lk.hotelme.dao.SuperDAO;

/**
 *
 * @author Nadun N. T. Fernando
 */
public interface LoginDAO extends SuperDAO{
    public String getPassword(String username) throws Exception;
    
    public String getAdminPass(String Username) throws Exception;
}
