package belajar.generic;

public class List<T> {

    private T[] elements;
    private int size;

    @SuppressWarnings("unchecked")
    public List() {
        elements = (T[]) new Object[10];
        size = 0;
    }

    @SuppressWarnings("unchecked")
    public void add(T element) {
        if (size >= elements.length) {
            T[] newElements = (T[]) new Object[2 * elements.length];
            System.arraycopy(elements, 0, newElements, 0, elements.length);
            elements = newElements;
        }
        elements[size++] = element;
    }

    public T get(int index) {
        if (index >= size) {
            throw new IndexOutOfBoundsException();
        }
        return elements[index];
    }
}