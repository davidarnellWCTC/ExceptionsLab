/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab4;

/**
 *The Parking Fee Calculator classes extend from this class
 * This ensures the Parking Fee Calculators are interchangeable and calculate
 * based on similar data
 * @author David
 */
public interface ParkingFeeCalculatorStrategy {

    double getChargePerHour();

    double getHoursParked();

    double getMaxFee();

    double getMaxHours();

    double getMinFee();

    double getMinHours();

    double getParkingFee(double enterTime, double exitTime);
    
    double getChargableHours();

    void setChargePerHour(double chargePerHour);

    void setHoursParked(double hoursParked);
    
    // The parking fee should not be able to be set by any other classes
    //    public void setParkingFee(double parkingFee) {
    //        this.parkingFee = parkingFee;
    //    }

    void setMaxFee(double maxFee);

    void setMaxHours(double maxHours);

    void setMinFee(double minFee);

    void setMinHours(double minHours);  

    void setChargableHours(double chargableHours); 
    
}
