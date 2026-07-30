package com.practice.tryWithResources;

import java.io.IOException;

public class Device implements AutoCloseable{
    boolean open = false;
    public Device(){
        open = true;
    }

    public String read() throws IOException{
        throw new IOException("Can't read!");
    }

    public boolean isOpened(){
        return open;
    }

    public void close(){
        open = false;
        System.out.println("Device closed");
    }

    public static void main(String[] args) {
        Device d1 = new Device();
        try(d1;
            Device d2 = new Device();
            Device d3 = new Device()){
            d2.read();
        }catch(Exception e){
            System.out.println("Got Exception "+e.getMessage());
        }
    }
}
