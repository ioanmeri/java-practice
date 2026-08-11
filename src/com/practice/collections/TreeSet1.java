package com.practice.collections;

import java.util.TreeSet;

enum Title {
    MS2("Ms."), MR("Mr."), MS1("Ms.");
    private String title;

    private Title(String s){
        title = s;
    }
}

public class TreeSet1{
    public static void main(String[] args) {
        var ts = new TreeSet<Title>();
        ts.add(Title.MS2);
        ts.add(Title.MR);
        ts.add(Title.MS1);

        for(Title t :  ts){
            System.out.println(t);
        }

//        for (Title value : Title.values()){
//            System.out.println(value);
//        }
    }
}

// TreeSet keeps elements sorted in natural order (by default)

// Natural Order for Enums is the order in which they are defined