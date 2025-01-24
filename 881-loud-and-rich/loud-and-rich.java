class Solution {
    public int[] loudAndRich(int[][] richer, int[] quiet) {
        int n = quiet.length;
        int inDegree[] = new int[n];
        Map<Integer,List<Integer>> adj = new HashMap<>();
        for(int edge[]:richer){
            if(!adj.containsKey(edge[0])){
                adj.put(edge[0],new ArrayList<>());
            }
            adj.get(edge[0]).add(edge[1]);
            inDegree[edge[1]]++;
        }
        Queue<Integer> queue = new LinkedList<>();
        int []ans = new int[n];
        for(int i=0;i<n;i++)
            ans[i]  = i;

        for(int i=0;i<n;i++){
            if(inDegree[i] == 0)
                queue.add(i);
        }

        while(!queue.isEmpty()){
            int curr = queue.poll();
            
            if(adj.containsKey(curr)){
                for(int j:adj.get(curr)){
                    inDegree[j]--;
                    if(quiet[ans[j]] > quiet[ans[curr]])
                        ans[j] = ans[curr];
                    if(inDegree[j] == 0)
                        queue.add(j);
                }
            }
            // System.out.println(curr+" "+Arrays.toString(ans));

        }
        return ans;
    }
}