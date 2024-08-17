class Solution {
    public int maxScoreSightseeingPair(int[] values) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b)->b-a); // to give the maximum value possible 

        int dist = 1; // this keeps track of the distance requried to subtracted 
        pq.add(values[0]);
        int ans=0;
        for(int i=1;i<values.length;i++){
            
            ans = Math.max(ans, pq.peek()+values[i] - dist);
            dist++;
            pq.add(values[i]+i);
        }
        return ans;
    }
}
