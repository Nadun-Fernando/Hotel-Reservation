/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.hotelme.dao.custom.impl;

import lk.hotelme.dao.CrudUtil;
import lk.hotelme.dao.custom.PaymentDetailsDAO;
import lk.hotelme.entity.Payment_Detail;
import java.util.ArrayList;

/**
 *
 * @author Nadun N. T. Fernando
 */
public class PaymentDetailsDAOImpl implements PaymentDetailsDAO{

    @Override
    public boolean add(Payment_Detail t) throws Exception {
        String sql = "insert into Payment_Detail values(?,?,?,?,?)";
        return CrudUtil.executeUpdate(sql, t.getPayment_ID(),t.getPayment_Type_ID(),t.getPayment_Date(),t.getAmount_Paid(),t.getRemaining_Amount());
    }

    @Override
    public boolean update(Payment_Detail t) throws Exception {
        String sql = "update Payment_Detail set Payment_Type_ID=?,Payment_Date=?,Amount_Paid=?,Remaining_Amount=? where Payment_ID=?";
        return CrudUtil.executeUpdate(sql, t.getPayment_Type_ID(),t.getPayment_Date(),t.getAmount_Paid(),t.getRemaining_Amount(),t.getPayment_ID());
    }

    @Override
    public boolean delete(String id) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Payment_Detail search(String id) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<Payment_Detail> loadAll() throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
}
