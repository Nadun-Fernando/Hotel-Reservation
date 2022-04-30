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
public class Packages {

    private String Package_ID;
    private String Package_Name;
    private String Package_Details;
    private double Package_Price;

    public Packages() {
    }

    public Packages(String Package_ID, String Package_Name, String Package_Details, double Package_Price) {
        this.Package_ID = Package_ID;
        this.Package_Name = Package_Name;
        this.Package_Details = Package_Details;
        this.Package_Price = Package_Price;
    }

   
    public String getPackage_ID() {
        return Package_ID;
    }

    public void setPackage_ID(String Package_ID) {
        this.Package_ID = Package_ID;
    }

    public String getPackage_Name() {
        return Package_Name;
    }

    public void setPackage_Name(String Package_Name) {
        this.Package_Name = Package_Name;
    }

    public String getPackage_Details() {
        return Package_Details;
    }

    public void setPackage_Details(String Package_Details) {
        this.Package_Details = Package_Details;
    }

    public double getPackage_Price() {
        return Package_Price;
    }

    public void setPackage_Price(double Package_Price) {
        this.Package_Price = Package_Price;
    }
    

}
