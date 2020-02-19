package teme.w03_recap;

class Ex5_DistinctWordCount {

    static String[] splitToWords(String text) {
        //TODO
        return null;
    }

    static boolean contains(String[] wordsArray, String word) {
        //TODO
        return false;
    }

    static int distinctWordCount(String phrase) {
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
        testIt(" aa  bb aa");
        testIt("aa Cc bb  AA cc  ");
    }

    //helper method for manual tests
    private static void testIt(String phrase) {
        System.out.println("distinctWordCount('" + phrase + "') = " + distinctWordCount(phrase));
    }
}
