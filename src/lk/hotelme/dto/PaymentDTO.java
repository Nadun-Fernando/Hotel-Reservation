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
public class PaymentDTO {
    private String Payment_ID;
    private double Total_Payment;

    public PaymentDTO() {
    }

    public PaymentDTO(String Payment_ID, double Total_Payment) {
        this.Payment_ID = Payment_ID;
        this.Total_Payment = Total_Payment;
    }

    public String getPayment_ID() {
        return Payment_ID;
    }

    public void setPayment_ID(String Payment_ID) {
        this.Payment_ID = Payment_ID;
    }

    public double getTotal_Payment() {
        return Total_Payment;
    }

    public void setTotal_Payment(double Total_Payment) {
        this.Total_Payment = Total_Payment;
    }
    
    
    
}
