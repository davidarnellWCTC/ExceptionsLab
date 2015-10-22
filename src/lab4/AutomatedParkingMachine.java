/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab4;

/**
 *The Automated Parking Machine directs the requests for parking information
 * this includes issuing tickets and receipts for parking and adding this information
 * to an array of ticket receipts.
 * 
 * The calculations for these functions are not performed within this class.
 * @author David
 */
public class AutomatedParkingMachine {
    
    
    private ParkingReceipt[] garageCustomerList = new ParkingReceipt[0];
    
    /**
     * 
     * @param carId - double; the unique ID given to each car that enters the garage and receives a ticket
     * @param enterTime - double; The time of entry for each car in Military Styled time
     * @param calculator - ParkingFeeCalculatorStrategy; Fee calculator type. Currently set up to accept MinimumNoMaximumFeeCalculator and MinimumWithMaximumFeeCalculator
     * @param output - GarageInformationOutputStrategy; Output method for the receipt information.
     */
    public void enterNewCar( double carId, double enterTime, ParkingFeeCalculatorStrategy calculator, 
            GarageInformationOutputStrategy output){// throws IllegalArgumentException, NullPointerException{
        
//        if (carId == null || enterTime == null || enterTime > 2359){
////        throw new IllegalArgumentException (
////                    "Ensure values have been entered");
//        }
        
        ParkingReceipt receipt = new ParkingReceipt(enterTime, carId, calculator, output);
        
        addToArray(receipt);
    }
    
    /**
     * private method for the AutmatedParkingMachine class
     * The method takes an instance of ParkingReceipt and adds it to an array of receipts
     * @param receipt 
     */
    private void addToArray(ParkingReceipt receipt) throws IllegalArgumentException {
        // needs validation
        if(receipt == null){
        throw new IllegalArgumentException (
                    "ParkingReceipt[] receipt must have values");
        }
        
        ParkingReceipt[] tempItems = new ParkingReceipt[garageCustomerList.length + 1];
        System.arraycopy(garageCustomerList, 0, tempItems, 0, garageCustomerList.length);
        tempItems[garageCustomerList.length] = receipt;
        garageCustomerList = tempItems;
    }
    
    /**
     * exitCar takes two parameters, the carId and the exitTime to create the fee and receipt
     * @param carId - double; the unique identifier for each car. Created for enterNewCar()
     * @param exitTime - double; 4 digit number the exit time or the car. Used to calculate total and billable hours
     */
    public void exitCar(double carId, double exitTime) throws IllegalArgumentException{
        
//        if (carId == null || exitTime == null || exitTime > 2359){
//        throw new IllegalArgumentException (
//                    "Ensure values have been entered");
//        }
        
        for(ParkingReceipt customer: garageCustomerList ){            
            if (customer.getCarId() == carId){
                customer.setExitTime(exitTime);
                customer.outputReceipt();
            }            
        }
    }
    
    /**
     * outputParkingGarageDailyTotals outputs the total parked and billed hours
     * for the parking garage.
     * @param output - output method for displaying the garage totals, type GarageInformationOutputStrategy
     */
    public void outputParkingGarageDailyTotals(GarageInformationOutputStrategy output){
        ParkingGarageTotalParkingCalculator garageTotals = 
                new ParkingGarageTotalParkingCalculator(garageCustomerList, output);
        garageTotals.outputGarageTotalParkingForCurrentDay();
    }
    
}
