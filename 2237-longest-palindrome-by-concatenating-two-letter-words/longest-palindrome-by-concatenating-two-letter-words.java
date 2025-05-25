class Solution {
    public int longestPalindrome(String[] words) {
        int  [][]freq = new int[26][26];

        for(String s: words){
            freq[s.charAt(0) - 'a'][s.charAt(1) - 'a']++;
        }

        int len = 0;
        int middle = 0;
        for(int i=0;i<26;i++){
            for(int j=0;j<i;j++){
                len += 2 * Math.min(freq[i][j],freq[j][i]);
            }
            if(freq[i][i]%2 == 0){
                len += freq[i][i];
            }else{
                len += freq[i][i]-1;
                middle = 1;
            }
        }

        return len*2+ middle * 2;
        
    }
}