/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab4;

/**
 * This class takes an array of all of the parking garage receipts and 
 * totals the information on the total parked hours and total fees
 * @author David
 */
public class ParkingGarageTotalParkingCalculator {

    private GarageInformationOutputStrategy output;

    private final String TOTALSHEETHEADER = "Totals for the Garage Today";
    private final String PARKINGGARAGENAME = "Best Value Parking Garage";
    private final String HOURSCHARGEDTEXT = "Total Hours Parked: ";
    private final String TOTALFEESCOLLECTEDTEXT = "Total Fees Collected: $";

    private double totalHours;
    private double totalFees;

    private ParkingReceipt[] garageCustomerList;

    /**
     * the ParkingGarageTotalParkingCalculator constructor takes the array of
     * parkingReceipts and the output method.
     * @param garageCustomerList - ParkingReceipt[] garageCustomerList; array of receipts from the customers
     * @param output - GarageInformationOutputStrategy output; Output method
     */
    public ParkingGarageTotalParkingCalculator(ParkingReceipt[] garageCustomerList,
            GarageInformationOutputStrategy output) {
        this.garageCustomerList = garageCustomerList;
        this.output = output;
    }

    /**
     * The outputGarageTotalParkingForCurrentDay method calculates the totals
     * for the parked hours and fees and sends them to an output class to be
     * displayed
     */
    public void outputGarageTotalParkingForCurrentDay() throws NullPointerException {
        
        if (garageCustomerList == null){
            throw new NullPointerException("The customer list is empty");
        }
        
        for (ParkingReceipt customer : garageCustomerList) {

            totalHours += customer.getHoursParked();
            totalFees += customer.getParkingFee();
        }

        String[] garageTotalOutput = new String[4];
        garageTotalOutput[0] = TOTALSHEETHEADER;
        garageTotalOutput[1] = PARKINGGARAGENAME;
        garageTotalOutput[2] = HOURSCHARGEDTEXT + totalHours;
        garageTotalOutput[3] = TOTALFEESCOLLECTEDTEXT + totalFees;

        output.print(garageTotalOutput);
    }

    public double getTotalHours() {
        return totalHours;
    }

    public void setTotalHours(double totalHours) {
        this.totalHours = totalHours;
    }

    public double getTotalFees() {
        return totalFees;
    }

    public void setTotalFees(double totalFees) {
        this.totalFees = totalFees;
    }

    public ParkingReceipt[] getGarageCustomerList() {
        return garageCustomerList;
    }

    public void setGarageCustomerList(ParkingReceipt[] garageCustomerList) {
        this.garageCustomerList = garageCustomerList;
    }

}
