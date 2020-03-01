package teme.w03_recap;

import java.util.Arrays;

class Ex3_Anagrams {

    static boolean anagrams(String s1, String s2) {

        if (s1.length() != s2.length()) {
            return false;
        }

        char[] charS1 = s1.toLowerCase().toCharArray();
        char[] charS2 = s2.toLowerCase().toCharArray();

        Arrays.sort(charS1);
        Arrays.sort(charS2);

        for (int i = 0; i < s1.length(); i++) {
            if (charS1[i] != charS2[i]) {
                return false;
            }
        }

        return true;

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
