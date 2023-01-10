public class ArrayDeque<Item> {
    private Item[] items;
    private int size;
    private int start;
    private static final double ratioFactor = 0.25;
    private static final int arbitrarySize = 16;
    public ArrayDeque(){
        items = (Item[]) new Object[8]; // Item[100] 是不被允许的
        size = 0;
        start = items.length / 2;
    }
    private void resize(int capacity){
        Item[] temp = (Item[]) new Object[capacity];
        int newStart = (capacity - size) / 2;
        System.arraycopy(items, start, temp, newStart, size);
        items = temp;
        start = newStart;
    }
    public boolean isEmpty(){
        return size == 0;
    }
    public void addFirst(Item x){
        if (isEmpty()){
            items[start] = x;
            size += 1;
            return;
        }
        if (start == 0){
            resize(size * 2);
        }
        items[start-1] = x;
        size += 1;
    }
    public void addLast(Item x){
        if (isEmpty()){
            items[start] = x;
            size += 1;
            return;
        }
        if (start + size - 1 == items.length)
            resize(size * 2); // state of the art approach！ geometric resizing;
        // usage ratio...... half array size when R < 0.25
        items[start + size] = x;
        size += 1;
    }
    public Item getFirst(){
        if (isEmpty())
            return null;
        return items[start];
    }

    public Item getLast(){
        if (isEmpty())
            return null;
        return items[start + size - 1];
    }
    public Item get(int i){
        return items[start + i];
    }
    public int size(){
        return size;
    }
    public Item removeFirst(){
        if (isEmpty())
            return null;
        Item temp = getFirst();
        items[start] = null; // loitering 垃圾？
        if (! isEmpty())
            start += 1;
        if (size > arbitrarySize && (double) size / items.length < ratioFactor)
            resize(size / 2);
        return temp;
    }
    public Item removeLast(){
        if (isEmpty())
            return null;
        Item temp = getLast();
        items[size - 1] = null; // loitering 垃圾？
        size -= 1;
        if (size > arbitrarySize && (double) size / items.length < ratioFactor)
            resize(size / 2);
        return temp;
    }
}

