/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.hotelme.dao.custom.impl;

import lk.hotelme.dao.CrudUtil;
import lk.hotelme.dao.custom.ReservationDAO;
import lk.hotelme.entity.Reservation;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author Nadun N. T. Fernando
 */
public class ReservationDAOImpl implements ReservationDAO{

    @Override
    public boolean add(Reservation t) throws Exception {
        String sql = "insert into Reservation values(?,?,?,?,?,?,?,?,?,?)";
        return CrudUtil.executeUpdate(sql, t.getReservation__ID(),t.getCustomer_ID(),t.getNo_of_Guests(),t.getArrival_Date(),t.getDeparture_Date(),t.getPackage_ID(),t.getMeal_ID(),t.getRoom_ID(),t.getReceptionist_ID(),t.getPayment_ID());
    }

    @Override
    public boolean update(Reservation t) throws Exception {
        String sql ="update Reservation set Arrival_Date=?,Departure_Date=? where Reservation__ID=?";
        return CrudUtil.executeUpdate(sql, t.getArrival_Date(),t.getDeparture_Date(),t.getReservation__ID());
        
    }

    @Override
    public boolean delete(String id) throws Exception {
        String sql="delete from Reservation where Reservation__ID=?";
        return CrudUtil.executeUpdate(sql, id);
    }

    @Override
    public Reservation search(String id) throws Exception {
     String sql="select * from Reservation where Reservation__ID=?";
        ResultSet rst = CrudUtil.executeQuery(sql,id);
        Reservation res=null;
        while(rst.next()){
            res=new Reservation(rst.getString("Reservation__ID"), rst.getString("Customer_ID"), rst.getInt("No_of_Guests"), rst.getString("Arrival_Date"), rst.getString("Departure_Date"), rst.getString("Package_ID"), rst.getString("Meal_ID"), rst.getString("Room_ID"), rst.getString("Receptionist_ID"), rst.getString("Payment_ID"));
        }
        return res;
    }

    @Override
    public ArrayList<Reservation> loadAll() throws Exception {
        String sql="select * from Reservation";
        ResultSet rst = CrudUtil.executeQuery(sql);
        ArrayList<Reservation> reservation=new ArrayList<>();
        while(rst.next()){
            Reservation res = new Reservation(rst.getString(1), rst.getString(2), rst.getInt(3), rst.getString(4), rst.getString(5), rst.getString(6), rst.getString(7), rst.getString(8), rst.getString(9), rst.getString(10));
            reservation.add(res);
        }
        return reservation;
    }   

    
}
