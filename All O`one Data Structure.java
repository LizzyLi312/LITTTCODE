// using doubly linked list and hashmap 
class AllOne {
    HashMap<String, Integer> stringCnt;
    HashMap<Integer, Node> cntNode;
    Node head, tail;
    public AllOne() {
        stringCnt = new HashMap<>();
        cntNode = new HashMap<>();
        head = new Node(Integer.MIN_VALUE);
        tail = new Node(Integer.MAX_VALUE);
        head.next = tail;
        tail.prev = head;
    }
    
    public void inc(String key) {
        // update string-cnt map
        int oldCnt = stringCnt.getOrDefault(key, 0);
        stringCnt.put(key, oldCnt + 1);
        //update cnt-node map
        Node cur = cntNode.get(oldCnt);
        Node next = cntNode.get(oldCnt + 1);
        if (next == null) next = addNodeAfter(cur == null ? head : cur, oldCnt + 1); 
        next.set.add(key);
        if (cur != null) {
            cur.set.remove(key);
            if (cur.set.isEmpty()) removeNode(cur);
        }
    }
    
    public void dec(String key) {
        int oldCnt = stringCnt.getOrDefault(key, 0);
        if (oldCnt == 1) stringCnt.remove(key);
        else stringCnt.put(key, oldCnt - 1);

        Node cur = cntNode.get(oldCnt);
        Node prev = cntNode.get(oldCnt - 1);
        if (prev == null && oldCnt > 1) prev = addNodeAfter(cur.prev, oldCnt - 1);
        if (oldCnt > 1) prev.set.add(key);

        cur.set.remove(key);
        if (cur.set.isEmpty()) removeNode(cur);
    }
    
    public String getMaxKey() {
        if (head.next == tail) return "";
        else return tail.prev.set.iterator().next();
    }
    
    public String getMinKey() {
        if (head.next == tail) return "";
        else return head.next.set.iterator().next();
    }

    private Node addNodeAfter(Node prevNode, int cnt) {
        Node newNode = new Node(cnt);
        Node t = prevNode.next;
        prevNode.next = newNode;
        newNode.prev = prevNode;
        t.prev = newNode;
        newNode.next = t;
        cntNode.put(cnt, newNode);
        return newNode;
    }

    private void removeNode(Node node) {
        Node p = node.prev;
        Node n = node.next;
        p.next = n;
        n.prev = p;
        cntNode.remove(node.cnt);
        return;
    }

    class Node {
        Node next, prev;
        int cnt;
        HashSet<String> set;

        public Node(int c) {
            next = null;
            prev = null;
            cnt = c;
            set = new HashSet<>();
        }

    }
}

/**
 * Your AllOne object will be instantiated and called as such:
 * AllOne obj = new AllOne();
 * obj.inc(key);
 * obj.dec(key);
 * String param_3 = obj.getMaxKey();
 * String param_4 = obj.getMinKey();
 */
