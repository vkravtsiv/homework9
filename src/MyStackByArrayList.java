import java.util.Arrays;

public class MyStackByArrayList<T> {

    private int queueLength = 10;
    MyArrayList<T> myArrayList = new MyArrayList<>(queueLength);

    public MyStackByArrayList() {
        MyArrayList<T> myArrayList = new MyArrayList<>(queueLength);


    }

    public MyStackByArrayList(int queueLength) {
        this();
        this.queueLength = queueLength;
    }

    boolean empty() {
        return myArrayList.size() == 0;
    }

    void push(T o) {
        myArrayList.add(o);
    }

    T remove(int index) {
        if (!empty()) {
            return myArrayList.remove(index);
        } else return null;
    }

    T peek() {
        if (!empty()) {
            return myArrayList.get(size() - 1);
        } else return null;
    }

    T pop() {
        if (!empty()) {
            T result = myArrayList.get(size() - 1);
            myArrayList.remove(size() - 1);
            return result;
        } else {
            return null;
        }
    }

    void clear() {
        myArrayList.clear();
    }

    int size() {
        return myArrayList.size();
    }

    @Override
    public String toString() {

        return "MyStackByArrayList{" + myArrayList + '}';
    }

    public static void main(String[] args) {
        MyStackByArrayList<String> stck = new MyStackByArrayList<>(5);

        stck.push("5");
        stck.push("50");
        stck.push("500");
        stck.push("5000");
        stck.push("50000");
        stck.push("500000");
        System.out.println(stck);
        System.out.println(stck.pop());
        System.out.println(stck.pop());

        System.out.println(stck.remove(1));
        System.out.println(stck);

        System.out.println("stck1.peek() = " + stck.peek());
        System.out.println("stck1.size() = " + stck.size());

        stck.clear();
        System.out.println(stck);
        System.out.println("stck1.size() = " + stck.size());

    }
}


