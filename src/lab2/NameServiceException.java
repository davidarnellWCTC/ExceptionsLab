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
    
    // holds exceptions from the NameService
    
    InputOutputGui iog = new InputOutputGui();
    
    String exception;
    
    // should use this instead
    private static final String MSG = "Error message";

    // Class constructor with no data
//    public NameServiceException() {
//        //exception = "Incorrect input";
//        //iog.nameSerivceException(exception);
//    }
    
    

    public NameServiceException(String exception) throws NameServiceException {
        this.exception = exception;
        iog.nameSerivceException(exception);
        iog.startConversation();
    }
    
    
    
    
}
