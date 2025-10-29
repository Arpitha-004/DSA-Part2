class LRUCache {
    int capacity;
    Node head = new Node(0,0);
    Node tail = new Node(0,0);
    Map<Integer,Node> mpp = new HashMap<>();

    public LRUCache(int capacity) {
        this.capacity = capacity;
        head.next = tail;
        tail.prev = head;
    }
    
    public int get(int key) {
        if(!mpp.containsKey(key))
            return -1;
        Node node = mpp.get(key);
        deleteNode(node);
        insertAfterHead(node);

        return node.value;
    }
    
    public void put(int key, int value) {
        if(mpp.containsKey(key)){
            Node node = mpp.get(key);
            node.value = value;
            deleteNode(node);
            insertAfterHead(node);
        }else{
            if(mpp.size()==capacity){
                Node node = tail.prev;
                mpp.remove(node.key);
                deleteNode(node);
            }
            Node node = new Node(key,value);
            mpp.put(key,node);
            insertAfterHead(node);
        }
    }

    public void deleteNode(Node node){
        Node bef = node.prev;
        Node aft = node.next;

        bef.next = aft;
        aft.prev = bef;
    }

    public void insertAfterHead(Node node){
        Node cur = head.next;
        head.next = node;
        node.prev = head;
        node.next = cur;
        cur.prev = node;
    }
}
class Node{
    int key,value;
    Node prev,next;
    Node(int key,int value){
        this.key=key;
        this.value=value;
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */