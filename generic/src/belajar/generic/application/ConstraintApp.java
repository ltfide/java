package belajar.generic.application;

public class ConstraintApp {
    public static void main(String[] args) {

        NumberData<Integer> integerNumberData = new NumberData<>(1000);
        System.out.println(integerNumberData.getData());

        NumberData<Long> longNumberData = new NumberData<>(10L);
        System.out.println(longNumberData.getData());

        // NumberData<String> stringNumberData = new NumberData<String>("ERROR"); // ERROR
    }

    public static class NumberData<T extends Number> {

        private T data;

        public NumberData(T data) {
            this.data = data;
        }

        public T getData() {
            return data;
        }

        public void setData(T data) {
            this.data = data;
        }
    }
}
