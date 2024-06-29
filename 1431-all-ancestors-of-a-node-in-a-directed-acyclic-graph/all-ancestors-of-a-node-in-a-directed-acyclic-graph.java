class Solution {
    public void traverse(Map<Integer,List<Integer>> adj, boolean []vis,int node,int start,List<Integer> res){
        vis[node] = true;

        if(adj.containsKey(node)){
            for(int i:adj.get(node)){
                if(!vis[i]){
                    traverse(adj,vis,i,start,res);
                }
            }
        }
        

        if(node != start) 
            res.add(node);
    }
    public List<List<Integer>> getAncestors(int n, int[][] edges) {
        
        

        Map<Integer,List<Integer>> adj = new HashMap<>();
        for(int i=0;i<edges.length;i++){
            if(!adj.containsKey(edges[i][1])){
                adj.put(edges[i][1],new ArrayList<>());
            }
            adj.get(edges[i][1]).add(edges[i][0]);
        }


        List<List<Integer>> ans = new ArrayList<>();
        for(int i=0;i<n;i++){
            
                List<Integer> temp = new ArrayList<>();
                traverse(adj,new boolean[n],i,i,temp);
                Collections.sort(temp);
                ans.add(temp);
            
        }
        return ans;
    }
}