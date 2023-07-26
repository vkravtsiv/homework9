import java.util.Arrays;

public class MyQueueByArrayList<T> {
    private int head;

    private int tail;

    private int queueLength = 10;
    MyArrayList<T> myArrayList = new MyArrayList<>(queueLength);

    public MyQueueByArrayList() {
        MyArrayList<T> myArrayList = new MyArrayList<>(queueLength);
        this.head = -1;
        this.tail = -1;

    }

    public MyQueueByArrayList(int queueLength) {
        this();
        this.queueLength = queueLength;
    }

    boolean empty() {
        return myArrayList.size() == 0;
    }

    void add(T o) {
        myArrayList.add(o);
    }

    T peek() {
        if (!empty()) {
            return myArrayList.get(0);
        } else return null;
    }

    T poll() {
        if (!empty()) {
            T result = myArrayList.get(0);
            myArrayList.remove(0);
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

        return "MyQueueByArrayList{" + myArrayList + '}';
    }

    public static void main(String[] args) {
        MyQueueByArrayList<String> queue = new MyQueueByArrayList<>(5);
        queue.add("Maksym");
        System.out.println(queue);
        System.out.println("queue.size() = " + queue.size());
        System.out.println("queue.peek() = " + queue.peek());
        queue.add("Maks");
        queue.add("Olena");
        queue.add("Olya");
        queue.add("Oleh");
        queue.add("Lina");
        System.out.println(queue);
        System.out.println("queue.peek() = " + queue.peek());
        System.out.println("queue.poll() = " + queue.poll());
        System.out.println("queue.poll() = " + queue.poll());
        queue.clear();
        System.out.println(queue);
//        System.out.println(queue);
        System.out.println("queue.size() = " + queue.size());
        System.out.println(queue);
        System.out.println("queue.poll() = " + queue.poll());
    }

}
