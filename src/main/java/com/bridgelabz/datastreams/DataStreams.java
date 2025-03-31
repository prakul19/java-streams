package com.bridgelabz.datastreams;

import java.io.*;
import java.util.Scanner;

public class DataStreams {
    public static void main(String[] args) {
        String fileName = "studentData.bin";
        Scanner scanner = new Scanner(System.in);

        try (DataOutputStream dos = new DataOutputStream(new FileOutputStream(fileName))) {
            System.out.print("Enter the number of students: ");
            int numberOfStudents = scanner.nextInt();
            scanner.nextLine();

            for (int i = 0; i < numberOfStudents; i++) {
                System.out.println("Enter details for student " + (i + 1) + ":");
                System.out.print("Roll Number: ");
                int rollNumber = scanner.nextInt();
                scanner.nextLine();

                System.out.print("Name: ");
                String name = scanner.nextLine();

                System.out.print("GPA: ");
                double gpa = scanner.nextDouble();
                scanner.nextLine();

                // Write student details to the binary file
                dos.writeInt(rollNumber);
                dos.writeUTF(name);
                dos.writeDouble(gpa);
            }

            System.out.println("Student details have been saved to the file.");
        } catch (IOException e) {
            System.out.println("An error occurred while writing to the file: " + e.getMessage());
        }

        // Retrieve student details
        try (DataInputStream dis = new DataInputStream(new FileInputStream(fileName))) {
            System.out.println("\nRetrieved student details:");
            while (dis.available() > 0) {
                int rollNumber = dis.readInt();
                String name = dis.readUTF();
                double gpa = dis.readDouble();

                System.out.println("Roll Number: " + rollNumber);
                System.out.println("Name: " + name);
                System.out.println("GPA: " + gpa);
            }
        } catch (IOException e) {
            System.out.println("An error occurred while reading from the file: " + e.getMessage());
        } finally {
            scanner.close();
        }
    }
}


