package linkedList;

import java.util.Arrays;

public class MyLinkedList<T> {
    private Node<T> firstNode;
    private Node<T> lastNode;
    private int size = 0;

    boolean indexIsTrue(int index) {
        if (!(index >= 0 && index < size)) System.out.println("Out of range in index");
        return index >= 0 && index < size;
    }

    public void add(T value) {
        if (firstNode == null) {
            firstNode = new Node<>(null, null, value);
        } else if (lastNode == null) {
            lastNode = new Node<>(firstNode, null, value);
            firstNode.setNextNode(lastNode);
        } else {
            Node<T> node = new Node<>(lastNode, null, value);
            lastNode.setNextNode(node);
            lastNode = node;
        }
        size++;
    }

    public void remove(int index) {
        if (indexIsTrue(index)) {
            Node<T> currentNode = firstNode;
            Node<T> prev, next;
            if (index == 0) {
                firstNode = currentNode.getNextNode();
                firstNode.setPrevNode(null);
            } else if (index == size() - 1) {
                currentNode = lastNode;
                prev = currentNode.getPrevNode();
                prev.setNextNode(null);
            } else {
                for (int i = 0; i < index; i++) {
                    currentNode = currentNode.getNextNode();
                }
                prev = currentNode.getPrevNode();
                prev.setNextNode(currentNode.getNextNode());
                next = currentNode.getNextNode();
                next.setPrevNode(prev);
            }
            currentNode = null;
            size--;
        }
//        currentNode.setPrevNode(null);
//        currentNode.setNextNode(null);
    }


    public int size() {
        return size;
    }

    public void clear() {
//        for (Node<T> x = firstNode; x != null; ) {
//            Node<T> next = x.getNextNode();
//            x.setValue(null);
//            x.setNextNode(null);
//            x.setPrevNode(null);
//            x = next;
//        }
        firstNode = lastNode = null;
        size = 0;

    }

    @Override
    public String toString() {
        int i = 0;
        T[] array = (T[]) new Object[size];
        for (Node<T> x = firstNode; x != null; ) {
            Node<T> next = x.getNextNode();
            array[i] = x.getValue();
            x = next;
            i++;

        }
        return "MyLinkedList{" + Arrays.toString(array) + "}";
    }

    public static void main(String[] args) {
        MyLinkedList<String> ownLL = new MyLinkedList<>();
        ownLL.add("Hello");
        ownLL.add("from");
        ownLL.add("Vasyl");
        ownLL.add("Va");
        System.out.println("ownLL = " + ownLL);

        System.out.println("ownLL.size() = " + ownLL.size());
        System.out.println(ownLL.get(1));
        System.out.println("ownLL.size() = " + ownLL.size());
        System.out.println("ownLL.remove(1)=" + ownLL.get(1));
        ownLL.remove(1);
        System.out.println("ownLL.remove(2)=" + ownLL.get(2));
        ownLL.remove(2);
        System.out.println("ownLL.size() = " + ownLL.size());
        System.out.println("ownLL = " + ownLL);

        ownLL.clear();
        System.out.println("ownLL.size() = " + ownLL.size());
        System.out.println("__________________");
        System.out.println("ownLL = " + ownLL);
    }

    public T get(int index) {
        if (indexIsTrue(index)) {
            Node<T> currentNode = firstNode;
            for (int i = 0; i < index; i++) {
                currentNode = currentNode.getNextNode();
            }
            return currentNode.getValue();
        } else {
            System.err.println("Out of index");
            return null;
        }

    }
}
