package com.practice.format;

import java.text.NumberFormat;
import java.text.ParseException;
import java.util.Locale;

public class NumberFormat1 {

    public static void main(String[] args) throws ParseException {
        double amount = 123456.789;
        Locale fr = new Locale("fr", "FR");

        //using default locale (US) and default style (Style.SHORT)
        NumberFormat shortFormat = NumberFormat.getCompactNumberInstance();
        NumberFormat longFormat =
                NumberFormat.getCompactNumberInstance(Locale.US, NumberFormat.Style.LONG);

        String ss = shortFormat.format(amount) ;
        String ls = longFormat.format(amount) ;
        System.out.println("Short:"+ss);
        System.out.println("Long:"+ls);

        Number amountS = shortFormat.parse(ss);
        Number amountL = longFormat.parse(ls);

        System.out.println("Short Amount: "+amountL+" Long Amount: "+amountL );
    }
}
