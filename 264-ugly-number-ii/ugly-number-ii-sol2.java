class Solution {
    public int nthUglyNumber(int n) {
        PriorityQueue<Long> pq = new PriorityQueue<>();

        Set<Long> set  = new HashSet<>();
        pq.add(1L);
        set.add(1L);
        long curr = 1L;

        for(int i=0;i<n;i++){
            curr = pq.poll();

            if((long)curr*2 > 0L && !set.contains((long)curr*2 )){
                pq.add((long)curr*2);
                set.add((long)2*curr);
            }
            if((long)curr*3 > 0 && !set.contains((long)curr*3)){
                pq.add((long)curr*3);
                set.add((long)3*curr);
            }
            if((long)curr*5 > 0 && !set.contains((long)curr*5)){
                pq.add((long)curr*5);
                set.add((long)5*curr);
            }
        }
        return (int)curr;
    }
}
