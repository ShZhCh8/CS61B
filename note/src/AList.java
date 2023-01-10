public class AList<Item> {
    private Item[] items;
    private int size;
    public AList(){
        items = (Item[]) new Object[100]; // Item[100] 是不被允许的！
        size = 0;
    }
    private void resize(int capacity){

    Item[] temp = (Item[]) new Object[capacity];
    System.arraycopy(items, 0, temp, 0, size);
    items = temp;

    }
    public void addLast(Item x){
        if (size == items.length)
            resize(size * 2); // state of the art approach！ geometric resizing;
        // usage ratio...... half array size when R < 0.25
        items[size] = x;
        size += 1;
    }
    public Item getLast(){
        return items[size-1];
    }
    public Item get(int i){
        return items[i];
    }
    public int size(){
        return size;
    }
    public Item removeLast(){
        Item temp = getLast();
        items[size - 1] = null; // loitering 垃圾？
        size -= 1;
        return temp;
    }
}
