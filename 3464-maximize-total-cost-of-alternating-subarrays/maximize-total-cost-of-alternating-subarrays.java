class Solution {
    public long maximumTotalCost(int[] nums) {
        int n = nums.length;
        long dp[] =  new long[n+1];
        dp[1] = nums[0];

        for(int i=2;i<=n;i++){
            dp[i] = Math.max((long)dp[i-1] + nums[i-1] ,(long) dp[i-2] + nums[i-2] - nums[i-1]);
        }
        return dp[n];
    }
}