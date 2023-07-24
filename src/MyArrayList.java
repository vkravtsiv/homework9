import java.util.Arrays;

public class MyArrayList {
    private Object[] array;
    private int pointer;

    public MyArrayList(int size) {
        array = new Object[size];
        pointer = 0;
//        System.out.println("array.length = " + array.length);
    }

    void add(Object value) {
        if (pointer == array.length-1) {
            Object[] temp = new Object[array.length * 2];
            for (int i = 0; i < array.length; i++) {
                temp[i] = array[i];
            }
            array = temp;
        }
        array[pointer++] = value;
    }

    Object remove(int index) {
        Object result=array[index];
        for (int i = index; i < array.length - 1; i++) {
            array[i] = array[i + 1];
        }
        array[array.length - 1] = null;
        System.out.println("Видалений елемнт "+result);
        return result;

    }

    int clear() {
        for (int i = 0; i < array.length; i++) {
            array[i] = null;
        }
        return 0;
    }

    int size() {
        int result = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] != null) result++;
        }
        return result;
    }

    Object get(int index) {

        return array[index];
    }
    public static void main(String[] args) {
        MyArrayList arr1=new MyArrayList(5);
        arr1.add(50);
        arr1.add("500");
        arr1.add(true);
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

    }
}
