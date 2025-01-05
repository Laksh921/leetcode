class LRUCache {
    HashMap<Integer, Node> map = new HashMap<>();;
    private final int capacity;
    private final Node head, tail;
    public class Node{
        int key, data;
        Node next;
        Node prev;
        public Node(int key, int data){
            this.key = key;
            this.data = data;
            this.prev = null;
            this.next = null;
        }
    }
    public LRUCache(int capacity) {
        this.capacity = capacity;
        head = new Node(0,0);
        tail = new Node(0,0);
        head.next = tail;
        tail.prev = head;
    }
    private void removeNode(Node node){
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }
    private void addNode(Node node){
        node.next = head.next;
        node.prev = head;
        head.next.prev = node;
        head.next = node;
    }
    
    public int get(int key) {
        if(!map.containsKey(key)){
            return -1;
        }
        Node node = map.get(key);
        removeNode(node);
        addNode(node);
        return node.data;
    }
    
    public void put(int key, int value) {
        if(map.containsKey(key)){
            Node node = map.get(key);
            removeNode(node);
        }
        else if(map.size() == capacity){
            Node lru = tail.prev;
            removeNode(lru);
            map.remove(lru.key);
        }
        Node newNode = new Node(key, value);
        addNode(newNode);
        map.put(key,newNode);
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */