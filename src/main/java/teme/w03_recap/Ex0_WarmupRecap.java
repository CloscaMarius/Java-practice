package teme.w03_recap;

class Ex0_WarmupRecap {

    static String ends(String text) {
        return "TODO!";
    }

    static String middle(String text) {
        return "TODO!";
    }

    static String onlyUpper(String text) {
        return "TODO!";
    }

    static boolean contains(String text, char letter) {
        return false; //TODO!
    }

    static int count(String text, char letter) {
        return -1; //TODO
    }

    static int countVowels(String s) {
        return -1; //TODO
    }

    static boolean isSorted(String text) {
        return false; //TODO!
    }

    static String sorted(String text) {
        return "?"; //TODO!
    }


    //some manual tests
    public static void main(String[] args) {
        System.out.println(ends(""));
        System.out.println(ends("a"));
        System.out.println(ends("ab"));
        System.out.println(ends("abcd"));

        System.out.println(middle(""));
        System.out.println(middle("a"));
        System.out.println(middle("ab"));
        System.out.println(middle("abc"));
        System.out.println(middle("abcd"));
        System.out.println(middle("abcde"));

        System.out.println(onlyUpper("A Fost OdaTa.."));

        System.out.println("\ncontains(\"abcd\", 'c'): " + contains("abcd", 'c'));
        System.out.println("\ncontains(\"abcd\", 'x'): " + contains("abcd", 'x'));

        System.out.println("\ncount(\"ab c d c ba c e\", 'c'): " + contains("ab c d c ba c e", 'c'));
        System.out.println("\ncount(\"abc\", 'C'): " + contains("abc", 'C'));

        System.out.println("\ncountVowels('Run, Forest, run!') = " + countVowels("Run, Forest, run!"));
        System.out.println("countVowels('I will..') = " + countVowels("I will.."));

        System.out.println("\nisSorted(\"abccd\"): " + isSorted("abccd"));
        System.out.println("isSorted(\"abec\"): " + isSorted("abec"));

        System.out.println("\nsorted(\"ba\"): " + sorted("ba"));
        System.out.println("\nsorted(\"badc\"): " + sorted("badc"));
    }
}
