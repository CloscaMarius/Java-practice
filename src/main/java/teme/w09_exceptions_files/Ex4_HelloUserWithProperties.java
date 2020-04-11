package teme.w09_exceptions_files;

import java.io.*;
import java.util.Date;
import java.util.Properties;
import java.util.Scanner;

class Ex4_HelloUserWithProperties {

    public static void main(String[] args) {


        Scanner scanner = new Scanner(System.in);

        try (InputStream input = new FileInputStream("user.properties")) {


            Scanner myReader = new Scanner("user.properties");
            Properties prop = new Properties();
            prop.load(input);
            String lastVisit = prop.getProperty("last_visit_time");
            String username = prop.getProperty("username");

            if (myReader.hasNextLine() && (username != null) && (lastVisit != null)) {

                System.out.println("Hello " + username + ", nice to see you again! (have't seen you since: " + lastVisit + ")");
            } else {
                try (OutputStream output = new FileOutputStream("user.properties")) {
                    System.out.println("Hello, stranger. Please enter your name:");
                    String userName = scanner.next();
                    Date date = new Date();
                    System.out.println("Hello " + userName + ", nice to meet you!");
                    prop.setProperty("username", userName);
                    prop.setProperty("last_visit_time", date.toString());
                    prop.store(output, null);
                }
            }

        } catch (FileNotFoundException e) {
            try {
                File myObj = new File("user.properties");
                if (myObj.createNewFile()) {
                    System.out.println("File created: " + myObj.getName());
                    try (OutputStream output = new FileOutputStream("user.properties")) {
                        Properties prop = new Properties();
                        System.out.println("Hello, stranger. Please enter your name:");
                        String userName = scanner.nextLine();
                        Date date = new Date();
                        System.out.println("Hello " + userName + ", nice to meet you!");
                        prop.setProperty("username", userName);
                        prop.setProperty("last_visit_time", date.toString());
                        prop.store(output, null);
                    }
                } else {
                    System.out.println("File already exists.");
                }
            } catch (IOException ex) {
                System.out.println("An error occurred.");
                e.printStackTrace();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}




