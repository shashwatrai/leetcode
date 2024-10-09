class Solution {
    public int minAddToMakeValid(String s) {
        int openCnt =0, ans =0;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i) == '(')
                openCnt++;
            else{
                if(openCnt > 0)
                    openCnt--;
                else
                    ans++;
            }
        }
        return ans + openCnt;
    }
}