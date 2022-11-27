package com.dicoding.javafundamental;

public class Percabangan {
    public static void main(java.lang.String[] args) {
        // if else
        boolean isTrue = false;
        int value = 3;

        if (isTrue) {
            System.out.println("The result is True");
        } else {
            System.out.println("The result is False");
        }

        // switch
        switch (value) {
            case 3:
                System.out.println("The value is 3");
                break;
            case 4:
                System.out.println("The value is 4");
                break;
            case 5:
                System.out.println("The value is 5");
                break;
            default:
                System.out.println("This is Default Value");
        }
    }
}
