class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        int n = s.length();

        boolean []dp = new boolean[n];

        for(int i=0;i<n;i++){

            for(String word: wordDict){
                
                if(i - word.length()+1 < 0)
                    continue;
                
                if((i-word.length() < 0 || dp[i-word.length()]) && s.startsWith(word,i-word.length()+1)){
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[n-1];
    }
}