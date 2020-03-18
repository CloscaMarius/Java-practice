package teme.w07_comparable.ex3_palindrome;

import java.util.Arrays;

class Palindrome {

    static boolean isSymmetrical(int[] array) {
        //TODO
        return false;
    }

    //OPTIONAL: make this generic version also work (similar to previous one, but should work with ANY type of object, not just int values)
    //Note: do NOT use Object instead of ??, but a generic type...
    /*
    static ?? boolean isSymmetrical_generic( ?? [] array) {
        return false;
    }
    */


    static boolean isPalindrome(String text) {
        //TODO
        return false;
    }


    public static void main(String[] args) {

        testSym(new int[]{1, 2, 3, 4, 1});

        testSym(new int[]{1});
        testSym(new int[]{2, 2});
        testSym(new int[]{1, 2, 3, 2, 1});


        //TODO: uncomment after making generic version work
        /*
        String[] strings1 = {"ab", "cd"};
        String[] strings2 = {"ab", "cd", "cd", "ab"};
        String[] strings3 = {"ab", "cd", "cd", "ef", "ab"};
        Boolean[] bools = {true, false, true};
        System.out.println("array: " + Arrays.toString(strings1) + " - is symmetrical?: " + isSymmetrical_generic(strings1));
        System.out.println("array: " + Arrays.toString(strings2) + " - is symmetrical?: " + isSymmetrical_generic(strings2));
        System.out.println("array: " + Arrays.toString(strings3) + " - is symmetrical?: " + isSymmetrical_generic(strings3));
        System.out.println("array: " + Arrays.toString(bools) + " - is symmetrical?: " + isSymmetrical_generic(bools));
        */


        testPal("not a palindrome");
        testPal("abb");
        testPal("abcXa");

        testPal("a");
        testPal("abba");
        testPal("rotitor");
        testPal("Step on no pets");
        testPal("Ene purta patru pene");
        testPal("Ion a luat luni vinul tau la noi");
    }

    private static void testSym(int[] array) {
        System.out.println("array: " + Arrays.toString(array) + " - is symmetrical?: " + isSymmetrical(array));
    }

    private static void testPal(String text) {
        System.out.println("'" + text + "' - is palindrome?: " + isPalindrome(text));
    }
}
