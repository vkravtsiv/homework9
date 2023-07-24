package linkedList;

public class MyLinkedList<T> {
    private Node<T> firstNode;
    private Node<T> lastNode;
    private int size=0;
    public void add(T value){
        if (firstNode==null){
            firstNode =new Node<>(null,null,value);
        } else if (lastNode==null){
            lastNode=new Node<>(firstNode,null,value);
            firstNode.setNextNode(lastNode);
        } else {
            Node<T> node =new Node<>(lastNode,null,value);
            lastNode.setNextNode(node);
            lastNode=node;
        }
        size++;
            }
    public void remove(int index){
        Node<T> currentNode=firstNode;
        Node<T> prev,next;
        if (index==0){
            firstNode=currentNode.getNextNode();
            firstNode.setPrevNode(null);
        } else if (index==size()-1){
           currentNode=lastNode;
           prev=currentNode.getPrevNode();
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
        currentNode=null;
        size--;
//        currentNode.setPrevNode(null);
//        currentNode.setNextNode(null);
    }


    public int size(){
        return size;
    }
    public void clear(){
        for (Node<T> x = firstNode; x != null; ) {
            Node<T> next = x.getNextNode();
            x.setValue(null);
            x.setNextNode(null);
            x.setPrevNode(null);
            x = next;
        }
        firstNode = lastNode = null;
        size=0;

    }




    public static void main(String[] args) {
        MyLinkedList<String> ownLL=new MyLinkedList<>();
        ownLL.add("Hello");
        ownLL.add("from");
        ownLL.add("Vasyl");
        ownLL.add("Va");
        System.out.println("ownLL.size() = " + ownLL.size());
        System.out.println(ownLL.get(1));
        System.out.println("ownLL.size() = " + ownLL.size());
        ownLL.remove(1);
        ownLL.remove(2);
        System.out.println("ownLL.size() = " + ownLL.size());
        for (int i = 0; i <ownLL.size() ; i++) {
            System.out.println(ownLL.get(i));
        }
        ownLL.clear();
        System.out.println("ownLL.size() = " + ownLL.size());
        System.out.println("__________________");
        for (int i = 0; i <ownLL.size() ; i++) {
            System.out.println(ownLL.get(i));
        }
        }
    public T get(int index){
       Node<T> currentNode=firstNode;
       for (int i=0; i<index;i++){
           currentNode=currentNode.getNextNode();
       }
       return currentNode.getValue();
    }
}
