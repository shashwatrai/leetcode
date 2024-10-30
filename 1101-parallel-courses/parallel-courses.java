class Solution {
    public int minimumSemesters(int n, int[][] relations) {
        
        Map<Integer,Set<Integer>> map = new HashMap<>();
        int []inDegree = new int[n+1];
        for(int i=0;i<relations.length;i++){
            if(!map.containsKey(relations[i][0]))
                map.put(relations[i][0],new HashSet<>());
            map.get(relations[i][0]).add(relations[i][1]);
            inDegree[relations[i][1]]++;
        }


        Queue<Integer> q = new LinkedList<>();
        int cnt =0;
        
        for(int i=1;i<=n;i++){
            if(inDegree[i] == 0){
                q.add(i);
            }
        }
        int semester =0;
        while(!q.isEmpty()){
            int len = q.size();
            semester++;
            while(len-- > 0){
                int node = q.poll();
                cnt++;
                if(map.containsKey(node)){
                    for(int i:map.get(node)){
                        inDegree[i]--;
                        if(inDegree[i] == 0){
                            q.add(i);
                        }
                    }
                }  
            }
        }
        if(cnt != n)
            return -1;

        return semester;

    }
}