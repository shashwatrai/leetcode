class Solution {
    public void traverse( Map<Integer,List<Integer>> adj, Set<Integer> set,
             int curr, int pathLen, int []arr,Map<Integer,Integer> dist){
        set.add(curr);
        arr[pathLen%2]++;
        dist.put(curr,pathLen);
        for(int j: adj.get(curr)){
            if(set.contains(j))
                continue;
            traverse(adj,set,j,pathLen+1,arr,dist);
        }
    }
    public int[] maxTargetNodes(int[][] edges1, int[][] edges2) {
        Map<Integer,List<Integer>> adj1 = new HashMap<>();
        Map<Integer,Integer> dist1 = new HashMap<>();
        for(int edge[]:edges1){
            if(!adj1.containsKey(edge[0]))
                adj1.put(edge[0],new ArrayList<>());
            if(!adj1.containsKey(edge[1]))
                adj1.put(edge[1],new ArrayList<>());
            
            adj1.get(edge[0]).add(edge[1]);
            adj1.get(edge[1]).add(edge[0]);
        }

        Map<Integer,List<Integer>> adj2 = new HashMap<>();

        for(int edge[]:edges2){
            if(!adj2.containsKey(edge[0]))
                adj2.put(edge[0],new ArrayList<>());
            if(!adj2.containsKey(edge[1]))
                adj2.put(edge[1],new ArrayList<>());
            
            adj2.get(edge[0]).add(edge[1]);
            adj2.get(edge[1]).add(edge[0]);
        }

        int n = edges1.length+1;
        Set<Integer> set = new HashSet<>();
        int dis1[] = new int[2];
        traverse(adj1,set,0,0,dis1,dist1);

        int m = edges2.length+1;
        set = new HashSet<>();
        int dis2[] = new int[2];
        Map<Integer,Integer> dist2 = new HashMap<>();
        traverse(adj2,set,0,0,dis2,dist2);


        int ans[] = new int[n];
        

        for(int i=0;i<n;i++){
            int t = dist1.get(i);
            if(t%2 == 0)
                ans[i] = dis1[0] + Math.max(dis2[0],dis2[1]);
            else
                ans[i] = dis1[1] + Math.max(dis2[0],dis2[1]);
        }
        return ans;

    }
}