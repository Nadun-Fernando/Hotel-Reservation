/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.hotelme.dao.custom.impl;

import lk.hotelme.dao.CrudUtil;
import lk.hotelme.dao.custom.CustomerDAO;
import lk.hotelme.entity.Customer;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author Nadun N. T. Fernando
 */
public class CustomerDAOImpl implements CustomerDAO{

    @Override
    public boolean add(Customer t) throws Exception {
        String sql="insert into Customer values(?,?,?,?,?)";
        return CrudUtil.executeUpdate(sql, t.getCustomer_ID(), t.getCustomer_Name(), t.getAddress(), t.getContact_No(), t.getEmail());
    }

    @Override
    public boolean update(Customer t) throws Exception {
       String sql="Update Customer set Customer_Name=?,Address=?,Contact_No=?,Email=? where Customer_ID=?";
       return CrudUtil.executeUpdate(sql,t.getCustomer_Name(),t.getAddress(),t.getContact_No(),t.getEmail(),t.getCustomer_ID());
    }

    @Override
    public boolean delete(String id) throws Exception {
        String sql="DELETE FROM Customer WHERE Customer_ID=?";
        return CrudUtil.executeUpdate(sql, id);
    }

    @Override
    public Customer search(String id) throws Exception {
        String sql ="SELECT * FROM Customer WHERE Customer_ID=?";
        ResultSet rst = CrudUtil.executeQuery(sql, id);
        Customer customer=null;
        while(rst.next()){
            customer = new Customer(rst.getString(1), rst.getString(2), rst.getString(3), rst.getString(4), rst.getString(5));
        }
        return customer;
        
    }

    @Override
    public ArrayList<Customer> loadAll() throws Exception {
        String sql="SELECT * FROM Customer";
        ResultSet rst = CrudUtil.executeQuery(sql);
        ArrayList<Customer> all=new ArrayList<>();
        while(rst.next()){
            Customer customer = new Customer(rst.getString("Customer_ID"), rst.getString("Customer_Name"), rst.getString("Address"), rst.getString("Contact_No"), rst.getString("Email"));
            all.add(customer);
        }
        return all;
    }

    @Override
    public Customer searchbyContactNo(String contactNumber) throws Exception {
        String sql="select * from Customer where Contact_No=?";
        ResultSet rst = CrudUtil.executeQuery(sql, contactNumber);
        Customer cus=null;
        while(rst.next()){
            cus=new Customer(rst.getString(1), rst.getString(2), rst.getString(3), rst.getString(4), rst.getString(5));
        }
        return cus;
    }
    
}
