/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.hotelme.bo.custom.impl;

import lk.hotelme.bo.custom.LoginBO;
import lk.hotelme.dao.DAOFactory;
import lk.hotelme.dao.custom.LoginDAO;

/**
 *
 * @author Nadun N. T. Fernando
 */
public class LoginBOImpl implements LoginBO{
    public static LoginDAO logdao=(LoginDAO) DAOFactory.getInstance().getDAAO(DAOFactory.dAOTypes.LOGIN);

    @Override
    public String getpassword(String username) throws Exception {
        return logdao.getPassword(username);
    }

    @Override
    public String getAdminPass(String Username) throws Exception {
        return logdao.getAdminPass(Username);
    }
    
    
}
