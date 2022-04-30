/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.hotelme.entity;

/**
 *
 * @author Nadun N. T. Fernando
 */
public class Payment_Type {

    private String Payment_Type_ID;
    private String Payment_Type_Name;

    public Payment_Type() {
    }

    public Payment_Type(String Payment_Type_ID, String Payment_Type_Name) {
        this.Payment_Type_ID = Payment_Type_ID;
        this.Payment_Type_Name = Payment_Type_Name;
    }

    public String getPayment_Type_ID() {
        return Payment_Type_ID;
    }

    public void setPayment_Type_ID(String Payment_Type_ID) {
        this.Payment_Type_ID = Payment_Type_ID;
    }

    public String getPayment_Type_Name() {
        return Payment_Type_Name;
    }

    public void setPayment_Type_Name(String Payment_Type_Name) {
        this.Payment_Type_Name = Payment_Type_Name;
    }

}
