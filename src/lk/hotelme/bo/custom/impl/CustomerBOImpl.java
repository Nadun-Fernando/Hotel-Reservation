/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.hotelme.bo.custom.impl;

import lk.hotelme.bo.custom.CustomerBO;
import lk.hotelme.dto.CustomerDTO;
import lk.hotelme.dao.custom.CustomerDAO;
import lk.hotelme.dao.DAOFactory;
import lk.hotelme.entity.Customer;
import java.util.ArrayList;

/**
 *
 * @author Nadun N. T. Fernando
 */
public class CustomerBOImpl implements CustomerBO{
    public static CustomerDAO Custdao = (CustomerDAO) DAOFactory.getInstance().getDAAO(DAOFactory.dAOTypes.CUSTOMER);
    @Override
    public boolean addCustomer(CustomerDTO customer) throws Exception {
        return Custdao.add(new Customer(customer.getID(), customer.getName(), customer.getAddress(), customer.getTelephoneNumber(), customer.getEmail()));
    }

    @Override
    public boolean updateCustomer(CustomerDTO customer) throws Exception {
        return Custdao.update(new Customer(customer.getID(), customer.getName(), customer.getAddress(), customer.getTelephoneNumber(), customer.getEmail()));
    }

    @Override
    public boolean deleteCustomer(String ID) throws Exception{
        return Custdao.delete(ID);
    }

    @Override
    public CustomerDTO searchCustomer(String ID) throws Exception {
        Customer search = Custdao.search(ID);
        return new CustomerDTO(search.getCustomer_ID(), search.getCustomer_Name(), search.getAddress(), search.getContact_No(), search.getEmail());
    }

    @Override
    public ArrayList<CustomerDTO> loadAllCustomer() throws Exception {
        ArrayList<CustomerDTO> customers=new ArrayList<>();
        ArrayList<Customer> loadAll = Custdao.loadAll();
        for (Customer customer : loadAll) {
            customers.add(new CustomerDTO(customer.getCustomer_ID(), customer.getCustomer_Name(), customer.getAddress(), customer.getContact_No(), customer.getEmail()));
        }
        return customers;
    }

    @Override
    public CustomerDTO searchbyContacNumber(String contactNumber) throws Exception {
        Customer scn = Custdao.searchbyContactNo(contactNumber);
        return new CustomerDTO(scn.getCustomer_ID(), scn.getCustomer_Name(), scn.getAddress(), scn.getContact_No(), scn.getEmail());
    }
    
    
    
}
