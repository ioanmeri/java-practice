package com.practice.basics;

public class StringsStrip {
    public static void main(String[] args) {
        var result = """    
   hello java \
guru
   """.strip();

        System.out.println(result);

        // Also
        System.out.println("" +5 + 6);   //1
        System.out.println(5 + "" +6);   // 2
        System.out.println(5 + 6 +"");   // 3
        System.out.println(5 + 6);       // 4
    }


}
