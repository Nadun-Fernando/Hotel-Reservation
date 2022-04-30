/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.hotelme.dao.custom.impl;

import lk.hotelme.dao.CrudUtil;
import lk.hotelme.dao.custom.PaymentDAO;
import lk.hotelme.entity.Payment;
import java.util.ArrayList;

/**
 *
 * @author Nadun N. T. Fernando
 */
public class PaymentDAOImpl implements PaymentDAO{

    @Override
    public boolean add(Payment t) throws Exception {
        String sql ="insert into Payment values(?,?)";
        return CrudUtil.executeUpdate(sql, t.getPayment_ID(),t.getTotal_Amount());
    }

    @Override
    public boolean update(Payment t) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean delete(String id) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Payment search(String id) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<Payment> loadAll() throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
}
