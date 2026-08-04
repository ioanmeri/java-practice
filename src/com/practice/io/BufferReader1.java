package com.practice.io;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

public class BufferReader1 {

    public static void main(String[] args) {
        try(Reader r = new BufferedReader(new FileReader("c:\\tmp\\testLetters.txt"))){
            if(r.markSupported()){
                BufferedReader in = (BufferedReader) r;
                System.out.println(in.readLine());
                in.mark(100);
                System.out.println(in.readLine());
                System.out.println(in.readLine());
                in.reset();
                System.out.println(in.readLine());
                in.reset();
                System.out.println(in.readLine());
            } else {
                System.out.println("Mark Not Supported");
            }
        } catch (IOException e){
            e.printStackTrace();
        }
    }
}
