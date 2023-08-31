package belajar.generic;

public class ListApp {

    public static void main(String[] args) {
        List<Integer> list1 = new List<>();
        list1.add(1);
        list1.add(2);

        System.out.println(list1.get(0));
        System.out.println(list1.get(1));
    }
}
