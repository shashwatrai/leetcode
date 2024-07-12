class Solution {
    public int accessCount(Map<Integer,List<Integer> > map , boolean []vis,int node){
        vis[node] = true;

        int total = 0;
        if(map.containsKey(node)){
            for(int i:map.get(node)){
                if(!vis[i]){
                    total += accessCount(map,vis,i);
                }
            }
        }
        return total + 1;
    }
    public long countPairs(int n, int[][] edges) {
        
        Map<Integer,List<Integer> > map = new HashMap<>();
        for(int i=0;i<edges.length;i++){
            if(!map.containsKey(edges[i][0]))
                map.put(edges[i][0],new ArrayList<>());
            if(!map.containsKey(edges[i][1]))
                map.put(edges[i][1],new ArrayList<>());
            
            map.get(edges[i][0]).add(edges[i][1]);
            map.get(edges[i][1]).add(edges[i][0]);
        }

        boolean [] vis = new boolean[n];
        List<Integer> ans = new ArrayList<>();
        for(int i=0;i<n;i++){
            if(!vis[i])
                ans.add(accessCount(map,vis,i));
        }

        long res = 0L;

        List<Integer> cum = new ArrayList<>();
        cum.add(ans.get(0));  

        for(int i=1;i<ans.size();i++){
            cum.add(cum.get(i-1)+ans.get(i));
        } 
        for(int i=1;i<cum.size();i++){
            res += (long)(cum.get(cum.size()-1) - cum.get(i-1)) * ans.get(i-1);
        }
        System.out.println(ans+" "+cum);
        return res;
    }
}