package demo;

import java.util.HashMap;

public class LruHashMap1<K,V> {

    private Node head = new Node(null,null);
    private Node tail = new Node(null,null);
    private int capcity  = 0;
    private HashMap<K,Node> map = new HashMap<K, Node>();
    private int size = 0;

    public LruHashMap1(int capcity){
        this.capcity = capcity;

        head.next = tail;
        tail.pre = head;
    }

    public void put(K key,V val){
        if(map.containsKey(key)){
            Node node = map.get(key);
            node.val = val;

            node.pre.next = node.next;
            node.next.pre = node.pre;

            addtoTail(node);

            map.put(key,node);
            return;
        }

        if(size + 1 > capcity){
            Node del = head.next;


            head.next = del.next;
            del.next.pre = head;
            del.pre = null;
            del.next = null;

            map.remove(del.key);
            size--;
        }

        Node node = new Node(key,val);
        map.put(key,node);
        addtoTail(node);
        size++;
    }

    public Node getHead(){
        return head.next;
    }
    private void addtoTail(Node node) {

        node.pre = tail.pre;
        tail.pre.next = node;

        node.next = tail;
        tail.pre = node;
    }

    static class Node<K,V>{
        Node pre;
        Node next;
        K key;
        V val;

        Node(K key,V val){
            this.key = key;
            this.val = val;
            pre = null;
            next = null;
        }
    }

    public static void main(String[] args) {
        LruHashMap1 lru = new LruHashMap1<Integer,Integer>(15);
        for(int i = 0; i < 200; i ++){
            lru.put(i,i);
            Node head = lru.getHead();
            System.out.println(" In times "+i+" get Head val = "+head.val == null ? " nul" : head.val);
        }
    }
}
