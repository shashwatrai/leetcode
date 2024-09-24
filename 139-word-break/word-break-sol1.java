class Solution {
    public boolean helper(String s, int start, int end, List<String> wordDict,int [][]dp){
        if(start == end)
            return true;
        else if(dp[start][end] > 0)
            return dp[start][end] > 1 ? true:false;
        
        String temp= s.substring(start,end);
        for(String i:wordDict){
            if(temp.startsWith(i)){
                // System.out.println(s+" "+i+" "+temp);
                if(helper(s,start+i.length(),end,wordDict,dp)){
                    dp[start][end] = 2;
                    return true;
                }
            }
        }
        dp[start][end]= 1;
        return false;
    }
    public boolean wordBreak(String s, List<String> wordDict) {
        int end  = s.length();
        int dp[][] = new int[end+1][end+1];
        return helper(s,0,end,wordDict,dp);
    }
}
