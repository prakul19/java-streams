package com.bridgelabz.userinputtofile;

import java.io.*;

public class UserInputToFile {
    public static void main(String[] args) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = "/Users/prakulagarwal/Desktop/bridgelabz-workspace/java-streams/src/main/java/userinputtofile/userInfo.txt";

        try (FileWriter writer = new FileWriter(fileName)) {
            // Ask user for their name, age, and favorite programming language
            System.out.print("Enter your name: ");
            String name = reader.readLine();

            System.out.print("Enter your age: ");
            String age = reader.readLine();

            System.out.print("Enter your favorite programming language: ");
            String programmingLanguage = reader.readLine();

            // Write the information to the file
            writer.write("Name: " + name + "\n");
            writer.write("Age: " + age + "\n");
            writer.write("Favorite Programming Language: " + programmingLanguage + "\n");

            System.out.println("Information saved to " + fileName);

        } catch (IOException e) {
            System.out.println("An error occurred: " + e.getMessage());
        }
    }
}

