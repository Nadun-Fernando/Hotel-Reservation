/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.hotelme.bo.custom;

import lk.hotelme.bo.SuperBO;
import lk.hotelme.dto.Payment_DetailsTO;

/**
 *
 * @author Nadun N. T. Fernando
 */
public interface Payment_DetailBO extends SuperBO{
    
    public boolean updatePaymentDetail(Payment_DetailsTO t) throws Exception;
    
}
