package belajar.generic.application;

import belajar.generic.MyData;

public class CovariantApp {
    public static void main(String[] args) {

        MyData<Object> stringMyData = new MyData<>("Lutfi");
        process(stringMyData);

        MyData<? extends Object> myData = stringMyData;
        System.out.println(myData.getData());
    }

    public static void process(MyData<? extends Object> myData) {
        System.out.println(myData.getData());

        // myData.setData("Lutfi Dendiansyah"); // ERROR
    }
}
