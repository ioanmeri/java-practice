package com.practice.io;

import java.io.RandomAccessFile;

public class RandomAccessFileDemo {

    public static void main(String[] args) {
        try (RandomAccessFile raf = new RandomAccessFile("example.txt", "rw")) {

            // Write some data
            raf.writeInt(100);       // 4 bytes
            raf.writeDouble(3.14);   // 8 bytes
            raf.writeUTF("Hello");   // UTF string

            System.out.println("File pointer after writing: " + raf.getFilePointer());

            // Seek back to the beginning
            raf.seek(0);

            // Read the data in the same order
            int number = raf.readInt();
            double pi = raf.readDouble();
            String text = raf.readUTF();

            System.out.println("Read int: " + number);
            System.out.println("Read double: " + pi);
            System.out.println("Read UTF: " + text);

            // Seek to the double value only (skip the int)
            raf.seek(4);
            double piAgain = raf.readDouble();
            System.out.println("Read double again using seek: " + piAgain);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

// | Mode    | Meaning                                                |
//| ------- | ------------------------------------------------------ |
//| `"r"`   | Read only                                              |
//| `"rw"`  | Read and write                                         |
//| `"rws"` | Read/write + synchronously update content and metadata |
//| `"rwd"` | Read/write + synchronously update content only         |


// Another Demo: write chars at the end of the file

// RandomAccessFile raf = new RandomAccessFile("file.txt", "rw");
// raf.seek( raf.length() );
// raf.writeChars("FINAL TEXT");

