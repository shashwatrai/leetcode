class Solution {
    public int countPalindromicSubsequence(String s) {
        int n = s.length();
        int [][]count = new int[n][26];
        int start[] = new int[26];
        int end[] = new int[26];
        Arrays.fill(start,Integer.MAX_VALUE);
        Arrays.fill(end,Integer.MIN_VALUE);
        for(int i=0;i<n;i++){
            count[i][s.charAt(i) - 'a']++;
            if(i> 0){
                for(int j=0;j<26;j++){
                    count[i][j] += count[i-1][j];
                }
            }
            start[s.charAt(i) - 'a'] = Math.min(start[s.charAt(i) - 'a'],i);
            end[s.charAt(i) - 'a'] = Math.max(end[s.charAt(i) - 'a'],i);
        }
        int ans=0;
        for(int i=0;i<26;i++){
            if(start[i] < end[i]){
                int c =0;
                for(int j=0;j<26;j++){
                    if(count[end[i]-1][j] - count[start[i]][j] > 0)
                        c++;
                }
                ans += c;
            }
        }
        return ans;
    }
}