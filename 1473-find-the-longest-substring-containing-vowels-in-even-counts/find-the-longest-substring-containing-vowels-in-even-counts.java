class Solution {
    public int findTheLongestSubstring(String s) {
        int val[] = new int[26];
        val['a'-'a'] = 1;
        val['e'-'a'] = 2;
        val['i'-'a'] = 4;
        val['o'-'a'] = 8;
        val['u'-'a'] = 16;

        int []possibles = new int[32];
        Arrays.fill(possibles,-1);
        int curr =0;
        int len=0;
        for(int i=0;i<s.length();i++){
            curr ^= val[s.charAt(i) - 'a'];
            if(curr > 0 && possibles[curr] > -1)
                len = Math.max(len,i-possibles[curr]);
            else if(curr == 0)
                len = Math.max(len,i+1);
            
            if(possibles[curr] == -1)
                possibles[curr] = i;
        }
        return len;
 
        
    }
}