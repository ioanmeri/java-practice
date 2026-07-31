package com.practice.io;

import java.io.FileInputStream;
import java.io.InputStreamReader;

public class IO1 {
    public static void main(String[] args) throws Exception{
        // test content: 12345678
        try(var fis = new FileInputStream("c:\\tmp\\test.txt");
            var isr = new InputStreamReader(fis)){
            while(isr.ready()){
                isr.skip(1);
                int i = isr.read();
                char c = (char) i;
                System.out.print(c);
            }
        }
    }
}

// ready()
// - Returns true if the next read() is guaranteed not to block.
// - for a file: there is another character available to read.

// skip()
// - It simply advances the reading position.

// What does read() return?
// - the Unicode value of the character
// - or -1 if EOF is reached

