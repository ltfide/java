package belajar.generic.application;

import belajar.generic.MyData;

public class InvariantApp {
    public static void main(String[] args) {

        MyData<String> stringMyData = new MyData<>("Lutfi");
        MyData<Object> objectMyData = new MyData<>("Test");
        doIt(objectMyData);
        // MyData<Object> objectMyData = stringMyData; // ERROR

    }

    public static void doIt(MyData<Object> objectMyData) {
        System.out.println(objectMyData.getData());
    }
}
