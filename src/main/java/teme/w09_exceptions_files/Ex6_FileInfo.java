package teme.w09_exceptions_files;

import java.io.File;
import java.text.SimpleDateFormat;

class Ex6_FileInfo {

    public static void main(String[] args) {

        File file = new File("src/main/java/teme/w09_exceptions_files/ex3_persons_csv/persons_sorted.csv");

        System.out.println("File exists: " + file.exists());

        System.out.println("File absolute path: " + file.getAbsolutePath());

        System.out.println("Is dir: " + file.isDirectory());

        System.out.println("File size: " + file.length() + " bytes");

        SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");

        System.out.println("File last update: " + sdf.format(file.lastModified()));
    }
}
