class Solution {
    public void prepare(String []words,int [][]freq){
        for(int i=0;i<words.length;i++){
            for(int j=0;j<words[i].length();j++){
                freq[i][words[i].charAt(j) - 'a']++;
            }
        }
    }
    public List<String> wordSubsets(String[] words1, String[] words2) {
        
        
        int [][]freq1 = new int[words1.length][26];
        int [][]freq2 = new int[words2.length][26];

        prepare(words1,freq1);
        prepare(words2,freq2);
        int match[] = new int[26];

        for(int i[]:freq2){
            for(int j=0;j<26;j++)
                match[j] = Math.max(match[j],i[j]);
        }

        List<String> ans = new ArrayList<>();
        for(int i=0;i<words1.length;i++){
            boolean isValid = true;
            for(int j=0;j<26;j++){
                if(match[j] > freq1[i][j]){
                    isValid = false;
                    break;
                }
            }
            if(isValid){
                ans.add(words1[i]);
            }
        }
        return ans;
    }
}