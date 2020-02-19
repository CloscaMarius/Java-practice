package teme.w03_recap;

class Ex3_Anagrams {

    static boolean anagrams(String s1, String s2) {
        //TODO
        return false;
    }

    /**
     * Some manual tests:
     */
    public static void main(String[] args) {
        checkAnagrams("", "");
        checkAnagrams("A", "a");
        checkAnagrams("binary", "brainy");
        checkAnagrams("Listen", "Silent");
        checkAnagrams("anagram", "nagaram");

        checkAnagrams("ab", "ac");
        checkAnagrams("Aa", "a");
        checkAnagrams("anagram", "angrm");
    }

    private static void checkAnagrams(String s1, String s2) {
        System.out.println("'" + s1 + "' and '" + s2 + "' are anagrams? : " + anagrams(s1, s2));
    }
}
