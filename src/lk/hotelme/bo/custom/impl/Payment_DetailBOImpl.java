/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.hotelme.bo.custom.impl;

import lk.hotelme.bo.custom.Payment_DetailBO;
import lk.hotelme.dao.DAOFactory;
import lk.hotelme.dao.custom.PaymentDetailsDAO;
import lk.hotelme.dto.Payment_DetailsTO;
import lk.hotelme.entity.Payment_Detail;

/**
 *
 * @author Nadun N. T. Fernando
 */
public class Payment_DetailBOImpl implements Payment_DetailBO{
    
    public static PaymentDetailsDAO pddao=(PaymentDetailsDAO) DAOFactory.getInstance().getDAAO(DAOFactory.dAOTypes.PAYMENTDETAILS);

    @Override
    public boolean updatePaymentDetail(Payment_DetailsTO t) throws Exception {
        return pddao.update(new Payment_Detail(t.getPayment_ID(), t.getPayment_Type_ID(), t.getPayment_Date(), t.getAmount_Paid(), t.getRemaining_Amount()));
    }
    
}
