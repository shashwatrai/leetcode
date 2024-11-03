class Node{
    int val;
    long cnt;
    Node(int v,long c){
        this.val = v;
        this.cnt = c;
    }
    public String toString(){
        return "val:"+ this.val;
    }
}

class MKAverage {


    TreeSet<Node> left;
    TreeSet<Node> center;
    TreeSet<Node> right;
    Queue<Node> queue;
    int capacity;
    int size;
    int centerSum;
    long cnt;
    public MKAverage(int m, int k) {
        capacity = m;
        size = k;
        left = new TreeSet<>((a,b)->a.val != b.val ? a.val - b.val: Long.compare(a.cnt,b.cnt));
        right = new TreeSet<>((a,b)->a.val != b.val ? a.val - b.val: Long.compare(a.cnt,b.cnt));
        center = new TreeSet<>((a,b)->a.val != b.val ? a.val - b.val: Long.compare(a.cnt,b.cnt));
        queue = new LinkedList<>();
        centerSum =0;
        cnt = 0L;
    }
    
    public void addElement(int num) {
        Node newNode = new Node(num,cnt++);
        queue.add(newNode);
        if(queue.size() > capacity){
            Node ele = queue.poll();
            if(left.contains(ele)){
                left.remove(ele);
            }else if(center.contains(ele)){
                centerSum -= ele.val;
                center.remove(ele);
            }else{
                right.remove(ele);               
            }
            backFill();
        }
        left.add(newNode);    
        balance();
                // System.out.println(queue+" "+left+" "+center+" "+right);
    }
    private void backFill(){
        while(left.size() < size){
            Node first = center.first();
            centerSum -= first.val;
            left.add(first);
            center.remove(first);
        }
        while(center.size() < capacity - 2*size){
            Node first = right.first();
            centerSum += first.val;
            center.add(first);
            right.remove(first);
        }
    }
    private void balance(){
        
        while(left.size() > size){
            Node last = left.last();
            centerSum += last.val;
            left.remove(last);
            center.add(last);
        }
        
        
        while(center.size() > capacity - 2*size){
            Node last = center.last();
            centerSum -= last.val;
            center.remove(last);
            right.add(last);
        }
        
        
        // while(right.size() > size){
        //     Node last = right.last();
        //     left.add(last);
        //     right.remove(last);
        // }
        // balance();
    }
    
    public int calculateMKAverage() {
        // System.out.println(queue+" "+left+" "+center+" "+right);
        if(queue.size() != capacity)
            return -1;
        
        return (centerSum)/(capacity - 2 * size);
    }
}

/**
 * Your MKAverage object will be instantiated and called as such:
 * MKAverage obj = new MKAverage(m, k);
 * obj.addElement(num);
 * int param_2 = obj.calculateMKAverage();
 */