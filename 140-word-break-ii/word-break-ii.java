class Solution {
    public void solve(String s,int indx, List<String>wordDict, List<String> res,StringBuilder stb){
        if(s.length() == indx){
            res.add(stb.toString());
            return;
        }

        for(String i: wordDict){
            if(s.startsWith(i,indx)){
                int len =0;
                if(stb.length() != 0){
                    stb.append(" ");
                    len++;
                }
                stb.append(i);
                solve(s,indx+i.length(),wordDict,res,stb);
                stb.setLength(stb.length() - i.length() - len);
            }
        }
        return ;
    }
    public List<String> wordBreak(String s, List<String> wordDict) {
        List<String > res  = new ArrayList<>();

        solve(s,0,wordDict,res,new StringBuilder());
        return res;
    }
}