class Solution {
    public String longestPalindrome(String s) {
        int n = s.length();

        boolean dp[][] =new boolean[n][n];

        for(int i=0;i<n;i++){
            dp[i][i] =true;
        }
        int maxLen = 1,start = 0,end = 1;
        for(int l=1;l<n;l++){
            for(int i=0;i<n-l;i++){
                int j = i + l;
                int len = j-i+1;
                if(s.charAt(i) == s.charAt(j)){
                    dp[i][j] = len-2> 0 ?dp[i+1][j-1]:true;
                    if(dp[i][j] && maxLen < len){
                        maxLen = len;
                        start = i;
                        end = j+1;
                    }
                }
            }
        }
        return s.substring(start,end);
    }
}