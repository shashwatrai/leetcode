class Solution {
    public void traverse(Map<Integer,List<Integer>> adj,  Set<Integer> vis, int curr, int d,int k,int arr[]){
        if(d > k)
            return;
        vis.add(curr);
        arr[d]++;

        for(int j:adj.get(curr)){
            if(!vis.contains(j)){
                traverse(adj,vis,j,d+1,k,arr);
            }
        }

    }
    public int[] maxTargetNodes(int[][] edges1, int[][] edges2, int k) {
        int n = edges1.length+1;
        int m = edges2.length+1;

        int dp1[][] = new int[n][k+1];
        Map<Integer,List<Integer>> adj1 = new HashMap<>();
        for(int edge[]: edges1){
            if(!adj1.containsKey(edge[0]))
                adj1.put(edge[0],new ArrayList<>());
            if(!adj1.containsKey(edge[1]))
                adj1.put(edge[1],new ArrayList<>());
            
            adj1.get(edge[0]).add(edge[1]);
            adj1.get(edge[1]).add(edge[0]);
        }

        for(int i=0;i<n;i++){
            Set<Integer> vis = new HashSet<>();
            traverse(adj1,vis,i,0,k, dp1[i]);
        }

        for(int i =0;i<n;i++){
            for(int j=1;j<=k;j++){
                dp1[i][j] += dp1[i][j-1];
            }
        }

        int dp2[][] = new int[m][k+1];
        Map<Integer,List<Integer>> adj2 = new HashMap<>();
        for(int edge[]: edges2){
            if(!adj2.containsKey(edge[0]))
                adj2.put(edge[0],new ArrayList<>());
            if(!adj2.containsKey(edge[1]))
                adj2.put(edge[1],new ArrayList<>());
            
            adj2.get(edge[0]).add(edge[1]);
            adj2.get(edge[1]).add(edge[0]);
        }


        for(int i=0;i<m;i++){
             Set<Integer> vis = new HashSet<>();
            traverse(adj2,vis,i,0,k, dp2[i]);
        }
        
        for(int i =0;i<m;i++){
            for(int j=1;j<=k;j++){
                dp2[i][j] += dp2[i][j-1];
            }
        }

        int ans[] = new int[n];

        for(int i=0;i<n;i++){
            int max = 0;
            for(int j=0;j<m;j++){
                max = Math.max(max,(k>0?dp2[j][k-1]:0));
            }
            ans[i] = max + dp1[i][k];
        }
        return ans;
    }
}