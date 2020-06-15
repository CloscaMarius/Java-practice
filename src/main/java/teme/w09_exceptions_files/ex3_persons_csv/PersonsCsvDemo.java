package teme.w09_exceptions_files.ex3_persons_csv;

import java.io.File;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static java.io.File.separator;

class PersonsCsvDemo {
    public static void main(String[] args) {

        //String baseFolder = tryToGetParentFolderOfThisClass();
        //if the line above doesn't work correctly, you may have to manually set a base path like this:
        String baseFolder = "src/main/java/teme/w09_exceptions_files/ex3_persons_csv/"; //relative path, linux/mac style but ok also on windows (accepts '/' as separator)

        String inputFile = baseFolder + "persons.csv";
        String outputFile = baseFolder + "persons_sorted.csv";

        //just check file path is correct:
        System.out.println("Input file full path: " + new File(inputFile).getAbsolutePath());
        System.out.println("Input file exits?: " + new File(inputFile).exists());

        List<Person> persons = PersonCsvUtils.loadFromCsvFile(inputFile);
        System.out.println("\nLoaded " + persons.size() + " valid persons from file " + inputFile + ":");
        persons.forEach(System.out::println);

        Collections.sort(persons);
        System.out.println("\nPersons list after sorting: ");
        persons.forEach(System.out::println);

        System.out.println("\nWriting sorted persons list to csv file: " + outputFile);
        PersonCsvUtils.writeToCsvFile(outputFile, persons);


        findHighestPerson(persons);
    }

    private static void findHighestPerson(List<Person> persons) {
        System.out.println("\nSearching for highest person:");


        Optional<Person> highestPerson = persons.stream()
                .sorted((p1, p2) -> Integer.compare(p2.getHeight(), p1.getHeight()))
                .findFirst();

        System.out.println("Highest person:" + highestPerson);
    }

    /**
     * Utility method, doing ugly stuff to try to compute current folder where the source code
     * of this class is located (and also the csv files) - probably works only when run from IntelliJ !
     */
    private static String tryToGetParentFolderOfThisClass() {
        String path = PersonsCsvDemo.class.getClassLoader().getResource(".").getPath();
        String pkg = PersonsCsvDemo.class.getPackage().getName();
        String newPath = path.replace(
                "build" + separator + "classes" + separator + "java" + separator + "main",
                "src" + separator + "main" + separator + "java" + separator + pkg.replace(".", separator));
        //System.out.println("path: " + path);
        //System.out.println("package: " + pkg);
        System.out.println("computed base path: " + newPath);
        return newPath;
    }
}
