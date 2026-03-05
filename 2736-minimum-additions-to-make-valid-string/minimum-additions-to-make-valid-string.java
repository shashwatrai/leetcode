class Solution {
    public int addMinimum(String word) {
        int d  = 0 ;

        int ans = 0;
        for(int i=0;i<word.length();i++){
            if(word.charAt(i) != (char)('a'+d)){
                ans++;
                i--;
            }
            
            d = (d+1)%3;
                
        }
        return ans + (d > 0 ? 3 - d:0);
    }
}