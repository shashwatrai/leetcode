class Solution {
    public boolean checkOnesSegment(String s) {
        int len = 0;
        for(int i=0;i<s.length()-1;i++){
            if(s.charAt(i) != s.charAt(i+1))
                len++;
           
            if(len > 1)
                return false;
        }
        if(s.charAt(0) == '1' || len > 0)
            return true;
        return false;
    }
}