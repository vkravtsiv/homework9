import java.util.Arrays;

public class MyStack<T> {

    private T[] stck;



    private int tos;

    MyStack(int size) {
        stck = (T[]) new Object[size];
        tos = -1;
    }

    void push(T item) {
        if (tos == stck.length - 1) {
            T[] temp = (T[])new Object[stck.length * 2];
            for (int i = 0; i < stck.length; i++) {
                temp[i] = stck[i];
            }
            stck = temp;
        }
        stck[++tos] = item;
    }

    boolean isEmpty(){
        return tos==-1;
    }
    Object peek(){
        if (!isEmpty())
            return stck[tos];

        return null;
    }
    Object pop() {
        if (isEmpty()) {
            System.out.println("Stack is empty");
            return null;

        } else
            return stck[tos--];

    }
    Object remove(int index){
        for (int i = index; i < stck.length-1 ; i++) {
           stck[i]= stck[i+1];
        }
        stck[stck.length-1]=null;
        return stck;

    }
    int size(){
        int result=0;
        for (int i = 0; i < stck.length; i++) {
            if (stck[i]!= null) result++;
        }
        return result;
    }
    int clear(){
        for (int i = 0; i < stck.length; i++) {
            stck[i] = null;
        }
        return 0;
    }
    public static void main(String[] args) {
        MyStack<String> stack1=new MyStack(5);
        stack1.push("50");
        stack1.push("500");
        stack1.push("true");
        stack1.push("5000");
        stack1.push("50000");
        stack1.push("5");

            System.out.println(Arrays.toString(stack1.stck));


        System.out.println(stack1.pop());
        System.out.println(stack1.pop());
//        System.out.println(stack1.pop());
//        System.out.println(stack1.pop());
        stack1.remove(1);
        System.out.println(Arrays.toString(stack1.stck));
        System.out.println("tos = " + stack1.tos);
        System.out.println("stack1.peek() = " + stack1.peek());
        System.out.println("stack1.size() = " + stack1.size());

        stack1.clear();
        System.out.println(Arrays.toString(stack1.stck));
        System.out.println("stack1.size() = " + stack1.size());

    }


}
