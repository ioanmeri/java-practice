package com.practice.basics;

public class StringComparison2 {

    public static void main(String[] args) {

        String myStr = "good";
        char[] myCharArr = {'g', 'o', 'o', 'd' };

        String newStr = null;
        for(char ch : myCharArr){
            newStr = newStr + ch;
        }

        System.out.println("myStr: " + myStr);
        System.out.println("newStr: " + newStr);
        // newStr: // nullgood
        System.out.println((newStr == myStr)+ " " + (newStr.equals(myStr)));
    }
}
