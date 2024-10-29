class Solution {

    public void dfs(Map<Integer,Set<Integer>> adj,boolean []vis,int node){
        vis[node] = true;

        if(adj.containsKey(node)){
            for(int j:adj.get(node)){
                if(!vis[j]){
                    dfs(adj,vis,j);
                }
            }
        }
    }
    public double calculateDist(double x1,double y1,double x2,double y2){
        return Math.sqrt((double)((x1-x2)*(x1-x2) + (y1-y2)*(y1-y2)));
    }

    public int maximumDetonation(int[][] bombs) {
        int n = bombs.length;

        Map<Integer,Set<Integer>> adj = new HashMap<>();

        
        for(int i=0;i<n;i++){
            adj.put(i,new HashSet<>());
            for(int j=0;j<n;j++){
                
                double dist =  calculateDist(bombs[i][0],bombs[i][1],bombs[j][0],bombs[j][1]);
                if(dist > (double)bombs[i][2]){
                    continue;
                } 
                adj.get(i).add(j);
            }
        }
        
        int max = 0;
        for(int i:adj.keySet()){
            boolean []vis = new boolean[n];
            
            dfs(adj,vis,i);
            int cnt=0;
            for(int j=0;j<n;j++){
                if(vis[j])
                    cnt++;
            }
            max = Math.max(cnt,max);

        }
        return max;
    }
}