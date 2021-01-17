package teme.w12_jdbc.notes_text_app.ui.text;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * Utility methods for user interface
 */
class TextMenuUtil {

    /**
     * Shows the user a menu and reads his choice, accepting only one of the valid options
     */
    static char readChoice(String menu, Character... options) {
        Set<Character> allowedOptions = new HashSet<>(Arrays.asList(options));
        char choice = '?';

        Scanner sc = new Scanner(System.in);
        while (choice == '?') {
            System.out.println("\n" + menu + "\nChoice? : ");
            String input = sc.next().trim().toUpperCase();
            char first = input.length() >= 1 ? input.charAt(0) : '?';
            if (allowedOptions.contains(first)) {
                choice = first;
            } else {
                System.err.println("'" + input + "' is not a valid choice, try again!");
            }
        }

        System.out.println(); //add empty line after

        return choice;
    }

    /**
     * Displays a label and also reads the user input; allows empty string only if specified so
     */
    static String readString(String label, boolean allowEmpty) {
        System.out.println(label);
        Scanner sc = new Scanner(System.in);
        String input;
        do {
            input = sc.nextLine().trim();
        } while (!allowEmpty && input.isEmpty());
        return input;
    }

    /**
     * Displays a label and reads a value from user, validating that it's an integer value
     */
    static int readInt(String label) {
        while (true) {
            String str = readString(label, false);
            try {
                return Integer.parseInt(str);
            } catch (NumberFormatException e) {
                System.err.println("Invalid integer value, try again! (error: " + e.getMessage() + ")");
            }
        }
    }
}
