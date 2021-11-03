/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ooc.yoursolution;

import java.util.ArrayList;
import java.util.List;
import ooc.enums.Make;
import ooc.enums.Month;

/**
 *
 * @author rennersantana
 */
public class RentACar implements RentACarInterface {            //implementing RentACar class to the interface

    private List<CarInterface> cars; //List of cars from the carInterface
    private String name; //sign value name to the rent a car

    public RentACar(){
        cars = new ArrayList<CarInterface>(); // list of cars from carInterface
    }
    public RentACar(List<CarInterface> cars) { //List of cars I want from this class implemented by carInterface
        this.cars = cars;
    }
    public RentACar(String name) { // name of cars read by the carInterface
        this.name = name; // 
    }

    public RentACar(List<CarInterface> cars, String name) { // list of cars from the carInterface
        this.cars = cars;
        this.name = name;
    }

    @Override
    public List<CarInterface> getCars() { // get the value from the variable car
        return cars;
    }

    @Override
    public void setCars(List<CarInterface> cars) { //Set the value of the variable car 
        this.cars = cars;
    }

    @Override
    public String getName() { // // get the value from the variable name
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name; // Set the value of the variable name
    }

    @Override
    public boolean checkAvailability(Month month, int day, Make make, int lengthOfRent) {
        return false; //Setting parameters of method to check availability 
    }

    @Override
    public int getCarAvailable(Month month, int day, Make make, int lengthOfRent) {
        return 0; // getting the information available car
    }

    @Override
    public boolean bookCar(Month month, int day, Make make, int lengthOfRent) {

        return false; // For booking a car whether it is available or not using boolean
    }

    @Override
    public int getNumberOfCars() {
        return cars.size(); //  getting the number of element car in this list
    }
}
