package teme.w09_exceptions_files.ex0_string_to_int;

public class NegativeNumberException extends Exception {
    public NegativeNumberException(String value) {
        super("The value " + value + " is a negative number");
    }
}
