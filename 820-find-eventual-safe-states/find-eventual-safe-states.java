class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        int n = graph.length;

        List<Integer> adj[] = new List[n];
        int inDegree[] = new int[n];
        Queue<Integer> queue = new LinkedList<>();
        boolean []vis = new boolean[n];
        for(int i=0;i<n;i++){
           
            inDegree[i] = graph[i].length;
            for(int j:graph[i]){
                if(adj[j] == null){
                    adj[j] = new ArrayList<>();
                }
                adj[j].add(i);
            }
            if(inDegree[i] == 0)
                queue.add(i);
        }  
        // System.out.println(Arrays.toString(inDegree)+"\n"+Arrays.toString(adj));
        while(!queue.isEmpty()){
            int curr = queue.poll();
            vis[curr] = true;

            if(adj[curr]!= null){
                for(int j:adj[curr]){
                    inDegree[j]--;
                    if(inDegree[j] == 0)
                        queue.add(j);
                }
            }
        }
        List<Integer> ans = new ArrayList<>();
        for(int i=0;i<n;i++)
            if(vis[i])
                ans.add(i);
        return ans;
    }
}