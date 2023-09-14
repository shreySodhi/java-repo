import java.util.Arrays;
import java.util.EmptyStackException;

class MyStack {
    int size = 0;
    Integer[]arr;
    int initSize;
    public MyStack() {
        this(7);
    }
    public void clear(){
        arr = new Integer[initSize];
    }
    MyStack(int initSize){
        this.initSize = initSize;
        arr = new Integer[initSize];
    }
    public boolean isEmpty(){
        return size == 0;
    }
    public void push(Integer val) {
         if(size == arr.length)
            doubleCapacity();

        arr[size] = val;
        size++;
    }
    public void doubleCapacity(){
        Integer [] arr2 = new Integer[arr.length*2];
        for(int x = 0; x < arr.length;x++){
            arr2[x] = arr[x];
        }
        arr = arr2;
    }
    public Integer pop() {
        if(size == 0)
            throw new EmptyStackException();
        Integer x = arr[size-1];
        arr[size-1] = null;
        size--;
        return x;

    }
    public int size(){
        return size;
    }
    public Integer peek() {
        return  arr[size-1];
    }
    @Override
    public String toString() {
        return Arrays.toString(arr);
    }
}