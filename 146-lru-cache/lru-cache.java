class Node{
    int key;
    int val;
    Node left;
    Node right;
    
    Node(int k,int v, Node l, Node r){
        this.key = k;
        this.val =v;
        this.left = l;
        this.right = r;
    }
}
class LRUCache {

    int count;
    int capacity;
    Map<Integer,Node> map;
    Node head,tail;
    
    public LRUCache(int capacity) {
        count=0;
        this.capacity = capacity;
        map  = new HashMap<>();
        head = tail = new Node(-1,-1,null,null);
    }
    
    public int get(int key) {
        if(!map.containsKey(key))
            return -1;
        Node temp = map.get(key);
        if(temp != tail){
            temp.left.right = temp.right;
            temp.right.left = temp.left;
            tail.right = temp;
            temp.left = tail;
            temp.right = null;
            tail = temp;
        }
        return tail.val;
        
    }
    
    public void put(int key, int value) {
        if(map.containsKey(key)){
            get(key);
            tail.val = value;
            return ;
        }
        if(count == capacity){
            int kd = head.right.key;
            // System.out.println(kd);
            map.remove(kd);
            
            if(head.right != tail){
                head.right = head.right.right;
                head.right.left = head;
            }
            else
                tail = head;
            count--;
        }
        
        Node temp = new Node(key,value,tail,null);
        tail.right = temp;
        tail = temp;
        map.put(key,tail);
        count++;
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */