class Solution {
    public int maxScoreSightseeingPair(int[] values) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b)->b-a);

        int dist = 1;
        pq.add(values[0]);
        int ans=0;
        for(int i=1;i<values.length;i++){
            System.out.println(ans+" "+ (pq.peek()+values[i] - dist) );
            ans = Math.max(ans, pq.peek()+values[i] - dist);
            dist++;
            pq.add(values[i]+i);
        }
        return ans;
    }
}