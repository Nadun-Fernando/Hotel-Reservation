/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.hotelme.bo;

import lk.hotelme.bo.custom.impl.CustomerBOImpl;
import lk.hotelme.bo.custom.impl.LoginBOImpl;
import lk.hotelme.bo.custom.impl.Room_TypeBOImpl;
import lk.hotelme.bo.custom.impl.PackagesBOImpl;
import lk.hotelme.bo.custom.impl.Payment_DetailBOImpl;
import lk.hotelme.bo.custom.impl.ReceptionistBOImpl;
import lk.hotelme.bo.custom.impl.ReservationBOImpl;
import lk.hotelme.bo.custom.impl.RoomReservationBOImpl;
import lk.hotelme.bo.custom.impl.RoomsBOImpl;

/**
 *
 * @author Nadun N. T. Fernando
 */
public class BOFactory {

    private static BOFactory bOFactory;

    private BOFactory() {
    }

    public static BOFactory getInstance() {
        if (bOFactory == null) {
            bOFactory = new BOFactory();
        }
        return bOFactory;
    }

    public enum bOTYPES {
        CUSTOMER, RESERVATION, ROOMTYPE, PACKAGE, ROOMRESERVATION,ROOMS,RECEPTIONIST,LOGIN,PAYMENTDETAILS
    }

    public SuperBO getBO(bOTYPES type) {
        switch (type) {
            case CUSTOMER:
                return new CustomerBOImpl();
            case ROOMTYPE:
                return new Room_TypeBOImpl();
            case PACKAGE:
                return new PackagesBOImpl();
            case ROOMRESERVATION:
                return new RoomReservationBOImpl();
            case RESERVATION:
                return new ReservationBOImpl();
            case ROOMS:
                return new RoomsBOImpl();
            case RECEPTIONIST:
                return new ReceptionistBOImpl();
            case LOGIN:
                return new LoginBOImpl();
            case PAYMENTDETAILS:
                return new Payment_DetailBOImpl();
            default:
                return null;
        }
    }
}
