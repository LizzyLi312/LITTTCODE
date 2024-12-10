// HashMap (Integer, Node) + doubly linked list 
class LRUCache {
    HashMap<Integer, Node> map;
    Node head, tail;
    int capa;

    public LRUCache(int capacity) {
        map = new HashMap<>();
        head = new Node(-1, -1);
        tail = new Node(-1, -1);
        capa = capacity;

        head.next = tail;
        tail.prev = head;
    }
    
    public int get(int key) {
        if (map.containsKey(key)) {
            Node p = map.get(key);
            remove(p);
            insertToHead(p);
            return p.val;
        }
        else return -1;
        
    }
    
    public void put(int key, int value) {
        if (map.containsKey(key)) {
            Node p = map.get(key);
            p.val = value;
            remove(p);
            insertToHead(p);
        } else {
            if (map.size() == capa) {
                map.remove(tail.prev.key); // NEED TO REMOVE THE MAP FIRST OTHERWISE tail.prev would be a differnet element
                remove(tail.prev);
            }
            Node p = new Node(key, value);
            map.put(key, p);
            insertToHead(p);
        }
    }

    private void remove(Node node) {
        Node prev = node.prev;
        Node next = node.next;
        prev.next = next;
        next.prev = prev;
    }

    private void insertToHead(Node node) {
        Node next = head.next;
        node.next = next;
        head.next = node;
        next.prev = node;
        node.prev = head;
        
    }

    class Node {
        int key, val;
        Node prev, next;

        public Node(int key, int val) {
            this.key = key;
            this.val = val;
            this.prev = null;
            this.next = null;
        }
    }
}
