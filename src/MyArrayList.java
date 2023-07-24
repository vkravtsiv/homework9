import java.util.Arrays;

public class MyArrayList<T> {
    private T[] array;
    private int pointer;
    private int size=0;
    private int length=5;


    public MyArrayList() {
        array = (T[])new Object[length];
        pointer = 0;
    }

    public MyArrayList(int length) {
        this();
        this.length=length;
//        System.out.println("array.length = " + array.length);
    }

    void add(T value) {
        if (pointer == array.length-1) {
            this.length=array.length * 2;
            T[] temp = (T[])new Object[array.length * 2];
            for (int i = 0; i < array.length; i++) {
                temp[i] = array[i];
            }
            array = temp;
        }
        array[pointer++] = value;
        size++;

    }

    T remove(int index) {
        T result=array[index];
        for (int i = index; i < array.length - 1; i++) {
            array[i] = array[i + 1];
        }
        array[array.length - 1] = null;
        System.out.println("Видалений елемнт "+result);
        size--;
        return result;

    }

    int clear() {
        array = (T[])new Object[length];
        size=0;
        return 0;
    }

    int size() {
        return size;
    }

    T get(int index) {

        return array[index];
    }
    public static void main(String[] args) {
        MyArrayList<String> arr1=new MyArrayList<>();
        arr1.add("50");
        arr1.add("500");
        arr1.add("4000");
        arr1.add("5000");
        arr1.add("50000");
        System.out.println(Arrays.toString(arr1.array));
        System.out.println(arr1.remove(2));

        System.out.println(arr1.get(1));

        arr1.remove(1);
        System.out.println(Arrays.toString(arr1.array));

        System.out.println("arr1.get(1) = " + arr1.get(1));

        arr1.clear();
        System.out.println(Arrays.toString(arr1.array));
        System.out.println("arr1.size() = " + arr1.size());

    }
}
