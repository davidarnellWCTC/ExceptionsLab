package lab1;

import javax.swing.JOptionPane;

/**
 * The purpose of this challenge is to give you practice time using Java
 * Exception handling techniques.
 * <p>
 * Your challenge is to consider all the possible things that can go wrong with
 * this program and use exception handling where appropriate to prevent the
 * program from crashing. In addition you must display a friendly error message
 * in a JOptionPane and ask the user to try again. (Yes, this violates the
 * Single Responsibility Principle, but for this lab, we'll overlook that.)
 *
 * @author Jim Lombardo, jlombardo@wctc.edu
 * @version 1.00
 */
public class Challenge1 {

    private static final int LAST_NAME_IDX = 1;

    public static void main(String[] args) {
        Challenge1 app = new Challenge1();
        boolean askAgain = false;
        String lastName = "";
        String fullName = "";

        do {
            fullName = JOptionPane.showInputDialog("Enter full name (use Format: first last):");
            try {
                lastName = app.extractLastName(fullName);
                askAgain = false;
            } catch (IllegalArgumentException iae) {
                JOptionPane.showMessageDialog(null, iae.getMessage());
                askAgain = true;
            }
        } while (askAgain);

        String msg = "Your last name is: " + lastName;
        JOptionPane.showMessageDialog(null, msg);
    }

    /**
     * Attempts to extract the last name from the full name. cannot guarantee
     * the last name is extracted. checks for empty strings, null, or all spaces
     *
     * @param fullName - String containing the first and last name
     * @return
     * @throws IllegalArgumentException
     */
    public String extractLastName(String fullName) throws IllegalArgumentException {
        // Names can contain numbers and symbols
        // ÄÑÄµ and the symbol Prince turned his name into are all valid
//        if(fullName == null || fullName.length() < 3 || fullName.trim().isEmpty() ){
//            throw new IllegalArgumentException("The name is empty. Please enter a name");
//        }
        if (fullName == null || fullName.isEmpty()) {
            throw new IllegalArgumentException("Sorry you must provide a full name.");
        }

        String[] parts = fullName.split(" ");
        if (parts.length < 2) {
            throw new IllegalArgumentException("Sorry you must provide both a "
                    + "first name and last name.");
        }

        String[] nameParts = fullName.split(" ");
        return nameParts[nameParts.length - 1];
    }

}
