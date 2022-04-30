/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.hotelme.bo.custom.impl;

import lk.hotelme.bo.custom.ReceptionistBO;
import lk.hotelme.dao.DAOFactory;
import lk.hotelme.dao.custom.ReceptionistDAO;
import lk.hotelme.dto.ReceptionistDTO;
import lk.hotelme.entity.Receptionist;
import java.util.ArrayList;

/**
 *
 * @author Nadun N. T. Fernando
 */
public class ReceptionistBOImpl implements ReceptionistBO{
     public static ReceptionistDAO recdao=(ReceptionistDAO) DAOFactory.getInstance().getDAAO(DAOFactory.dAOTypes.RECEPTIONIST);
    @Override
    public ArrayList<ReceptionistDTO> loadallUsers() throws Exception {
        ArrayList<ReceptionistDTO> users=new ArrayList<>();
        ArrayList<Receptionist> loadAll = recdao.loadAll();
        for (Receptionist receptionist : loadAll) {
            users.add(new ReceptionistDTO(receptionist.getReceptionist_ID(), receptionist.getReceptionist_Name(), receptionist.getUsername(), receptionist.getPassword()));
        }
        return users;
    }

    @Override
    public boolean adduser(ReceptionistDTO t) throws Exception {
        return recdao.add(new Receptionist(t.getReceptionist_ID(), t.getReceptionist_Name(), t.getUsername(), t.getPassword()));
    }

    @Override
    public boolean updateUser(ReceptionistDTO t) throws Exception {
        return recdao.update(new Receptionist(t.getReceptionist_ID(), t.getReceptionist_Name(), t.getUsername(), t.getPassword()));
    }

    @Override
    public boolean deleteuser(String ID) throws Exception {
        return recdao.delete(ID);
    }

    @Override
    public ReceptionistDTO searchuser(String ID) throws Exception {
         Receptionist search = recdao.search(ID);
         return new ReceptionistDTO(search.getReceptionist_ID(), search.getReceptionist_Name(), search.getUsername(), search.getPassword());
    }
    
}
