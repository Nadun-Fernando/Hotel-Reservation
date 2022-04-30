/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.hotelme.controller;

import lk.hotelme.bo.BOFactory;
import lk.hotelme.bo.custom.LoginBO;

/**
 *
 * @author Nadun N. T. Fernando
 */
public class LoginMethodController {
    public static LoginBO logbo=(LoginBO) BOFactory.getInstance().getBO(BOFactory.bOTYPES.LOGIN);
    
    public static String getpass(String Username) throws Exception{
        return logbo.getpassword(Username);
    }
    
    public static String getAdminPass(String username) throws Exception{
        return logbo.getAdminPass(username);
    }
    
}
