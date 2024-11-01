class Solution {
    public String reorganizeString(String s) {
        char []freq = new char[26];

        for(char c: s.toCharArray()){
            freq[c-'a']++;
            if(freq[c-'a'] > (1+s.length())/2)
                return "";
        }
        Integer indices[] = new Integer[26];
        for(int i=0;i<26;i++)
            indices[i] = i;
        
        Arrays.sort(indices,(a,b)-> freq[b] - freq[a]);
        char ans[] =  new char[s.length()];

        int indx = 0;
        for(int i=0;i<26;i++){
            while(freq[indices[i]]-- > 0){
                ans[indx] = (char)('a'+indices[i]);
                indx += 2;
                if(indx >= s.length()){
                    indx  = 1;
                }
            }
        }
        return new String(ans);
    }
}