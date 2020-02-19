package teme.w03_recap;

class Ex4_WordCount {

    static int wordCount(String phrase) {
        //TODO
        return -1;
    }

    //some manual tests
    public static void main(String[] args) {
        testIt("");
        testIt("abc");
        testIt("aa bb");
        testIt("aa  bb");
        testIt("  ");
        testIt(" aa  bb");
        testIt("aa bb  cc  ");
    }

    //helper method for manual tests
    private static void testIt(String phrase) {
        System.out.println("wordCount('" + phrase + "') = " + wordCount(phrase));
    }
}
