/** hides the terrible truth of the nakedness within*/
public class SLList<LochNess> { // 泛型！
    private IntNode sentinel;
    private int size;
    private class IntNode { // static: never look outside, tiny memory saving...
        public IntNode prev; // double link
        // 带来的问题：结尾加一个sentinel？
        public LochNess item;
        public IntNode next;

        public IntNode(LochNess i, IntNode n){
            item = i;
            next = n;
        }
    }

    /**
     IMO: one sentinel for both the first and the last
     */

    public SLList(int x){
        sentinel = new IntNode(0, null);
        sentinel.next = new IntNode(x, null);
        size = 1;
    }

    public SLList() {
        sentinel = new IntNode(0, null);
        size = 0;
    }

    public void addFirst(int x) {
        sentinel.next = new IntNode(x, sentinel.next);
        size += 1;
    }

    public LochNess getFirst() {
        return sentinel.next.item;
    }

    public void addLast(int x) {
        // downside: slow
        IntNode p = sentinel;
        while (p.next != null) {
            p = p.next;
        }
        p.next = new IntNode(x, null);
        size += 1;
    }

    public int size() {
        return size;
    }

    public static void main(String[] args){
        SLList L = new SLList(10); // no need to worry about null reference
    }
}
