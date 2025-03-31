package com.bridgelabz.filterstreams;

import java.io.*;

public class ConvertToLowercase {
    public static void main(String[] args) {
        String sourceFile = "/Users/prakulagarwal/Desktop/bridgelabz-workspace/java-streams/src/main/java/com/bridgelabz/filterstreams/source.txt";
        String destinationFile = "/Users/prakulagarwal/Desktop/bridgelabz-workspace/java-streams/src/main/java/com/bridgelabz/filterstreams/destination.txt";

        try (
                // Using BufferedReader to read the file efficiently
                BufferedReader reader = new BufferedReader(new FileReader(sourceFile));
                // Using BufferedWriter to write the modified content to the new file
                BufferedWriter writer = new BufferedWriter(new FileWriter(destinationFile))
        ) {
            String line;
            while ((line = reader.readLine()) != null) {
                // Convert the line to lowercase and write it to the output file
                writer.write(line.toLowerCase());
                writer.newLine();
            }
            System.out.println("File content converted to lowercase and written to " + destinationFile);
        } catch (FileNotFoundException e) {
            System.out.println("Source file not found: " + sourceFile);
        } catch (IOException e) {
            System.out.println("An error occurred while reading or writing the file: " + e.getMessage());
        }
    }
}

