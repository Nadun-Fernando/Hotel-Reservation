/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.hotelme.bo.custom.impl;

import lk.hotelme.bo.custom.RoomReservationBO;
import lk.hotelme.dao.DAOFactory;
import lk.hotelme.dao.custom.PaymentDAO;
import lk.hotelme.dao.custom.PaymentDetailsDAO;
import lk.hotelme.dao.custom.QueryDAO;
import lk.hotelme.dao.custom.ReservationDAO;
import lk.hotelme.db.DBConnection;
import lk.hotelme.dto.PaymentDTO;
import lk.hotelme.dto.Payment_DetailsTO;
import lk.hotelme.dto.ReservationDTO;
import lk.hotelme.entity.Payment;
import lk.hotelme.entity.Payment_Detail;
import lk.hotelme.entity.Reservation;
import java.sql.Connection;

/**
 *
 * @author Nadun N. T. Fernando
 */
public class RoomReservationBOImpl implements RoomReservationBO {

    public static QueryDAO queryDAO = (QueryDAO) DAOFactory.getInstance().getDAAO(DAOFactory.dAOTypes.QUERY);
    public static ReservationDAO rdao = (ReservationDAO) DAOFactory.getInstance().getDAAO(DAOFactory.dAOTypes.RESERVATION);
    public static PaymentDAO pdao = (PaymentDAO) DAOFactory.getInstance().getDAAO(DAOFactory.dAOTypes.PAYMENT);
    public static PaymentDetailsDAO pddao = (PaymentDetailsDAO) DAOFactory.getInstance().getDAAO(DAOFactory.dAOTypes.PAYMENTDETAILS);

    @Override
    public boolean confirmBooking(PaymentDTO p, Payment_DetailsTO pd, ReservationDTO res) throws Exception {
        Connection connection = DBConnection.getInstance().getConnection();
        connection.setAutoCommit(false);
        boolean addpayment = pdao.add(new Payment(p.getPayment_ID(), p.getTotal_Payment()));
        if (addpayment) {
            boolean addpaymentdetail = pddao.add(new Payment_Detail(pd.getPayment_ID(), pd.getPayment_Type_ID(), pd.getPayment_Date(), pd.getAmount_Paid(), pd.getRemaining_Amount()));
            if (addpaymentdetail) {
                boolean addreservation = rdao.add(new Reservation(res.getReservation__ID(), res.getCustomer_ID(), res.getNo_of_Guests(), res.getArrival_Date(), res.getDeparture_Date(), res.getPackage_ID(),res.getMeal_ID(),res.getRoom_ID(), res.getReceptionist_ID(), res.getPayment_ID()));
                if (!addreservation) {
                    connection.rollback();
                    connection.setAutoCommit(true);
                    return false;
                }
            } else {
                connection.rollback();
                connection.setAutoCommit(true);
                return false;
            }
            connection.commit();
            connection.setAutoCommit(true);
            return true;
        } else {
            connection.rollback();
            connection.setAutoCommit(true);
            return false;
        }

    }
    
}
