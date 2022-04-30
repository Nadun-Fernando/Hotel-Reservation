/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.hotelme.dao.custom;

import lk.hotelme.dao.CrudDAO;
import lk.hotelme.entity.Customer;

/**
 *
 * @author Nadun N. T. Fernando
 */
public interface CustomerDAO extends CrudDAO<Customer, String>{
    public Customer searchbyContactNo(String contactNumber) throws Exception;
}
