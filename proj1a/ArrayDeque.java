public class ArrayDeque<T> {
    private T[] items;
    private int size;
    private int start;
    private static final double RATIOFACTOR = 0.25;
    private static final int ARBITRARYSIZE = 16;

    public ArrayDeque() {
        items = (T[]) new Object[8]; // Item[100] 是不被允许的
        size = 0;
        start = items.length / 2;
    }

    private void resize(int capacity) {
        T[] temp = (T[]) new Object[capacity];
        int newStart = (capacity - size) / 2;
        System.arraycopy(items, start, temp, newStart, size);
        items = temp;
        start = newStart;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void addFirst(T x) {
        if (isEmpty()) {
            items[start] = x;
            size += 1;
            return;
        }
        if (start == 0) {
            resize(items.length * 2);
        }
        start -= 1;
        items[start] = x;
        size += 1;
    }

    public void addLast(T x) {
        if (isEmpty()) {
            items[start] = x;
            size += 1;
            return;
        }
        if (start + size == items.length) {
            resize(items.length * 2); // state of the art approach！ geometric resizing;
        }
        // usage ratio...... half array size when R < 0.25
        items[start + size] = x;
        size += 1;
    }

    public T get(int i) {
        if (i < size && i >= 0) {
            return items[start + i];
        }
        return null;
    }

    public int size() {
        return size;
    }

    public T removeFirst() {
        if (isEmpty()) {
            return null;
        }
        T temp = items[start];
        items[start] = null; // loitering 垃圾？
        size -= 1;
        if (!isEmpty()) {
            start += 1;
        }
        if (items.length > ARBITRARYSIZE && (double) size / items.length < RATIOFACTOR) {
            resize(items.length / 2);
        }
        return temp;
    }

    public void printDeque() {
        for (int i = 0; i < start + size; i += 1) {
            System.out.print(items[i] + " ");
        }
    }

    public T removeLast() {
        if (isEmpty()) {
            return null;
        }
        T temp = items[start + size - 1];
        items[start + size - 1] = null; // loitering 垃圾？
        size -= 1;
        if (items.length > ARBITRARYSIZE && (double) size / items.length < RATIOFACTOR) {
            resize(items.length / 2);
        }
        return temp;
    }
}
