/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab4;

/**
 * This class calculates the fee based on not having a maximum charge
 *
 * @author David
 */
public class MinimumNoMaximumFeeCalculator implements ParkingFeeCalculatorStrategy {

    private double minFee = 1.50;
    private double maxFee = 0.00; // There is no maximum fee
    private double minHours = 2.0;
    private double chargePerHour = 0.75;
    private double maxHours = 24.0;

    private double enterTime;
    private double exitTime;

    private double hoursParked;
    private double chargableHours;

    private double parkingFee;

    /**
     * Standard Constructor used in this program This constructor uses the
     * default values
     */
    public MinimumNoMaximumFeeCalculator() {
    }

    public MinimumNoMaximumFeeCalculator(double enterTime, double exitTime) throws IllegalArgumentException {

        try {
            this.enterTime = enterTime;
            this.exitTime = exitTime;
        } catch (NullPointerException npe) {
            System.out.println("Enter values for the enter and exit time");
        } catch (Exception e) {

        }
    }

    /**
     * This constructor allows the use of this fee calculator but with different
     * values for the fee calculation variables The customer requested that the
     * program be able to run with the only input being the hours parked and the
     * time the car entered and left. However, the customer also required that
     * the program be able to be altered "without editing anything more than the
     * Startup class." This constructor allows for considerable change to the
     * program without requiring any changes to any classes other than where the
     * class is instantiated.
     *
     * @param hoursParked - double
     * @param minFee - double
     * @param maxFee - double
     * @param chargePerHour - double
     * @param maxHours - double
     */
    public MinimumNoMaximumFeeCalculator(double hoursParked, double minFee,
            double maxFee, double minHours, double chargePerHour, double maxHours) {
        this.hoursParked = hoursParked;
        this.minFee = minFee;
        this.maxFee = maxFee;
        this.minHours = minHours;
        this.chargePerHour = chargePerHour;
        this.maxHours = maxHours;
    }

    /**
     * getParkingFee returns the charge amount to the customer The fee is
     * calculated by addin the minimum charge to the hourly rate multiplied by
     * the billable hours
     *
     * @param enterTime - double; 4 digit military styled time
     * @param exitTime - double; 4 digit military styled time
     * @return
     */
    @Override
    public double getParkingFee(double enterTime, double exitTime) {

        try {
            hoursParked = (((exitTime / 100) * 60) - ((enterTime / 100) * 60)) / 60;

        // variabes are automatically private and only accessable inside of the
            // method. Private does not need to be declared
            if (hoursParked <= minHours) {
                this.chargableHours = minHours;
                parkingFee = minFee;
                //return parkingFee;
            } else {
                chargableHours = (int) Math.ceil(hoursParked - minHours);
                parkingFee = minFee + (chargePerHour * chargableHours);
                //return parkingFee;
            }
        } catch (NullPointerException npe) {
            System.out.println("Enter values for the enter and exit time");
        } catch (Exception e) {

        }
        return parkingFee;
    }

    @Override
    public double getMinFee() {
        return minFee;
    }

    @Override
    public void setMinFee(double minFee) {
        this.minFee = minFee;
    }

    @Override
    public double getMaxFee() {
        return maxFee;
    }

    @Override
    public void setMaxFee(double maxFee) {
        this.maxFee = maxFee;
    }

    @Override
    public double getMinHours() {
        return minHours;
    }

    @Override
    public void setMinHours(double minHours) {
        this.minHours = minHours;
    }

    @Override
    public double getChargePerHour() {
        return chargePerHour;
    }

    @Override
    public void setChargePerHour(double chargePerHour) {
        this.chargePerHour = chargePerHour;
    }

    @Override
    public double getMaxHours() {
        return maxHours;
    }

    @Override
    public void setMaxHours(double maxHours) {
        this.maxHours = maxHours;
    }

    @Override
    public double getHoursParked() {
        return hoursParked;
    }

    @Override
    public void setHoursParked(double hoursParked) {
        this.hoursParked = hoursParked;
    }

    // The parking fee should not be able to be set by any other classes
//    public void setParkingFee(double parkingFee) {
//        this.parkingFee = parkingFee;
//    }
    public double getChargableHours() {
        return chargableHours;
    }

    public void setChargableHours(double chargableHours) {
        this.chargableHours = chargableHours;
    }
}
