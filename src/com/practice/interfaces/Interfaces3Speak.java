package com.practice.interfaces;

public class Interfaces3Speak {
    public static void main(String[] args) {
        Interfaces3Speak s = new GoodSpeak();

        ((GoodSpeak)s).up();

        ((Tone)s).up();
        // Does Tone declare up()? Yes
        // casts the Speak reference to the interface Tone.
        // At runtime: it looks at the actual object's class

        // s.up() // not valid
        // The compiler only looks at the reference type, not the runtime object.

    }
}

class GoodSpeak extends Interfaces3Speak implements Tone{
    public void up(){
        System.out.println("UP UP UP");
    }
}

interface Tone{
    void up();
}