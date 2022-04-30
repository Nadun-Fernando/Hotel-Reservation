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
public class Payment {

    private String Payment_ID;
    private double Total_Amount;

    public Payment() {
    }

    public Payment(String Payment_ID, double Total_Amount) {
        this.Payment_ID = Payment_ID;
        this.Total_Amount = Total_Amount;
    }

    public String getPayment_ID() {
        return Payment_ID;
    }

    public void setPayment_ID(String Payment_ID) {
        this.Payment_ID = Payment_ID;
    }

    public double getTotal_Amount() {
        return Total_Amount;
    }

    public void setTotal_Amount(double Total_Amount) {
        this.Total_Amount = Total_Amount;
    }
    
}
