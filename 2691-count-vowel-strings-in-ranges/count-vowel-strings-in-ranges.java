class Solution {
    public int[] vowelStrings(String[] words, int[][] queries) {
        int []prefix = new int[words.length];

        for(int i=0;i<words.length;i++){
            int l = words[i].length();
            if((words[i].charAt(0) == 'a' || words[i].charAt(0) == 'e' || words[i].charAt(0) == 'i' 
            || words[i].charAt(0) == 'o'  || words[i].charAt(0) == 'u') && (words[i].charAt(l-1) == 'a' 
            || words[i].charAt(l-1) == 'e' || words[i].charAt(l-1) == 'i' 
            || words[i].charAt(l-1) == 'o'  || words[i].charAt(l-1) == 'u' ))
                prefix[i] = 1;
            
            prefix[i] += (i > 0? prefix[i-1]:0);
        }
        int ans[] = new int[queries.length];
        for(int i=0;i<queries.length;i++){
            ans[i] = prefix[queries[i][1]] - (queries[i][0] > 0 ? prefix[queries[i][0]-1] : 0);
        }
        return ans;
    }
}