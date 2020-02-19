package teme.w03_recap;

class Ex6_ValidParentheses {

    static boolean isValid(String expression) {
        //TODO
        return false;
    }

    /**
     * Some manual tests:
     */
    public static void main(String[] args) {
        testIt("");
        testIt("Abc 123");
        testIt("()");
        testIt("ab ()");
        testIt("x*(y+z), (2+3)");
        testIt("(1+(2+3))-((4))");
        testIt("(.()..((?))..)..");

        testIt("(..");
        testIt(")( abc ()");
        testIt("() )( ()");
    }

    private static void testIt(String s) {
        System.out.println();
        System.out.println("'" + s + "' - is valid? : " + isValid(s));
    }
}
