class LRUCache {

    private HashMap<Integer, DBLinkList> hm;
    private DBLinkList first;
    private DBLinkList last;
    private int capacity;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        hm = new HashMap<>();
        first = new DBLinkList();
        last = new DBLinkList();
        first.next = last;
        last.prev = first;
    }

    private void remove(DBLinkList node) {
        node.next.prev = node.prev;
        node.prev.next = node.next;
    }

    private void insert(DBLinkList node) {
        node.next = first.next;
        node.next.prev = node;
        first.next = node;
        node.prev = first;
    }



    
    public int get(int key) {
        if (!hm.containsKey(key)) return -1;

        DBLinkList node = hm.get(key);
        remove(node);
        insert(node);

        return node.value;
    }
    
    public void put(int key, int value) {
        if (hm.containsKey(key)) remove(hm.get(key));
        DBLinkList newNode = new DBLinkList(key, value);
        insert(newNode);
        hm.put(key, newNode);

        if (hm.size() > capacity) {
            hm.remove(last.prev.key);
            remove(last.prev);
        }
    }
}

class DBLinkList {
    public DBLinkList prev;
    public DBLinkList next;
    public int key;
    public int value;

    public DBLinkList() {

    }

    public DBLinkList(int k, int val) {
        key = k;
        value = val;
    }
}
