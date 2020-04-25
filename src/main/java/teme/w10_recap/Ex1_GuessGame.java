package teme.w10_recap;

import java.util.Random;
import java.util.Scanner;

/**
 * TODO: this version has at least one bug still left in it
 * - Can you find it?
 * - Can you find any other bugs? And how would you fix them?
 * (send your improved version of this code, with comments, to your trainers)
 */
public class Ex1_GuessGame {

    public static void main(String[] args) {
        do {
            playOneGame();
        } while (askUserToContinue());
    }

    private static void playOneGame() {
        int secret = chooseSecretNumber();

        int guess;
        int attempt = 1;
        do {
            guess = readUserGuess();
            printHiLowHint(secret, guess, attempt);

            attempt++;
        } while (secret != guess && attempt <= 7);

        printFinalConclusion(secret, guess, attempt);
    }

    private static int chooseSecretNumber() {
        Random r = new Random();
        return r.nextInt(100) + 1;
    }

    private static int readUserGuess() {
        System.out.println("Enter an integer between 1 and 100:");
        Scanner sc = new Scanner(System.in);

        while (true) {
            try {
                int n = Integer.parseInt(sc.nextLine());
                if (n < 1 || n > 100) {
                    System.out.println("Enter a number in this range 1..100:");
                } else {
                    return n;
                }
            } catch (Exception e) {
                System.out.println("Please enter a number (between 1..100):");
            }
        }
    }

    private static void printHiLowHint(int secret, int guess, int tries) {
        if (secret < guess) {
            System.out.println("Try " + tries + ": Secret number is smaller...try again");
        } else if (secret > guess) {
            System.out.println("Try " + tries + ": Secret number is bigger...try again");
        }
    }

    private static void printFinalConclusion(int secret, int guess, int tries) {
        if (secret == guess) {
            System.out.println("Congratulations, you guessed the number!!! (in only " + tries + " tries)");
        } else {
            System.out.println("Sorry, you lost! Secret number was: " + secret);
        }
    }

    private static boolean askUserToContinue() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Play another one? (y/n): ");
        String answer = sc.next();
        return answer.equalsIgnoreCase("y");
    }
}
