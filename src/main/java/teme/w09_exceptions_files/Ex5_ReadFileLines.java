package teme.w09_exceptions_files;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

class Ex5_ReadFileLines {

    public static void main(String[] args) {

        String numeCompletFisier = "curs/README.md";

        File fisier = new File(numeCompletFisier);
        System.out.println("Fisierul exista pe disk? " + fisier.exists());
        File file = new File("file_statistics.txt");
        FileWriter writer = null;
        try {
            createFile();
            writer = new FileWriter("file_statistics.txt");
        } catch (IOException e) {
            e.printStackTrace();
        }

        try (Scanner scanner = new Scanner(fisier)) {

            writer.write("Fisierul exista pe disk? " + fisier.exists());


            String line = scanner.nextLine();
            System.out.println("prima linie: " + line);
            writer.write("\nprima linie: " + line);

            int nrOfLines = 1;
            while (scanner.hasNext()) {
                nrOfLines++;
                scanner.nextLine();
            }
            System.out.println("Number of lines: " + nrOfLines);
            writer.write("\nNumber of lines: " + nrOfLines);

        } catch (IOException e) {
            System.out.println("Eroare citire fisier:" + e);
        }

        try (Scanner scannerFisier = new Scanner(fisier)) {

            int maxLineCount = 1;
            String maxLine = scannerFisier.next();

            int currentLine = 0;
            while (scannerFisier.hasNext()) {
                currentLine++;
                String crtLine = scannerFisier.next();

                if (maxLine.length() < crtLine.length()) {
                    maxLine = crtLine;
                    maxLineCount = currentLine;
                }
            }
            System.out.println("Max line: " + maxLineCount + " length= " + maxLine.length()
                    + ", full line: '" + maxLine + "'");
            writer.write("\nMax line: " + maxLineCount + " length= " + maxLine.length()
                    + ", full line: '" + maxLine + "'");
        } catch (IOException e) {
            System.out.println("Eroare citire fisier:" + e);
        }


        try (Stream<String> lines = Files.lines(fisier.toPath())) {

            Map<Object, Long> wordMap;//IntStream (de primitive!)
            wordMap = lines.flatMap(line -> Arrays.stream(line.trim().split("\\s+")).sorted())
                    .collect(Collectors.groupingBy(s -> s, Collectors.counting()));

            List<Map.Entry<Object, Long>> top5Words;
            top5Words = wordMap
                    .entrySet()
                    .stream()
                    .limit(5)
                    .collect(Collectors.toList());


            System.out.println("Word usage count:  " + wordMap);
            writer.write("\nWord usage count:  " + wordMap);

            System.out.println("top 5: " + top5Words);
            writer.write("\ntop 5: " + top5Words);

        } catch (IOException e) {
            e.printStackTrace();
        }


        try (Stream<String> lines = Files.lines(fisier.toPath())) {

            int wordCount = lines

                    //version1: map to objects (Integer), then reduce()
                    //.map(line -> line.trim().split("\\s+").length) //Stream<Integer> //obiect!
                    //.reduce(0, (i, j) -> i+j)

                    //version2: map to primitive stream
                    .mapToInt(line -> line.trim().split("\\s+").length) //IntStream (de primitive!)
                    .sum();

            System.out.println("Numar total cuvinte: " + wordCount);
            writer.write("\nNumar total cuvinte: " + wordCount);
            writer.close();
        } catch (
                IOException e) {
            System.out.println("Eroare citire fisier:" + e);
        }


    }

    static void createFile() throws IOException {
        File file = new File("file_statistics.txt");
        if (file.createNewFile()) {
            System.out.println("File created: " + file.getName());
        } else {
            System.out.println("File already exists.");
        }
    }

}

