/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab4;

/**
 * Information on the parking garage that requires output is displayed through
 * this output strategy
 * @author David
 */
public interface GarageInformationOutputStrategy {

    // This method takes a string array and outputs it
    /**
     * This method is used for displaying or printing values from a String array
     * @param receiptOutput - String[]; this method outputs the values in a String array
     */
    public void print(String[] receiptOutput);
    
}
