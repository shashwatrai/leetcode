class Solution {
    public int nthUglyNumber(int n) {
        Set<Long> set = new HashSet<>();
        PriorityQueue<Long> pq = new PriorityQueue<>((a,b)->a-b > 0L ? -1:1);
        if(n == 1)  
            return 1;

        set.add(1L);
        pq.add(1L);
        // System.out.println(x);
        Set<Long> traversal = new HashSet<>();
        traversal.add(1L);
        for(;pq.size()<4*n;){
            Set<Long> temp = new HashSet<>();
            for(long k : traversal){
                
                
                
                
                if((long)k*2L > k && !set.contains((long)k*2L)){
                    temp.add((long)k*2L);
                    pq.add((long)k*2L);
                    set.add((long)k*2L);
                }
                if((long)k*3L > k && !set.contains((long)k*3L)){
                    temp.add((long)k*3L);
                    pq.add((long)k*3L);
                    set.add((long)k*3L);
                }
                if((long)k*5L > k && !set.contains((long)k*5L)){
                    temp.add((long)k*5L);
                    pq.add((long)k*5L);
                    set.add((long)k*5L);
                }
            }
           
            traversal = temp;
        }
        // System.out.println(pq);
        while(pq.size() > n)
            pq.poll();
        long ans  = pq.peek();
        // System.out.println(pq.poll()+" "+pq.poll() +" "+ pq.size());
        return (int)ans;
    }
}
