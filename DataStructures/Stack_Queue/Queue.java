public class Queue {
    private Node first;
    private Node last;
    private int length;

    public class Node {
        int value;
        Node next;
    
        Node (int value) {
            this.value = value;
        }
    }

    public int getLength() {
        return length;
    }

    public Node getFirst(){
        return first;
    }

    public Node getLast(){
        return last;
    }

    //constructor
    Queue(int value) {
        Node newNode = new Node(value);
        first = newNode;
        last = newNode;
        length = 1;
    }

    //print
    public void printQueue() {
        Node tmp = first;
        while (tmp != null) {
            System.out.println(tmp.value);
            tmp = tmp.next;
        }
    }
    
    //Enqueue 
    public void enqueue(int value) {
        Node newNode = new Node(value));
        if (length == 0) {
            first = newNode;
            last = newNode;    
        } else {
            last.next = newNode;
            last = newNode;
        }
    }

    //Dequeue
    public Node dequeue() {
        Node tmp = first;
        if (length == 0) {
            return null;
        }
        if (length == 1) {
            first = null;
            last = null;
        } else {
            first = first.next;
            tmp.next = null;
        }
        return tmp;
    }
    
}

