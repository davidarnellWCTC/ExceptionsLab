/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab4;

/**
 *This class extends the GarageInformationOutputStrategy
 * This class takes a string array and prints it to a console screen 
 * @author David
 */
public class OutputToConsole implements GarageInformationOutputStrategy {
    
    private String[] textToDisplay;

    public OutputToConsole() {
    }
    
    /**
     * OutputToConsole constructor takes a string array when creating an instance
     * of this class
     * @param receiptOutput - String[] array; the data that will be printed to the console
     */
    public OutputToConsole(String[] receiptOutput) {
        this.textToDisplay = receiptOutput;
    }
    
    /**
     * the print(String[] receiptOutput) method takes a String[] array and prints
     * each element to a separate line
     * @param receiptOutput - String[] receiptOutput; Array of elements that will be printed to the console
     */
    @Override
    public void print(String[] receiptOutput){
        try{
        this.textToDisplay = receiptOutput;
        //System.out.println(receiptOutput);
        for (int i = 0; i < textToDisplay.length; i++){
            System.out.println(textToDisplay[i]);
        } 
        System.out.println("");
        }  catch (NullPointerException npe) {
            System.out.println("Enter values into the String[] array");
        } catch (IllegalArgumentException e) {
            System.out.println("");
        }
    }
    
}
