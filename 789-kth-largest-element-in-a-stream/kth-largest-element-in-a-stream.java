class KthLargest {
    PriorityQueue<Integer> minPQ ;
    
    int size;
    public KthLargest(int k, int[] nums) {
        minPQ= new PriorityQueue<>(new Comparator<Integer>(){
            public int compare(Integer a, Integer b){
                return a-b;
            }
        });

        size = k;

        for(int i: nums){
            add(i);
        }

    }
    
    public int add(int val) {
       if(minPQ.size() < size){
            minPQ.add(val);
            if(minPQ.size() < size)
                return -1;
       }else{
            if(minPQ.peek() < val){
                minPQ.poll();
                minPQ.add(val);
            }
           
       }
        return minPQ.peek();
    }
}

/**
 * Your KthLargest object will be instantiated and called as such:
 * KthLargest obj = new KthLargest(k, nums);
 * int param_1 = obj.add(val);
 */