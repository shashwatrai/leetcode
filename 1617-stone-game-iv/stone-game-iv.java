class Solution {
    public boolean solve(int n , int turn,int dp[][] ){
        if(n == 0){
            dp[n][turn] =  turn != 0 ? 1: 2;
            return dp[n][turn] == 1;
        }

        if(dp[n][turn] != 0)
            return dp[n][turn] == 1;

        for(int i = 1;i*i <= n;i++){
            boolean ans = solve(n - i*i, 1- turn,dp);
            if( turn == 0 && ans){
                dp[n][turn] = 1;
                return ans;
            }
            else if (turn ==1 && !ans){
                dp[n][turn] = 2;
                return ans;
            }
        }
        dp[n][turn] = turn == 0 ? 2 : 1;
        return dp[n][turn] == 1;
    }
    public boolean winnerSquareGame(int n) {
        int dp[][] = new int[n+1][2];
        return solve(n,0,dp);
    }
}