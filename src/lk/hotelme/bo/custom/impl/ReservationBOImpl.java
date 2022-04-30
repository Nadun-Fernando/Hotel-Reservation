/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.hotelme.bo.custom.impl;

import lk.hotelme.bo.custom.ReservationBO;
import lk.hotelme.dao.DAOFactory;
import lk.hotelme.dao.custom.ReservationDAO;
import lk.hotelme.dto.ReservationDTO;
import lk.hotelme.entity.Reservation;
import java.util.ArrayList;

/**
 *
 * @author Nadun N. T. Fernando
 */
public class ReservationBOImpl implements ReservationBO{
    public static ReservationDAO res=(ReservationDAO) DAOFactory.getInstance().getDAAO(DAOFactory.dAOTypes.RESERVATION);
    
    @Override
    public boolean updateReservation(ReservationDTO t) throws Exception {
        return res.update(new Reservation(t.getReservation__ID(), t.getArrival_Date(), t.getDeparture_Date()));
    }

    @Override
    public ReservationDTO searchReservation(String ID) throws Exception {
        Reservation search = res.search(ID);
        return new ReservationDTO(search.getReservation__ID(), search.getCustomer_ID(), search.getNo_of_Guests(), search.getArrival_Date(), search.getDeparture_Date(), search.getPackage_ID(), search.getMeal_ID(), search.getRoom_ID(), search.getReceptionist_ID(), search.getPayment_ID());
    }

    @Override
    public ArrayList<ReservationDTO> loadAllReservation() throws Exception {
         ArrayList<ReservationDTO> reservation = new ArrayList<>();
        ArrayList<Reservation> loadAll = ReservationBOImpl.res.loadAll();
        for (Reservation get : loadAll) {
            reservation.add(new ReservationDTO(get.getReservation__ID(), get.getCustomer_ID(), get.getNo_of_Guests(), get.getArrival_Date(), get.getDeparture_Date(), get.getPackage_ID(), get.getMeal_ID(), get.getRoom_ID(), get.getReceptionist_ID(), get.getPayment_ID()));
        }
        return reservation;
    }   

    @Override
    public boolean deleteReservation(String id) throws Exception {
        return res.delete(id);
    }
    
}
