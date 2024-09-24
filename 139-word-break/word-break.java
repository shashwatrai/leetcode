class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        int n = s.length();
        boolean dp[] = new boolean[n];

        for(int i=0;i<n;i++){

            for(String word : wordDict){
                if(i+1 - word.length() < 0)
                    continue;
                if((i+1-word.length() == 0 ||  dp[i-word.length()]) 
                    && word.equals(s.substring(i-word.length() +1,i+1))){
                        dp[i] = true;
                        break;
                    }
            }
        }
        return dp[n-1];
    }
}