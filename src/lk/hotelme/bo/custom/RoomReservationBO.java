/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.hotelme.bo.custom;

import lk.hotelme.bo.SuperBO;
import lk.hotelme.dto.PaymentDTO;
import lk.hotelme.dto.Payment_DetailsTO;
import lk.hotelme.dto.ReservationDTO;

/**
 *
 * @author Nadun N. T. Fernando
 */
public interface RoomReservationBO extends SuperBO{
    
    public boolean confirmBooking(PaymentDTO p,Payment_DetailsTO pd,ReservationDTO res) throws Exception;
    
}
