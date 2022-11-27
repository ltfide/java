package belajar.lambda.app;

import belajar.lambda.SimpleAction;

public class SimpleActionApp {
    public static void main(String[] args) {

        SimpleAction simpleAction1 = new SimpleAction() {
            @Override
            public String action(String name) {
                return name;
            }
        };

        SimpleAction simpleAction2 = String::toUpperCase;

        System.out.println(simpleAction1.action("Lutfi"));
        System.out.println(simpleAction2.action("Lutfi"));

        SimpleAction simpleAction3 = (String value) -> {
            return "Hello " + value;
        };

        SimpleAction simpleAction4 = name -> {
            return "Hello " + name;
        };

        SimpleAction simpleAction5 = (String name) -> "Hello " + name;

        SimpleAction simpleAction6 = name -> "Hello " + name;

        SimpleAction simpleAction7 = (name) -> "Hello " + name;

        System.out.println(simpleAction3.action("SimpleAction3"));
        System.out.println(simpleAction4.action("SimpleAction4"));
        System.out.println(simpleAction5.action("SimpleAction5"));
        System.out.println(simpleAction6.action("SimpleAction6"));
        System.out.println(simpleAction7.action("SimpleAction7"));
        
    }
}
