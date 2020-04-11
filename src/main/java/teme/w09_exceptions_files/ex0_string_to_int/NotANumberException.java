package teme.w09_exceptions_files.ex0_string_to_int;

public class NotANumberException extends Exception {
    public NotANumberException(String value) {
        super("The value " + value + " is not a number");
    }
}
