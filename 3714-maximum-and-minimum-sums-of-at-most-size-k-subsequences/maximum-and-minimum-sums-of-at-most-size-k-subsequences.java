class Solution {
    
    public int minMaxSums(int[] nums, int k) {
        int n = nums.length;
        int R = 1000000007;
        long dp[][] = new long[k][n+1];
        Arrays.fill(dp[0], 1);
        for(int i=1;i<k;i++){
            for(int j = i;j<=n;j++){
                dp[i][j] = (dp[i][j-1]%R + dp[i-1][j-1]%R)%R;
            }
        }
        // System.out.println(Arrays.deepToString(dp));
        long finalDp[] = new long[n+1];
        for(int i=0;i<=n;i++){
            for(int j=0;j<k;j++){
                finalDp[i] = (finalDp[i]%R + dp[j][i]%R)%R;
            }
        }
        Arrays.sort(nums);
        long ans = 0L;
        for(int i =0;i<nums.length;i++){
            ans = (ans%R + (long)(finalDp[i]%R + finalDp[n-1-i]%R)%R * nums[i]%R)%R;
        }
        return (int)ans;
    }
}