
class Solution {
    
    public int minMaxWeight(int n, int[][] edges, int threshold) {
        
        Map<Integer,List<int[]>> adj = new HashMap<>();

        for(int edge[]: edges){
            if(!adj.containsKey(edge[1]))
                adj.put(edge[1],new ArrayList<>());
            
            adj.get(edge[1]).add(new int[]{edge[0],edge[2]});
        }

        int dp[] = new int[n];
        Arrays.fill(dp,Integer.MAX_VALUE);
        dp[0] = 0;
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> a[1] - b[1]);
        boolean []vis = new boolean[n];
        pq.add(new int[]{0,0});
        int count = n;
        while(!pq.isEmpty()){
            int[] node = pq.poll();
            if(vis[node[0]])
                continue;
            count--;
            if(count == 0)
                break;
            vis[node[0]] = true;
            if(adj.containsKey(node[0])){
                for(int edge[]:adj.get(node[0])){
                   if(!vis[edge[0]] && dp[edge[0]] > Math.max(edge[1],dp[node[0]])){
                        dp[edge[0]] = Math.max(edge[1],dp[node[0]]);
                        pq.add(new int[]{edge[0],dp[edge[0]]});
                   } 
                }
            }
        }
        int ans = Integer.MIN_VALUE;
        for(int i:dp)
            ans = Math.max(ans,i);
        return ans != Integer.MAX_VALUE ? ans : -1;
    }
}