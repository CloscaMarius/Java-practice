package teme.w10_recap.ex0_warmup;

import java.util.Scanner;

public class Ex0a_EchoRoom {
    /*
    public static void main(String[] args) {
        Scanner userInput = new Scanner(System.in);
        String value = "";
        while (!value.equalsIgnoreCase("exit")) {
            System.out.println("Enter value");
            value = userInput.nextLine();
            System.out.println(value);
        }
    }*/

    /* version 2 */
    public static void main(String[] args) {
        System.out.println("Please enter a word:");
        Scanner keyboard = new Scanner(System.in);

        while (true) {
            String word = keyboard.nextLine();
            if (word.equals("exit")) {
                break;
            }
            System.out.println(word.toUpperCase() + " " + word.toLowerCase());
        }
    }


/*    public static void main(String[] args) throws InterruptedException {
        System.out.println("ceva");
        Thread.sleep(1000);
        System.out.println("dupa");
    }*/
}
