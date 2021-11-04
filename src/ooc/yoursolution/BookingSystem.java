/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ooc.yoursolution;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import ooc.enums.Make;

/**
 *
 * @author aurel
 */
public class BookingSystem implements BookingSystemInterface {

    private RentACarInterface rentACar; // setting value for variable to read the file
    
    @Override
    public RentACarInterface setupRentACar(BufferedReader in) throws IOException {
     
         int aux = 0;
            rentACar = new RentACar(); //creating a new method to read the file and using the information to populate the book system
            rentACar.setName(in.readLine()); //setting name for the first line of the file as the structure will not change

            String line = in.readLine();


            List<CarInterface> cars = new ArrayList<>();  //creating a list of cars
            while (line != null){  //looping
               String[] parts = line.split(":"); //if is not null, separate in a array of strings, separate by ":" as is in the file
               int numOfCars = Integer.parseInt(parts[parts.length-1]); //separating the line in a array of 3 words, 0-2 index 
               for (int i=0;i<numOfCars;i++) { //looping to insert the car into the list
                   float dailyRate = Float.parseFloat(parts[1]);//transform dailyRate into String beucause comes from a file as String 
                   String makeString = parts[0];  //makeString as using enums
                   Car c = new Car(aux,Make.valueOf(makeString),dailyRate); //create object a new car with constructors (enum and dailyrate)
                   c.createAvailability();
                   cars.add(c); //add into the list
                   aux++;
               }
                line = in.readLine(); //read and repeat
            }
            rentACar.setCars(cars); //setting the cars with the list created 
            return rentACar;
    }
    
}