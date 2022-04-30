/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.hotelme.dao;

import lk.hotelme.dao.custom.impl.CustomerDAOImpl;
import lk.hotelme.dao.custom.impl.LoginDAOImpl;
import lk.hotelme.dao.custom.impl.PackageDAOImpl;
import lk.hotelme.dao.custom.impl.PaymentDAOImpl;
import lk.hotelme.dao.custom.impl.PaymentDetailsDAOImpl;
import lk.hotelme.dao.custom.impl.QueryDAOImpl;
import lk.hotelme.dao.custom.impl.ReceptionistDAOImpl;
import lk.hotelme.dao.custom.impl.ReservationDAOImpl;
import lk.hotelme.dao.custom.impl.Room_TypeDAOImpl;
import lk.hotelme.dao.custom.impl.RoomsDAOImpl;

/**
 *
 * @author Nadun N. T. Fernando
 */
public class DAOFactory {

    private static DAOFactory dAOFactory;

    private DAOFactory() {
    }

    public static DAOFactory getInstance() {
        if (dAOFactory == null) {
            dAOFactory = new DAOFactory();
        }
        return dAOFactory;
    }

    public enum dAOTypes {
        CUSTOMER, RESERVATION, QUERY, ROOMTYPE, PACKAGE, PAYMENT, PAYMENTDETAILS, ROOMS, RECEPTIONIST, LOGIN
    }

    public SuperDAO getDAAO(dAOTypes types) {
        switch (types) {
            case CUSTOMER:
                return new CustomerDAOImpl();
            case QUERY:
                return new QueryDAOImpl();
            case ROOMTYPE:
                return new Room_TypeDAOImpl();
            case PACKAGE:
                return new PackageDAOImpl();
            case PAYMENT:
                return new PaymentDAOImpl();
            case PAYMENTDETAILS:
                return new PaymentDetailsDAOImpl();
            case RESERVATION:
                return new ReservationDAOImpl();
            case ROOMS:
                return new RoomsDAOImpl();
            case RECEPTIONIST:
                return new ReceptionistDAOImpl();
            case LOGIN:
                return new LoginDAOImpl();
            default:
                return null;
        }
    }
}
