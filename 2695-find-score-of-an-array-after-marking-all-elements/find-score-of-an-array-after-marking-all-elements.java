class Solution {
    public long findScore(int[] nums) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b)-> nums[a] != nums[b] ? nums[a] - nums[b] : a - b);

        int n = nums.length;

        for(int i=0;i<n;i++)
            pq.add(i);

        boolean []vis = new boolean[n];
        long score = 0L;
        while(!pq.isEmpty()){
            int t = pq.poll();

            if(vis[t])
                continue;

            score += (long)nums[t];

            vis[t] = true;

            if(t+1 < n)
                vis[t+1] = true;
            if(t > 0)
                vis[t-1] = true;
        }
        return score;
        
    }
}