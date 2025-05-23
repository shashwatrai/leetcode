class Solution {
    public long maximumValueSum(int[] nums, int k, int[][] edges) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b) -> {
            int d1 = (k ^ nums[a]) - nums[a];
            int d2 = (k ^ nums[b]) - nums[b];
            return d1-d2;
        });
        long ans = 0L;
        for(int i=0;i<nums.length;i++){
            ans += (long)nums[i];
            pq.add(i);
        }
        // System.out.println(pq.size());
        if(pq.size() %2 == 1){
            pq.poll();
            // System.out.println(t+" "+(k ^ nums[t] )+" "+((k ^ nums[t] )- nums[t]));
            // System.out.println(pq.poll());
        }
        while(!pq.isEmpty()){
            int a = pq.poll();
            int b = pq.poll();
            int v1 = ((k ^ nums[a] )- nums[a]);
            int v2 = ((k ^ nums[b] )- nums[b]);
            if(v1 + v2 >= 0){
                ans += (long)(v1+v2);
            }
            
        }
        return ans;
    }
}