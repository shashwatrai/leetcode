class Solution {
    public int minOperations(int[] nums, int k) {
        PriorityQueue<Long> pq  = new PriorityQueue<>();

        for(int i:nums)
            pq.add((long)i);
        
        int count=0;
        while(!pq.isEmpty() && pq.peek() < k){
            long a = pq.poll();
            long b= pq.poll();
            pq.add((long)((long)((long)a*2L) + (long)b));
            count++;
        }
        return count;

    }
}