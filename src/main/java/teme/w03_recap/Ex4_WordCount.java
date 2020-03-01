package teme.w03_recap;

class Ex4_WordCount {

    static int wordCount(String phrase) {
        if (phrase == null) {
            return 0;
        }
        String words = phrase.trim();
        if (words.isEmpty()) {
            return 0;
        }
        return words.split("\\s+").length;
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
