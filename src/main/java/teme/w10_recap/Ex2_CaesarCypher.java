package teme.w10_recap;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Ex2_CaesarCypher {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        //String pathname = scanner.nextLine();

        String pathname = "src/main/resources/proverbe.txt";
        String encryptedFilePath = "src/main/resources/proverbe_encrypted.txt";

        CaesarCypherFiles.encryptFile(pathname, 11);

        CaesarCypherFiles.decryptFile(encryptedFilePath, 11);

        //System.out.println("Please enter your text: ");
        //String text = scanner.nextLine();

        //System.out.println("Please enter a shift value: ");
        //int shift = scanner.nextInt();

        System.out.println(encrypt("abcxyz", 7));
        System.out.println(decrypt(encrypt("abcxyz", 7), 7));
        System.out.println(encrypt("xyz", 2));
        System.out.println(decrypt("zab", 2));
        System.out.println(encrypt("help me !", 13));

        //SOME HINTS:

        //shifting one char
        /*char c = 'a';
        char e = (char) (c + 3); //char+int results in int type (due to type widening), must cast it back to char
        System.out.println(e);

        String text = "abcde";*/

        //iterating over chars of a string - converting to char[]
        /*for (char x : text.toCharArray()) {
            System.out.println(x);
        }*/

        //or with .chars(), which produces an IntStream directly (must convert values to char later)
        /*text.chars() //IntStream
                .mapToObj(asciiCode -> (char) (asciiCode + 3)) //Stream<Character>
                .forEach(System.out::println);*/
    }

    static String encrypt(String text, int shift) {
        text = text.trim();

        char[] encryptedChar = new char[text.toCharArray().length];
        int i = 0;
        for (char c : text.toCharArray()) {

            if (c >= 65 && c <= 90) {
                c = (char) (c + shift);
                if (c > 90) {
                    c = (char) (c - 26);
                } else if (c < 65) {
                    c = (char) (c + 26);
                }
            } else if (c >= 97 && c <= 122) {
                c = (char) (c + shift);
                if (c > 122) {
                    c = (char) (c - 26);
                } else if (c < 97) {
                    c = (char) (c + 26);
                }
            }
            encryptedChar[i] = c;
            i++;
        }
        String encryptedText = String.valueOf(encryptedChar);
        return encryptedText;
    }

    static String decrypt(String text, int shift) {
        return encrypt(text, -shift);
    }


}

class CaesarCypherFiles {

    static void createFile(String pathname) {
        File file = new File(pathname);
        try {
            if (file.createNewFile()) {
                System.out.println("File created: " + file.getName());
            } else {
                System.out.println("File already exists.");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static void encryptFile(String pathname, int shift) {

        String fileName = pathname.replace(".txt", "_encrypted.txt");
        createFile(fileName);
        File file = new File(pathname);
        String line = "";
        FileWriter writer;
        try {
            Scanner scanner = new Scanner(file);
            writer = new FileWriter(fileName);
            while (scanner.hasNextLine()) {
                line += scanner.nextLine() + "\n";
            }
            writer.write(Ex2_CaesarCypher.encrypt(line, shift));
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static void decryptFile(String encryptedFilePath, int shift) {
        String fileName = encryptedFilePath.replace("_encrypted.txt", "_decrypted.txt");
        createFile(fileName);
        File file = new File(encryptedFilePath);
        String line = "";
        FileWriter writer;
        try {
            Scanner scanner = new Scanner(file);
            writer = new FileWriter(fileName);
            while (scanner.hasNextLine()) {
                line += scanner.nextLine() + "\n";
            }
            writer.write(Ex2_CaesarCypher.decrypt(line, shift));
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }


}
