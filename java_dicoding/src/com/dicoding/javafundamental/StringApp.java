package com.dicoding.javafundamental;

public class StringApp {
    public static void main(java.lang.String[] args) {
        char[] myName = {'l', 'u', 't', 'f', 'i'};
        java.lang.String myNameString = new java.lang.String(myName);
        int ok = 123;

        int _k = 32;

        int lengthOfMyName = myName.length; // 5
        char charAtResult = myNameString.charAt(0); // l

        System.out.println(lengthOfMyName);
        System.out.println(charAtResult);
        System.out.println(myNameString.substring(0, 2));
        System.out.println(myNameString.contains("l"));
        System.out.println(myNameString.lastIndexOf('u'));
        System.out.println(ok);
        System.out.println(_k);

    }
}
