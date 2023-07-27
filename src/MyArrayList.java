import java.util.Arrays;

public class MyArrayList<T> {
    private T[] array;
//    private int pointer;
    private int size = 0;
    private int length = 5;


    public MyArrayList() {
        array = (T[]) new Object[length];
        size = 0;
    }

    public MyArrayList(int length) {
        this();
        this.length = length;
//        System.out.println("array.length = " + array.length);
    }

    boolean indexIsTrue(int index) {
        if (!(index >= 0 && index < size)) System.out.println("Out of range in index");
        return index >= 0 && index < size;
    }

    void add(T value) {
        if (size == array.length - 1) {
            this.length = array.length * 2;
            T[] temp = (T[]) new Object[array.length * 2];
            for (int i = 0; i < array.length; i++) {
                temp[i] = array[i];
            }
            array = temp;
        }
        array[size++] = value;
//        size++;

    }

    void add(int index, T value) {
        if (size == array.length - 1) {
            this.length = array.length * 2;
            T[] temp = (T[]) new Object[array.length * 2];
            for (int i = 0; i < array.length; i++) {
                temp[i] = array[i];
            }
            array = temp;
        }
        size++;

        for (int i = size - 2; i >= index; i--) {
            array[i + 1] = array[i];
        }
        array[index] = value;
    }

    T remove(int index) {
        if (indexIsTrue(index)) {
            T result = array[index];
            for (int i = index; i < array.length - 1; i++) {
                array[i] = array[i + 1];
            }

            size--;
            return result;
        } else {
            return null;
        }

    }

    void clear() {
        array = (T[]) new Object[length];
        size = 0;

    }

    int size() {
        return size;
    }

    T get(int index) {
        if (indexIsTrue(index)) {
            return array[index];
        } else return null;
    }

    @Override
    public String toString() {
        T[] temp = (T[]) new Object[size];
        for (int i = 0; i < size; i++) {
            temp[i] = array[i];
        }

        return "MyArrayList{" +
                Arrays.toString(temp) +
                '}';
    }

    public static void main(String[] args) {
        MyArrayList<String> arr1 = new MyArrayList<>();
        for (int i = 0; i < 2 << 2; i++) {
            arr1.add(Integer.toString(i));
        }
        arr1.add("50");
        arr1.add("500");
        arr1.add("4000");
        arr1.add("5000");
        arr1.add("50000");
        System.out.println(arr1);
        arr1.add(3, "0");
        System.out.println(arr1);
        System.out.println("arr1.size() = " + arr1.size());
        System.out.println(arr1);
        System.out.println("arr1.remove(2)=" + arr1.remove(2));
        System.out.println(arr1);
        System.out.println("arr1.get(1)=" + arr1.get(1));
        System.out.println("arr1.remove(1) = " + arr1.remove(1));
        System.out.println(arr1);
        arr1.toString();
//        System.out.println(Arrays.toString(arr1.array));

        System.out.println("arr1.get(1) = " + arr1.get(1));

        arr1.clear();
        System.out.println(arr1);
        System.out.println("arr1.size() = " + arr1.size());

    }
}
