package teme.w09_exceptions_files.ex3_persons_csv;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

class PersonCsvUtils {

    static List<Person> loadFromCsvFile(String fileName) {

        //Steps:
        // -read all lines from file
        // -convert each line to a person (if possible)
        // -add persons to the result list
        // -return the list

        File file = new File(fileName);
        System.out.println("File found?: " + file.exists());

        //using Files.lines with stream ops
        try (Stream<String> lines = Files.lines(file.toPath())) { //to autoclose it
            return lines
                    .map(line -> Person.convertFromLine(line))
                    .filter(person -> person != null)
                    .collect(Collectors.toList());
        } catch (IOException e) { //in case we failed to open/read from file
            return new ArrayList<>(); //return empty list (nicer than null) in case we failed to read the file
        }
    }

    static void writeToCsvFile(String fileName, List<Person> persons) {

        //Steps:
        // - iterate over persons list
        // - convert each person to a csv line
        // - write all lines to the new file (with the given filename)
        // - close file

        //write to file using FileWriter - see https://www.w3schools.com/java/java_files_create.asp

        try (FileWriter writer = new FileWriter(fileName)) { //try-with-resources, for autoclose of writer
            for (Person p : persons) {
                String linie = p.convertToLine();
                writer.write(linie + "\n");
            }
        } catch (IOException e) {
            System.out.println("Sorry, failed to write persons to file: " + e);
        }
    }
}
