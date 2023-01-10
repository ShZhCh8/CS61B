public class IntList {
    public int first;
    public IntList rest;
    public IntList(int f, IntList r){
        first = f;
        rest = r;
    }
    public int size(){
        if(this.rest == null){
            return 1;
        }
        else{
            return 1 + rest.size();
        }
    }
    public int iterativeSize(){
        IntList p = this;
        int size = 0;
        while(p != null){
            size += 1;
            p = p.rest;
            // use name p to remind that you are using a pointer
        }
        return size;
    }
    public int get(int i){
        IntList p = this;
        while(i != 0){
            p = p.rest;
            i -= 1;
        }
        return p.first;
    }
    public static void main(String[] args){
        IntList L = new IntList(15, null);
        L = new IntList(20, L);
        System.out.println(L.get(1));
    }
}
