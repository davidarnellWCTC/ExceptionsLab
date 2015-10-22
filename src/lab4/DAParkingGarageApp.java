/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab4;

/**
 *The DAParkingGarageApp class is the startup class for this program.
 * A new instance of the AutomatedParkingMachine is created and vehicle entry
 * and exit times are added to the apm object. The totals are requested from the
 * apm object for the garage owner's reference.
 * @author David
 */
public class DAParkingGarageApp {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        AutomatedParkingMachine apm = new AutomatedParkingMachine();
        
        //apm.enterNewCar(carId, enterTime, feeCalculator, outputType)
        apm.enterNewCar(101, 0300, new MinimumNoMaximumFeeCalculator(),
                new OutputToConsole());
        //apm.exitCar(carId, exitTime)
        apm.exitCar(101, 1700);
        
        apm.enterNewCar(102, 0030, new MinimumWithMaximumFeeCalculator(),
                new OutputToConsole());
        apm.exitCar(102, 1100);
        
        // Multiple cars can be "parked" at once without having to exit
        // The cars can also exit in different orders
        apm.enterNewCar(103, 0130, new MinimumNoMaximumFeeCalculator(),
                new OutputToConsole());
        
        apm.enterNewCar(104, 0750, new MinimumNoMaximumFeeCalculator(),
                new OutputToConsole());
        
        apm.enterNewCar(105, 1030, new MinimumWithMaximumFeeCalculator(),
                new OutputToConsole());
        
        apm.exitCar(104, 1900);
        
        apm.exitCar(103, 1900);
        
        apm.enterNewCar(106, 0200, new MinimumNoMaximumFeeCalculator(),
                new OutputToConsole());
        
        apm.exitCar(105, 1900);
        
        apm.exitCar(106, 1700);
        
        apm.outputParkingGarageDailyTotals(new OutputToConsole());
        
    }
    
}
