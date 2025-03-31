package com.bridgelabz.largefilereader;

import java.io.*;

public class LargeFileReader {
    public static void main(String[] args) {
        String fileName = "/Users/prakulagarwal/Desktop/bridgelabz-workspace/java-streams/src/main/java/com/bridgelabz/largefilereader/largefile.txt";

        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = reader.readLine()) != null) {
                // Check if the line contains the word "error"
                if (line.toLowerCase().contains("error")) {
                    System.out.println(line);
                }
            }
        } catch (IOException e) {
            System.out.println("An error occurred while reading the file: " + e.getMessage());
        }
    }
}

