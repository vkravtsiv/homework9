import java.util.Arrays;


public class MyQueue<T>{

    private T[] array;
    private int queueLength;
    private int head;
    private int tail;


    public MyQueue(int queueLength) {
        this.queueLength = queueLength;
        array = (T[]) new Object[queueLength];
        this.head = -1;
        this.tail = -1;

    }

    boolean isFull() {
        return tail == queueLength - 1;
    }

    boolean isEmpty() {
        return (this.head == -1 && this.tail == -1);
    }

    void add(T o) {
        if (isFull()) {
            System.out.println("Queue is Full");
        } else if (size() == 0) {
            head = tail = 0;
            array[tail] = o;
        } else {
            array[++tail] = o;
        }
    }

    T peek() {
        T result;
        if (size() == 0) {
            System.out.println("Queue is Empty");
            return null;
        } else {
            result = array[head];
        }
        return result;

    }

    Object poll() {
        Object result;
        if (size() == 0) {
            System.out.println("Queue is empty.");
            result = null;
        } else if (head == tail) {
            result = peek();
            array[head] = null;
            head = tail = -1;
        } else {
            result = peek();
            array[head] = null;
            head++;
        }
        return result;
    }

    int size() {
        int result = 0;
        for (T o : array) {
            if (o != null) result++;
        }
        return result;
    }

    void clear() {
        for (int i = head; i < tail + 1; i++) {
            array[i] = null;
        }
    }

    @Override
    public String toString() {
        return "MyQueue{" +
                "array=" + Arrays.toString(array) +
                '}';
    }

    public static void main(String[] args) {
        MyQueue<String> queue = new MyQueue<>(5);
        System.out.println("queue.poll() = " + queue.poll());
        queue.add("Maksym");
        System.out.println(queue);
        System.out.println("queue.size() = " + queue.size());
//        System.out.println("queue.peek() = " + queue.peek());
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
        System.out.println("queue.size() = " + queue.size());
        System.out.println(queue);
        System.out.println("queue.poll() = " + queue.poll());
    }
}
