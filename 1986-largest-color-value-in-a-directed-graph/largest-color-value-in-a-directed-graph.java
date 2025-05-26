class Solution {
    public boolean traverse(Map<Integer,List<Integer>> map,String colors,int curr, boolean vis[] , 
    boolean path[], int []max, int dp[][]){
        vis[curr] = true;
        path[curr] = true;
        int ans[] = dp[curr];
        if(map.containsKey(curr)){
            for(int j: map.get(curr)){
                if(vis[j]){
                    if(path[j])
                        return true;
                    
                }else{
                    if(traverse(map,colors,j,vis,path,max,dp))
                        return true;
                    
                }
                for(int i=0;i<26;i++){
                    ans[i] = Math.max(ans[i],dp[j][i]);
                }
            }
        }
        ans[colors.charAt(curr)-'a']++;
        for(int i=0;i<26;i++){
            max[0] = Math.max(max[0],ans[i]);
        }
        path[curr] = false;
        return false;
    }
    public int largestPathValue(String colors, int[][] edges) {
        Map<Integer,List<Integer>> map = new HashMap<>();

        for(int edge[]: edges){
            if(!map.containsKey(edge[0])){
                map.put(edge[0],new ArrayList<>());
            }
            map.get(edge[0]).add(edge[1]);
        }
        int n  = colors.length();
        boolean []vis = new boolean[n];
        int [][]dp = new int[n][26];
        int max[] = new int[1];

        for(int i=0;i<n;i++){
            if(!vis[i]){
                if(traverse(map,colors,i,vis,new boolean[n],max,dp))
                    return -1;
            }
        }
        return max[0];
    }
}