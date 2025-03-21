class Solution {
    public void traverse(Map<Integer,List<int[]>> adj ,boolean []vis,int arr[] ,
        int curr,int group,int []ans){
        if(vis[curr])
            return;
        vis[curr] = true;
        arr[curr] = group;

        if(adj.containsKey(curr)){
            for(int[] j:adj.get(curr)){
                ans[0] &= j[1];
                traverse(adj,vis,arr,j[0],group,ans);
                
            }
        }
    }
    public int[] minimumCost(int n, int[][] edges, int[][] query) {
        
        Map<Integer,List<int[]>> adj = new HashMap<>();
        
        for(int j[]:edges){
            if(!adj.containsKey(j[0]))
                adj.put(j[0],new ArrayList<>());
            if(!adj.containsKey(j[1]))
                adj.put(j[1],new ArrayList<>());
            adj.get(j[0]).add(new int[]{j[1],j[2]});
            adj.get(j[1]).add(new int[]{j[0],j[2]});
        }
        

        int arr[] = new int[n];
        Arrays.fill(arr,-1);

        boolean []vis = new boolean[n];
        Map<Integer,Integer> map = new HashMap<>();
        int g=0;
        for(int i=0;i<n;i++){
            if(!vis[i]){
                int []ans = new int[1];
                ans[0] = Integer.MAX_VALUE;
                traverse(adj,vis,arr,i,g,ans);
                map.put(g,ans[0] != Integer.MAX_VALUE?ans[0]:-1);
                g++;
            }
        }
        int []res = new int[query.length];
        for(int i=0;i<query.length;i++){
            if(arr[query[i][0]] != arr[query[i][1]])
                res[i] = -1;
            else
                res[i] = map.get(arr[query[i][0]]);

        }
        return res;
    }
}