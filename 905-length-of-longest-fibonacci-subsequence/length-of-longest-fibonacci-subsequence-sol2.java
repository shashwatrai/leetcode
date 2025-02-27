class Solution {
    
    public int lenLongestFibSubseq(int[] arr) {
        int n = arr.length;
        int [][]dp = new int[n][n];
        int max =0;
        Map<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<n;i++)
            map.put(arr[i],i);
        for(int i=n-2;i>=0;i--){
            for(int j = n-1;j>i;j--){
                if(!map.containsKey(arr[i]+arr[j]))
                    dp[i][j] = 2;
                else{
                    int c = map.get(arr[i]+arr[j]);
                    dp[i][j] = dp[j][c] + 1;
                }
                max = Math.max(max,dp[i][j]);
            }
        }
        return max > 2 ? max:0;
    }
}
