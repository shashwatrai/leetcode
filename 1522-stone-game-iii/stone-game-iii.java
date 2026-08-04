class Solution {
    public int solve(int []stoneValue, int start, int []dp){
        if(start >= stoneValue.length)
            return 0;
        
        if(dp[start] != -1000_000_000)
            return dp[start];
        int ans = -1000_000_000;
        int sum = 0;
        for(int i =0;i<3 && start + i < stoneValue.length ;i++){
            sum += stoneValue[start + i];
            ans = Math.max(ans, sum - solve(stoneValue,start + 1 +i,dp));
        }

        return dp[start] = ans;
    }
    public String stoneGameIII(int[] stoneValue) {
        

        int dp[] = new int[stoneValue.length];
        Arrays.fill(dp,-1000_000_000);

        int result = solve(stoneValue, 0, dp);
        return result == 0 ? "Tie" : result > 0 ? "Alice" : "Bob";
    }
}