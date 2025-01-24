class Solution {
    public List<Integer> findTopoSort(int [][]edges,int k){
        Map<Integer,List<Integer> > adj = new HashMap<>();

        int inDegree[] = new int[k+1];
        for(int []edge:edges){
            if(!adj.containsKey(edge[0])){
                adj.put(edge[0],new ArrayList<>());
            }
            adj.get(edge[0]).add(edge[1]);
            inDegree[edge[1]]++;
        }
        Queue<Integer> queue = new LinkedList<>();
        for(int i=1;i<=k;i++){
            if(inDegree[i] == 0)
                queue.add(i);
        }
        
        List<Integer> ans = new ArrayList<>();
        while(!queue.isEmpty()){
            int curr = queue.poll();
            ans.add(curr);
            if(adj.containsKey(curr)){
                for(int j:adj.get(curr)){
                    inDegree[j]--;
                    if(inDegree[j] == 0)
                        queue.add(j);
                }
            }
        }
        if(ans.size() == k)
            return ans;
        return null;
    }

    public int[][] buildMatrix(int k, int[][] rowConditions, int[][] colConditions) {
        List<Integer> verticalOrder = findTopoSort(rowConditions,k);

        if(verticalOrder == null)
            return new int[0][0];
        
        List<Integer> horizontalOrder = findTopoSort(colConditions,k);
        
        if(horizontalOrder == null)
            return new int[0][0];
        
        int pos[][] = new int[k+1][2];
        for(int i=0;i<k;i++){
            pos[verticalOrder.get(i)][0] = i;
            pos[horizontalOrder.get(i)][1] = i;
        }

        int ans[][] = new int[k][k];
        for(int i=1;i<=k;i++){
            ans[pos[i][0]][pos[i][1]] = i;
        }
        return ans;

    }
}