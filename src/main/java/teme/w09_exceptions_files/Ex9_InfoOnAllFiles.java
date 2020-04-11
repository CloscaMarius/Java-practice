package teme.w09_exceptions_files;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

class Ex9_InfoOnAllFiles {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        FileWriter writer = null;
        try {
            createFile();
            writer = new FileWriter("dir_info.txt");
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("Please input a base directory path: ");
        String basedirPath = scanner.nextLine();

        File file = new File(basedirPath);
        List<File> files = Arrays.asList(file.listFiles());
        long totalNrOfFiles = files.size();

        System.out.println("\nTotal number of files and directories: " + totalNrOfFiles);
        try {
            writer.write("\nTotal number of files and directories: " + totalNrOfFiles);
        } catch (IOException e) {
            System.out.println("Eroare scriere fisier:" + e);
        }

        List<File> top5 = files.stream()
                .sorted((f1, f2) -> Long.compare(f2.length(), f1.length()))
                .limit(5)
                .collect(Collectors.toList());

        System.out.println("\nTop 5 biggest files: ");
        try {
            writer.write("\n\nTop 5 biggest files: ");
        } catch (IOException e) {
            System.out.println("Eroare scriere fisier:" + e);
        }

        for (File f : top5) {
            System.out.println("\nFile name: " + f.getName() + "; "
                    + "\nFile path: " + f.getAbsolutePath() + "; "
                    + "\nFile size: " + f.length() + " bytes");

            try {
                writer.write("\n\nFile name: " + f.getName() + "; "
                        + "\nFile path: " + f.getAbsolutePath() + "; "
                        + "\nFile size: " + f.length() + " bytes");
            } catch (IOException e) {
                System.out.println("Eroare scriere fisier:" + e);
            }
        }

        try {
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    static void createFile() throws IOException {
        File file = new File("dir_info.txt");
        if (file.createNewFile()) {
            System.out.println("File created: " + file.getName());
        } else {
            System.out.println("File already exists.");
        }
    }

}
