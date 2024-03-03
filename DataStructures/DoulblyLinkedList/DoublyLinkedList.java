class DoublyLinkedList {
    private Node tail;
    private Node head;
    private int length;

    public class Node {
        int value; 
        Node next;
        Node prev;

        Node (int value) {
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

    //Constructor for DoublyLinkedList
    public DoublyLinkedList (int value) {
        Node newNode = new Node(value);
        head = newNode;
        tail = newNode;
        length = 1;
    }

    public void append(int value) {
        Node newNode = new Node(value);
        if (length == 0) {
            head = newNode;
            tail = newNode;
            newNode.next = null;
            newNode.prev = null;
        } else {
            tail.next=newNode;
            newNode.prev = tail;
            tail= newNode;
        }
        length++;
    }

    public Node removeLast() {
        if (length == 0) {
            return null;
        }
        Node tmp = tail;
        if (length == 1) {
            head = null;
            tail = null;
        } else  {
            tail = tail.prev;
            tail.next = null;
            tmp.prev = null;
        }
        length--;
        return tmp;
    }

    public void prepend(int value) {
        Node newNode = new Node(value);
        if (length == 0) {
            head = newNode;
            tail = newNode;
        } else {
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
        }
        length++;
    }

    public Node removeFist() {
        if (length == 0) {
            return null;
        }
        Node tmp = head;
        if( length == 1) {
            tail = null;
            head = null;
        } else {
            head = head.next;
            head.prev = null;
            tmp.next = null;
        }
        length--;
        return tmp;       
    }

    public Node get(int index) {
        if (index < 0 || index >= length) {
            return null;
        }
        Node tmp = head;
        if (index < length/2)
        {
            for(int i = 0; i < index; i++) {
                tmp = tmp.next;
            }
        } else {
            for(int i = length-1; i > index; i--) {
                tmp = tmp.prev;
            }
        }
        return tmp;
    }

    public boolean set(int index, int value) {
        Node tmp = get(index); // condition to check in in set method
        if (tmp != null) {
            tmp.value = value;
            return true;
        }
        return false;
    }

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
        Node before = get(index-1);
        Node after = before.next;
        newNode.prev = before;
        newNode.next = after;
        before.next = newNode;
        after.prev = newNode;
        length++;
        return true;
    }

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
        Node tmp = get(index);
        tmp.next.prev = tmp.prev;
        tmp.prev.next= tmp.next;
        tmp.next = null;
        tmp.prev = null;
        length--;
        return tmp;
    }
}