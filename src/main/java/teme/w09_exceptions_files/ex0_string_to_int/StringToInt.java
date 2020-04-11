package teme.w09_exceptions_files.ex0_string_to_int;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class StringToInt {

    static int toPositiveIntCalls;

    static int toPositiveIntUnchecked(String value) throws ArrayIndexOutOfBoundsException,
            NullPointerException,
            NumberFormatException {
        return Integer.parseInt(value);
    }

    static int toPositiveInt(String value) throws NegativeNumberException, NotANumberException {
        try {
            int intValue = Integer.parseInt(value);
            if (intValue < 0) {
                throw new NegativeNumberException(value);
            }
            return intValue;
        } catch (NumberFormatException e) {
            throw new NotANumberException(value);
        } finally {
            toPositiveIntCalls++;
        }
    }

    static List<Integer> toPositiveInt(List<String> values) {
        List<Integer> list = new ArrayList<>();
        for (String value : values) {
            try {
                list.add(toPositiveInt(value));
            } catch (NotANumberException | NegativeNumberException e) {
                System.err.println("The value " + value + " is not a positive integer. Skipping...");
            }
        }
        return list;
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
