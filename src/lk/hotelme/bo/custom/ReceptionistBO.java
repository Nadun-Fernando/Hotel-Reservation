/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.hotelme.bo.custom;

import lk.hotelme.bo.SuperBO;
import lk.hotelme.dto.ReceptionistDTO;
import java.util.ArrayList;

/**
 *
 * @author Nadun N. T. Fernando
 */
public interface ReceptionistBO extends SuperBO{
    public ArrayList<ReceptionistDTO> loadallUsers() throws Exception;

    public boolean adduser(ReceptionistDTO t) throws Exception;

    public boolean updateUser(ReceptionistDTO t) throws Exception;

    public boolean deleteuser(String ID) throws Exception;

    public ReceptionistDTO searchuser(String ID) throws Exception;
    
}
