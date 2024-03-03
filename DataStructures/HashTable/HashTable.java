import java.util.ArrayList;

public class HashTable {
    private int size = 7;
    
    class Node {
        private String key;
        private int value;
        private Node next;
        //constructor for Node
        Node(String key, int value) {
            this.key = key;
            this.value = value;
        }
    }
    
    private Node[] dataMap;

    private int hash(String key) {
        int hash = 0;
        char[] keyyChar = key.toCharArray();
        for (int i = 0; i < keyChar.length; i++) {
            int asciiValue = keyChar[i];
            hash = (hash + asciiValue*23) % dataMap.length;

        }
        return hash;
    }

    public HashTable() {
        dataMap = new Node[size];
    }
    public void set(String key, int value) {
        int index = hash(key);
        Node newNode = new Node(key, value);
        if (dataMap[index] != null) {
            dataMap[index] = newNode;
        } else {
            Node temp = dataMap[index];
            while (temp.next!= null) {
                temp = temp.next;
            }
            temp.next = newNode;
        }
    }
    public int get(String key) {   
        int index = hash(key);
        Node temp = dataMap[index]; 
        while (temp!= null) {
            if (temp.key == key) {
                return temp.value;
            }
            temp = temp.next;
        }
        return 0;
    }

    @SuppressWarnings("rawtypes")
    public ArrayList keys() {
        ArrayList<String> allKeys = new ArrayList<>();
        for (int i = 0; i < dataMap.length; i++) { {
            Node temp = dataMap[i];
            while (temp!= null) {
                allKeys.add(temp.key);
                temp = temp.next;
            }
        }
        return allKeys;
    }

}
