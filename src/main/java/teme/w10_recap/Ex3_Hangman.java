package teme.w10_recap;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Ex3_Hangman {
    public static void main(String[] args) {
        playGame();
    }

    public static void playGame() {
        do {
            playOneGame();
        }
        while (askUserToContinue());
    }

    private static void playOneGame() {
        String word = randomWord();
        String hidden = hiddenWord(word);
        int count = 0;

        while (count < 7 && hidden.contains("_")) {
            System.out.println("Guess any letter in the word");
            System.out.println(hidden);
            char guess = readUserGuess();
            String guessed = "";
            for (int i = 0; i < word.length(); i++) {
                if (word.charAt(i) == guess) {
                    guessed += guess;
                } else if (hidden.charAt(i) != '_') {
                    guessed += word.charAt(i);
                } else {
                    guessed += "_";
                }
            }

            if (hidden.equals(guessed)) {
                count++;
                hangmanImage(word, count);
            } else {
                hidden = guessed;
            }
            if (hidden.equals(word)) {
                System.out.println("Correct! You win! The word was " + word);
            }
        }
    }

    private static void hangmanImage(String word, int count) {
        if (count == 1) {
            System.out.println("Wrong guess, try again");
            System.out.println();
            System.out.println();
            System.out.println();
            System.out.println();
            System.out.println("___|___");
            System.out.println();
        }
        if (count == 2) {
            System.out.println("Wrong guess, try again");
            System.out.println("   |");
            System.out.println("   |");
            System.out.println("   |");
            System.out.println("   |");
            System.out.println("   |");
            System.out.println("   |");
            System.out.println("   |");
            System.out.println("___|___");
        }
        if (count == 3) {
            System.out.println("Wrong guess, try again");
            System.out.println("   ____________");
            System.out.println("   |");
            System.out.println("   |");
            System.out.println("   |");
            System.out.println("   |");
            System.out.println("   |");
            System.out.println("   |");
            System.out.println("   | ");
            System.out.println("___|___");
        }
        if (count == 4) {
            System.out.println("Wrong guess, try again");
            System.out.println("   ____________");
            System.out.println("   |          _|_");
            System.out.println("   |         /   \\");
            System.out.println("   |        |     |");
            System.out.println("   |         \\_ _/");
            System.out.println("   |");
            System.out.println("   |");
            System.out.println("   |");
            System.out.println("___|___");
        }
        if (count == 5) {
            System.out.println("Wrong guess, try again");
            System.out.println("   ____________");
            System.out.println("   |          _|_");
            System.out.println("   |         /   \\");
            System.out.println("   |        |     |");
            System.out.println("   |         \\_ _/");
            System.out.println("   |           |");
            System.out.println("   |           |");
            System.out.println("   |");
            System.out.println("___|___");
        }
        if (count == 6) {
            System.out.println("Wrong guess, try again");
            System.out.println("   ____________");
            System.out.println("   |          _|_");
            System.out.println("   |         /   \\");
            System.out.println("   |        |     |");
            System.out.println("   |         \\_ _/");
            System.out.println("   |           |");
            System.out.println("   |           |");
            System.out.println("   |          / \\ ");
            System.out.println("___|___      /   \\");
        }
        if (count == 7) {
            System.out.println("GAME OVER!");
            System.out.println("   ____________");
            System.out.println("   |          _|_");
            System.out.println("   |         /   \\");
            System.out.println("   |        |     |");
            System.out.println("   |         \\_ _/");
            System.out.println("   |          _|_");
            System.out.println("   |         / | \\");
            System.out.println("   |          / \\ ");
            System.out.println("___|___      /   \\");
            System.out.println("GAME OVER! The word was " + word);
        }
    }

    private static List<String> words() {
        List<String> words = new ArrayList<>();
        String pathname = "src/main/resources/cuvinte.txt";
        File file = new File(pathname);
        Scanner scanner = null;
        try {
            scanner = new Scanner(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        while (scanner.hasNextLine()) {
            words.add(scanner.nextLine());
        }
        //words.stream().forEach(System.out::println);
        return words;
    }

    private static String randomWord() {

        Random random = new Random();
        //System.out.println(words.get(random.nextInt(words.size())));
        return words().get(random.nextInt(words().size()));
    }

    private static String hiddenWord(String word) {

        //System.out.println(word);
        char[] hiddenCharArray = word.toCharArray();

        for (int i = 1; i < hiddenCharArray.length - 1; i++) {
            if (hiddenCharArray[i] == hiddenCharArray[0]
                    || hiddenCharArray[i] == hiddenCharArray[hiddenCharArray.length - 1]) {
                hiddenCharArray[i] = hiddenCharArray[i];
            } else {
                hiddenCharArray[i] = '_';
            }
        }
        return String.valueOf(hiddenCharArray);
    }

    private static char readUserGuess() {

        System.out.println("Please enter a letter: ");
        Scanner scanner = new Scanner(System.in);

        while (true) {
            try {
                //int n = Integer.parseInt(scanner.nextLine());
                char c = scanner.next().trim().toLowerCase().charAt(0);
                if (c < 97 || c > 122) {
                    System.out.println("Please enter a letter between 'a' and 'z'");
                } else {
                    return c;
                }
                //System.out.println(c);
            } catch (Exception e) {
                System.out.println("Please enter a letter (between 'a' and 'z'):");
            }
        }
    }

    private static boolean askUserToContinue() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Play another one? (y/n): ");
        String answer = sc.next();
        return answer.equalsIgnoreCase("y");
    }
}
