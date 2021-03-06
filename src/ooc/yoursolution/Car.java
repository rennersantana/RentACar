/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ooc.yoursolution;

import java.util.HashMap;
import java.util.Map;
import ooc.enums.Make;
import ooc.enums.Month;
import java.util.Arrays;

/**
 *
 * @author aurelio
 */
public class Car implements CarInterface {

    private int id;
    private Make make;
    private Map<Month, boolean[]> availability;
    private double dailyRate;

    public Car(int id,Make make,double dailyRate) {
        this.id = id;
        this.make = make;
        this.dailyRate = dailyRate;
    }
    
    @Override
    public Map<Month, boolean[]> createAvailability() {
     availability = new HashMap<>();
        for (Month month : Arrays.asList(Month.values())) {

            boolean[] myAvailability = new boolean[month.getNumberOfDays()];
            // filling the entire array to true, meaning the all the days are available
            Arrays.fill(myAvailability,true);
            availability.put(month,myAvailability);

        }


        return availability;
    }

    @Override
    public Make getMake() {
        return make;                         //retrieve the value from the property "make"
    }

    @Override
    public void setMake(Make make) {
        this.make = make;                           //setting the values for the attribute "make"
    }

    @Override
    public double getRate() {
        return this.dailyRate;                     //retrieve the value from the property "dailyrate"
    }

    @Override
    public void setRate(double rate) { 
        this.dailyRate = rate;                   //setting the values for the attribute "rate"
    }

    @Override
    public Map<Month, boolean[]> getAvailability() {       //retrieve the value from the property "availability"
        return this.availability;                
    }

    @Override
    public void setAvailability(Map<Month, boolean[]> availability) {
        this.availability = availability;                  //setting the values for the attribute "availability"
    }

    @Override
    public int getId() {
        return this.id;                     //retrieve the values from the attribute "id"
    }

    @Override
    public boolean isAvailable(Month month, int day) {           
        return this.availability.get(month)[day-1];           //retrieve the value from the propertie "make"
    }

    @Override
    public boolean book(Month month, int day) {
        if(!availability.get(month)[day-1]){                //if statement to book cars if available monthly/daily 
            availability.get(month)[day-1] = true;
    }
        
        return availability.get(month)[day-1];               //to book a car if availability is true
        
        
    }
    
}
