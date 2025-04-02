class Solution {
    public int countPaths(int n, int[][] roads) {
        Map<Integer,List<int []>> adj = new HashMap<>();
        for(int i[]:roads){
            if(!adj.containsKey(i[0]))
                adj.put(i[0],new ArrayList<>());
            if(!adj.containsKey(i[1]))
                adj.put(i[1],new ArrayList<>());
            
            adj.get(i[1]).add(new int[]{i[0],i[2]});
            adj.get(i[0]).add(new int[]{i[1],i[2]});
        }

        int R = (int)1e9+7;
        long dist[] = new long[n];
        long path[] = new long[n];

        PriorityQueue<long []> pq = new PriorityQueue<>((a,b)->Long.compare(a[1],b[1]));
        Arrays.fill(dist,Long.MAX_VALUE);
        dist[0] = 0L;
        path[0] = 1;
        pq.add(new long[]{0,0});
        while(!pq.isEmpty()){
            // System.out.println(Arrays.toString(dist)+" "+Arrays.toString(path));
            long []curr = pq.poll();
            if((int)curr[0] == n-1)
                break;
            if(adj.containsKey((int)curr[0])){
                for(int j[]:adj.get((int)curr[0])){
                    if(dist[(int)j[0]] > j[1] + curr[1]){
                        dist[(int)j[0]] = j[1] + curr[1];
                        pq.add(new long[]{j[0],dist[(int)j[0]]});
                        path[(int)j[0]] = path[(int)curr[0]];
                    }else if(dist[(int)j[0]] == j[1] + curr[1]){
                        path[(int)j[0]] = (path[(int)j[0]] %R + path[(int)curr[0]]%R)%R;
                    }
                }
            }
        }
        return (int)path[n-1];
    }
}