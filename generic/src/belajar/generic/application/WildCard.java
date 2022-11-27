package belajar.generic.application;

import belajar.generic.MyData;

public class WildCard {
    public static void main(String[] args) {

        print(new MyData<>(100));
        print(new MyData<>("Lutfi"));
        print(new MyData<MultipleConstraintApp.Manager>(new MultipleConstraintApp.Manager()));
    }

    public static void print(MyData<?> myData) {
        System.out.println(myData.getData());
    }
}
