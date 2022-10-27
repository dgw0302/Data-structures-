package LRU;


import java.util.HashMap;
import java.util.Map;

public class LRU {


    class Node {
        int key;
        int value;

        Node pre;
        Node next;

        public Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
        public Node() {
        }
    }


    Map<Integer, Node> map = new HashMap<>();

    public int capacity;

    int size;

    public Node head;
    public Node tail;

    public LRU(int capacity) {
        this.capacity = capacity;
        this.size = 0;
        head =  new Node();
        tail = new Node();
        head.next = tail;
        tail.pre = head;
    }



    public int get(int key) {

        Node res = map.get(key);
        if(res == null) return -1;

        MoveToHead(res);
        return res.value;

    }

    public void put(int key, int value) {
        Node node = map.get(key);
        if(node == null) {

            Node newNode = new Node(key, value);
            map.put(key,newNode);
            addToHead(newNode);
            size++;
            if(size > capacity) {
                Node tailpre = RemoveTail();
                map.remove(tailpre.key);
                size--;
            }

        } else {
            node.value = value;
            MoveToHead(node);
        }

    }

    public void addToHead(Node node) {
        node.pre = head;
        node.next = head.next;
        node.next.pre = node;
        head.next = node;
    }

    public void RemoveNode(Node node) {
        node.pre.next = node.next;
        node.next.pre = node.pre;
    }

    public void MoveToHead(Node node) {
        RemoveNode(node);
        addToHead(node);
    }

    public Node RemoveTail() {
        Node temp = tail.pre;
        RemoveNode(temp);
        return temp;
    }





















}
