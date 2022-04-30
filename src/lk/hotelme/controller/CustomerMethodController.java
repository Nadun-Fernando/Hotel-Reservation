/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.hotelme.controller;

import lk.hotelme.dto.CustomerDTO;
import lk.hotelme.bo.BOFactory;
import lk.hotelme.bo.custom.CustomerBO;
import java.util.ArrayList;

/**
 *
 * @author Nadun N. T. Fernando
 */
public class CustomerMethodController {
     public static CustomerBO Custbo = (CustomerBO) BOFactory.getInstance().getBO(BOFactory.bOTYPES.CUSTOMER);
        
    
    public static boolean addCustomer(CustomerDTO customerDTO) throws Exception {
        return Custbo.addCustomer(customerDTO);
        //CustomerDTO tempcustomer = new CustomerDTO(customerDTO.getID(), customerDTO.getName(), customerDTO.getAddress(), customerDTO.getTelephoneNumber(), customerDTO.getEmail());
        //customer.add(tempcustomer);
        
        //tblCustomerInfo.setItems(FXCollections.observableArrayList(customer));
        

    }
    
    public static ArrayList<CustomerDTO> loadCustomer() throws Exception{
        return Custbo.loadAllCustomer();
    }
    
    public static boolean updateCustomer(CustomerDTO customer) throws Exception{
        return Custbo.updateCustomer(customer);
    }
    
    public static boolean deleteCustomer(String id) throws Exception{
        return Custbo.deleteCustomer(id);
    }
    
    public static CustomerDTO searchCustomer(String ID) throws Exception{
        return Custbo.searchCustomer(ID);
    }
}
