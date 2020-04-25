package teme.w10_recap;

import java.io.File;
import java.io.IOException;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Ex6_DuplicateFileFinder {

    public static void main(String[] args) {

        String folderPath = "C:\\Users\\Marius\\Desktop\\New folder";

        //getDuplicateFilesByName(folderPath);

        //getDuplicateFilesBySize(folderPath);

        getDuplicateFilesByContent(folderPath);


    }

    private static List<File> getDuplicateFilesByName(String folderPath) {

        List<File> files = new ArrayList<>();

        fileList(folderPath, files);

        files = files.stream()
                .sorted(Comparator.comparing(File::getName))
                .collect(Collectors.toList());


        List<File> duplicateFiles = new ArrayList<>();

        for (int i = 0; i < files.size() - 1; i++) {
            if (files.get(i).getName().equals(files.get(i + 1).getName())) {
                duplicateFiles.add(files.get(i));
                duplicateFiles.add(files.get(i + 1));
            }
        }

        duplicateFiles = duplicateFiles.stream().distinct()
                .sorted(Comparator.comparing(File::getName))
                .collect(Collectors.toList());

        System.out.println("Duplicate files by name: ");
        duplicateFiles.stream().forEach(i -> System.out.println("\nFile: " + i.getName() + "\nsize: " + i.length() + " bytes" + "\npath: " + i.getAbsolutePath()));
        return duplicateFiles;

    }

    private static List<File> getDuplicateFilesBySize(String folderPath) {

        List<File> files = new ArrayList<>();

        fileList(folderPath, files);

        files = files.stream()
                .sorted(Comparator.comparing(File::length))
                .collect(Collectors.toList());


        List<File> duplicateFiles = new ArrayList<>();

        for (int i = 0; i < files.size() - 1; i++) {
            if (files.get(i).length() == files.get(i + 1).length()) {
                duplicateFiles.add(files.get(i));
                duplicateFiles.add(files.get(i + 1));
            }
        }

        duplicateFiles = duplicateFiles.stream().distinct()
                .sorted(Comparator.comparing(File::length))
                .collect(Collectors.toList());

        System.out.println("Duplicate files by size: ");
        duplicateFiles.stream().forEach(i -> System.out.println("\nFile: " + i.getName() + "\nsize: " + i.length() + " bytes" + "\npath: " + i.getAbsolutePath()));
        return duplicateFiles;
    }

    private static List<File> getDuplicateFilesByContent(String folderPath) {
        List<File> contentDuplicate = new ArrayList<>();
        List<File> sizeDuplicate = getDuplicateFilesBySize(folderPath);
        String firstFileLine = "";
        String secondFileLine = "";
        for (int i = 0; i < sizeDuplicate.size() - 1; i++) {
            try (Scanner scanner = new Scanner(sizeDuplicate.get(i))) {
                firstFileLine += scanner.nextLine();
                while (scanner.hasNext()) {
                    scanner.nextLine();
                }

            } catch (IOException e) {
                System.out.println("Eroare citire fisier:" + e);
            }
            try (Scanner scanner = new Scanner(sizeDuplicate.get(i + 1))) {
                secondFileLine += scanner.nextLine();
                while (scanner.hasNext()) {
                    scanner.nextLine();
                }
            } catch (IOException e) {
                System.out.println("Eroare citire fisier:" + e);
            }
            if (firstFileLine.equals(secondFileLine)) {
                contentDuplicate.add(sizeDuplicate.get(i));
                contentDuplicate.add(sizeDuplicate.get(i + 1));
            }
        }

        System.out.println("Duplicate files by content: ");
        contentDuplicate.stream().forEach(i -> System.out.println("\nFile: " + i.getName() + "\nsize: " + i.length() + " bytes" + "\npath: " + i.getAbsolutePath()));
        return contentDuplicate;
    }

    private static void fileList(String folderPath, List<File> files) {
        File dir = new File(folderPath);

        File[] fList = dir.listFiles();

        if (fList != null) {
            for (File file : fList) {
                if (file.isFile()) {
                    files.add(file);
                } else if (file.isDirectory()) {
                    fileList(file.getAbsolutePath(), files);
                }
            }
        }
    }

    private static <T> Predicate<T> distinctBy(Function<? super T, String> keyExtractor) {
        Map<Object, Boolean> map = new ConcurrentHashMap<>();
        return t -> map.putIfAbsent(keyExtractor.apply(t), Boolean.TRUE) == null;
    }
}
