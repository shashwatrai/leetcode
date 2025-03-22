class Solution {
    public void traverse(Map<Integer,List<Integer>> adj,int curr, boolean []vis,int []ec,int []mc){
        if(vis[curr]){
            return;
        }
        mc[0]++;
        vis[curr]=true;
        if(adj.containsKey(curr)){
            for(int j:adj.get(curr)){
                ec[0]++;
                traverse(adj,j,vis,ec,mc);
            }
        }
    }
    public int countCompleteComponents(int n, int[][] edges) {
        Map<Integer,List<Integer>> adj = new HashMap<>();
        for(int []edge:edges){
            if(!adj.containsKey(edge[0]))
                adj.put(edge[0],new ArrayList<>());
            if(!adj.containsKey(edge[1]))
                adj.put(edge[1],new ArrayList<>());
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
        }

        int ans=0;
        boolean []vis = new boolean[n];
        for(int i=0;i<n;i++){
            if(!vis[i]){
                int ec[] = new int[1];
                int mc[] = new int[1];
                traverse(adj,i,vis,ec,mc);
                if(ec[0] == ((mc[0]-1)*mc[0]))
                    ans++;
            }
        }
        return ans;
    }
}