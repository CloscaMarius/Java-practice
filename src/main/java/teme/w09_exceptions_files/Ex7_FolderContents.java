package teme.w09_exceptions_files;

import java.io.File;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

class Ex7_FolderContents {

    public static void main(String[] args) {

        String dirName = "C:\\Users\\Marius\\Desktop\\teme_marius_closca\\src\\main\\java\\teme\\w09_exceptions_files";


        try {
            File dir = new File(dirName);
            List<File> filesList = Arrays.asList(dir.listFiles())
                    .stream()
                    .sorted((p1, p2) -> Long.compare(p2.length(), p1.length()))
                    .collect(Collectors.toList());

            for (File file : filesList) {
                System.out.println("File name: " + file.getName() + ", size: " + file.length() + " bytes");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
