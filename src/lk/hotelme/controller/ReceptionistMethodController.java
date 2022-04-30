/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.hotelme.controller;

import lk.hotelme.bo.BOFactory;
import lk.hotelme.bo.custom.ReceptionistBO;
import lk.hotelme.dto.ReceptionistDTO;
import java.util.ArrayList;

/**
 *
 * @author Nadun N. T. Fernando
 */
public class ReceptionistMethodController {
    public static ReceptionistBO recbo=(ReceptionistBO) BOFactory.getInstance().getBO(BOFactory.bOTYPES.RECEPTIONIST);
    
    public static boolean addUser(ReceptionistDTO t) throws Exception{
        return recbo.adduser(t);
    }
    
    public static boolean updateUser(ReceptionistDTO t) throws Exception{
        return recbo.updateUser(t);
    }
    
    public static boolean deleteUser(String ID) throws Exception{
        return recbo.deleteuser(ID);
    }
    
    public static ReceptionistDTO search(String ID) throws Exception{
        return recbo.searchuser(ID);
    }
    
    public static ArrayList<ReceptionistDTO> loadallUsers() throws Exception{
        return recbo.loadallUsers();
    }
}
