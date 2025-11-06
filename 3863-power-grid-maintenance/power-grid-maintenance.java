class Solution {

    public void traverse(Map<Integer, List<Integer>> map, int []vis,int g,int src,TreeSet<Integer> tSet){

        vis[src] = g;
        tSet.add(src);
        if(map.containsKey(src)){
            for(int j: map.get(src)){
                if(vis[j] == 0)
                    traverse(map,vis,g,j,tSet);
            }
        }
    }
    public int[] processQueries(int c, int[][] connections, int[][] queries) {

        Map<Integer, List<Integer>> map = new HashMap<>();

        for(int conn[]:connections){
            if(!map.containsKey(conn[0])){
                map.put(conn[0],new ArrayList<>());
            }

            if(!map.containsKey(conn[1])){
                map.put(conn[1],new ArrayList<>());
            }

            map.get(conn[0]).add(conn[1]);
            map.get(conn[1]).add(conn[0]);
        } 

        int vis[] = new int[c+1];
        Map<Integer, TreeSet<Integer>> group = new HashMap<>();
        int g = 1;

        for(int i=1 ;i<=c;i++){
            if(vis[i] == 0){
                TreeSet<Integer> tSet = new TreeSet<>();
                traverse(map, vis,g , i, tSet);

                group.put(g++,tSet);
            }
        }

        List<Integer> ans = new ArrayList<>();

        for(int q[]:queries){
            if(q[0] == 1){
                if(group.get(vis[q[1]]).contains(q[1]))
                    ans.add(q[1]);
                else{
                    if(group.get(vis[q[1]]).isEmpty())
                        ans.add(-1);
                    else
                        ans.add(group.get(vis[q[1]]).first());
                }
            }else{
                group.get(vis[q[1]]).remove(q[1]);
            }
        }

        return ans.stream().mapToInt(Integer::intValue).toArray();
    }
}