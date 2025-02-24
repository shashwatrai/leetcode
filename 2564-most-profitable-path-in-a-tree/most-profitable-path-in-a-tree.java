class Solution {
    public boolean traverseBob(int node,int currTime,int []timeBob, boolean []vis,Map<Integer,List<Integer>> adj,int target ){
        timeBob[node] = currTime++;
        vis[node] = true;
        if(node == target)
            return true;
        for(int j:adj.get(node)){
            if(!vis[j] && traverseBob(j,currTime,timeBob,vis,adj,target) ){
                return true;
            }
        }
        timeBob[node] = Integer.MAX_VALUE;
        return false;
    }
    public void traverse(int node, int currTime,int currScore ,int []amount,int []timeBob, boolean []vis,Map<Integer,List<Integer>> adj,int max[]){
        // System.out.println(node+" "+currScore);
        vis[node] = true;
        if(timeBob[node] > currTime){
            currScore += amount[node];
        }else if(timeBob[node] == currTime)
            currScore += amount[node]/2;

        if(node != 0 && adj.get(node).size() == 1){
            max[0] = Math.max(max[0],currScore);
            return;
        }

        for(int j:adj.get(node)){
            if(!vis[j]){
                traverse(j,currTime+1,currScore,amount,timeBob,vis,adj,max);
            }
        }

    }
    public int mostProfitablePath(int[][] edges, int bob, int[] amount) {
        Map<Integer,List<Integer>> adj = new HashMap<>();

        for(int edge[]: edges){
            if(!adj.containsKey(edge[0]))
                adj.put(edge[0],new ArrayList<>());
            if(!adj.containsKey(edge[1]))
                adj.put(edge[1],new ArrayList<>());
            
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
        }

        int timeBob[] = new int[amount.length];
        Arrays.fill(timeBob,Integer.MAX_VALUE);

        traverseBob(bob,0,timeBob,new boolean[timeBob.length],adj,0);
        
        int max[] = new int[1];
        max[0] = Integer.MIN_VALUE;
        traverse(0,0,0,amount,timeBob,new boolean[timeBob.length],adj,max);
        return max[0];
    }
}