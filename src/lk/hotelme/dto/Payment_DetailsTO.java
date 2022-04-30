/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.hotelme.dto;

/**
 *
 * @author Nadun N. T. Fernando
 */
public class Payment_DetailsTO {
    private String Payment_ID;
    private String Payment_Type_ID;
    private String Payment_Date;
    private double Amount_Paid;
    private double Remaining_Amount;

    public Payment_DetailsTO() {
    }

    public Payment_DetailsTO(String Payment_ID, String Payment_Type_ID, String Payment_Date, double Amount_Paid, double Remaining_Amount) {
        this.Payment_ID = Payment_ID;
        this.Payment_Type_ID = Payment_Type_ID;
        this.Payment_Date = Payment_Date;
        this.Amount_Paid = Amount_Paid;
        this.Remaining_Amount = Remaining_Amount;
    }

    public String getPayment_ID() {
        return Payment_ID;
    }

    public void setPayment_ID(String Payment_ID) {
        this.Payment_ID = Payment_ID;
    }

    public String getPayment_Type_ID() {
        return Payment_Type_ID;
    }

    public void setPayment_Type_ID(String Payment_Type_ID) {
        this.Payment_Type_ID = Payment_Type_ID;
    }

    public String getPayment_Date() {
        return Payment_Date;
    }

    public void setPayment_Date(String Payment_Date) {
        this.Payment_Date = Payment_Date;
    }

    public double getAmount_Paid() {
        return Amount_Paid;
    }

    public void setAmount_Paid(double Amount_Paid) {
        this.Amount_Paid = Amount_Paid;
    }

    public double getRemaining_Amount() {
        return Remaining_Amount;
    }

    public void setRemaining_Amount(double Remaining_Amount) {
        this.Remaining_Amount = Remaining_Amount;
    }
    
    
    
}
