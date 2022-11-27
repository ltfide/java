package belajar.collection;

import java.util.Stack;

public class StackApp {
    public static void main(String[] args) {

        Stack<String> names = new Stack<>();

        names.push("Lutfi");
        names.push("Dendiansyah");

        System.out.println(names.pop());
        System.out.println(names.pop());
//        System.out.println(names.pop());

        for (var name = names.pop(); name != null; name = names.pop()) {
            System.out.println(name);
        }

    }
}
