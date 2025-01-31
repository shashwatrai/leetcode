class Solution {
    public void traverse1(Map<Integer,List<Integer>> adj,boolean []vis,int curr,Set<Integer> members){
        vis[curr] = true;
        members.add(curr);
        if(adj.containsKey(curr)){
            for(int j:adj.get(curr)){
                if(!vis[j])
                    traverse1(adj,vis,j,members);
            }
        }
    }
    public int traverse2(Map<Integer,List<Integer>> adj,int n,int node,int []level){

        Queue<Integer> queue = new LinkedList<>();
        queue.add(node);
        int l =0;
        boolean vis[] = new boolean[n+1];
        vis[node] = true;
        level[node] = l;
        while(!queue.isEmpty()){
            int len  = queue.size();
            // System.out.println(queue+" "+l);
            while( len-- > 0){
                int curr = queue.poll();
                if(adj.containsKey(curr)){
                    for(int j:adj.get(curr)){
                        if(!vis[j]){
                            queue.add(j);
                            vis[j] = true;
                            level[j] = l+1;
                        }else{
                            if(Math.abs(level[j] - level[curr]) != 1)
                                return -1;
                        }
                    }
                }
            }
            l++;
        }
        // System.out.println(Arrays.toString(level)+" "+l+" "+node);
        return l;
    }
    public int magnificentSets(int n, int[][] edges) {

        Map<Integer,List<Integer>> adj = new HashMap<>();
        for(int []edge:edges){
            if(!adj.containsKey(edge[0]))
                adj.put(edge[0],new ArrayList<>());
            if(!adj.containsKey(edge[1]))
                adj.put(edge[1],new ArrayList<>());
            
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
        }

        Map<Integer,Set<Integer>> groupMap = new HashMap<>();

        boolean []vis = new boolean[n+1];
        int g = 1;
        for(int i=1;i<=n;i++){
            if(!vis[i]){
                Set<Integer> members = new HashSet<>();
                traverse1(adj,vis,i,members);
                groupMap.put(g++,members);
            }
        }

        int ans=0;

        for(int i:groupMap.keySet()){
            int max =0;
            for(int j: groupMap.get(i)){
               
                int level[] = new int[n+1];
                int hL = traverse2(adj,n,j,level);
                if(hL == -1){
                    // System.out.println(j +" "+ Arrays.toString(level));
                    return -1;
                }
                max = Math.max(hL,max);
            }
            ans+=max;
        }
        return ans;
    }
}