package com.bridgelabz.countwordsinfile;

import java.io.*;
import java.util.*;

public class WordFrequencyCounter {
    public static void main(String[] args) {
        String fileName = "/Users/prakulagarwal/Desktop/bridgelabz-workspace/java-streams/src/main/java/com/bridgelabz/countwordsinfile/input.txt";

        // HashMap to store word frequencies
        Map<String, Integer> wordCount = new HashMap<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;

            // Read the file line by line
            while ((line = reader.readLine()) != null) {
                // Split the line into words
                String[] words = line.toLowerCase().split("\\W+");
                for (String word : words) {
                    if (!word.isEmpty()) {
                        wordCount.put(word, wordCount.getOrDefault(word, 0) + 1);
                    }
                }
            }

            // Sort the map by frequency in descending order
            List<Map.Entry<String, Integer>> sortedWords = new ArrayList<>(wordCount.entrySet());
            sortedWords.sort((e1, e2) -> e2.getValue().compareTo(e1.getValue()));

            // Display the top 5 most frequent words
            System.out.println("Top 5 most frequent words:");
            for (int i = 0; i < Math.min(5, sortedWords.size()); i++) {
                Map.Entry<String, Integer> entry = sortedWords.get(i);
                System.out.println(entry.getKey() + ": " + entry.getValue());
            }

        } catch (FileNotFoundException e) {
            System.out.println("The file " + fileName + " was not found.");
        } catch (IOException e) {
            System.out.println("An error occurred while reading the file: " + e.getMessage());
        }
    }
}

