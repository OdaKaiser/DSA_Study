class Stack {
    private Node top;
    private int height;

    public class Node {
        int value;
        Node next;
    
        Node (int value) {
            this.value = value;
        }
    }

    public Stack(int value) {
        Node newNode = new Node(value);
        top = newNode;
        height = 1;
    }

    public int getHeight() {
        return height;
    }

    public Node getTop(){
        return top;
    }
    //print Stack
    public void printStack() { 
        Node tmp = top;
        while (tmp!= null) {
            System.out.println(tmp.value);
            tmp = tmp.next;
        }
    }

    //push
    public void push(int value) {
        Node newNode = new Node(value);
        if (top==null){
            top = newNode;
        }else{
        newNode.next = top;
        top = newNode;
        }
        height++;
    }
    
    //pop
    public Node pop() {
        if (height==0) {
            return null;
        }
        Node tmp = top;
        top = top.next;
        temp.next = null;

        height--;
        return tmp;
    } 

    }
}