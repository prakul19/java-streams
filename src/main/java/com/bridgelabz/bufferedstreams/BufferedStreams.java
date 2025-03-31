package com.bridgelabz.bufferedstreams;

import java.io.*;

public class BufferedStreams {
    public static void main(String[] args) {
        String sourceFile = "/Users/prakulagarwal/Desktop/bridgelabz-workspace/java-streams/src/main/java/com/bridgelabz/bufferedstreams/large.txt";
        String destinationBuffered = "/Users/prakulagarwal/Desktop/bridgelabz-workspace/java-streams/src/main/java/com/bridgelabz/bufferedstreams/buffered.txt";
        String destinationUnbuffered = "/Users/prakulagarwal/Desktop/bridgelabz-workspace/java-streams/src/main/java/com/bridgelabz/bufferedstreams/unbuffered.txt";

        try {
            // Copy using buffered streams
            long bufferedStart = System.nanoTime();
            copyUsingBufferedStreams(sourceFile, destinationBuffered);
            long bufferedEnd = System.nanoTime();
            System.out.println("Buffered Stream Time: " + (bufferedEnd - bufferedStart) + " nanoseconds");

            // Copy using normal streams
            long unbufferedStart = System.nanoTime();
            copyUsingNormalStreams(sourceFile, destinationUnbuffered);
            long unbufferedEnd = System.nanoTime();
            System.out.println("Unbuffered Stream Time: " + (unbufferedEnd - unbufferedStart) + " nanoseconds");

        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    // Method to copy file using BufferedInputStream and BufferedOutputStream
    public static void copyUsingBufferedStreams(String source, String destination) throws IOException {
        try (BufferedInputStream bis = new BufferedInputStream(new FileInputStream(source));
             BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(destination))) {

            byte[] buffer = new byte[4096];
            int bytesRead;
            while ((bytesRead = bis.read(buffer)) != -1) {
                bos.write(buffer, 0, bytesRead);
            }
        }
    }

    // Method to copy file using normal FileInputStream and FileOutputStream
    public static void copyUsingNormalStreams(String source, String destination) throws IOException {
        try (FileInputStream fis = new FileInputStream(source);
             FileOutputStream fos = new FileOutputStream(destination)) {

            int byteData;
            while ((byteData = fis.read()) != -1) {
                fos.write(byteData);
            }
        }
    }
}

