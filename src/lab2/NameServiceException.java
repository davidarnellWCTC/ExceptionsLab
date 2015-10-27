/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab2;

/**
 *
 * @author David
 */
public class NameServiceException extends Exception{
    
    //ons from the NameService
    
    //InputOutputGui iog = new InputOutputGui();
    
    //String exception;
    
    // should use this instead
    private static final String MSG = "Please enter a valid name.";


    public NameServiceException() {
    }

    public NameServiceException(String string) {
        //this.MSG = string;
        super(MSG);
        //System.out.println(string);
    }

    public NameServiceException(String string, Throwable thrwbl) {
        super(MSG, thrwbl);
    }

    public NameServiceException(Throwable thrwbl) {
        super(MSG);
    }

    public NameServiceException(String string, Throwable thrwbl, boolean bln, boolean bln1) {
        super(MSG, thrwbl, bln, bln1);
    }
    
    
    
    
}
