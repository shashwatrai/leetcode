class Solution {
    public boolean check(int []piles, int start, int end, int turn, int score1,int score2, int dp[][][]){
        if(end-start == 1){
            return score1 + Math.max(piles[start],piles[end]) > score2 + Math.min(piles[start],piles[end]);
        }

        if(dp[start][end][turn] != 0 )
            return dp[start][end][turn] == 1;
    
        if(turn == 0){
            dp[start][end][0] = check(piles,start+1,end,1,score1 + piles[start],score2,dp) ||  check(piles,start,end-1,1,score1 + piles[end],score2,dp) ? 1 : 2;
        }else{
           dp[start][end][1] = check(piles,start+1,end,0,score1 ,score2 + piles[start],dp) ||  check(piles,start,end-1,0,score1 ,score2 + piles[end],dp) ? 1 : 2;
        }
        return dp[start][end][turn] == 1;
    }
    public boolean stoneGame(int[] piles) {
        int dp[][][] = new int[piles.length][piles.length][2];
        return check(piles,0, piles.length-1,0,0,0,dp);
    }
}