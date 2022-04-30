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
public class Package_Meal {

    private String Package_ID;
    private String Meal_ID;

    public Package_Meal() {
    }

    public Package_Meal(String Package_ID, String Meal_ID) {
        this.Package_ID = Package_ID;
        this.Meal_ID = Meal_ID;
    }

    public String getPackage_ID() {
        return Package_ID;
    }

    public void setPackage_ID(String Package_ID) {
        this.Package_ID = Package_ID;
    }

    public String getMeal_ID() {
        return Meal_ID;
    }

    public void setMeal_ID(String Meal_ID) {
        this.Meal_ID = Meal_ID;
    }
    
}
