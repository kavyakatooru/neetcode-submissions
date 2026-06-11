class LRUCache {

    int cap;
    Map<Integer, DLL> map;
    class DLL {
        int key;
        int val;
        DLL next;
        DLL prev;
        DLL(int key, int val) {
            this.key = key;
            this.val = val;
            this.next = null;
            this.prev = null;
        }
        void update(int key, int val) {
            this.key = key; 
            this.val = val;
        }
    }
    DLL head;
    DLL tail;

    public LRUCache(int capacity) {
        map = new HashMap<>();
        cap = capacity;
        head = new DLL(-1,-1);
        tail = new DLL(-1,-1);
        head.next = tail;
        tail.prev = head;
        
    }
    
    public int get(int key) {
        if (map.containsKey(key)) {
            DLL node = map.get(key);
            moveToStart(node);
            return node.val;
        }
        return -1;
    }
    
    public void put(int key, int value) {
        DLL node = map.get(key);
        if (node == null) {
            node = new DLL(key, value);
            map.put(key, node);
            addToCache(node);
            if (map.size() > cap) {
                DLL temp = deleteLRUFromCache();
                map.remove(temp.key);
            }
        } else {
            node.val = value;
            map.put(key, node);
            moveToStart(node);
        }
    }

    public void moveToStart(DLL node) {
        deleteNode(node);
        addToCache(node);
    }

    public DLL deleteLRUFromCache() {
        DLL temp = tail.prev;
        tail.prev = tail.prev.prev;
        temp.prev.next = tail;
        temp.next = null;
        temp.prev = null;
        return temp;
    }

    public void deleteNode(DLL node) {
        DLL prevNode = node.prev;
        DLL nextNode = node.next;
        prevNode.next = nextNode;
        nextNode.prev = prevNode;
    }

    public void addToCache(DLL node) {
        node.next = head.next;
        node.prev = head;
        node.next.prev = node;
        head.next = node;
    }
}
