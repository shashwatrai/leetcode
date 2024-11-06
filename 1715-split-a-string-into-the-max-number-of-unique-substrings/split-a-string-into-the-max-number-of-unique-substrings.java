class Solution {
    public int max ;
    public void solve(String str,int indx, Set<String> ans){
        if(indx == str.length()){
            max = Math.max(max,ans.size());
            return ;
        }
        
        StringBuilder stb = new StringBuilder();
        for(int i=indx ; i<str.length();i++){
            stb.append(str.charAt(i));
            if(ans.contains(stb.toString())){
                continue;
            }
            ans.add(stb.toString());
            solve(str, i+1, ans);
            ans.remove(stb.toString());
        }
    }
    public int maxUniqueSplit(String s) {
        max = 0;
        solve(s,0,new HashSet<>());
        return max;
    }
}