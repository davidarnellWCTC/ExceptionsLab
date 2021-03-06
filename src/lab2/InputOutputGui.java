package lab2;

import javax.swing.JOptionPane;

/**
 * This class is responsible for all input and output in the program.
 * 
 * @author  Jim Lombardo, jlombardo@wctc.edu
 * @version 1.00
 */
public class InputOutputGui {
    // display exception here
    private NameService nameService;
    // moving the lastName outside the method
    private String lastName = "";

    public InputOutputGui() {
        nameService = new NameService();
    }

    public void startConversation() { //throws NameServiceException {
        
        String fullName = JOptionPane.showInputDialog("Enter full name:");
        //String lastName = "";
        try {
            lastName = nameService.extractLastName(fullName);
        } catch (NameServiceException nse) {
            JOptionPane.showMessageDialog(null, nse.getMessage());
        }
    }
  
        String msg = "Your last name is: " + lastName;
        JOptionPane.showMessageDialog(null, msg);
        
        
        /*
        String fullName = JOptionPane.showInputDialog("Enter full name:");
        String lastName = null;
        try {
            lastName = nameService.extractLastName(fullName);
        } catch(IllegalArgumentException iae) {
            JOptionPane.showMessageDialog(null, iae.getMessage());
        }
        String msg = "Your last name is: " + lastName;
        JOptionPane.showMessageDialog(null, msg);
        */
        
        
    }
    
//    public void nameSerivceException(String e){
//        // Exceptions are thrown to this method
//        // The exception text is sent to the JOptionPane output in this class
//        // Output is the responsibility of this class
//        String exception = e;        
//        JOptionPane.showMessageDialog(null, e);
//        
//    }
     
}
