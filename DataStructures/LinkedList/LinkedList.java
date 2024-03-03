class LinkedList {
    private Node tail;
    private Node head;
    private int length;
    
    class Node {
        Node next;
        int value;
        //constructor for Node
        Node(int value) {
            this.value = value;
        }
    }

    public Node getHead() {
        return head;
    }

    public Node getTail() {
        return tail;    }
    
    public int getheight() {
        return length;
    }

    //Constructor for LinkedList
    public LinkedList(int value) {
        Node newNode = new Node(value);
        head = newNode;
        tail = newNode;
        length = 1;
    }

    //print list
    public void printList() {
        Node tmp = head;
        while (tmp !=null){
            System.out.println(tmp.value);
            tmp = tmp.next;
        }
    }
    //append 
    public void append(int value) {
        Node newNode = new Node(value);
        if (length == 0) {
            head = newNode;
            tail = newNode;
            newNode.next = null;
        } else {
            tail.next=newNode;
            tail= newNode;
        }
    }
    
    //remove last node
    public Node removeLast() {
        Node pre = head;
        Node tmp = head;
        while (tmp.next != null) {
            pre = tmp;
            tmp = tmp.next;
        }
        tail = pre;
        tail.next = null;
        length--;
        if (length == 0) {
            head = null;
            tail = null;
        }
        return tmp;
    }
    
    //prepend
    public void prepend(int value) {
        Node newNode = new Node(value);
        if (length == 0) {
            head = newNode;
            tail = newNode;
        } else {
            newNode.next = head;
            head = newNode;
        }
        length++;
    }

    //remove frist node
    public Node removeFist() {
        if (length == 0) {
            return null;
        }
        Node tmp = head;
        head = head.next;
        tmp.next = null;
        length--;
        if( length == 0) {
            tail = null;
        }
        return tmp;       
    }

    //get index
    public Node get(int index) {
        if (index < 0 || index >= length) {
            return null;
        }
        Node tmp = head;
        for(int i = 0; i < index; i++) {
            tmp = tmp.next;
        }
        return tmp;
    }

    //set values indexed
    public boolean set(int index, int value) {
        Node tmp = get(index); // condition to check in in set method
        if (tmp != null) {
            tmp.value = value;
            return true;
        }
        return false;
    }

    //Insert
    public boolean insert(int index, int value) {
        if (index < 0 || index > length) {
            return false;
        }
        if (index == 0)
        {
            prepend(value);
            return true;
        }
        if (index == length) {
            append(value);
            return true;
        }
        Node newNode = new Node(value);
        Node tmp = get(index-1);
        newNode.next = tmp.next;
        tmp.next = newNode;
        return true;
    }

    //Remove
    public Node remove(int index) {
        if (index < 0 || index > length) {
            return null;
        }
        if (index == 0) {
            return removeFist();
        } 
        if (index == length -1){
            return removeLast();
        }

        Node prev = get(index -1);
        Node tmp = prev.next;
        prev.next = tmp.next;
        tmp.next = null;
        length--;
        return tmp;
    }

    //reverse the LinkedList
    void reverseList() {
        Node tmp = head;
        head = tail;
        tail = tmp;
        Node after = tmp.next;
        Node before = null;
        for (int i = 0; i < length; i++) {
            after = tmp.next;
            tmp.next = before;
            before = tmp;
            tmp = after;
        }
    }
}