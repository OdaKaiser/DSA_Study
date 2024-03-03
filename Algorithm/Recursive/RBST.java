import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class RBST {

    Node root;

    public class Node {
        int value;
        Node left;;
        Node right;
    
        Node (int value) {
            this.value = value;
        }
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

    public boolean rContain(Node currentNode, int value) {
        if (currentNode == null) {
            return false;
        }
        
        if (currentNode.value == value) {
            return true;
        }

        if (value < currentNode.value) {
            return rContain(currentNode.left, value);
        } else {
            return rContain(currentNode.right, value);
        }
    }

    public boolean rContain(int value) {
        return rContain(root, value);
    }

    private Node rInsert(Node currentNode, int value) {
        if (currentNode == null) {
            return new Node(value);
        }

        if (value < currentNode.value) {
            return rInsert(currentNode.left, value);
        } else if (value > currentNode.value) {
            return rInsert(currentNode.right, value);
        }

        return currentNode;
    }

    public void rInsert(int value) {
        if (root == null) {
            root = new Node(value);
        }
        root = rInsert(root, value);
    }

    public int minValue(Node currentNode) {
        while (currentNode.left != null) {
            currentNode = currentNode.left;
        }
        return currentNode.value;
    }
    
    private Node deleteNode(Node currentNode, int value) {
        if (currentNode == null) {
            return null;
        }

        if (value < currentNode.value) {
            currentNode.left = deleteNode(currentNode.left, value);
        } else if  (value > currentNode.value){
            currentNode.right = deleteNode(currentNode.right, value);
        } else {
            if (currentNode.left == null && currentNode.right == null) {
                return null;
            } else if (currentNode.left == null ) {
                currentNode = currentNode.right;
            } else if ( currentNode.right == null ) {
                currentNode = currentNode.left;
            } else {
                int subTreeMin = minValue(currentNode.right);
                currentNode.value = subTreeMin;
                currentNode.right = deleteNode(currentNode.right, subTreeMin);
            }
        } 
        return currentNode;
        }
    
     public void deleteNode(int value) {
        deleteNode(root, value);
    }

    public ArrayList<Integer> BFS() {
        Node currentNode = root;
        Queue<Node> queue = new LinkedList<>();
        ArrayList<Integer> results = new ArrayList<>();
        queue.add(currentNode);

        while (queue.size() > 0) {
            currentNode = queue.remove();
            results.add(currentNode.value);
            if (currentNode.left != null) {
                queue.add(currentNode.left);
            }
            if (currentNode.right != null) {
                queue.add(currentNode.right);
            }
        }
        return results;
    }

    public ArrayList<Integer> DFSPreOrder() {
        ArrayList<Integer> results = new ArrayList<>();

        class Traverse {
            Traverse(Node currentNode) {
                results.add(currentNode.value);
                if (currentNode.left != null) {
                    new Traverse(currentNode.left);
                }
                if (currentNode.right != null) {
                    new Traverse(currentNode.right);
                }
            }
        }

        new Traverse(root);
        return results;
    }

    public ArrayList<Integer> DFSPostOrder() {
        ArrayList<Integer> results = new ArrayList<>();

        class Traverse {
            Traverse(Node currentNode) {
                if (currentNode.left != null) {
                    new Traverse(currentNode.left);
                }
                if (currentNode.right != null) {
                    new Traverse(currentNode.right);
                }
                results.add(currentNode.value);
            }
        }

        new Traverse(root);
        return results;
    }

    public ArrayList<Integer> DFSInOrder() {
        ArrayList<Integer> results = new ArrayList<>();

        class Traverse {
            Traverse(Node currentNode) {
                if (currentNode.left != null) {
                    new Traverse(currentNode.left);
                }
                results.add(currentNode.value);
                if (currentNode.right != null) {
                    new Traverse(currentNode.right);
                }
            }
        }

        new Traverse(root);
        return results;
    }
}
