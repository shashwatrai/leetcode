class Solution {
    public List<String> getWordsInLongestSubsequence(String[] words, int[] groups) {
        int n = words.length;
        int dp[][]  = new int [n][2];

        for(int i=0;i<n;i++){
            dp[i][0] = 1;
            dp[i][1] = i;
        }
        int max = 1,indx = 0;
        for(int i=1;i<n;i++){
            for(int j=i-1;j>=0;j--){
                if(words[j].length() != words[i].length() || groups[i] == groups[j])
                    continue;
                int count =0 ;// isValid = true;
                for(int k = 0;k<words[i].length();k++){
                    if(words[i].charAt(k) != words[j].charAt(k)){
                        count++;
                    }
                }
                if(count > 1)
                    continue;
                
                if(dp[i][0] < dp[j][0]+1){
                    dp[i][0] = dp[j][0] + 1;
                    dp[i][1] = j;
                }
                if(dp[i][0] > max){
                    max = dp[i][0];
                    indx = i;
                }
            }
        }
        List<String> ans = new ArrayList<>();

        int prev =  -1;
        while(prev != indx){
            ans.add(words[indx]);
            prev = indx;
            indx = dp[indx][1];
        }
        Collections.reverse(ans);
        return  ans;
    }
}