package belajar.collection.impl;

import java.util.*;

public class ListIterface {

    private static List<String> index = new ArrayList<>();

    public static void content() {
        index.add("A");
        index.add("B");
        index.add("C");
    }

    public static void sizeMethod() {
        index.add("Lutfi");
        index.add("Dendiansyah");
        int length = index.size();

        System.out.println(length); // 2
    }

    public static void isEmptyMethod() {
        boolean isValid = index.isEmpty();
        System.out.println(isValid); // true

        index.add("A");
        boolean isStillValid = index.isEmpty();
        System.out.println(isStillValid); // false
    }

    public static void containsMethod() {
        index.add("Lutfi");
        index.add("Dendiansyah");

        boolean isContain = index.contains("Dendiansyah");
        System.out.println(isContain); // true

        boolean isContain2 = index.contains("dendiansyah");
        System.out.println(isContain2); // false
    }

    public static void iteratorMethod() {
        content();

        Iterator<String> alphabets = index.iterator();
        while (alphabets.hasNext()) {
            String alphabet = alphabets.next();
            System.out.println(alphabet); // A B C
        }
    }

    public static void toArrayMethod() {
        content();

        String[] stringArray = new String[index.size()];
        stringArray = index.toArray(stringArray);
        System.out.println(Arrays.toString(stringArray)); // [A, B, C]
    }

    public static void addMethod() {
        content();
        System.out.println(index); // [A, B, C]
    }

    public static void removeMethod() {
        content();

        boolean rmvA = index.remove("A");
        System.out.println(rmvA); // true
        index.remove(0);
        System.out.println(index); // [C]
    }

    public static void containsAllMethod() {
        content();

        boolean isExists = index.containsAll(List.of("A", "X"));
        System.out.println(isExists); // false
        boolean isExists2 = index.containsAll(List.of("A", "A"));
        System.out.println(isExists2); // true
    }

    public static void addAllMethod() {
        content();

        boolean isTrue = index.addAll(List.of("D", "E", "F"));
        System.out.println(isTrue); // true
        System.out.println(index); // [A, B, C, D, E, F]
        index.addAll(List.of("G", "H"));
        System.out.println(index); // [A, B, C, D, E, F, G, H]
    }

    public static void removeAllMethod() {
        content();

        boolean isTrue = index.removeAll(List.of("A", "C"));
        System.out.println(isTrue); // true
        System.out.println(index); // [B]
    }

    public static void retainAllMethod() {
        content();

        List<String> index2 = new ArrayList<>();
        index2.add("D");
        index2.add("E");
        index2.add("A");

        boolean isTrue = index.retainAll(index2);
        System.out.println(isTrue); // true
        System.out.println(index); // [A]
    }

    public static void replaceAllMethod() {
        content();

        index.replaceAll(s -> s.equals("A") ? "Z" : s);
        index.replaceAll(s -> s.toLowerCase(Locale.ROOT));
        System.out.println(index); // [z, b, c]
//        ListIterator<String> li = index.listIterator();
//        while (li.hasNext()) {
//            li.set();
//        }
    }

    public static void sortMethod() {
        content();

        index.add("H");
        index.add("G");
        index.sort((o1, o2) -> o1.compareTo(o2));
        System.out.println(index); // [A, B, C, G, H]
        index.sort((o1, o2) -> o2.compareTo(o1));
        System.out.println(index); // [H, G, C, B, A]
    }

    public static void clearMethod() {
        content();

        index.clear();
        System.out.println(index); // []
        System.out.println(index.isEmpty()); // true
    }

    public static void equalsMethod() {
        content();

        boolean isEquals = index.equals(List.of("A", "B", "C"));
        System.out.println(isEquals); // true
        boolean isEquals2 = index.equals(List.of("A", "B"));
        System.out.println(isEquals2); // false
    }

    public static void hashCodeMethod() {
        content();

        int hashValue = index.hashCode();
        System.out.println(hashValue); // 94369
        System.out.println(ListIterface.index.hashCode()); // 94369
    }

    public static void getMethod() {
        content();

        System.out.println(index.get(0)); // A
        System.out.println(index.get(4)); // IndexOutBoundsException
    }

    public static void setMethod() {
        content();

        index.set(0, "X");
        System.out.println(index); // [X, B, C]
    }

    public static void addWithMethod() {
        content();

        index.add(1, "X");
        System.out.println(index); // [A, X, B, C]
    }

    public static void indexOfMethod() {
        content();

        int indexOfValue = index.indexOf("B");
        System.out.println(indexOfValue); // 1
        int indexOfValue2 = index.indexOf("X");
        System.out.println(indexOfValue2); // -1 // not found
    }

    public static void lastIndexOfMethod() {
        content();

        index.add("A"); // [A, B, C, A]
        int lastIndex = index.lastIndexOf("A");
        System.out.println(lastIndex); // 3
    }

    public static void listIteratorMethod() {
        content();

        ListIterator<String> listIterator = index.listIterator();
        while (listIterator.hasNext()) {
            System.out.println(listIterator.next()); // A B C
        }
        ListIterator<String> listIterator2 = index.listIterator(2);
        while (listIterator2.hasNext()) {
            System.out.println(listIterator2.next()); // C // start from element 2
        }
    }

    public static void subListMethod() {
        content();

        index.add("D");
        index.add("E");
        index.add("F");
        List<String> subList = index.subList(0, 3);
        System.out.println(subList); // [A, B, C]
        System.out.println(index.subList(2, 6)); // [C, D, E, F]
        index.subList(4,6).clear();
        System.out.println(index); // [A, B, C, D]
    }

    public static void splitIteratorMethod() {
        content();

        Spliterator<String> spliterator = index.spliterator();
         spliterator.forEachRemaining(System.out::println); // A B C
        spliterator.forEachRemaining(n -> System.out.println(n)); // empty
    }

    public static void ofMethod() {
        content();

        List<String> arr = List.of("X", "Y", "Z"); // [X, Y, Z]
        List<String> arr2 = List.of("X"); // [X]
        System.out.println(arr);
        System.out.println(arr2);
    }

    public static void copyOfMethod() {
        content();

        List<String> list = List.copyOf(index);
        System.out.println(list); // [A, B, C]
        List<String> list2 = List.copyOf(List.of("X", "Y", "Z"));
        System.out.println(list2); // [X, Y, Z]
    }

    public static void main(String[] args) {
        // sizeMethod();
        // isEmptyMethod();
        // containsMethod();
        // iteratorMethod();
        // iteratorMethod();
        // toArrayMethod();
        // addMethod();
        // removeMethod();
        // containsAllMethod();
        // addAllMethod();
        // removeAllMethod();
        // retainAllMethod();
        // replaceAllMethod();
        // sortMethod();
        // clearMethod();
        // equalsMethod();
        // hashCodeMethod();
        // getMethod();
        // setMethod();
        // addWithMethod();
        // indexOfMethod();
        // lastIndexOfMethod();
        // listIteratorMethod();
        // subListMethod();
        // splitIteratorMethod();
        // ofMethod();
        copyOfMethod();
    }

}
