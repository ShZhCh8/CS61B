public class LinkedListDeque<T> {
    private class node {
        T item;
        node prev;
        node next;

        private node(T item, node prev, node next) {
            this.item = item;
            this.prev = prev;
            prev.next = this;
            this.next = next;
            next.prev = this;
        }

        public node() {
        }

        public T get(int index) {
            if (index == 0)
                return this.item;
            return this.next.get(index - 1);
        }
    }

    private node sentinel;
    private int size;

    public int size() {
        return size;
    }

    public LinkedListDeque() {
        this.sentinel = new node();
        sentinel.prev = sentinel;
        sentinel.next = sentinel;
        size = 0;
    }

    public void addFirst(T item) {
        new node(item, sentinel, sentinel.next);
        size += 1;
    }

    public void addLast(T item) {
        new node(item, sentinel.prev, sentinel);
        size += 1;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void printDeque() {
        node p = this.sentinel.next;
        while (p != sentinel) {
            System.out.print(p.item + " ");
            p = p.next;
        }
    }

    public T removeFirst() {
        if (sentinel.next != sentinel) {
            T temp = sentinel.next.item;
            sentinel.next = sentinel.next.next;
            sentinel.next.prev = sentinel;
            size -= 1;
            return temp;
        }
        return null;
    }

    public T removeLast() {
        if (sentinel.prev != sentinel) {
            T temp = sentinel.prev.item;
            sentinel.prev = sentinel.prev.prev;
            sentinel.prev.next = sentinel;
            size -= 1;
            return temp;
        }
        return null;
    }

    public T get(int index) {
        if (index >= size && size < 0)
            return null;
        node p = sentinel.next;
        for (int i = 0; i < index; i += 1) {
            p = p.next;
        }
        return p.item;
    }

    public T getRecursive(int index) {
        if (index >= size && size < 0)
            return null;
        return sentinel.next.get(index);
    }
}
