package teme.w03_recap;

class Ex5_DistinctWordCount {

    static String[] splitToWords(String text) {
        String[] result = new String[0];
        if (text == null) {
            return result;
        }

        String words = text.trim();

        if (words.isEmpty()) {
            return result;
        }
        result = words.split("\\s+");
        return result;
    }

    static boolean contains(String[] wordsArray, String word) {
        for (int i = 0; i < wordsArray.length; i++) {
            if (word.equals(wordsArray[i])) {
                return true;
            }
        }
        return false;
    }

    static int distinctWordCount(String phrase) {
        String lowerCasePhrase = phrase.toLowerCase();
        String[] phraseArray = splitToWords(lowerCasePhrase);
        int count = phraseArray.length;

        for (int i = 0; i < phraseArray.length; i++) {
            for (int j = i + 1; j < phraseArray.length; j++) {
                if (phraseArray[i].equals(phraseArray[j])) {
                    count--;
                    break;
                }
            }
        }
        return count;
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
