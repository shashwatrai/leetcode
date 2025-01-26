class Solution {
    public int traverse( Map<Integer,List<Integer>> map,int curr){
        int dist =0;
        if(map.containsKey(curr)){
            for(int j:map.get(curr))
                dist = Math.max(dist,traverse(map,j));
        }
        return dist + 1;
    }
    public int maximumInvitations(int[] favorite) {
        int n = favorite.length;

        int inDegree[] = new int[n];
        for(int i=0;i<n;i++){
            inDegree[favorite[i]]++;
        }

        Queue<Integer> queue = new LinkedList<>();
        for(int i=0;i<n;i++){
            if(inDegree[i] == 0)
                queue.add(i);
        }

        while(!queue.isEmpty()){
            int curr = queue.poll();
            inDegree[favorite[curr]]--;
            if(inDegree[favorite[curr]] == 0)
                queue.add(favorite[curr]);
        }
        boolean []vis = new boolean[n];
        int dist[] = new int[n];
        int group[] = new int[n];
        Arrays.fill(group, -1);
        int g=1;
        for(int i=0;i<n;i++){
            if(inDegree[i] != 0 && !vis[i]){
                int count =0;
                int curr = i;
                while(!vis[curr]){
                    vis[curr] = true;
                    curr = favorite[curr];
                    count++;
                }

                curr = i;
                do{
                    dist[curr] = count;
                    group[curr] = g;
                    curr = favorite[curr];


                }while(curr != i);
                g++;
            }
            
        }
        Map<Integer,List<Integer>> map = new HashMap<>();

        for(int i=0;i<n;i++){
            if(group[i] == -1 || group[i] != group[favorite[i]]){
                if(!map.containsKey(favorite[i]) ){
                    map.put(favorite[i],new ArrayList<>());
                }
                map.get(favorite[i]).add(i);
            }
        }
        System.out.println(map);

        vis = new boolean[n];

        int maxPossible = 0;
        for(int i=0;i<n;i++){
            if(dist[i] == 2 && !vis[i]){
                maxPossible += traverse(map,i) + traverse(map,favorite[i]);
                vis[i] = vis[favorite[i]] = true;
            }
        }
        for(int i=0;i<n;i++){
            maxPossible = Math.max(dist[i],maxPossible);
        }

        return maxPossible;
    }
}