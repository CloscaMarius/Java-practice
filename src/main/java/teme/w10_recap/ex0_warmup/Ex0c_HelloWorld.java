package teme.w10_recap.ex0_warmup;

import java.util.Scanner;

//Clasa scrisa in notepad direct
public class Ex0c_HelloWorld {

    public static void main(String[] args) {
        if (args.length > 0) {
            String p1 = args[0];
            System.out.println("Hello, " + p1 + "!");
        } else {
            System.out.println("Hello, World!");
        }

        Scanner sc = new Scanner(System.in);
        sc.nextLine();
    }
}