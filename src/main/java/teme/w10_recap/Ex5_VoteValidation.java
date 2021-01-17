package teme.w10_recap;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Ex5_VoteValidation {

    public static void main(String[] args) {
        String votingLocation = "iasi_sectia1";
        String fileName = "src/main/resources/VoteValidation/input/" + votingLocation + ".csv";
        Person Adrian = new Person("Adrian Grigore", "1900309090034", "2012-07-10 14:58:00");
        Person Mircea = new Person("Mircea Matei", "1900309090034", "2012-07-11 14:58:00");
        Person Andrei = new Person("Andrei Mihalcea", "1970902090034", "2019-07-10 14:58:00");
        Person Mihai = new Person("Mihai Sebastian", "189090034", "2019-07-10 14:58:00");
        Person Ion = new Person("Ion Pavel", "1890910100034", "14:58:00 2019-07-10");
        Person Catalin = new Person("Catalin Dimitrie", "1890100034", "14:58:00 2019-07-10");
        Person Marcel = new Person("Marcel", "189100034", "14:58:00 2019-07-10");
        Person Ab = new Person("Ab Ion", "189100034", "14:58:00 2019-07-10");
        List<Person> persons = Arrays.asList(Adrian, Andrei, Mihai, Ion, Catalin, Marcel, Ab, Mircea);


        programOperations(fileName, persons);

    }

    private static void programOperations(String fileName, List<Person> persons) {
        createFolders();
        createInputFile(fileName);
        writeToInputCsvFile(fileName, persons);
        createAndWriteValidOutputFile(fileName, persons);
        createAndWriteInvalidOutputFile(fileName, persons);
        moveInputFileToArchive(fileName);
    }

    private static void moveInputFileToArchive(String fileName) {
        try {
            File inputFile = new File(fileName);


            if (inputFile.renameTo(new File("src/main/resources/VoteValidation/input_archive/" + inputFile.getName()))) {
                System.out.println("File is moved successful!");
            } else {
                System.out.println("File failed to move!");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void createFolders() {
        File input = new File("src/main/resources/VoteValidation/input");

        File inputArchive = new File("src/main/resources/VoteValidation/input_archive");

        File outputValid = new File("src/main/resources/VoteValidation/output_valid");

        File outputInvalid = new File("src/main/resources/VoteValidation/output_invalid");

        File[] files = new File[]{input, inputArchive, outputInvalid, outputValid};
        for (File f : files) {
            if (f.mkdirs()) {
                System.out.println(f + " is created!");
            } else {
                System.out.println(f + " is not created or exists!");
            }

        }


    }

    private static void createInputFile(String fileName) {
        String votingLocation = fileName.substring(fileName.lastIndexOf("input") + 6, fileName.lastIndexOf(".csv"));
        File file = new File("src/main/resources/VoteValidation/input/" + votingLocation + ".csv");
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

    private static void createAndWriteValidOutputFile(String fileName, List<Person> persons) {
        String out = new SimpleDateFormat("yyyy-MM-dd hh-mm-ss'.csv'").format(new Date());
        File file = new File("src/main/resources/VoteValidation/output_valid/valid_" + out);
        try {
            if (file.createNewFile()) {
                System.out.println("File created: " + file.getName());
            } else {
                System.out.println("File already exists.");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        writeToValidOutputCsvFile(file.getAbsolutePath(), fileName, persons);
    }

    private static void createAndWriteInvalidOutputFile(String fileName, List<Person> persons) {
        String out = new SimpleDateFormat("yyyy-MM-dd hh-mm-ss'.csv'").format(new Date());
        File file = new File("src/main/resources/VoteValidation/output_invalid/invalid_" + out);
        try {
            if (file.createNewFile()) {
                System.out.println("File created: " + file.getName());
            } else {
                System.out.println("File already exists.");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        writeToInvalidOutputCsvFile(file.getAbsolutePath(), fileName, persons);
    }

    private static void writeToInputCsvFile(String fileName, List<Person> persons) {

        try (FileWriter writer = new FileWriter(fileName)) {
            for (Person p : persons) {
                String line = p.convertToLine();
                writer.write(line + "\n");
            }
        } catch (IOException e) {
            System.out.println("Sorry, failed to write persons to file: " + e);
        }
    }

    private static List<Person> loadFromCsvFile(String fileName) {

        File file = new File(fileName);
        System.out.println("File found?: " + file.exists());

        try (Stream<String> lines = Files.lines(file.toPath())) {
            return lines
                    .map(line -> Person.convertFromLine(line))
                    .filter(person -> person != null)
                    .collect(Collectors.toList());
        } catch (IOException e) {
            return new ArrayList<>();
        }
    }

    private static <T> Predicate<T> distinctBy(Function<? super T, String> keyExtractor) {
        Map<Object, Boolean> map = new ConcurrentHashMap<>();
        return t -> map.putIfAbsent(keyExtractor.apply(t), Boolean.TRUE) == null;
    }

    private static void writeToValidOutputCsvFile(String fileOutput, String fileName, List<Person> persons) {

        Set<Person> validOutput = loadFromCsvFile(fileName)
                .stream()
                .filter(i -> i.getName().contains(" "))
                .filter(i -> i.getName().substring(i.getName().indexOf(" ") + 1, i.getName().length()).length() >= 3)
                .filter(i -> i.getName().substring(0, i.getName().indexOf(" ")).length() >= 3)
                .filter(i -> i.getCnp().length() == 13)
                .filter(distinctBy(i -> i.getCnp()))
                .filter(i -> 120 - Integer.parseInt(i.getCnp().substring(1, 3)) >= 18)
                .filter(i -> !i.getDate().contains("wrong data format"))
                .collect(Collectors.toSet());

        try (FileWriter writer = new FileWriter(fileOutput)) {
            writer.write("voting location    name             cnp              date \n");
            for (Person p : validOutput) {
                String line = fileName.substring(fileName.lastIndexOf("input") + 6, fileName.lastIndexOf(".csv"))
                        + ", " + p.getName() + ", " + p.getCnp() + ", " + p.getDate();
                writer.write(line + "\n");
            }
        } catch (IOException e) {
            System.out.println("Sorry, failed to write persons to file: " + e);
        }
    }

    private static void writeToInvalidOutputCsvFile(String fileOutput, String fileName, List<Person> persons) {

        Set<Person> validOutput = loadFromCsvFile(fileName)
                .stream()
                .filter(i -> i.getName().contains(" "))
                .filter(i -> i.getName().substring(i.getName().indexOf(" ") + 1, i.getName().length()).length() >= 3)
                .filter(i -> i.getName().substring(0, i.getName().indexOf(" ")).length() >= 3)
                .filter(i -> i.getCnp().length() == 13)
                .filter(distinctBy(i -> i.getCnp()))
                .filter(i -> 120 - Integer.parseInt(i.getCnp().substring(1, 3)) >= 18)
                .filter(i -> !i.getDate().contains("wrong data format"))
                .collect(Collectors.toSet());

        List<Person> invalidOutput = loadFromCsvFile(fileName);
        invalidOutput.removeAll(new ArrayList<>(validOutput));

        try (FileWriter writer = new FileWriter(fileOutput)) {
            writer.write("error message    voting location             row data               \n");
            for (Person p : invalidOutput) {
                String votingLocation = fileName.substring(fileName.lastIndexOf("input") + 6, fileName.lastIndexOf(".csv"));
                if (p.getName() == null || p.getCnp() == null || p.getDate() == null) {
                    String line = "missing columns, " + votingLocation
                            + ", " + p.getName() + ", " + p.getCnp() + ", " + p.getDate();
                    writer.write(line + "\n");
                }
                if (p.getCnp().length() != 13 || p.getCnp().length() == 13 && !p.getCnp().matches("\\d+")) {
                    String line = "wrong cnp format, " + votingLocation
                            + ", " + p.getName() + ", " + p.getCnp() + ", " + p.getDate();
                    writer.write(line + "\n");
                }
                if (p.getCnp().length() == 13 && p.getCnp().matches("\\d+")) {
                    String line = "duplicate cnp, " + votingLocation
                            + ", " + p.getName() + ", " + p.getCnp() + ", " + p.getDate();
                    writer.write(line + "\n");
                }
                if (!p.getName().contains(" ")
                        || p.getName().substring(p.getName().indexOf(" ") + 1, p.getName().length()).length() < 3
                        || p.getName().substring(0, p.getName().indexOf(" ")).length() < 3) {
                    String line = "invalid name, " + votingLocation
                            + ", " + p.getName() + ", " + p.getCnp() + ", " + p.getDate();
                    writer.write(line + "\n");
                }
                if (p.getDate().contains("wrong")) {
                    String line = "wrong data format, " + votingLocation
                            + ", " + p.getName() + ", " + p.getCnp() + ", " + p.getDate();
                    writer.write(line + "\n");
                }
            }
        } catch (IOException e) {
            System.out.println("Sorry, failed to write persons to file: " + e);
        }
    }
}

class Person {

    private String name;
    private String cnp;
    private String date;


    public String getName() {
        return name;
    }

    public String getCnp() {
        return cnp;
    }

    public String getDate() {
        return date;
    }

    public Person(String name, String cnp, String date) {
        this.name = name;
        this.cnp = cnp;
        this.date = date;
    }

    String convertToLine() {

        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        try {
            return name + "," + cnp + "," + format.parse(date);

        } catch (Exception e) {
            return name + "," + cnp + "," + " wrong data format";
        }
    }

    static Person convertFromLine(String line) {
        SimpleDateFormat format = new SimpleDateFormat("yyy-MM-dd HH:mm:ss");

        String[] parts = line.split(",\\s*");
        try {
            return new Person(parts[0], parts[1], parts[2]);
        } catch (Exception e) {
            System.out.println("failed to convert line to person: '" + line + "'" +
                    ", because: " + e);
            return null;
        }
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", cnp='" + cnp + '\'' +
                ", date='" + date + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return Objects.equals(name, person.name) &&
                Objects.equals(cnp, person.cnp) &&
                Objects.equals(date, person.date);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, cnp, date);
    }


}
