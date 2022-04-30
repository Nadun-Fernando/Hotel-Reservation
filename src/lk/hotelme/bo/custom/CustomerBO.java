/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.hotelme.bo.custom;

import lk.hotelme.dto.CustomerDTO;
import lk.hotelme.bo.SuperBO;
import java.util.ArrayList;

/**
 *
 * @author Nadun N. T. Fernando
 */
public interface CustomerBO extends SuperBO{

    public boolean addCustomer(CustomerDTO customer) throws Exception;

    public boolean updateCustomer(CustomerDTO customer) throws Exception;

    public boolean deleteCustomer(String ID) throws Exception;

    public CustomerDTO searchCustomer(String ID) throws Exception;

    public ArrayList<CustomerDTO> loadAllCustomer() throws Exception;
    
    public CustomerDTO searchbyContacNumber(String contactNumber) throws Exception;

}
