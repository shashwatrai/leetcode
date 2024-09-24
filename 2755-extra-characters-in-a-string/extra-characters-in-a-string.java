class Solution {
    public int minExtraChar(String s, String[] dictionary) {
        
        int n = s.length();

        int dp[] = new int[n];
        Arrays.fill(dp,Integer.MAX_VALUE);

        for(int i =0;i<n;i++){

            for(String word: dictionary){
                if(i + 1 -word.length() < 0){
                    dp[i] =Math.min(dp[i], (i> 0 ? dp[i-1]:0) + 1);
                }else{
                    // System.out.println(s.substring(i+1-word.length(),i+1)+" "+word.equals(s.substring(i+1-word.length(),i+1)));
                    if(word.equals(s.substring(i+1-word.length(),i+1))){
                        dp[i] = Math.min(dp[i],i - word.length() < 0? 0 : dp[i-word.length()]);
                        // System.out.println(i+" "+dp[i]+" "+(i - word.length() < 0? 0 : dp[i-word.length()]));
                    }else{
                        dp[i] =  Math.min(dp[i],(i> 0 ? dp[i-1]:0) + 1);
                    }
                }
            }
            // System.out.println(i+" "+dp[i]);
        }
        return dp[n-1];

    }
}