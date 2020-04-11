package teme.w09_exceptions_files;

import java.io.File;
import java.io.FileFilter;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

class Ex8_FindFilesByName {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Please input the base path: ");
        String basePath = scanner.nextLine();

        System.out.println("Please input the name pattern: ");
        String namePattern = scanner.nextLine();

        File dir = new File(basePath);

        FileFilter filter = new FileFilter() {
            @Override
            public boolean accept(File dir) {
                if (dir.getName().toLowerCase().contains(namePattern.toLowerCase())) {
                    return true;
                } else {
                    return false;
                }
            }
        };

        List<File> files = Arrays.asList(dir.listFiles(filter));

        if (files == null) {

            System.out.println("Either dir does not exist or is not a directory");

        } else if (files.stream().map(f -> f.getName()).noneMatch(f -> f.toLowerCase().contains(namePattern.toLowerCase()))) {

            System.out.println("\nNo files found matching pattern: '" + namePattern + "'");

        } else {

            for (File file : files) {
                System.out.println("\nFile found: " + file.getName() +
                        "\nFile path: " + file.getAbsolutePath() +
                        "\nFile size: " + file.length() + " bytes" +
                        "\nIt's a dir: " + file.isDirectory());
            }
        }

    }


}

