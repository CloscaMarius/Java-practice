package teme.w03_recap;

class Ex0_WarmupRecap {

    static String ends(String text) {

        if (text.length() <= 2) {
            return text;
        }

        char prima = text.charAt(0);
        char ultima = text.charAt(text.length() - 1);


        return (String.valueOf(prima) + ultima);
    }

    static String middle_v1(String text) {
        if (text.length() % 2 == 0 && text.length() > 3) {
            char middle1 = text.charAt(text.length() / 2 - 1);
            char middle2 = text.charAt(text.length() / 2);
            return (String.valueOf(middle1) + middle2);
        }
        if (text.length() % 2 == 1) {
            char middle = text.charAt((text.length() / 2));
            return (String.valueOf(middle));
        }
        return text;
    }

    static String middle(String text) {
        if (text.length() <= 2) {
            return text;
        }

        int indexMid = text.length() / 2;
        if (text.length() % 2 == 0) {
            char middle1 = text.charAt(indexMid - 1);
            char middle2 = text.charAt(indexMid);
            return String.valueOf(middle1) + middle2;
        }

        char middle = text.charAt(indexMid);
        return String.valueOf(middle);

    }

    static String onlyUpper(String text) {
        char[] litere = text.toCharArray();
        String result = "";
        for (char litera : litere) {

            if (litera >= 'A' && litera <= 'Z') {
                result += litera;
            }
        }
        return result;
    }

    static boolean contains(String text, char letter) {
        int i = 0;
        while (i < text.length()) {
            if (text.charAt(i) == letter) {
                return true;
            }
            i++;
        }
        return false;
    }

    static int count(String text, char letter) {
        int count = 0;
        for (char l : text.toCharArray()) {
            if (l == letter) {
                count++;
            }
        }

        return count;
    }

    static int countVowels(String s) {
        int count = 0;
        String sLower = s.toLowerCase();
        for (char l : sLower.toCharArray()) {
            if (l == 'a' || l == 'e' || l == 'i' || l == 'o' || l == 'u') {
                count++;

            }
        }
        return count;
    }

    static boolean isSorted(String text) {
        for (int i = 0; i < text.length() - 1; i++) {
            if (text.charAt(i) > text.charAt(i + 1)) {
                return false;
            }
        }
        return true;
    }

    static String sorted(String text) {
        char[] letters = text.toCharArray();
        sort(letters);
        return String.valueOf(letters);

    }

    static void sort(char[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            for (int j = 0; j < array.length - i - 1; j++) {
                if (array[j] > array[j + 1]) {
                    char temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }
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
