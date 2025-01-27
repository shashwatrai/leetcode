class Solution {
    public void traverse( Map<Integer,List<Integer>> adj,int node, boolean []vis ,Map<Integer,Set<Integer>> map){
        vis[node] = true;
        Set<Integer> ans = new HashSet<>();
        if(adj.containsKey(node)){
            
            for(int j: adj.get(node)){
                if(!vis[j])
                    traverse(adj,j,vis,map);
                ans.addAll(map.get(j));
                ans.add(j);
            }
        }
        map.put(node,ans);
    }

    public List<Boolean> checkIfPrerequisite(int numCourses, int[][] prerequisites, int[][] queries) {
        Map<Integer,List<Integer>> adj = new HashMap<>();


        for(int i[]:prerequisites){
            if(!adj.containsKey(i[1])){
                adj.put(i[1],new ArrayList<>());
            }
            adj.get(i[1]).add(i[0]);
        }

        Map<Integer,Set<Integer>> map = new HashMap<>();
        boolean vis[]= new boolean[numCourses];

        for(int i=0;i<numCourses;i++){
            if(!vis[i]){
                traverse(adj,i,vis,map);
            }
        }

        List<Boolean> ans = new ArrayList<>();
        // System.out.println(map);
        for(int j=0;j<queries.length;j++){
            if(map.containsKey(queries[j][1]) && map.get(queries[j][1]).contains(queries[j][0])){
                ans.add(true);
            }else
                ans.add(false);
        }    
        return ans;  
    }
}