class Solution {
    public int countPaths(int n, int[][] roads) {
        Map<Integer,Set<Integer>> map = new HashMap<>();
        long dist[] = new long[n];
        Arrays.fill(dist,Long.MAX_VALUE);
        dist[0] = 0;
        int newRoads[][] = new int[2* roads.length][3];
        for(int i=0;i<roads.length;i++){
            newRoads[2*i][0] = roads[i][0];
            newRoads[2*i][1] = roads[i][1];
            newRoads[2*i][2] = roads[i][2];

            newRoads[2*i+1][0] = roads[i][1];
            newRoads[2*i+1][1] = roads[i][0];
            newRoads[2*i+1][2] = roads[i][2];

        }
        for(int i=0;i<n;i++){
            for(int j=0;j<newRoads.length;j++){
                if(dist[newRoads[j][0]] != Long.MAX_VALUE){
                    if(dist[newRoads[j][0]] + (long)newRoads[j][2] < dist[newRoads[j][1]]  ){
                        dist[newRoads[j][1]] =  dist[newRoads[j][0]] + (long)newRoads[j][2] ;
                        map.put(newRoads[j][1],new HashSet<>());
                        map.get(newRoads[j][1]).add(newRoads[j][0]);
                    }else if(dist[newRoads[j][0]] + newRoads[j][2] == dist[newRoads[j][1]]){
                        if(!map.containsKey(newRoads[j][1]))
                            map.put(newRoads[j][1],new HashSet<>());
                        map.get(newRoads[j][1]).add(newRoads[j][0]);
                    }
                }
            }
        }
        // System.out.println(map);
        Map<Integer,List<Integer>> adj = new HashMap<>();
        int []inDegree = new int[n];
        for(int i=0;i<n;i++){
            if(map.containsKey(i)){
                for(int j:map.get(i)){
                    if(!adj.containsKey(j)){
                        adj.put(j,new ArrayList<>());
                    }
                    adj.get(j).add(i);
                }
                inDegree[i] = map.get(i).size();
            }
        }
        int []path = new int[n];

        Queue<Integer> queue = new LinkedList<>();

        queue.add(0);
        path[0] = 1;
        int R = (int)1e9+7;
        while(!queue.isEmpty()){
            int curr = queue.poll();
            if(curr == n-1)
                break;
            
            if(adj.containsKey(curr)){
                for(int j : adj.get(curr)){
                    inDegree[j]--;
                    path[j]  = (path[j]%R + path[curr]%R)%R;
                    if(inDegree[j] == 0)
                        queue.add(j);
                }
            }
        }
        return path[n-1];
        
    }
}