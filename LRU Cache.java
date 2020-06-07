class LRUCache{
    private int capacity;
    private int curSize;
    private HashMap<Integer, DLL> map; //cache
    private DLL head;
    private DLL tail;
    
    public LRUCache(int capacity) {
        this.capacity = capacity;
        curSize = 0;
        map = new HashMap<>();
        head = new DLL(0, 0); //take dummy node as head and tail 
        tail = new DLL(0, 0); 
        head.next = tail;
        tail.prev = head;
    }
    
    public int get(int key) { 
    // Get the value (will always be positive) of the key if the key exists in the cache, otherwise return -1
        if(!map.containsKey(key)) return -1;
        DLL node = map.get(key);
        moveToHead(node); 
        return node.val;
    }
    /*
    Set or insert the value if the key is not already present. When the cache reached its capacity, 
    it should invalidate the least recently used item before inserting a new item.
    */
    public void put(int key, int value) {
        if(!map.containsKey(key)){ 
            DLL node = new DLL(key, value);
            map.put(key, node);
            if(curSize < capacity) curSize++;
            else{ //if the size is over capacity. then delete the last word (delete node from doubly linked list)
                DLL lastOne = tail.prev;
                lastOne.prev.next = tail;
                tail.prev = lastOne.prev;
                map.remove(lastOne.key);
            }
            moveToHead(node);
        }
        else{
            DLL node = map.get(key);
            node.set(value);
            moveToHead(node);
        }
    }
    private void moveToHead(DLL node){
        DLL prev = node.prev;
        DLL next = node.next;
        //cut the previous connection
        if(prev != null) prev.next = next; 
        if(next != null) next.prev = prev; 
        //put the node to the head 
        node.next = head.next;
        head.next = node;
        node.prev = head;
        node.next.prev = node;
    }
    class DLL{ //doubly linked list
        public int key;
        public int val;
        public DLL prev;
        public DLL next;
        
        public DLL(int key, int v){
            this.key = key;
            val = v;
        }
        public void set(int v){
            val = v;
        }
    }
}
