class Solution {
    public int solve(int a,int b, int []arr, Map<Integer,Integer> map,int [][]dp){
        if(!map.containsKey(arr[a]+arr[b]))
            return dp[a][b] = 2;
        
        if(dp[a][b] != 0)
            return dp[a][b];
        
        int c = map.get(arr[a]+arr[b]);
        return dp[a][b] = solve(b,c,arr,map,dp)+1;
    }
    public int lenLongestFibSubseq(int[] arr) {
        int n = arr.length;
        int [][]dp = new int[n][n];
        int max =0;
        Map<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<n;i++)
            map.put(arr[i],i);
        for(int i=n-2;i>=0;i--){
            for(int j = n-1;j>i;j--){
                max = Math.max(max,solve(i,j,arr,map,dp));
            }
        }
        return max > 2 ? max:0;
    }
}
