public class BST {

    Node root;

    public class Node {
        int value;
        Node left;;
        Node right;
    
        Node (int value) {
            this.value = value;
        }
    }
    
    //constructor empty tree
    public BST () {
    }
    
    //Insert
    public boolean insert(int value) {
        Node newNode = new Node(value);
        if (root == null) {
            root = newNode;
            return true;
        }
        Node tmp = root;
        while (true) {
            //val is already contained in BST
            if (newNode.value == tmp.value) {
                return false;
            }

            //Go left
            if (newNode.value < tmp.value) {
                if (tmp.left == null) {
                    tmp.left = newNode;
                    return true;
                }
                tmp = tmp.left;
            } else { //Go right
                if (tmp.right == null) {
                    tmp.right = newNode;
                    return true;
                }
                tmp = tmp.right;     
            }
        }
    }

    public boolean contain(int value) {
        Node tmp = root;
        while (tmp !=null) {
            if (value < tmp.value) {
                tmp = tmp.left;
            } else if (value > tmp.value) { 
                tmp = tmp.right;
            } else {
                return true;
            }
        }
        return false;
    }
}
