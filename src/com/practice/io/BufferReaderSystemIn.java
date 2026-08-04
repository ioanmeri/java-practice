package com.practice.io;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BufferReaderSystemIn {

    public static void main(String[] args) throws Exception {
        try(var bfr = new BufferedReader(new InputStreamReader(System.in))){
            System.out.println("Enter Number:");
            var s = bfr.readLine();
            System.out.println("Your Number is :" + s);
        } catch(Exception e){
            e.printStackTrace();
        }
    }
}

