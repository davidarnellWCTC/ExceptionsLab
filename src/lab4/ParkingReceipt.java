/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab4;

import java.text.DecimalFormat;

/**
 *The ParkingReceipt class stores the information that would be on a parking receipt.
 * The fees, hours, billable hours, display, and all other calculations are done
 * by other classes
 * @author David
 */
public class ParkingReceipt {
    
    private double enterTime;
    private double exitTime;
    private double hoursParked;
    private double parkingFee;
    
    private double carId;
    
    private final String RECEIPTCARIDRECEPTTEXT = "Receipt for Car ID: ";
    private final String PARKINGGARAGENAME = "Best Value Parking Garage";
    private final String RECEIPTHOURSPARKEDRECEIPTTEXT = "Hours Parked: ";
    private final String RECEIPTFEECHARGEDRECEIPTTEXT = "Fee Charged: $";
    
    private ParkingFeeCalculatorStrategy calculator;
    private GarageInformationOutputStrategy output;

    /**
     * 
     * @param enterTime - The time the car entered as a 4 digit military styled time
     * @param carId - The ID assigned to the car
     * @param calculator - Type of fee calculator
     * @param output - destination of receipt output
     */
    public ParkingReceipt(double enterTime, double carId,
            ParkingFeeCalculatorStrategy calculator, 
            GarageInformationOutputStrategy output) {
        
        this.enterTime = enterTime;
        this.carId = carId;
        this.calculator = calculator;
        this.output = output;
    }
    
    /**
     * The outputReceipt method arranges the information on the receipt and 
     * puts each line into a separate element in a String[] array. The array
     * is sent to an output object.
     */
    public void outputReceipt(){
        
        DecimalFormat dfNoDecimal = new DecimalFormat("#");
        DecimalFormat dfTwoDecimals = new DecimalFormat("#.00");
        
        String[] receiptOutput = new String[4];
        
        parkingFee = calculator.getParkingFee(enterTime, exitTime);
        hoursParked = calculator.getHoursParked();
                        
        receiptOutput[0] = PARKINGGARAGENAME;
        receiptOutput[1] = RECEIPTCARIDRECEPTTEXT + dfNoDecimal.format(carId);
        receiptOutput[2] = RECEIPTHOURSPARKEDRECEIPTTEXT + dfTwoDecimals.format(hoursParked);
        receiptOutput[3] = RECEIPTFEECHARGEDRECEIPTTEXT + dfTwoDecimals.format(parkingFee);
        
        output.print(receiptOutput);
    }

    public double getEnterTime() {
        return enterTime;
    }

    public void setEnterTime(double enterTime) {
        this.enterTime = enterTime;
    }

    public double getExitTime() {
        return exitTime;
    }

    public void setExitTime(double exitTime) {
        this.exitTime = exitTime;
    }

    public double getCarId() {
        return carId;
    }
    
    public double getHoursParked() {
        return hoursParked;
    }

    public void setHoursParked(double hoursParked) {
        this.hoursParked = hoursParked;
    }

    // Other classes should not be able to change the ID in this class
//    public void setCarId(double carId) {
//        this.carId = carId;
//    } 

    public double getParkingFee() {
        return parkingFee;
    }

    public void setParkingFee(double parkingFee) {
        this.parkingFee = parkingFee;
    }
}
