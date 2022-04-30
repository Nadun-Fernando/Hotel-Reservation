/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.hotelme.controller;

import java.util.ArrayList;
import lk.hotelme.bo.BOFactory;
import lk.hotelme.bo.custom.Payment_DetailBO;
import lk.hotelme.dao.DAOFactory;
import lk.hotelme.dao.custom.PaymentDetailsDAO;
import lk.hotelme.dao.custom.QueryDAO;
import lk.hotelme.dto.Payment_DetailsTO;
import lk.hotelme.entity.CustomEntity;

/**
 *
 * @author Nadun N. T. Fernando
 */
public class ManagePaymentsMethodController {
    public static QueryDAO qdao=(QueryDAO) DAOFactory.getInstance().getDAAO(DAOFactory.dAOTypes.QUERY);
    public static Payment_DetailBO pdbo=(Payment_DetailBO) BOFactory.getInstance().getBO(BOFactory.bOTYPES.PAYMENTDETAILS);
    
    public static ArrayList<CustomEntity> getallPaymentDetails(String currentDate) throws Exception{
        return qdao.getAllPaymentDetails(currentDate);
    }
    
    public static ArrayList<CustomEntity> getPaymentDetailsbyCustomerID(String customerID,String currentDate) throws Exception{
        return qdao.getPaymentDetailsbyCustomerID(customerID,currentDate);
    }
    
    public static ArrayList<CustomEntity> getPaymentDetailsbyPaymentID(String paymentID,String currentDate) throws Exception{
        return qdao.getPaymentDetailsbyPaymentID(paymentID,currentDate);
    }
    
    public static boolean updatePaymentDetail(Payment_DetailsTO t) throws Exception{
        return pdbo.updatePaymentDetail(t);
    }
}
