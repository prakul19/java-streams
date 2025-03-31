package com.bridgelabz.pipedstreams;

import java.io.*;

public class PipedStream {

    public static void main(String[] args) {
        // Create piped input and output streams
        PipedInputStream pipedInputStream = new PipedInputStream();
        PipedOutputStream pipedOutputStream = new PipedOutputStream();

        try {
            // Connect the piped streams
            pipedInputStream.connect(pipedOutputStream);

            // Create a writer thread
            Thread writerThread = new Thread(new WriterTask(pipedOutputStream));
            // Create a reader thread
            Thread readerThread = new Thread(new ReaderTask(pipedInputStream));

            // Start both threads
            writerThread.start();
            readerThread.start();

        } catch (IOException e) {
            System.out.println("An error occurred while connecting piped streams: " + e.getMessage());
        }
    }
}

// Writer task writes data to PipedOutputStream
class WriterTask implements Runnable {
    private PipedOutputStream outputStream;

    public WriterTask(PipedOutputStream outputStream) {
        this.outputStream = outputStream;
    }

    @Override
    public void run() {
        try {
            // Writing data to the piped output stream
            for (int i = 1; i <= 5; i++) {
                String message = "Message " + i;
                outputStream.write(message.getBytes());
                System.out.println("Writer: Wrote - " + message);
                Thread.sleep(500); // Simulate some delay
            }
            outputStream.close();
        } catch (IOException | InterruptedException e) {
            System.out.println("Writer encountered an error: " + e.getMessage());
        }
    }
}

// Reader task reads data from PipedInputStream
class ReaderTask implements Runnable {
    private PipedInputStream inputStream;

    public ReaderTask(PipedInputStream inputStream) {
        this.inputStream = inputStream;
    }

    @Override
    public void run() {
        try {
            // Reading data from the piped input stream
            byte[] buffer = new byte[1024];
            int bytesRead;
            while ((bytesRead = inputStream.read(buffer)) != -1) {
                String message = new String(buffer, 0, bytesRead);
                System.out.println("Reader: Received - " + message);
            }
            inputStream.close();
        } catch (IOException e) {
            System.out.println("Reader encountered an error: " + e.getMessage());
        }
    }
}

