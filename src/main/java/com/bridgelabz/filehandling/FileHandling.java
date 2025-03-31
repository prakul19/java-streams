package com.bridgelabz.filehandling;

import java.io.*;
import java.util.Scanner;

public class FileHandling {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            System.out.print("Enter the name of the source file: ");
            String sourceFile = scanner.nextLine();

            System.out.print("Enter the name of the destination file: ");
            String destinationFile = scanner.nextLine();

            // File handling with proper exception handling
            try (FileInputStream fis = new FileInputStream(sourceFile);
                 FileOutputStream fos = new FileOutputStream(destinationFile)) {

                // Read from source file and write to destination file
                int byteData;
                while ((byteData = fis.read()) != -1) {
                    fos.write(byteData);
                }

                System.out.println("File copied successfully!");
            } catch (FileNotFoundException e) {
                System.out.println("Source file does not exist: " + sourceFile);
            } catch (IOException e) {
                System.out.println("An error occurred while reading or writing the file: " + e.getMessage());
            }
        } catch (Exception e) {
            System.out.println("An unexpected error occurred.");
        } finally {
            scanner.close();
        }
    }
}


