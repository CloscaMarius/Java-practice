package teme.w09_exceptions_files.ex0_string_to_int;

import java.util.Arrays;
import java.util.List;

class StringToInt {

    static int toPositiveInt(String value) {
        //TODO!
        return -1;
    }

    static List<Integer> toPositiveInt(List<String> values) {
        //TODO!
        return null;
    }


    /**
     * Some manual tests
     */
    public static void main(String[] args) {

        try {
            System.out.println("toPositiveInt('abc') = " + toPositiveInt("abc"));
        } catch (Exception e) {
            System.err.println("Error while converting 'abc': " + e);
        }
        try {
            System.out.println("toPositiveInt('-2') = " + toPositiveInt("-2"));
        } catch (Exception e) {
            System.err.println("Error while converting '-2': " + e);
        }
        try {
            System.out.println("toPositiveInt('3') = " + toPositiveInt("3"));
        } catch (Exception e) {
            System.err.println("Error while converting '3': " + e);
        }

        List<String> values = Arrays.asList("lucian", "andrei", "-1", "-2", "1234", "2  ", "", "+3");
        System.out.println("List of string values before conversion: " + values);
        System.out.println("List of int values after conversion: " + toPositiveInt(values));
    }
}
