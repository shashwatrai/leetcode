class Solution {
    public int numTilings(int n) {
        long arr[][] = new long[n+1][2];
        long dp[] = new long[n+1];
        long R  = (long)1e9+7;
        dp[0] = dp[1] = 1L;
        arr[1][0] = arr[1][1] = 0L;
        for(int i=2;i<=n;i++){
            dp[i] = (dp[i-1]%R + dp[i-2]%R  + arr[i-1][1]%R +arr[i-1][0]%R)%R;
            arr[i][0] = (dp[i-2]%R + arr[i-1][1]%R)%R;
            arr[i][1] = (dp[i-2]%R + arr[i-1][0]%R)%R;
            // System.out.println(dp[i]);
        }
        return (int)dp[n];
    }
}