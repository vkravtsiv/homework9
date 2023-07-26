import java.util.Arrays;

public class MyStack<T> {

    private T[] stck;


    private int tos;
    private int length;
    private int size = 0;

    MyStack() {

        stck = (T[]) new Object[length];
        tos = -1;
    }

    MyStack(int length) {
        this();
        this.length = length;

    }

    boolean indexIsTrue(int index) {
        if (!(index >= 0 && index < size)) System.out.println("Out of range in index");
        return index >= 0 && index < size;
    }

    void push(T item) {
        if (tos == stck.length - 1) {
            length = length * 2 + 1;
            T[] temp = (T[]) new Object[length];
            for (int i = 0; i < stck.length; i++) {
                temp[i] = stck[i];
            }
            stck = temp;
        }

        stck[++tos] = item;
        size++;
    }

    boolean isEmpty() {
        return tos == -1;
    }

    T peek() {
        if (!isEmpty())
            return stck[tos];

        return null;
    }

    T pop() {

        if (isEmpty()) {
            System.out.println("Stack is empty");
            return null;

        } else {
            T result = stck[tos--];
            stck[++tos] = null;
            tos--;
            size--;

            return result;
        }


    }

    T remove(int index) {
        if (indexIsTrue(index)) {
            T result = stck[index];
            for (int i = index; i < stck.length - 1; i++) {
                stck[i] = stck[i + 1];
            }
            stck[stck.length - 1] = null;
            tos--;
            size--;
            return result;
        } else return null;

    }

    int size() {
//        int result=0;
//        for (int i = 0; i < stck.length; i++) {
//            if (stck[i]!= null) result++;
//        }
//        return result;
        return size;
    }

    int clear() {
        length = 0;
        stck = (T[]) new Object[length];
        size = 0;
        tos = -1;
        return 0;
    }


    @Override
    public String toString() {
        T[] stckOut = (T[]) new Object[size];
        for (int i = 0; i < size; i++) {
            stckOut[i] = stck[i];
        }
        return "MyStack{" +
                "stck=" + Arrays.toString(stckOut) +
                ", size=" + size +
                '}';
    }

    public static void main(String[] args) {
        MyStack<String> stack1 = new MyStack();
        stack1.push("5");
        stack1.push("50");
        stack1.push("500");
        stack1.push("5000");
        stack1.push("50000");
        stack1.push("500000");

        System.out.println(stack1);


        System.out.println(stack1.pop());
        System.out.println(stack1.pop());
//        System.out.println(stack1.pop());
//        System.out.println(stack1.pop());
        System.out.println(stack1.remove(1));
        System.out.println(stack1);
        System.out.println("tos = " + stack1.tos);
        System.out.println("stack1.peek() = " + stack1.peek());
        System.out.println("stack1.size() = " + stack1.size());

        stack1.clear();
        System.out.println(Arrays.toString(stack1.stck));
        System.out.println("stack1.size() = " + stack1.size());

    }


}
