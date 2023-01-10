public class ArrayDequeTest {
    public static void randomTest(){
        ArrayDeque<Integer> a = new ArrayDeque<>();
        a.get(8);
        for (int i = 0; i < 100; i += 1) {
            a.addFirst(i);
        }
        for (int i = 0; i < 100; i += 1) {
            a.addLast(i);
        }
        for (int i = 0; i < 150; i += 1) {
            a.removeLast();
        }
        int w = a.removeFirst();
    }
    public static  void main(String[] args){
        randomTest();
    }
}
