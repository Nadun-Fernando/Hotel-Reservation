/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.hotelme.bo.custom;

import lk.hotelme.bo.SuperBO;
import lk.hotelme.dto.ReservationDTO;
import java.util.ArrayList;

/**
 *
 * @author Nadun N. T. Fernando
 */
public interface ReservationBO extends SuperBO{
    public boolean updateReservation(ReservationDTO t) throws Exception;
    public ReservationDTO searchReservation(String ID) throws Exception;
    public ArrayList<ReservationDTO> loadAllReservation() throws Exception;
    public boolean deleteReservation(String id) throws Exception;
}
