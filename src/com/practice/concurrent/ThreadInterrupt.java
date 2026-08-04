package com.practice.concurrent;

class A extends Thread {
    public void run(){
        System.out.println("Starting loop");
        try {
          Thread.sleep(10000);
        } catch (Exception e){
            e.printStackTrace();
        }
        System.out.println("Ending loop");
    }
}

public class ThreadInterrupt {
    public static void main(String[] args) throws Exception {
        A a = new A();
        a.start();
        Thread.sleep(100);

        System.out.println("Before interrupt:");
        System.out.println("Main thread state: " + Thread.currentThread().getState());
        System.out.println("A thread state: " + a.getState());

        a.interrupt();

        System.out.println("After interrupt:");
        System.out.println("A    = " + a.getState());
    }
}